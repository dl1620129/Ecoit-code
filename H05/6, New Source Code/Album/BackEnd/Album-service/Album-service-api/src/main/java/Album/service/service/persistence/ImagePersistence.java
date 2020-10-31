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

import Album.service.exception.NoSuchImageException;
import Album.service.model.Image;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImageUtil
 * @generated
 */
@ProviderType
public interface ImagePersistence extends BasePersistence<Image> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ImageUtil} to access the image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the images where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching images
	 */
	public java.util.List<Image> findByCategoryId(long categoryId);

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
	public java.util.List<Image> findByCategoryId(
		long categoryId, int start, int end);

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
	public java.util.List<Image> findByCategoryId(
		long categoryId, int start, int end,
		OrderByComparator<Image> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Image> findByCategoryId(
		long categoryId, int start, int end,
		OrderByComparator<Image> orderByComparator);

	/**
	 * Returns the first image in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public Image findByCategoryId_First(
			long categoryId, OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException;

	/**
	 * Returns the first image in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image, or <code>null</code> if a matching image could not be found
	 */
	public Image fetchByCategoryId_First(
		long categoryId, OrderByComparator<Image> orderByComparator);

	/**
	 * Returns the last image in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public Image findByCategoryId_Last(
			long categoryId, OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException;

	/**
	 * Returns the last image in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image, or <code>null</code> if a matching image could not be found
	 */
	public Image fetchByCategoryId_Last(
		long categoryId, OrderByComparator<Image> orderByComparator);

	/**
	 * Returns the images before and after the current image in the ordered set where categoryId = &#63;.
	 *
	 * @param imageId the primary key of the current image
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next image
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	public Image[] findByCategoryId_PrevAndNext(
			long imageId, long categoryId,
			OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException;

	/**
	 * Removes all the images where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	public void removeByCategoryId(long categoryId);

	/**
	 * Returns the number of images where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching images
	 */
	public int countByCategoryId(long categoryId);

	/**
	 * Returns all the images where groupId = &#63; and companyId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @return the matching images
	 */
	public java.util.List<Image> findByFindAll(
		long groupId, long companyId, long categoryId);

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
	public java.util.List<Image> findByFindAll(
		long groupId, long companyId, long categoryId, int start, int end);

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
	public java.util.List<Image> findByFindAll(
		long groupId, long companyId, long categoryId, int start, int end,
		OrderByComparator<Image> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Image> findByFindAll(
		long groupId, long companyId, long categoryId, int start, int end,
		OrderByComparator<Image> orderByComparator);

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
	public Image findByFindAll_First(
			long groupId, long companyId, long categoryId,
			OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException;

	/**
	 * Returns the first image in the ordered set where groupId = &#63; and companyId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image, or <code>null</code> if a matching image could not be found
	 */
	public Image fetchByFindAll_First(
		long groupId, long companyId, long categoryId,
		OrderByComparator<Image> orderByComparator);

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
	public Image findByFindAll_Last(
			long groupId, long companyId, long categoryId,
			OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException;

	/**
	 * Returns the last image in the ordered set where groupId = &#63; and companyId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image, or <code>null</code> if a matching image could not be found
	 */
	public Image fetchByFindAll_Last(
		long groupId, long companyId, long categoryId,
		OrderByComparator<Image> orderByComparator);

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
	public Image[] findByFindAll_PrevAndNext(
			long imageId, long groupId, long companyId, long categoryId,
			OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException;

	/**
	 * Removes all the images where groupId = &#63; and companyId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 */
	public void removeByFindAll(long groupId, long companyId, long categoryId);

	/**
	 * Returns the number of images where groupId = &#63; and companyId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @return the number of matching images
	 */
	public int countByFindAll(long groupId, long companyId, long categoryId);

	/**
	 * Returns all the images where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching images
	 */
	public java.util.List<Image> findByFindGroup(long groupId, long companyId);

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
	public java.util.List<Image> findByFindGroup(
		long groupId, long companyId, int start, int end);

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
	public java.util.List<Image> findByFindGroup(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Image> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Image> findByFindGroup(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Image> orderByComparator);

	/**
	 * Returns the first image in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public Image findByFindGroup_First(
			long groupId, long companyId,
			OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException;

	/**
	 * Returns the first image in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image, or <code>null</code> if a matching image could not be found
	 */
	public Image fetchByFindGroup_First(
		long groupId, long companyId,
		OrderByComparator<Image> orderByComparator);

	/**
	 * Returns the last image in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public Image findByFindGroup_Last(
			long groupId, long companyId,
			OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException;

	/**
	 * Returns the last image in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image, or <code>null</code> if a matching image could not be found
	 */
	public Image fetchByFindGroup_Last(
		long groupId, long companyId,
		OrderByComparator<Image> orderByComparator);

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
	public Image[] findByFindGroup_PrevAndNext(
			long imageId, long groupId, long companyId,
			OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException;

	/**
	 * Removes all the images where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	public void removeByFindGroup(long groupId, long companyId);

	/**
	 * Returns the number of images where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching images
	 */
	public int countByFindGroup(long groupId, long companyId);

	/**
	 * Returns the image where categoryId = &#63; and isDaiDien = &#63; or throws a <code>NoSuchImageException</code> if it could not be found.
	 *
	 * @param categoryId the category ID
	 * @param isDaiDien the is dai dien
	 * @return the matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	public Image findByIsDaiDienAndCateId(long categoryId, boolean isDaiDien)
		throws NoSuchImageException;

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
	public Image fetchByIsDaiDienAndCateId(
		long categoryId, boolean isDaiDien, boolean useFinderCache);

	/**
	 * Returns the image where categoryId = &#63; and isDaiDien = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param categoryId the category ID
	 * @param isDaiDien the is dai dien
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching image, or <code>null</code> if a matching image could not be found
	 */
	public Image fetchByIsDaiDienAndCateId(long categoryId, boolean isDaiDien);

	/**
	 * Removes the image where categoryId = &#63; and isDaiDien = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param isDaiDien the is dai dien
	 * @return the image that was removed
	 */
	public Image removeByIsDaiDienAndCateId(long categoryId, boolean isDaiDien)
		throws NoSuchImageException;

	/**
	 * Returns the number of images where categoryId = &#63; and isDaiDien = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param isDaiDien the is dai dien
	 * @return the number of matching images
	 */
	public int countByIsDaiDienAndCateId(long categoryId, boolean isDaiDien);

	/**
	 * Caches the image in the entity cache if it is enabled.
	 *
	 * @param image the image
	 */
	public void cacheResult(Image image);

	/**
	 * Caches the images in the entity cache if it is enabled.
	 *
	 * @param images the images
	 */
	public void cacheResult(java.util.List<Image> images);

	/**
	 * Creates a new image with the primary key. Does not add the image to the database.
	 *
	 * @param imageId the primary key for the new image
	 * @return the new image
	 */
	public Image create(long imageId);

	/**
	 * Removes the image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param imageId the primary key of the image
	 * @return the image that was removed
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	public Image remove(long imageId) throws NoSuchImageException;

	public Image updateImpl(Image image);

	/**
	 * Returns the image with the primary key or throws a <code>NoSuchImageException</code> if it could not be found.
	 *
	 * @param imageId the primary key of the image
	 * @return the image
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	public Image findByPrimaryKey(long imageId) throws NoSuchImageException;

	/**
	 * Returns the image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param imageId the primary key of the image
	 * @return the image, or <code>null</code> if a image with the primary key could not be found
	 */
	public Image fetchByPrimaryKey(long imageId);

	/**
	 * Returns all the images.
	 *
	 * @return the images
	 */
	public java.util.List<Image> findAll();

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
	public java.util.List<Image> findAll(int start, int end);

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
	public java.util.List<Image> findAll(
		int start, int end, OrderByComparator<Image> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<Image> findAll(
		int start, int end, OrderByComparator<Image> orderByComparator);

	/**
	 * Removes all the images from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of images.
	 *
	 * @return the number of images
	 */
	public int countAll();

}