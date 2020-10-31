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

package Album.service.service.persistence;

import Album.service.model.Image;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the image service. This utility wraps <code>Album.service.service.persistence.impl.ImagePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImagePersistence
 * @generated
 */
@ProviderType
public class ImageUtil {

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
	public static void clearCache(Image image) {
		getPersistence().clearCache(image);
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
	public static Map<Serializable, Image> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Image> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Image> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Image> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Image> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Image update(Image image) {
		return getPersistence().update(image);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Image update(Image image, ServiceContext serviceContext) {
		return getPersistence().update(image, serviceContext);
	}

	/**
	 * Returns all the images where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching images
	 */
	public static List<Image> findByCategoryId(long categoryId) {
		return getPersistence().findByCategoryId(categoryId);
	}

	/**
	 * Returns a range of all the images where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @return the range of matching images
	 */
	public static List<Image> findByCategoryId(
		long categoryId, int start, int end) {

		return getPersistence().findByCategoryId(categoryId, start, end);
	}

	/**
	 * Returns an ordered range of all the images where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByCategoryId(long, int, int, OrderByComparator)}
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching images
	 */
	@Deprecated
	public static List<Image> findByCategoryId(
		long categoryId, int start, int end,
		OrderByComparator<Image> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCategoryId(
			categoryId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the images where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching images
	 */
	public static List<Image> findByCategoryId(
		long categoryId, int start, int end,
		OrderByComparator<Image> orderByComparator) {

		return getPersistence().findByCategoryId(
			categoryId, start, end, orderByComparator);
	}

	/**
	 * Returns the first image in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public static Image findByCategoryId_First(
			long categoryId, OrderByComparator<Image> orderByComparator)
		throws Album.service.exception.NoSuchImageException {

		return getPersistence().findByCategoryId_First(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the first image in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image, or <code>null</code> if a matching image could not be found
	 */
	public static Image fetchByCategoryId_First(
		long categoryId, OrderByComparator<Image> orderByComparator) {

		return getPersistence().fetchByCategoryId_First(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the last image in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public static Image findByCategoryId_Last(
			long categoryId, OrderByComparator<Image> orderByComparator)
		throws Album.service.exception.NoSuchImageException {

		return getPersistence().findByCategoryId_Last(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the last image in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image, or <code>null</code> if a matching image could not be found
	 */
	public static Image fetchByCategoryId_Last(
		long categoryId, OrderByComparator<Image> orderByComparator) {

		return getPersistence().fetchByCategoryId_Last(
			categoryId, orderByComparator);
	}

	/**
	 * Returns the images before and after the current image in the ordered set where categoryId = &#63;.
	 *
	 * @param imageId the primary key of the current image
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next image
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	public static Image[] findByCategoryId_PrevAndNext(
			long imageId, long categoryId,
			OrderByComparator<Image> orderByComparator)
		throws Album.service.exception.NoSuchImageException {

		return getPersistence().findByCategoryId_PrevAndNext(
			imageId, categoryId, orderByComparator);
	}

	/**
	 * Removes all the images where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	public static void removeByCategoryId(long categoryId) {
		getPersistence().removeByCategoryId(categoryId);
	}

	/**
	 * Returns the number of images where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching images
	 */
	public static int countByCategoryId(long categoryId) {
		return getPersistence().countByCategoryId(categoryId);
	}

	/**
	 * Returns all the images where groupId = &#63; and companyId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @return the matching images
	 */
	public static List<Image> findByFindAll(
		long groupId, long companyId, long categoryId) {

		return getPersistence().findByFindAll(groupId, companyId, categoryId);
	}

	/**
	 * Returns a range of all the images where groupId = &#63; and companyId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @return the range of matching images
	 */
	public static List<Image> findByFindAll(
		long groupId, long companyId, long categoryId, int start, int end) {

		return getPersistence().findByFindAll(
			groupId, companyId, categoryId, start, end);
	}

	/**
	 * Returns an ordered range of all the images where groupId = &#63; and companyId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByFindAll(long,long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching images
	 */
	@Deprecated
	public static List<Image> findByFindAll(
		long groupId, long companyId, long categoryId, int start, int end,
		OrderByComparator<Image> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByFindAll(
			groupId, companyId, categoryId, start, end, orderByComparator,
			useFinderCache);
	}

	/**
	 * Returns an ordered range of all the images where groupId = &#63; and companyId = &#63; and categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching images
	 */
	public static List<Image> findByFindAll(
		long groupId, long companyId, long categoryId, int start, int end,
		OrderByComparator<Image> orderByComparator) {

		return getPersistence().findByFindAll(
			groupId, companyId, categoryId, start, end, orderByComparator);
	}

	/**
	 * Returns the first image in the ordered set where groupId = &#63; and companyId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public static Image findByFindAll_First(
			long groupId, long companyId, long categoryId,
			OrderByComparator<Image> orderByComparator)
		throws Album.service.exception.NoSuchImageException {

		return getPersistence().findByFindAll_First(
			groupId, companyId, categoryId, orderByComparator);
	}

	/**
	 * Returns the first image in the ordered set where groupId = &#63; and companyId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image, or <code>null</code> if a matching image could not be found
	 */
	public static Image fetchByFindAll_First(
		long groupId, long companyId, long categoryId,
		OrderByComparator<Image> orderByComparator) {

		return getPersistence().fetchByFindAll_First(
			groupId, companyId, categoryId, orderByComparator);
	}

	/**
	 * Returns the last image in the ordered set where groupId = &#63; and companyId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public static Image findByFindAll_Last(
			long groupId, long companyId, long categoryId,
			OrderByComparator<Image> orderByComparator)
		throws Album.service.exception.NoSuchImageException {

		return getPersistence().findByFindAll_Last(
			groupId, companyId, categoryId, orderByComparator);
	}

	/**
	 * Returns the last image in the ordered set where groupId = &#63; and companyId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image, or <code>null</code> if a matching image could not be found
	 */
	public static Image fetchByFindAll_Last(
		long groupId, long companyId, long categoryId,
		OrderByComparator<Image> orderByComparator) {

		return getPersistence().fetchByFindAll_Last(
			groupId, companyId, categoryId, orderByComparator);
	}

	/**
	 * Returns the images before and after the current image in the ordered set where groupId = &#63; and companyId = &#63; and categoryId = &#63;.
	 *
	 * @param imageId the primary key of the current image
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next image
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	public static Image[] findByFindAll_PrevAndNext(
			long imageId, long groupId, long companyId, long categoryId,
			OrderByComparator<Image> orderByComparator)
		throws Album.service.exception.NoSuchImageException {

		return getPersistence().findByFindAll_PrevAndNext(
			imageId, groupId, companyId, categoryId, orderByComparator);
	}

	/**
	 * Removes all the images where groupId = &#63; and companyId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 */
	public static void removeByFindAll(
		long groupId, long companyId, long categoryId) {

		getPersistence().removeByFindAll(groupId, companyId, categoryId);
	}

	/**
	 * Returns the number of images where groupId = &#63; and companyId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @return the number of matching images
	 */
	public static int countByFindAll(
		long groupId, long companyId, long categoryId) {

		return getPersistence().countByFindAll(groupId, companyId, categoryId);
	}

	/**
	 * Returns all the images where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching images
	 */
	public static List<Image> findByFindGroup(long groupId, long companyId) {
		return getPersistence().findByFindGroup(groupId, companyId);
	}

	/**
	 * Returns a range of all the images where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @return the range of matching images
	 */
	public static List<Image> findByFindGroup(
		long groupId, long companyId, int start, int end) {

		return getPersistence().findByFindGroup(groupId, companyId, start, end);
	}

	/**
	 * Returns an ordered range of all the images where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByFindGroup(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching images
	 */
	@Deprecated
	public static List<Image> findByFindGroup(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Image> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByFindGroup(
			groupId, companyId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the images where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching images
	 */
	public static List<Image> findByFindGroup(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Image> orderByComparator) {

		return getPersistence().findByFindGroup(
			groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the first image in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public static Image findByFindGroup_First(
			long groupId, long companyId,
			OrderByComparator<Image> orderByComparator)
		throws Album.service.exception.NoSuchImageException {

		return getPersistence().findByFindGroup_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the first image in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image, or <code>null</code> if a matching image could not be found
	 */
	public static Image fetchByFindGroup_First(
		long groupId, long companyId,
		OrderByComparator<Image> orderByComparator) {

		return getPersistence().fetchByFindGroup_First(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last image in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public static Image findByFindGroup_Last(
			long groupId, long companyId,
			OrderByComparator<Image> orderByComparator)
		throws Album.service.exception.NoSuchImageException {

		return getPersistence().findByFindGroup_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the last image in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image, or <code>null</code> if a matching image could not be found
	 */
	public static Image fetchByFindGroup_Last(
		long groupId, long companyId,
		OrderByComparator<Image> orderByComparator) {

		return getPersistence().fetchByFindGroup_Last(
			groupId, companyId, orderByComparator);
	}

	/**
	 * Returns the images before and after the current image in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param imageId the primary key of the current image
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next image
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	public static Image[] findByFindGroup_PrevAndNext(
			long imageId, long groupId, long companyId,
			OrderByComparator<Image> orderByComparator)
		throws Album.service.exception.NoSuchImageException {

		return getPersistence().findByFindGroup_PrevAndNext(
			imageId, groupId, companyId, orderByComparator);
	}

	/**
	 * Removes all the images where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public static void removeByFindGroup(long groupId, long companyId) {
		getPersistence().removeByFindGroup(groupId, companyId);
	}

	/**
	 * Returns the number of images where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching images
	 */
	public static int countByFindGroup(long groupId, long companyId) {
		return getPersistence().countByFindGroup(groupId, companyId);
	}

	/**
	 * Returns the image where categoryId = &#63; and isDaiDien = &#63; or throws a <code>NoSuchImageException</code> if it could not be found.
	 *
	 * @param categoryId the category ID
	 * @param isDaiDien the is dai dien
	 * @return the matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public static Image findByIsDaiDienAndCateId(
			long categoryId, boolean isDaiDien)
		throws Album.service.exception.NoSuchImageException {

		return getPersistence().findByIsDaiDienAndCateId(categoryId, isDaiDien);
	}

	/**
	 * Returns the image where categoryId = &#63; and isDaiDien = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByIsDaiDienAndCateId(long,boolean)}
	 * @param categoryId the category ID
	 * @param isDaiDien the is dai dien
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching image, or <code>null</code> if a matching image could not be found
	 */
	@Deprecated
	public static Image fetchByIsDaiDienAndCateId(
		long categoryId, boolean isDaiDien, boolean useFinderCache) {

		return getPersistence().fetchByIsDaiDienAndCateId(
			categoryId, isDaiDien, useFinderCache);
	}

	/**
	 * Returns the image where categoryId = &#63; and isDaiDien = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param categoryId the category ID
	 * @param isDaiDien the is dai dien
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching image, or <code>null</code> if a matching image could not be found
	 */
	public static Image fetchByIsDaiDienAndCateId(
		long categoryId, boolean isDaiDien) {

		return getPersistence().fetchByIsDaiDienAndCateId(
			categoryId, isDaiDien);
	}

	/**
	 * Removes the image where categoryId = &#63; and isDaiDien = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param isDaiDien the is dai dien
	 * @return the image that was removed
	 */
	public static Image removeByIsDaiDienAndCateId(
			long categoryId, boolean isDaiDien)
		throws Album.service.exception.NoSuchImageException {

		return getPersistence().removeByIsDaiDienAndCateId(
			categoryId, isDaiDien);
	}

	/**
	 * Returns the number of images where categoryId = &#63; and isDaiDien = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param isDaiDien the is dai dien
	 * @return the number of matching images
	 */
	public static int countByIsDaiDienAndCateId(
		long categoryId, boolean isDaiDien) {

		return getPersistence().countByIsDaiDienAndCateId(
			categoryId, isDaiDien);
	}

	/**
	 * Caches the image in the entity cache if it is enabled.
	 *
	 * @param image the image
	 */
	public static void cacheResult(Image image) {
		getPersistence().cacheResult(image);
	}

	/**
	 * Caches the images in the entity cache if it is enabled.
	 *
	 * @param images the images
	 */
	public static void cacheResult(List<Image> images) {
		getPersistence().cacheResult(images);
	}

	/**
	 * Creates a new image with the primary key. Does not add the image to the database.
	 *
	 * @param imageId the primary key for the new image
	 * @return the new image
	 */
	public static Image create(long imageId) {
		return getPersistence().create(imageId);
	}

	/**
	 * Removes the image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param imageId the primary key of the image
	 * @return the image that was removed
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	public static Image remove(long imageId)
		throws Album.service.exception.NoSuchImageException {

		return getPersistence().remove(imageId);
	}

	public static Image updateImpl(Image image) {
		return getPersistence().updateImpl(image);
	}

	/**
	 * Returns the image with the primary key or throws a <code>NoSuchImageException</code> if it could not be found.
	 *
	 * @param imageId the primary key of the image
	 * @return the image
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	public static Image findByPrimaryKey(long imageId)
		throws Album.service.exception.NoSuchImageException {

		return getPersistence().findByPrimaryKey(imageId);
	}

	/**
	 * Returns the image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param imageId the primary key of the image
	 * @return the image, or <code>null</code> if a image with the primary key could not be found
	 */
	public static Image fetchByPrimaryKey(long imageId) {
		return getPersistence().fetchByPrimaryKey(imageId);
	}

	/**
	 * Returns all the images.
	 *
	 * @return the images
	 */
	public static List<Image> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @return the range of images
	 */
	public static List<Image> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of images
	 */
	@Deprecated
	public static List<Image> findAll(
		int start, int end, OrderByComparator<Image> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns an ordered range of all the images.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>ImageModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of images
	 * @param end the upper bound of the range of images (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of images
	 */
	public static List<Image> findAll(
		int start, int end, OrderByComparator<Image> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the images from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of images.
	 *
	 * @return the number of images
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ImagePersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ImagePersistence, ImagePersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ImagePersistence.class);

		ServiceTracker<ImagePersistence, ImagePersistence> serviceTracker =
			new ServiceTracker<ImagePersistence, ImagePersistence>(
				bundle.getBundleContext(), ImagePersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}