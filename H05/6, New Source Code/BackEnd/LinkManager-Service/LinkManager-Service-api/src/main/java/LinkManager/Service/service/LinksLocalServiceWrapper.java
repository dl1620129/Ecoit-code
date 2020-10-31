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
 * Provides a wrapper for {@link LinksLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LinksLocalService
 * @generated
 */
@ProviderType
public class LinksLocalServiceWrapper
	implements LinksLocalService, ServiceWrapper<LinksLocalService> {

	public LinksLocalServiceWrapper(LinksLocalService linksLocalService) {
		_linksLocalService = linksLocalService;
	}

	/**
	 * Adds the links to the database. Also notifies the appropriate model listeners.
	 *
	 * @param links the links
	 * @return the links that was added
	 */
	@Override
	public LinkManager.Service.model.Links addLinks(
		LinkManager.Service.model.Links links) {

		return _linksLocalService.addLinks(links);
	}

	/**
	 * Creates a new links with the primary key. Does not add the links to the database.
	 *
	 * @param linksid the primary key for the new links
	 * @return the new links
	 */
	@Override
	public LinkManager.Service.model.Links createLinks(long linksid) {
		return _linksLocalService.createLinks(linksid);
	}

	/**
	 * Deletes the links from the database. Also notifies the appropriate model listeners.
	 *
	 * @param links the links
	 * @return the links that was removed
	 */
	@Override
	public LinkManager.Service.model.Links deleteLinks(
		LinkManager.Service.model.Links links) {

		return _linksLocalService.deleteLinks(links);
	}

	/**
	 * Deletes the links with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linksid the primary key of the links
	 * @return the links that was removed
	 * @throws PortalException if a links with the primary key could not be found
	 */
	@Override
	public LinkManager.Service.model.Links deleteLinks(long linksid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linksLocalService.deleteLinks(linksid);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linksLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _linksLocalService.dynamicQuery();
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

		return _linksLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinkManager.Service.model.impl.LinksModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _linksLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinkManager.Service.model.impl.LinksModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _linksLocalService.dynamicQuery(
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

		return _linksLocalService.dynamicQueryCount(dynamicQuery);
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

		return _linksLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public LinkManager.Service.model.Links fetchLinks(long linksid) {
		return _linksLocalService.fetchLinks(linksid);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _linksLocalService.getActionableDynamicQuery();
	}

	@Override
	public int getCountByTag(String name, long groupId) throws Exception {
		return _linksLocalService.getCountByTag(name, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _linksLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<LinkManager.Service.model.Links> getLinkByLinkGroupId(
			long groupId, long linkGroupId)
		throws Exception {

		return _linksLocalService.getLinkByLinkGroupId(groupId, linkGroupId);
	}

	/**
	 * Returns the links with the primary key.
	 *
	 * @param linksid the primary key of the links
	 * @return the links
	 * @throws PortalException if a links with the primary key could not be found
	 */
	@Override
	public LinkManager.Service.model.Links getLinks(long linksid)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linksLocalService.getLinks(linksid);
	}

	/**
	 * Returns a range of all the linkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinkManager.Service.model.impl.LinksModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of linkses
	 * @param end the upper bound of the range of linkses (not inclusive)
	 * @return the range of linkses
	 */
	@Override
	public java.util.List<LinkManager.Service.model.Links> getLinkses(
		int start, int end) {

		return _linksLocalService.getLinkses(start, end);
	}

	/**
	 * Returns the number of linkses.
	 *
	 * @return the number of linkses
	 */
	@Override
	public int getLinksesCount() {
		return _linksLocalService.getLinksesCount();
	}

	@Override
	public java.util.List<LinkManager.Service.model.Links> getListLink(
			String name, long groupId, int start, int limit)
		throws Exception {

		return _linksLocalService.getListLink(name, groupId, start, limit);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _linksLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _linksLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the links in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param links the links
	 * @return the links that was updated
	 */
	@Override
	public LinkManager.Service.model.Links updateLinks(
		LinkManager.Service.model.Links links) {

		return _linksLocalService.updateLinks(links);
	}

	@Override
	public LinksLocalService getWrappedService() {
		return _linksLocalService;
	}

	@Override
	public void setWrappedService(LinksLocalService linksLocalService) {
		_linksLocalService = linksLocalService;
	}

	private LinksLocalService _linksLocalService;

}