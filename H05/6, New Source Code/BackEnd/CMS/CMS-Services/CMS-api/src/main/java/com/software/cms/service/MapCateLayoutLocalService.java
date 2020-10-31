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

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import com.software.cms.model.MapCateLayout;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for MapCateLayout. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author DungNV
 * @see MapCateLayoutLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface MapCateLayoutLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MapCateLayoutLocalServiceUtil} to access the map cate layout local service. Add custom service methods to <code>com.software.cms.service.impl.MapCateLayoutLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the map cate layout to the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapCateLayout the map cate layout
	 * @return the map cate layout that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public MapCateLayout addMapCateLayout(MapCateLayout mapCateLayout);

	public int checkExits(long categoryId, int type);

	public int countMapCateLayout(long groupId, long companyId)
		throws Exception;

	public MapCateLayout create();

	/**
	 * Creates a new map cate layout with the primary key. Does not add the map cate layout to the database.
	 *
	 * @param mapCateLayoutId the primary key for the new map cate layout
	 * @return the new map cate layout
	 */
	@Transactional(enabled = false)
	public MapCateLayout createMapCateLayout(long mapCateLayoutId);

	/**
	 * Deletes the map cate layout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapCateLayoutId the primary key of the map cate layout
	 * @return the map cate layout that was removed
	 * @throws PortalException if a map cate layout with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public MapCateLayout deleteMapCateLayout(long mapCateLayoutId)
		throws PortalException;

	/**
	 * Deletes the map cate layout from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapCateLayout the map cate layout
	 * @return the map cate layout that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public MapCateLayout deleteMapCateLayout(MapCateLayout mapCateLayout);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MapCateLayout fetchMapCateLayout(long mapCateLayoutId);

	/**
	 * Returns the map cate layout matching the UUID and group.
	 *
	 * @param uuid the map cate layout's UUID
	 * @param groupId the primary key of the group
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MapCateLayout fetchMapCateLayoutByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MapCateLayout getCategoryIdByLayoutIdAndType(
		long layoutId, int type);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MapCateLayout getFriendsUrlByCategoryId(long categoryId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MapCateLayout> getListMapCateLayout(
			long groupId, long companyId, int start, int limit)
		throws Exception;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MapCateLayout> getListMapCateLayoutByType(
		long groupId, int type);

	/**
	 * Returns the map cate layout with the primary key.
	 *
	 * @param mapCateLayoutId the primary key of the map cate layout
	 * @return the map cate layout
	 * @throws PortalException if a map cate layout with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MapCateLayout getMapCateLayout(long mapCateLayoutId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MapCateLayout getMapCateLayoutByCategoryIdAndType(
		long categoryId, int type);

	/**
	 * Returns the map cate layout matching the UUID and group.
	 *
	 * @param uuid the map cate layout's UUID
	 * @param groupId the primary key of the group
	 * @return the matching map cate layout
	 * @throws PortalException if a matching map cate layout could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MapCateLayout getMapCateLayoutByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MapCateLayout> getMapCateLayouts(int start, int end);

	/**
	 * Returns all the map cate layouts matching the UUID and company.
	 *
	 * @param uuid the UUID of the map cate layouts
	 * @param companyId the primary key of the company
	 * @return the matching map cate layouts, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MapCateLayout> getMapCateLayoutsByUuidAndCompanyId(
		String uuid, long companyId);

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MapCateLayout> getMapCateLayoutsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator);

	/**
	 * Returns the number of map cate layouts.
	 *
	 * @return the number of map cate layouts
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMapCateLayoutsCount();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Updates the map cate layout in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param mapCateLayout the map cate layout
	 * @return the map cate layout that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public MapCateLayout updateMapCateLayout(MapCateLayout mapCateLayout);

}