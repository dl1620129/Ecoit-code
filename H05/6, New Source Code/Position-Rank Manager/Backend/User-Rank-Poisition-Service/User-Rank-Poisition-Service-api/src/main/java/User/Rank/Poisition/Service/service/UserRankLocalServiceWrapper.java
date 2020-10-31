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

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link UserRankLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserRankLocalService
 * @generated
 */
@ProviderType
public class UserRankLocalServiceWrapper
	implements UserRankLocalService, ServiceWrapper<UserRankLocalService> {

	public UserRankLocalServiceWrapper(
		UserRankLocalService userRankLocalService) {

		_userRankLocalService = userRankLocalService;
	}

	/**
	 * Adds the user rank to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRank the user rank
	 * @return the user rank that was added
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserRank addUserRank(
		User.Rank.Poisition.Service.model.UserRank userRank) {

		return _userRankLocalService.addUserRank(userRank);
	}

	/**
	 * Creates a new user rank with the primary key. Does not add the user rank to the database.
	 *
	 * @param userRankId the primary key for the new user rank
	 * @return the new user rank
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserRank createUserRank(
		long userRankId) {

		return _userRankLocalService.createUserRank(userRankId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRankLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the user rank with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRankId the primary key of the user rank
	 * @return the user rank that was removed
	 * @throws PortalException if a user rank with the primary key could not be found
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserRank deleteUserRank(
			long userRankId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRankLocalService.deleteUserRank(userRankId);
	}

	/**
	 * Deletes the user rank from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userRank the user rank
	 * @return the user rank that was removed
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserRank deleteUserRank(
		User.Rank.Poisition.Service.model.UserRank userRank) {

		return _userRankLocalService.deleteUserRank(userRank);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userRankLocalService.dynamicQuery();
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

		return _userRankLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _userRankLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _userRankLocalService.dynamicQuery(
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

		return _userRankLocalService.dynamicQueryCount(dynamicQuery);
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

		return _userRankLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public User.Rank.Poisition.Service.model.UserRank fetchUserRank(
		long userRankId) {

		return _userRankLocalService.fetchUserRank(userRankId);
	}

	/**
	 * Returns the user rank matching the UUID and group.
	 *
	 * @param uuid the user rank's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user rank, or <code>null</code> if a matching user rank could not be found
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserRank
		fetchUserRankByUuidAndGroupId(String uuid, long groupId) {

		return _userRankLocalService.fetchUserRankByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userRankLocalService.getActionableDynamicQuery();
	}

	@Override
	public int getCountAll(String name, long groupId) throws Exception {
		return _userRankLocalService.getCountAll(name, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _userRankLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userRankLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<User.Rank.Poisition.Service.model.UserRank>
			getListUserRank(long groupId, String name, int start, int limit)
		throws Exception {

		return _userRankLocalService.getListUserRank(
			groupId, name, start, limit);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userRankLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRankLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user rank with the primary key.
	 *
	 * @param userRankId the primary key of the user rank
	 * @return the user rank
	 * @throws PortalException if a user rank with the primary key could not be found
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserRank getUserRank(
			long userRankId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRankLocalService.getUserRank(userRankId);
	}

	/**
	 * Returns the user rank matching the UUID and group.
	 *
	 * @param uuid the user rank's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user rank
	 * @throws PortalException if a matching user rank could not be found
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserRank
			getUserRankByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userRankLocalService.getUserRankByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<User.Rank.Poisition.Service.model.UserRank>
		getUserRanks(int start, int end) {

		return _userRankLocalService.getUserRanks(start, end);
	}

	/**
	 * Returns all the user ranks matching the UUID and company.
	 *
	 * @param uuid the UUID of the user ranks
	 * @param companyId the primary key of the company
	 * @return the matching user ranks, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<User.Rank.Poisition.Service.model.UserRank>
		getUserRanksByUuidAndCompanyId(String uuid, long companyId) {

		return _userRankLocalService.getUserRanksByUuidAndCompanyId(
			uuid, companyId);
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
	@Override
	public java.util.List<User.Rank.Poisition.Service.model.UserRank>
		getUserRanksByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<User.Rank.Poisition.Service.model.UserRank>
					orderByComparator) {

		return _userRankLocalService.getUserRanksByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of user ranks.
	 *
	 * @return the number of user ranks
	 */
	@Override
	public int getUserRanksCount() {
		return _userRankLocalService.getUserRanksCount();
	}

	/**
	 * Updates the user rank in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userRank the user rank
	 * @return the user rank that was updated
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserRank updateUserRank(
		User.Rank.Poisition.Service.model.UserRank userRank) {

		return _userRankLocalService.updateUserRank(userRank);
	}

	@Override
	public UserRankLocalService getWrappedService() {
		return _userRankLocalService;
	}

	@Override
	public void setWrappedService(UserRankLocalService userRankLocalService) {
		_userRankLocalService = userRankLocalService;
	}

	private UserRankLocalService _userRankLocalService;

}