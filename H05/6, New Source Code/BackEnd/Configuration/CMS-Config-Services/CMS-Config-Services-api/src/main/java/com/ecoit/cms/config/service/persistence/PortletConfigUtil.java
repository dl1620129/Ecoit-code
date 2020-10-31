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

package com.ecoit.cms.config.service.persistence;

import com.ecoit.cms.config.model.PortletConfig;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the portlet config service. This utility wraps <code>com.ecoit.cms.config.service.persistence.impl.PortletConfigPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PortletConfigPersistence
 * @generated
 */
public class PortletConfigUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(PortletConfig portletConfig) {
		getPersistence().clearCache(portletConfig);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, PortletConfig> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<PortletConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<PortletConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<PortletConfig> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<PortletConfig> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static PortletConfig update(PortletConfig portletConfig) {
		return getPersistence().update(portletConfig);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static PortletConfig update(
		PortletConfig portletConfig, ServiceContext serviceContext) {

		return getPersistence().update(portletConfig, serviceContext);
	}

	/**
	 * Returns all the portlet configs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching portlet configs
	 */
	public static List<PortletConfig> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the portlet configs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PortletConfigModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of portlet configs
	 * @param end the upper bound of the range of portlet configs (not inclusive)
	 * @return the range of matching portlet configs
	 */
	public static List<PortletConfig> findByUuid(
		String uuid, int start, int end) {

		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the portlet configs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PortletConfigModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of portlet configs
	 * @param end the upper bound of the range of portlet configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching portlet configs
	 */
	public static List<PortletConfig> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PortletConfig> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the portlet configs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PortletConfigModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of portlet configs
	 * @param end the upper bound of the range of portlet configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching portlet configs
	 */
	public static List<PortletConfig> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<PortletConfig> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first portlet config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portlet config
	 * @throws NoSuchPortletConfigException if a matching portlet config could not be found
	 */
	public static PortletConfig findByUuid_First(
			String uuid, OrderByComparator<PortletConfig> orderByComparator)
		throws com.ecoit.cms.config.exception.NoSuchPortletConfigException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first portlet config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portlet config, or <code>null</code> if a matching portlet config could not be found
	 */
	public static PortletConfig fetchByUuid_First(
		String uuid, OrderByComparator<PortletConfig> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last portlet config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portlet config
	 * @throws NoSuchPortletConfigException if a matching portlet config could not be found
	 */
	public static PortletConfig findByUuid_Last(
			String uuid, OrderByComparator<PortletConfig> orderByComparator)
		throws com.ecoit.cms.config.exception.NoSuchPortletConfigException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last portlet config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portlet config, or <code>null</code> if a matching portlet config could not be found
	 */
	public static PortletConfig fetchByUuid_Last(
		String uuid, OrderByComparator<PortletConfig> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the portlet configs before and after the current portlet config in the ordered set where uuid = &#63;.
	 *
	 * @param portletId the primary key of the current portlet config
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next portlet config
	 * @throws NoSuchPortletConfigException if a portlet config with the primary key could not be found
	 */
	public static PortletConfig[] findByUuid_PrevAndNext(
			String portletId, String uuid,
			OrderByComparator<PortletConfig> orderByComparator)
		throws com.ecoit.cms.config.exception.NoSuchPortletConfigException {

		return getPersistence().findByUuid_PrevAndNext(
			portletId, uuid, orderByComparator);
	}

	/**
	 * Removes all the portlet configs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of portlet configs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching portlet configs
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Caches the portlet config in the entity cache if it is enabled.
	 *
	 * @param portletConfig the portlet config
	 */
	public static void cacheResult(PortletConfig portletConfig) {
		getPersistence().cacheResult(portletConfig);
	}

	/**
	 * Caches the portlet configs in the entity cache if it is enabled.
	 *
	 * @param portletConfigs the portlet configs
	 */
	public static void cacheResult(List<PortletConfig> portletConfigs) {
		getPersistence().cacheResult(portletConfigs);
	}

	/**
	 * Creates a new portlet config with the primary key. Does not add the portlet config to the database.
	 *
	 * @param portletId the primary key for the new portlet config
	 * @return the new portlet config
	 */
	public static PortletConfig create(String portletId) {
		return getPersistence().create(portletId);
	}

	/**
	 * Removes the portlet config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param portletId the primary key of the portlet config
	 * @return the portlet config that was removed
	 * @throws NoSuchPortletConfigException if a portlet config with the primary key could not be found
	 */
	public static PortletConfig remove(String portletId)
		throws com.ecoit.cms.config.exception.NoSuchPortletConfigException {

		return getPersistence().remove(portletId);
	}

	public static PortletConfig updateImpl(PortletConfig portletConfig) {
		return getPersistence().updateImpl(portletConfig);
	}

	/**
	 * Returns the portlet config with the primary key or throws a <code>NoSuchPortletConfigException</code> if it could not be found.
	 *
	 * @param portletId the primary key of the portlet config
	 * @return the portlet config
	 * @throws NoSuchPortletConfigException if a portlet config with the primary key could not be found
	 */
	public static PortletConfig findByPrimaryKey(String portletId)
		throws com.ecoit.cms.config.exception.NoSuchPortletConfigException {

		return getPersistence().findByPrimaryKey(portletId);
	}

	/**
	 * Returns the portlet config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param portletId the primary key of the portlet config
	 * @return the portlet config, or <code>null</code> if a portlet config with the primary key could not be found
	 */
	public static PortletConfig fetchByPrimaryKey(String portletId) {
		return getPersistence().fetchByPrimaryKey(portletId);
	}

	/**
	 * Returns all the portlet configs.
	 *
	 * @return the portlet configs
	 */
	public static List<PortletConfig> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the portlet configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PortletConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of portlet configs
	 * @param end the upper bound of the range of portlet configs (not inclusive)
	 * @return the range of portlet configs
	 */
	public static List<PortletConfig> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the portlet configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PortletConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of portlet configs
	 * @param end the upper bound of the range of portlet configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of portlet configs
	 */
	public static List<PortletConfig> findAll(
		int start, int end,
		OrderByComparator<PortletConfig> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the portlet configs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PortletConfigModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of portlet configs
	 * @param end the upper bound of the range of portlet configs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of portlet configs
	 */
	public static List<PortletConfig> findAll(
		int start, int end, OrderByComparator<PortletConfig> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the portlet configs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of portlet configs.
	 *
	 * @return the number of portlet configs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static PortletConfigPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PortletConfigPersistence, PortletConfigPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(PortletConfigPersistence.class);

		ServiceTracker<PortletConfigPersistence, PortletConfigPersistence>
			serviceTracker =
				new ServiceTracker
					<PortletConfigPersistence, PortletConfigPersistence>(
						bundle.getBundleContext(),
						PortletConfigPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}