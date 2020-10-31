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

package com.software.cms.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for MapCateLayout. This utility wraps
 * <code>com.software.cms.service.impl.MapCateLayoutLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author DungNV
 * @see MapCateLayoutLocalService
 * @generated
 */
public class MapCateLayoutLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.software.cms.service.impl.MapCateLayoutLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the map cate layout to the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapCateLayout the map cate layout
	 * @return the map cate layout that was added
	 */
	public static com.software.cms.model.MapCateLayout addMapCateLayout(
		com.software.cms.model.MapCateLayout mapCateLayout) {

		return getService().addMapCateLayout(mapCateLayout);
	}

	public static int checkExits(long categoryId, int type) {
		return getService().checkExits(categoryId, type);
	}

	public static com.software.cms.model.MapCateLayout create() {
		return getService().create();
	}

	/**
	 * Creates a new map cate layout with the primary key. Does not add the map cate layout to the database.
	 *
	 * @param mapCateLayoutId the primary key for the new map cate layout
	 * @return the new map cate layout
	 */
	public static com.software.cms.model.MapCateLayout createMapCateLayout(
		long mapCateLayoutId) {

		return getService().createMapCateLayout(mapCateLayoutId);
	}

	/**
	 * Deletes the map cate layout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapCateLayoutId the primary key of the map cate layout
	 * @return the map cate layout that was removed
	 * @throws PortalException if a map cate layout with the primary key could not be found
	 */
	public static com.software.cms.model.MapCateLayout deleteMapCateLayout(
			long mapCateLayoutId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteMapCateLayout(mapCateLayoutId);
	}

	/**
	 * Deletes the map cate layout from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapCateLayout the map cate layout
	 * @return the map cate layout that was removed
	 */
	public static com.software.cms.model.MapCateLayout deleteMapCateLayout(
		com.software.cms.model.MapCateLayout mapCateLayout) {

		return getService().deleteMapCateLayout(mapCateLayout);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.MapCateLayoutModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.MapCateLayoutModelImpl</code>.
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

	public static com.software.cms.model.MapCateLayout fetchMapCateLayout(
		long mapCateLayoutId) {

		return getService().fetchMapCateLayout(mapCateLayoutId);
	}

	/**
	 * Returns the map cate layout matching the UUID and group.
	 *
	 * @param uuid the map cate layout's UUID
	 * @param groupId the primary key of the group
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	public static com.software.cms.model.MapCateLayout
		fetchMapCateLayoutByUuidAndGroupId(String uuid, long groupId) {

		return getService().fetchMapCateLayoutByUuidAndGroupId(uuid, groupId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static com.software.cms.model.MapCateLayout
		getCategoryIdByLayoutIdAndType(long layoutId, int type) {

		return getService().getCategoryIdByLayoutIdAndType(layoutId, type);
	}

	public static com.software.cms.model.MapCateLayout
		getFriendsUrlByCategoryId(long categoryId) {

		return getService().getFriendsUrlByCategoryId(categoryId);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static java.util.List<com.software.cms.model.MapCateLayout>
		getListMapCateLayoutByType(long groupId, int type) {

		return getService().getListMapCateLayoutByType(groupId, type);
	}

	/**
	 * Returns the map cate layout with the primary key.
	 *
	 * @param mapCateLayoutId the primary key of the map cate layout
	 * @return the map cate layout
	 * @throws PortalException if a map cate layout with the primary key could not be found
	 */
	public static com.software.cms.model.MapCateLayout getMapCateLayout(
			long mapCateLayoutId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMapCateLayout(mapCateLayoutId);
	}

	public static com.software.cms.model.MapCateLayout
		getMapCateLayoutByCategoryIdAndType(long categoryId, int type) {

		return getService().getMapCateLayoutByCategoryIdAndType(
			categoryId, type);
	}

	/**
	 * Returns the map cate layout matching the UUID and group.
	 *
	 * @param uuid the map cate layout's UUID
	 * @param groupId the primary key of the group
	 * @return the matching map cate layout
	 * @throws PortalException if a matching map cate layout could not be found
	 */
	public static com.software.cms.model.MapCateLayout
			getMapCateLayoutByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMapCateLayoutByUuidAndGroupId(uuid, groupId);
	}

	/**
	 * Returns a range of all the map cate layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.software.cms.model.impl.MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @return the range of map cate layouts
	 */
	public static java.util.List<com.software.cms.model.MapCateLayout>
		getMapCateLayouts(int start, int end) {

		return getService().getMapCateLayouts(start, end);
	}

	/**
	 * Returns all the map cate layouts matching the UUID and company.
	 *
	 * @param uuid the UUID of the map cate layouts
	 * @param companyId the primary key of the company
	 * @return the matching map cate layouts, or an empty list if no matches were found
	 */
	public static java.util.List<com.software.cms.model.MapCateLayout>
		getMapCateLayoutsByUuidAndCompanyId(String uuid, long companyId) {

		return getService().getMapCateLayoutsByUuidAndCompanyId(
			uuid, companyId);
	}

	/**
	 * Returns a range of map cate layouts matching the UUID and company.
	 *
	 * @param uuid the UUID of the map cate layouts
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching map cate layouts, or an empty list if no matches were found
	 */
	public static java.util.List<com.software.cms.model.MapCateLayout>
		getMapCateLayoutsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.software.cms.model.MapCateLayout> orderByComparator) {

		return getService().getMapCateLayoutsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of map cate layouts.
	 *
	 * @return the number of map cate layouts
	 */
	public static int getMapCateLayoutsCount() {
		return getService().getMapCateLayoutsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the map cate layout in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param mapCateLayout the map cate layout
	 * @return the map cate layout that was updated
	 */
	public static com.software.cms.model.MapCateLayout updateMapCateLayout(
		com.software.cms.model.MapCateLayout mapCateLayout) {

		return getService().updateMapCateLayout(mapCateLayout);
	}

	public static MapCateLayoutLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<MapCateLayoutLocalService, MapCateLayoutLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			MapCateLayoutLocalService.class);

		ServiceTracker<MapCateLayoutLocalService, MapCateLayoutLocalService>
			serviceTracker =
				new ServiceTracker
					<MapCateLayoutLocalService, MapCateLayoutLocalService>(
						bundle.getBundleContext(),
						MapCateLayoutLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}