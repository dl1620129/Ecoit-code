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

import com.ecoit.cms.config.exception.NoSuchPortletConfigException;
import com.ecoit.cms.config.model.PortletConfig;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the portlet config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PortletConfigUtil
 * @generated
 */
@ProviderType
public interface PortletConfigPersistence
	extends BasePersistence<PortletConfig> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PortletConfigUtil} to access the portlet config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the portlet configs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching portlet configs
	 */
	public java.util.List<PortletConfig> findByUuid(String uuid);

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
	public java.util.List<PortletConfig> findByUuid(
		String uuid, int start, int end);

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
	public java.util.List<PortletConfig> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PortletConfig>
			orderByComparator);

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
	public java.util.List<PortletConfig> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PortletConfig>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first portlet config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portlet config
	 * @throws NoSuchPortletConfigException if a matching portlet config could not be found
	 */
	public PortletConfig findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PortletConfig>
				orderByComparator)
		throws NoSuchPortletConfigException;

	/**
	 * Returns the first portlet config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching portlet config, or <code>null</code> if a matching portlet config could not be found
	 */
	public PortletConfig fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PortletConfig>
			orderByComparator);

	/**
	 * Returns the last portlet config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portlet config
	 * @throws NoSuchPortletConfigException if a matching portlet config could not be found
	 */
	public PortletConfig findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PortletConfig>
				orderByComparator)
		throws NoSuchPortletConfigException;

	/**
	 * Returns the last portlet config in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching portlet config, or <code>null</code> if a matching portlet config could not be found
	 */
	public PortletConfig fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<PortletConfig>
			orderByComparator);

	/**
	 * Returns the portlet configs before and after the current portlet config in the ordered set where uuid = &#63;.
	 *
	 * @param portletId the primary key of the current portlet config
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next portlet config
	 * @throws NoSuchPortletConfigException if a portlet config with the primary key could not be found
	 */
	public PortletConfig[] findByUuid_PrevAndNext(
			String portletId, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<PortletConfig>
				orderByComparator)
		throws NoSuchPortletConfigException;

	/**
	 * Removes all the portlet configs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of portlet configs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching portlet configs
	 */
	public int countByUuid(String uuid);

	/**
	 * Caches the portlet config in the entity cache if it is enabled.
	 *
	 * @param portletConfig the portlet config
	 */
	public void cacheResult(PortletConfig portletConfig);

	/**
	 * Caches the portlet configs in the entity cache if it is enabled.
	 *
	 * @param portletConfigs the portlet configs
	 */
	public void cacheResult(java.util.List<PortletConfig> portletConfigs);

	/**
	 * Creates a new portlet config with the primary key. Does not add the portlet config to the database.
	 *
	 * @param portletId the primary key for the new portlet config
	 * @return the new portlet config
	 */
	public PortletConfig create(String portletId);

	/**
	 * Removes the portlet config with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param portletId the primary key of the portlet config
	 * @return the portlet config that was removed
	 * @throws NoSuchPortletConfigException if a portlet config with the primary key could not be found
	 */
	public PortletConfig remove(String portletId)
		throws NoSuchPortletConfigException;

	public PortletConfig updateImpl(PortletConfig portletConfig);

	/**
	 * Returns the portlet config with the primary key or throws a <code>NoSuchPortletConfigException</code> if it could not be found.
	 *
	 * @param portletId the primary key of the portlet config
	 * @return the portlet config
	 * @throws NoSuchPortletConfigException if a portlet config with the primary key could not be found
	 */
	public PortletConfig findByPrimaryKey(String portletId)
		throws NoSuchPortletConfigException;

	/**
	 * Returns the portlet config with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param portletId the primary key of the portlet config
	 * @return the portlet config, or <code>null</code> if a portlet config with the primary key could not be found
	 */
	public PortletConfig fetchByPrimaryKey(String portletId);

	/**
	 * Returns all the portlet configs.
	 *
	 * @return the portlet configs
	 */
	public java.util.List<PortletConfig> findAll();

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
	public java.util.List<PortletConfig> findAll(int start, int end);

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
	public java.util.List<PortletConfig> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PortletConfig>
			orderByComparator);

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
	public java.util.List<PortletConfig> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<PortletConfig>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the portlet configs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of portlet configs.
	 *
	 * @return the number of portlet configs
	 */
	public int countAll();

}