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
 * Provides a wrapper for {@link portalLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see portalLocalService
 * @generated
 */
@ProviderType
public class portalLocalServiceWrapper
	implements portalLocalService, ServiceWrapper<portalLocalService> {

	public portalLocalServiceWrapper(portalLocalService portalLocalService) {
		_portalLocalService = portalLocalService;
	}

	/**
	 * Adds the portal to the database. Also notifies the appropriate model listeners.
	 *
	 * @param portal the portal
	 * @return the portal that was added
	 */
	@Override
	public LinkManager.Service.model.portal addportal(
		LinkManager.Service.model.portal portal) {

		return _portalLocalService.addportal(portal);
	}

	/**
	 * Creates a new portal with the primary key. Does not add the portal to the database.
	 *
	 * @param portalId the primary key for the new portal
	 * @return the new portal
	 */
	@Override
	public LinkManager.Service.model.portal createportal(long portalId) {
		return _portalLocalService.createportal(portalId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _portalLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the portal with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param portalId the primary key of the portal
	 * @return the portal that was removed
	 * @throws PortalException if a portal with the primary key could not be found
	 */
	@Override
	public LinkManager.Service.model.portal deleteportal(long portalId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _portalLocalService.deleteportal(portalId);
	}

	/**
	 * Deletes the portal from the database. Also notifies the appropriate model listeners.
	 *
	 * @param portal the portal
	 * @return the portal that was removed
	 */
	@Override
	public LinkManager.Service.model.portal deleteportal(
		LinkManager.Service.model.portal portal) {

		return _portalLocalService.deleteportal(portal);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _portalLocalService.dynamicQuery();
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

		return _portalLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinkManager.Service.model.impl.portalModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _portalLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinkManager.Service.model.impl.portalModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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

		return _portalLocalService.dynamicQuery(
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

		return _portalLocalService.dynamicQueryCount(dynamicQuery);
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

		return _portalLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public LinkManager.Service.model.portal fetchportal(long portalId) {
		return _portalLocalService.fetchportal(portalId);
	}

	/**
	 * Returns the portal matching the UUID and group.
	 *
	 * @param uuid the portal's UUID
	 * @param groupId the primary key of the group
	 * @return the matching portal, or <code>null</code> if a matching portal could not be found
	 */
	@Override
	public LinkManager.Service.model.portal fetchportalByUuidAndGroupId(
		String uuid, long groupId) {

		return _portalLocalService.fetchportalByUuidAndGroupId(uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _portalLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _portalLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _portalLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _portalLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _portalLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the portal with the primary key.
	 *
	 * @param portalId the primary key of the portal
	 * @return the portal
	 * @throws PortalException if a portal with the primary key could not be found
	 */
	@Override
	public LinkManager.Service.model.portal getportal(long portalId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _portalLocalService.getportal(portalId);
	}

	/**
	 * Returns the portal matching the UUID and group.
	 *
	 * @param uuid the portal's UUID
	 * @param groupId the primary key of the group
	 * @return the matching portal
	 * @throws PortalException if a matching portal could not be found
	 */
	@Override
	public LinkManager.Service.model.portal getportalByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _portalLocalService.getportalByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the portals.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinkManager.Service.model.impl.portalModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of portals
	 * @param end the upper bound of the range of portals (not inclusive)
	 * @return the range of portals
	 */
	@Override
	public java.util.List<LinkManager.Service.model.portal> getportals(
		int start, int end) {

		return _portalLocalService.getportals(start, end);
	}

	/**
	 * Returns all the portals matching the UUID and company.
	 *
	 * @param uuid the UUID of the portals
	 * @param companyId the primary key of the company
	 * @return the matching portals, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<LinkManager.Service.model.portal>
		getportalsByUuidAndCompanyId(String uuid, long companyId) {

		return _portalLocalService.getportalsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of portals matching the UUID and company.
	 *
	 * @param uuid the UUID of the portals
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of portals
	 * @param end the upper bound of the range of portals (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching portals, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<LinkManager.Service.model.portal>
		getportalsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<LinkManager.Service.model.portal> orderByComparator) {

		return _portalLocalService.getportalsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of portals.
	 *
	 * @return the number of portals
	 */
	@Override
	public int getportalsCount() {
		return _portalLocalService.getportalsCount();
	}

	/**
	 * Updates the portal in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param portal the portal
	 * @return the portal that was updated
	 */
	@Override
	public LinkManager.Service.model.portal updateportal(
		LinkManager.Service.model.portal portal) {

		return _portalLocalService.updateportal(portal);
	}

	@Override
	public portalLocalService getWrappedService() {
		return _portalLocalService;
	}

	@Override
	public void setWrappedService(portalLocalService portalLocalService) {
		_portalLocalService = portalLocalService;
	}

	private portalLocalService _portalLocalService;

}