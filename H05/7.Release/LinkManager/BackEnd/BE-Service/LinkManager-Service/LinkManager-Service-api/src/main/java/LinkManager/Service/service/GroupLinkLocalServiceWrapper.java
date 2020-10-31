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

package LinkManager.Service.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides a wrapper for {@link GroupLinkLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see GroupLinkLocalService
 * @generated
 */
@ProviderType
public class GroupLinkLocalServiceWrapper
	implements GroupLinkLocalService, ServiceWrapper<GroupLinkLocalService> {

	public GroupLinkLocalServiceWrapper(
		GroupLinkLocalService groupLinkLocalService) {

		_groupLinkLocalService = groupLinkLocalService;
	}

	/**
	 * Adds the group link to the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupLink the group link
	 * @return the group link that was added
	 */
	@Override
	public LinkManager.Service.model.GroupLink addGroupLink(
		LinkManager.Service.model.GroupLink groupLink) {

		return _groupLinkLocalService.addGroupLink(groupLink);
	}

	/**
	 * Creates a new group link with the primary key. Does not add the group link to the database.
	 *
	 * @param linksgroupid the primary key for the new group link
	 * @return the new group link
	 */
	@Override
	public LinkManager.Service.model.GroupLink createGroupLink(
		long linksgroupid) {

		return _groupLinkLocalService.createGroupLink(linksgroupid);
	}

	/**
	 * Deletes the group link from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupLink the group link
	 * @return the group link that was removed
	 */
	@Override
	public LinkManager.Service.model.GroupLink deleteGroupLink(
		LinkManager.Service.model.GroupLink groupLink) {

		return _groupLinkLocalService.deleteGroupLink(groupLink);
	}

	/**
	 * Deletes the group link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linksgroupid the primary key of the group link
	 * @return the group link that was removed
	 * @throws PortalException if a group link with the primary key could not be found
	 */
	@Override
	public LinkManager.Service.model.GroupLink deleteGroupLink(
			long linksgroupid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupLinkLocalService.deleteGroupLink(linksgroupid);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupLinkLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _groupLinkLocalService.dynamicQuery();
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

		return _groupLinkLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinkManager.Service.model.impl.GroupLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _groupLinkLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinkManager.Service.model.impl.GroupLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _groupLinkLocalService.dynamicQuery(
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

		return _groupLinkLocalService.dynamicQueryCount(dynamicQuery);
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

		return _groupLinkLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public LinkManager.Service.model.GroupLink fetchGroupLink(
		long linksgroupid) {

		return _groupLinkLocalService.fetchGroupLink(linksgroupid);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _groupLinkLocalService.getActionableDynamicQuery();
	}

	@Override
	public int getCount(String name, long groupId) {
		return _groupLinkLocalService.getCount(name, groupId);
	}

	@Override
	public int getCountAll(String name, long groupId) throws Exception {
		return _groupLinkLocalService.getCountAll(name, groupId);
	}

	/**
	 * Returns the group link with the primary key.
	 *
	 * @param linksgroupid the primary key of the group link
	 * @return the group link
	 * @throws PortalException if a group link with the primary key could not be found
	 */
	@Override
	public LinkManager.Service.model.GroupLink getGroupLink(long linksgroupid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupLinkLocalService.getGroupLink(linksgroupid);
	}

	/**
	 * Returns a range of all the group links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinkManager.Service.model.impl.GroupLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of group links
	 * @param end the upper bound of the range of group links (not inclusive)
	 * @return the range of group links
	 */
	@Override
	public java.util.List<LinkManager.Service.model.GroupLink> getGroupLinks(
		int start, int end) {

		return _groupLinkLocalService.getGroupLinks(start, end);
	}

	/**
	 * Returns the number of group links.
	 *
	 * @return the number of group links
	 */
	@Override
	public int getGroupLinksCount() {
		return _groupLinkLocalService.getGroupLinksCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _groupLinkLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<LinkManager.Service.model.GroupLink> getListGroupLink(
		String name, int start, int limit, long groupId) {

		return _groupLinkLocalService.getListGroupLink(
			name, start, limit, groupId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _groupLinkLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _groupLinkLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the group link in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param groupLink the group link
	 * @return the group link that was updated
	 */
	@Override
	public LinkManager.Service.model.GroupLink updateGroupLink(
		LinkManager.Service.model.GroupLink groupLink) {

		return _groupLinkLocalService.updateGroupLink(groupLink);
	}

	@Override
	public GroupLinkLocalService getWrappedService() {
		return _groupLinkLocalService;
	}

	@Override
	public void setWrappedService(GroupLinkLocalService groupLinkLocalService) {
		_groupLinkLocalService = groupLinkLocalService;
	}

	private GroupLinkLocalService _groupLinkLocalService;

}