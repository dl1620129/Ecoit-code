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

package com.ecoit.cms.config.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PortletConfigLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PortletConfigLocalService
 * @generated
 */
public class PortletConfigLocalServiceWrapper
	implements PortletConfigLocalService,
			   ServiceWrapper<PortletConfigLocalService> {

	public PortletConfigLocalServiceWrapper(
		PortletConfigLocalService portletConfigLocalService) {

		_portletConfigLocalService = portletConfigLocalService;
	}

	/**
	 * Adds the portlet config to the database. Also notifies the appropriate model listeners.
	 *
	 * @param portletConfig the portlet config
	 * @return the portlet config that was added
	 */
	@Override
	public com.ecoit.cms.config.model.PortletConfig addPortletConfig(
		com.ecoit.cms.config.model.PortletConfig portletConfig) {

		return _portletConfigLocalService.addPortletConfig(portletConfig);
	}

	@Override
	public int countConfig(String q) {
		return _portletConfigLocalService.countConfig(q);
	}

	/**
	 * Creates a new portlet config with the primary key. Does not add the portlet config to the database.
	 *
	 * @param portletId the primary key for the new portlet config
	 * @return the new portlet config
	 */
	@Override
	public com.ecoit.cms.config.model.PortletConfig createPortletConfig(
		String portletId) {

		return _portletConfigLocalService.createPortletConfig(portletId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _portletConfigLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the portlet config from the database. Also notifies the appropriate model listeners.
	 *
	 * @param portletConfig the portlet config
	 * @return the portlet config that was removed
	 */
	@Override
	public com.ecoit.cms.config.model.PortletConfig deletePortletConfig(
		com.ecoit.cms.config.model.PortletConfig portletConfig) {

		return _portletConfigLocalService.deletePortletConfig(portletConfig);
	}

	/**
	 * Deletes the portlet config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param portletId the primary key of the portlet config
	 * @return the portlet config that was removed
	 * @throws PortalException if a portlet config with the primary key could not be found
	 */
	@Override
	public com.ecoit.cms.config.model.PortletConfig deletePortletConfig(
			String portletId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _portletConfigLocalService.deletePortletConfig(portletId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _portletConfigLocalService.dynamicQuery();
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

		return _portletConfigLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.cms.config.model.impl.PortletConfigModelImpl</code>.
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

		return _portletConfigLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.cms.config.model.impl.PortletConfigModelImpl</code>.
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

		return _portletConfigLocalService.dynamicQuery(
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

		return _portletConfigLocalService.dynamicQueryCount(dynamicQuery);
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

		return _portletConfigLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.cms.config.model.PortletConfig fetchPortletConfig(
		String portletId) {

		return _portletConfigLocalService.fetchPortletConfig(portletId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _portletConfigLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _portletConfigLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the portlet config with the primary key.
	 *
	 * @param portletId the primary key of the portlet config
	 * @return the portlet config
	 * @throws PortalException if a portlet config with the primary key could not be found
	 */
	@Override
	public com.ecoit.cms.config.model.PortletConfig getPortletConfig(
			String portletId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _portletConfigLocalService.getPortletConfig(portletId);
	}

	/**
	 * Returns a range of all the portlet configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.cms.config.model.impl.PortletConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of portlet configs
	 * @param end the upper bound of the range of portlet configs (not inclusive)
	 * @return the range of portlet configs
	 */
	@Override
	public java.util.List<com.ecoit.cms.config.model.PortletConfig>
		getPortletConfigs(int start, int end) {

		return _portletConfigLocalService.getPortletConfigs(start, end);
	}

	/**
	 * Returns the number of portlet configs.
	 *
	 * @return the number of portlet configs
	 */
	@Override
	public int getPortletConfigsCount() {
		return _portletConfigLocalService.getPortletConfigsCount();
	}

	@Override
	public java.util.List<com.ecoit.cms.config.model.PortletConfig>
		searchConfig(String q, int start, int limit) {

		return _portletConfigLocalService.searchConfig(q, start, limit);
	}

	/**
	 * Updates the portlet config in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param portletConfig the portlet config
	 * @return the portlet config that was updated
	 */
	@Override
	public com.ecoit.cms.config.model.PortletConfig updatePortletConfig(
		com.ecoit.cms.config.model.PortletConfig portletConfig) {

		return _portletConfigLocalService.updatePortletConfig(portletConfig);
	}

	@Override
	public PortletConfigLocalService getWrappedService() {
		return _portletConfigLocalService;
	}

	@Override
	public void setWrappedService(
		PortletConfigLocalService portletConfigLocalService) {

		_portletConfigLocalService = portletConfigLocalService;
	}

	private PortletConfigLocalService _portletConfigLocalService;

}