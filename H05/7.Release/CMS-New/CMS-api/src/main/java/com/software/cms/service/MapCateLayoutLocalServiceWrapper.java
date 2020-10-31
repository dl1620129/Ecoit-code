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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MapCateLayoutLocalService}.
 *
 * @author DungNV
 * @see MapCateLayoutLocalService
 * @generated
 */
public class MapCateLayoutLocalServiceWrapper
	implements MapCateLayoutLocalService,
			   ServiceWrapper<MapCateLayoutLocalService> {

	public MapCateLayoutLocalServiceWrapper(
		MapCateLayoutLocalService mapCateLayoutLocalService) {

		_mapCateLayoutLocalService = mapCateLayoutLocalService;
	}

	/**
	 * Adds the map cate layout to the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapCateLayout the map cate layout
	 * @return the map cate layout that was added
	 */
	@Override
	public com.software.cms.model.MapCateLayout addMapCateLayout(
		com.software.cms.model.MapCateLayout mapCateLayout) {

		return _mapCateLayoutLocalService.addMapCateLayout(mapCateLayout);
	}

	@Override
	public int checkExits(long categoryId, int type) {
		return _mapCateLayoutLocalService.checkExits(categoryId, type);
	}

	@Override
	public com.software.cms.model.MapCateLayout create() {
		return _mapCateLayoutLocalService.create();
	}

	/**
	 * Creates a new map cate layout with the primary key. Does not add the map cate layout to the database.
	 *
	 * @param mapCateLayoutId the primary key for the new map cate layout
	 * @return the new map cate layout
	 */
	@Override
	public com.software.cms.model.MapCateLayout createMapCateLayout(
		long mapCateLayoutId) {

		return _mapCateLayoutLocalService.createMapCateLayout(mapCateLayoutId);
	}

	/**
	 * Deletes the map cate layout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapCateLayoutId the primary key of the map cate layout
	 * @return the map cate layout that was removed
	 * @throws PortalException if a map cate layout with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.MapCateLayout deleteMapCateLayout(
			long mapCateLayoutId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mapCateLayoutLocalService.deleteMapCateLayout(mapCateLayoutId);
	}

	/**
	 * Deletes the map cate layout from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapCateLayout the map cate layout
	 * @return the map cate layout that was removed
	 */
	@Override
	public com.software.cms.model.MapCateLayout deleteMapCateLayout(
		com.software.cms.model.MapCateLayout mapCateLayout) {

		return _mapCateLayoutLocalService.deleteMapCateLayout(mapCateLayout);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mapCateLayoutLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _mapCateLayoutLocalService.dynamicQuery();
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

		return _mapCateLayoutLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _mapCateLayoutLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _mapCateLayoutLocalService.dynamicQuery(
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

		return _mapCateLayoutLocalService.dynamicQueryCount(dynamicQuery);
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

		return _mapCateLayoutLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.software.cms.model.MapCateLayout fetchMapCateLayout(
		long mapCateLayoutId) {

		return _mapCateLayoutLocalService.fetchMapCateLayout(mapCateLayoutId);
	}

	/**
	 * Returns the map cate layout matching the UUID and group.
	 *
	 * @param uuid the map cate layout's UUID
	 * @param groupId the primary key of the group
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	@Override
	public com.software.cms.model.MapCateLayout
		fetchMapCateLayoutByUuidAndGroupId(String uuid, long groupId) {

		return _mapCateLayoutLocalService.fetchMapCateLayoutByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _mapCateLayoutLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.software.cms.model.MapCateLayout getCategoryIdByLayoutIdAndType(
		long layoutId, int type) {

		return _mapCateLayoutLocalService.getCategoryIdByLayoutIdAndType(
			layoutId, type);
	}

	@Override
	public com.software.cms.model.MapCateLayout getFriendsUrlByCategoryId(
		long categoryId) {

		return _mapCateLayoutLocalService.getFriendsUrlByCategoryId(categoryId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _mapCateLayoutLocalService.getIndexableActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.software.cms.model.MapCateLayout>
		getListMapCateLayoutByType(long groupId, int type) {

		return _mapCateLayoutLocalService.getListMapCateLayoutByType(
			groupId, type);
	}

	/**
	 * Returns the map cate layout with the primary key.
	 *
	 * @param mapCateLayoutId the primary key of the map cate layout
	 * @return the map cate layout
	 * @throws PortalException if a map cate layout with the primary key could not be found
	 */
	@Override
	public com.software.cms.model.MapCateLayout getMapCateLayout(
			long mapCateLayoutId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mapCateLayoutLocalService.getMapCateLayout(mapCateLayoutId);
	}

	@Override
	public com.software.cms.model.MapCateLayout
		getMapCateLayoutByCategoryIdAndType(long categoryId, int type) {

		return _mapCateLayoutLocalService.getMapCateLayoutByCategoryIdAndType(
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
	@Override
	public com.software.cms.model.MapCateLayout
			getMapCateLayoutByUuidAndGroupId(String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mapCateLayoutLocalService.getMapCateLayoutByUuidAndGroupId(
			uuid, groupId);
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
	@Override
	public java.util.List<com.software.cms.model.MapCateLayout>
		getMapCateLayouts(int start, int end) {

		return _mapCateLayoutLocalService.getMapCateLayouts(start, end);
	}

	/**
	 * Returns all the map cate layouts matching the UUID and company.
	 *
	 * @param uuid the UUID of the map cate layouts
	 * @param companyId the primary key of the company
	 * @return the matching map cate layouts, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.software.cms.model.MapCateLayout>
		getMapCateLayoutsByUuidAndCompanyId(String uuid, long companyId) {

		return _mapCateLayoutLocalService.getMapCateLayoutsByUuidAndCompanyId(
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
	@Override
	public java.util.List<com.software.cms.model.MapCateLayout>
		getMapCateLayoutsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.software.cms.model.MapCateLayout> orderByComparator) {

		return _mapCateLayoutLocalService.getMapCateLayoutsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of map cate layouts.
	 *
	 * @return the number of map cate layouts
	 */
	@Override
	public int getMapCateLayoutsCount() {
		return _mapCateLayoutLocalService.getMapCateLayoutsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _mapCateLayoutLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _mapCateLayoutLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the map cate layout in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param mapCateLayout the map cate layout
	 * @return the map cate layout that was updated
	 */
	@Override
	public com.software.cms.model.MapCateLayout updateMapCateLayout(
		com.software.cms.model.MapCateLayout mapCateLayout) {

		return _mapCateLayoutLocalService.updateMapCateLayout(mapCateLayout);
	}

	@Override
	public MapCateLayoutLocalService getWrappedService() {
		return _mapCateLayoutLocalService;
	}

	@Override
	public void setWrappedService(
		MapCateLayoutLocalService mapCateLayoutLocalService) {

		_mapCateLayoutLocalService = mapCateLayoutLocalService;
	}

	private MapCateLayoutLocalService _mapCateLayoutLocalService;

}