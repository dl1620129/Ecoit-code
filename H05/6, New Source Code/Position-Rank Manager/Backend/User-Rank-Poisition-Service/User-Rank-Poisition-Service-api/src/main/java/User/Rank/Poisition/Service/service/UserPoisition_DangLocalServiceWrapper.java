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
 * Provides a wrapper for {@link UserPoisition_DangLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see UserPoisition_DangLocalService
 * @generated
 */
@ProviderType
public class UserPoisition_DangLocalServiceWrapper
	implements UserPoisition_DangLocalService,
			   ServiceWrapper<UserPoisition_DangLocalService> {

	public UserPoisition_DangLocalServiceWrapper(
		UserPoisition_DangLocalService userPoisition_DangLocalService) {

		_userPoisition_DangLocalService = userPoisition_DangLocalService;
	}

	/**
	 * Adds the user poisition_ dang to the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPoisition_Dang the user poisition_ dang
	 * @return the user poisition_ dang that was added
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserPoisition_Dang
		addUserPoisition_Dang(
			User.Rank.Poisition.Service.model.UserPoisition_Dang
				userPoisition_Dang) {

		return _userPoisition_DangLocalService.addUserPoisition_Dang(
			userPoisition_Dang);
	}

	/**
	 * Creates a new user poisition_ dang with the primary key. Does not add the user poisition_ dang to the database.
	 *
	 * @param userPoisitionDangId the primary key for the new user poisition_ dang
	 * @return the new user poisition_ dang
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserPoisition_Dang
		createUserPoisition_Dang(long userPoisitionDangId) {

		return _userPoisition_DangLocalService.createUserPoisition_Dang(
			userPoisitionDangId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPoisition_DangLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the user poisition_ dang with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPoisitionDangId the primary key of the user poisition_ dang
	 * @return the user poisition_ dang that was removed
	 * @throws PortalException if a user poisition_ dang with the primary key could not be found
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserPoisition_Dang
			deleteUserPoisition_Dang(long userPoisitionDangId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPoisition_DangLocalService.deleteUserPoisition_Dang(
			userPoisitionDangId);
	}

	/**
	 * Deletes the user poisition_ dang from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPoisition_Dang the user poisition_ dang
	 * @return the user poisition_ dang that was removed
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserPoisition_Dang
		deleteUserPoisition_Dang(
			User.Rank.Poisition.Service.model.UserPoisition_Dang
				userPoisition_Dang) {

		return _userPoisition_DangLocalService.deleteUserPoisition_Dang(
			userPoisition_Dang);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _userPoisition_DangLocalService.dynamicQuery();
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

		return _userPoisition_DangLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _userPoisition_DangLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _userPoisition_DangLocalService.dynamicQuery(
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

		return _userPoisition_DangLocalService.dynamicQueryCount(dynamicQuery);
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

		return _userPoisition_DangLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public User.Rank.Poisition.Service.model.UserPoisition_Dang
		fetchUserPoisition_Dang(long userPoisitionDangId) {

		return _userPoisition_DangLocalService.fetchUserPoisition_Dang(
			userPoisitionDangId);
	}

	/**
	 * Returns the user poisition_ dang matching the UUID and group.
	 *
	 * @param uuid the user poisition_ dang's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user poisition_ dang, or <code>null</code> if a matching user poisition_ dang could not be found
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserPoisition_Dang
		fetchUserPoisition_DangByUuidAndGroupId(String uuid, long groupId) {

		return _userPoisition_DangLocalService.
			fetchUserPoisition_DangByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _userPoisition_DangLocalService.getActionableDynamicQuery();
	}

	@Override
	public int getCountAll(String name, long groupId) throws Exception {
		return _userPoisition_DangLocalService.getCountAll(name, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _userPoisition_DangLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _userPoisition_DangLocalService.
			getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<User.Rank.Poisition.Service.model.UserPoisition_Dang>
			getListUserPoisition_Dang(
				long groupId, String name, int start, int limit)
		throws Exception {

		return _userPoisition_DangLocalService.getListUserPoisition_Dang(
			groupId, name, start, limit);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _userPoisition_DangLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPoisition_DangLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the user poisition_ dang with the primary key.
	 *
	 * @param userPoisitionDangId the primary key of the user poisition_ dang
	 * @return the user poisition_ dang
	 * @throws PortalException if a user poisition_ dang with the primary key could not be found
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserPoisition_Dang
			getUserPoisition_Dang(long userPoisitionDangId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPoisition_DangLocalService.getUserPoisition_Dang(
			userPoisitionDangId);
	}

	/**
	 * Returns the user poisition_ dang matching the UUID and group.
	 *
	 * @param uuid the user poisition_ dang's UUID
	 * @param groupId the primary key of the group
	 * @return the matching user poisition_ dang
	 * @throws PortalException if a matching user poisition_ dang could not be found
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserPoisition_Dang
			getUserPoisition_DangByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _userPoisition_DangLocalService.
			getUserPoisition_DangByUuidAndGroupId(uuid, groupId);
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
	@Override
	public java.util.List<User.Rank.Poisition.Service.model.UserPoisition_Dang>
		getUserPoisition_Dangs(int start, int end) {

		return _userPoisition_DangLocalService.getUserPoisition_Dangs(
			start, end);
	}

	/**
	 * Returns all the user poisition_ dangs matching the UUID and company.
	 *
	 * @param uuid the UUID of the user poisition_ dangs
	 * @param companyId the primary key of the company
	 * @return the matching user poisition_ dangs, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<User.Rank.Poisition.Service.model.UserPoisition_Dang>
		getUserPoisition_DangsByUuidAndCompanyId(String uuid, long companyId) {

		return _userPoisition_DangLocalService.
			getUserPoisition_DangsByUuidAndCompanyId(uuid, companyId);
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
	@Override
	public java.util.List<User.Rank.Poisition.Service.model.UserPoisition_Dang>
		getUserPoisition_DangsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<User.Rank.Poisition.Service.model.UserPoisition_Dang>
					orderByComparator) {

		return _userPoisition_DangLocalService.
			getUserPoisition_DangsByUuidAndCompanyId(
				uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of user poisition_ dangs.
	 *
	 * @return the number of user poisition_ dangs
	 */
	@Override
	public int getUserPoisition_DangsCount() {
		return _userPoisition_DangLocalService.getUserPoisition_DangsCount();
	}

	/**
	 * Updates the user poisition_ dang in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param userPoisition_Dang the user poisition_ dang
	 * @return the user poisition_ dang that was updated
	 */
	@Override
	public User.Rank.Poisition.Service.model.UserPoisition_Dang
		updateUserPoisition_Dang(
			User.Rank.Poisition.Service.model.UserPoisition_Dang
				userPoisition_Dang) {

		return _userPoisition_DangLocalService.updateUserPoisition_Dang(
			userPoisition_Dang);
	}

	@Override
	public UserPoisition_DangLocalService getWrappedService() {
		return _userPoisition_DangLocalService;
	}

	@Override
	public void setWrappedService(
		UserPoisition_DangLocalService userPoisition_DangLocalService) {

		_userPoisition_DangLocalService = userPoisition_DangLocalService;
	}

	private UserPoisition_DangLocalService _userPoisition_DangLocalService;

}