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

package Album.service.service.persistence.impl;

import Album.service.exception.NoSuchImageException;
import Album.service.model.Image;
import Album.service.model.impl.ImageImpl;
import Album.service.model.impl.ImageModelImpl;
import Album.service.service.persistence.ImagePersistence;
import Album.service.service.persistence.impl.constants.portal_albumPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the image service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ImagePersistence.class)
@ProviderType
public class ImagePersistenceImpl
	extends BasePersistenceImpl<Image> implements ImagePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ImageUtil</code> to access the image persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ImageImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCategoryId;
	private FinderPath _finderPathWithoutPaginationFindByCategoryId;
	private FinderPath _finderPathCountByCategoryId;

	/**
	 * Returns all the images where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching images
	 */
	@Override
	public List<Image> findByCategoryId(long categoryId) {
		return findByCategoryId(
			categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Image> findByCategoryId(long categoryId, int start, int end) {
		return findByCategoryId(categoryId, start, end, null);
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
	@Override
	public List<Image> findByCategoryId(
		long categoryId, int start, int end,
		OrderByComparator<Image> orderByComparator, boolean useFinderCache) {

		return findByCategoryId(categoryId, start, end, orderByComparator);
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
	@Override
	public List<Image> findByCategoryId(
		long categoryId, int start, int end,
		OrderByComparator<Image> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByCategoryId;
			finderArgs = new Object[] {categoryId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByCategoryId;
			finderArgs = new Object[] {
				categoryId, start, end, orderByComparator
			};
		}

		List<Image> list = (List<Image>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Image image : list) {
				if ((categoryId != image.getCategoryId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_IMAGE_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				if (!pagination) {
					list = (List<Image>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Image>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first image in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	@Override
	public Image findByCategoryId_First(
			long categoryId, OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException {

		Image image = fetchByCategoryId_First(categoryId, orderByComparator);

		if (image != null) {
			return image;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append("}");

		throw new NoSuchImageException(msg.toString());
	}

	/**
	 * Returns the first image in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image, or <code>null</code> if a matching image could not be found
	 */
	@Override
	public Image fetchByCategoryId_First(
		long categoryId, OrderByComparator<Image> orderByComparator) {

		List<Image> list = findByCategoryId(
			categoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last image in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	@Override
	public Image findByCategoryId_Last(
			long categoryId, OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException {

		Image image = fetchByCategoryId_Last(categoryId, orderByComparator);

		if (image != null) {
			return image;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append("}");

		throw new NoSuchImageException(msg.toString());
	}

	/**
	 * Returns the last image in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image, or <code>null</code> if a matching image could not be found
	 */
	@Override
	public Image fetchByCategoryId_Last(
		long categoryId, OrderByComparator<Image> orderByComparator) {

		int count = countByCategoryId(categoryId);

		if (count == 0) {
			return null;
		}

		List<Image> list = findByCategoryId(
			categoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Image[] findByCategoryId_PrevAndNext(
			long imageId, long categoryId,
			OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException {

		Image image = findByPrimaryKey(imageId);

		Session session = null;

		try {
			session = openSession();

			Image[] array = new ImageImpl[3];

			array[0] = getByCategoryId_PrevAndNext(
				session, image, categoryId, orderByComparator, true);

			array[1] = image;

			array[2] = getByCategoryId_PrevAndNext(
				session, image, categoryId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Image getByCategoryId_PrevAndNext(
		Session session, Image image, long categoryId,
		OrderByComparator<Image> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_IMAGE_WHERE);

		query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(image)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Image> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the images where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	@Override
	public void removeByCategoryId(long categoryId) {
		for (Image image :
				findByCategoryId(
					categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(image);
		}
	}

	/**
	 * Returns the number of images where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching images
	 */
	@Override
	public int countByCategoryId(long categoryId) {
		FinderPath finderPath = _finderPathCountByCategoryId;

		Object[] finderArgs = new Object[] {categoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_IMAGE_WHERE);

			query.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CATEGORYID_CATEGORYID_2 =
		"image.categoryId = ?";

	private FinderPath _finderPathWithPaginationFindByFindAll;
	private FinderPath _finderPathWithoutPaginationFindByFindAll;
	private FinderPath _finderPathCountByFindAll;

	/**
	 * Returns all the images where groupId = &#63; and companyId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @return the matching images
	 */
	@Override
	public List<Image> findByFindAll(
		long groupId, long companyId, long categoryId) {

		return findByFindAll(
			groupId, companyId, categoryId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<Image> findByFindAll(
		long groupId, long companyId, long categoryId, int start, int end) {

		return findByFindAll(groupId, companyId, categoryId, start, end, null);
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
	@Override
	public List<Image> findByFindAll(
		long groupId, long companyId, long categoryId, int start, int end,
		OrderByComparator<Image> orderByComparator, boolean useFinderCache) {

		return findByFindAll(
			groupId, companyId, categoryId, start, end, orderByComparator);
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
	@Override
	public List<Image> findByFindAll(
		long groupId, long companyId, long categoryId, int start, int end,
		OrderByComparator<Image> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByFindAll;
			finderArgs = new Object[] {groupId, companyId, categoryId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByFindAll;
			finderArgs = new Object[] {
				groupId, companyId, categoryId, start, end, orderByComparator
			};
		}

		List<Image> list = (List<Image>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Image image : list) {
				if ((groupId != image.getGroupId()) ||
					(companyId != image.getCompanyId()) ||
					(categoryId != image.getCategoryId())) {

					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(5);
			}

			query.append(_SQL_SELECT_IMAGE_WHERE);

			query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDALL_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(categoryId);

				if (!pagination) {
					list = (List<Image>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Image>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Image findByFindAll_First(
			long groupId, long companyId, long categoryId,
			OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException {

		Image image = fetchByFindAll_First(
			groupId, companyId, categoryId, orderByComparator);

		if (image != null) {
			return image;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append("}");

		throw new NoSuchImageException(msg.toString());
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
	@Override
	public Image fetchByFindAll_First(
		long groupId, long companyId, long categoryId,
		OrderByComparator<Image> orderByComparator) {

		List<Image> list = findByFindAll(
			groupId, companyId, categoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Image findByFindAll_Last(
			long groupId, long companyId, long categoryId,
			OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException {

		Image image = fetchByFindAll_Last(
			groupId, companyId, categoryId, orderByComparator);

		if (image != null) {
			return image;
		}

		StringBundler msg = new StringBundler(8);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(", categoryId=");
		msg.append(categoryId);

		msg.append("}");

		throw new NoSuchImageException(msg.toString());
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
	@Override
	public Image fetchByFindAll_Last(
		long groupId, long companyId, long categoryId,
		OrderByComparator<Image> orderByComparator) {

		int count = countByFindAll(groupId, companyId, categoryId);

		if (count == 0) {
			return null;
		}

		List<Image> list = findByFindAll(
			groupId, companyId, categoryId, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Image[] findByFindAll_PrevAndNext(
			long imageId, long groupId, long companyId, long categoryId,
			OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException {

		Image image = findByPrimaryKey(imageId);

		Session session = null;

		try {
			session = openSession();

			Image[] array = new ImageImpl[3];

			array[0] = getByFindAll_PrevAndNext(
				session, image, groupId, companyId, categoryId,
				orderByComparator, true);

			array[1] = image;

			array[2] = getByFindAll_PrevAndNext(
				session, image, groupId, companyId, categoryId,
				orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Image getByFindAll_PrevAndNext(
		Session session, Image image, long groupId, long companyId,
		long categoryId, OrderByComparator<Image> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(5);
		}

		query.append(_SQL_SELECT_IMAGE_WHERE);

		query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

		query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

		query.append(_FINDER_COLUMN_FINDALL_CATEGORYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(image)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Image> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the images where groupId = &#63; and companyId = &#63; and categoryId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 */
	@Override
	public void removeByFindAll(long groupId, long companyId, long categoryId) {
		for (Image image :
				findByFindAll(
					groupId, companyId, categoryId, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(image);
		}
	}

	/**
	 * Returns the number of images where groupId = &#63; and companyId = &#63; and categoryId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param categoryId the category ID
	 * @return the number of matching images
	 */
	@Override
	public int countByFindAll(long groupId, long companyId, long categoryId) {
		FinderPath finderPath = _finderPathCountByFindAll;

		Object[] finderArgs = new Object[] {groupId, companyId, categoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_IMAGE_WHERE);

			query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

			query.append(_FINDER_COLUMN_FINDALL_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				qPos.add(categoryId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FINDALL_GROUPID_2 =
		"image.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDALL_COMPANYID_2 =
		"image.companyId = ? AND ";

	private static final String _FINDER_COLUMN_FINDALL_CATEGORYID_2 =
		"image.categoryId = ?";

	private FinderPath _finderPathWithPaginationFindByFindGroup;
	private FinderPath _finderPathWithoutPaginationFindByFindGroup;
	private FinderPath _finderPathCountByFindGroup;

	/**
	 * Returns all the images where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching images
	 */
	@Override
	public List<Image> findByFindGroup(long groupId, long companyId) {
		return findByFindGroup(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Image> findByFindGroup(
		long groupId, long companyId, int start, int end) {

		return findByFindGroup(groupId, companyId, start, end, null);
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
	@Override
	public List<Image> findByFindGroup(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Image> orderByComparator, boolean useFinderCache) {

		return findByFindGroup(
			groupId, companyId, start, end, orderByComparator);
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
	@Override
	public List<Image> findByFindGroup(
		long groupId, long companyId, int start, int end,
		OrderByComparator<Image> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByFindGroup;
			finderArgs = new Object[] {groupId, companyId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByFindGroup;
			finderArgs = new Object[] {
				groupId, companyId, start, end, orderByComparator
			};
		}

		List<Image> list = (List<Image>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Image image : list) {
				if ((groupId != image.getGroupId()) ||
					(companyId != image.getCompanyId())) {

					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_IMAGE_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(ImageModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Image>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Image>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Image findByFindGroup_First(
			long groupId, long companyId,
			OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException {

		Image image = fetchByFindGroup_First(
			groupId, companyId, orderByComparator);

		if (image != null) {
			return image;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchImageException(msg.toString());
	}

	/**
	 * Returns the first image in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching image, or <code>null</code> if a matching image could not be found
	 */
	@Override
	public Image fetchByFindGroup_First(
		long groupId, long companyId,
		OrderByComparator<Image> orderByComparator) {

		List<Image> list = findByFindGroup(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Image findByFindGroup_Last(
			long groupId, long companyId,
			OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException {

		Image image = fetchByFindGroup_Last(
			groupId, companyId, orderByComparator);

		if (image != null) {
			return image;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchImageException(msg.toString());
	}

	/**
	 * Returns the last image in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching image, or <code>null</code> if a matching image could not be found
	 */
	@Override
	public Image fetchByFindGroup_Last(
		long groupId, long companyId,
		OrderByComparator<Image> orderByComparator) {

		int count = countByFindGroup(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<Image> list = findByFindGroup(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Image[] findByFindGroup_PrevAndNext(
			long imageId, long groupId, long companyId,
			OrderByComparator<Image> orderByComparator)
		throws NoSuchImageException {

		Image image = findByPrimaryKey(imageId);

		Session session = null;

		try {
			session = openSession();

			Image[] array = new ImageImpl[3];

			array[0] = getByFindGroup_PrevAndNext(
				session, image, groupId, companyId, orderByComparator, true);

			array[1] = image;

			array[2] = getByFindGroup_PrevAndNext(
				session, image, groupId, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Image getByFindGroup_PrevAndNext(
		Session session, Image image, long groupId, long companyId,
		OrderByComparator<Image> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_IMAGE_WHERE);

		query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

		query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(ImageModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(image)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Image> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the images where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByFindGroup(long groupId, long companyId) {
		for (Image image :
				findByFindGroup(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(image);
		}
	}

	/**
	 * Returns the number of images where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching images
	 */
	@Override
	public int countByFindGroup(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByFindGroup;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_IMAGE_WHERE);

			query.append(_FINDER_COLUMN_FINDGROUP_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDGROUP_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_FINDGROUP_GROUPID_2 =
		"image.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDGROUP_COMPANYID_2 =
		"image.companyId = ?";

	private FinderPath _finderPathFetchByIsDaiDienAndCateId;
	private FinderPath _finderPathCountByIsDaiDienAndCateId;

	/**
	 * Returns the image where categoryId = &#63; and isDaiDien = &#63; or throws a <code>NoSuchImageException</code> if it could not be found.
	 *
	 * @param categoryId the category ID
	 * @param isDaiDien the is dai dien
	 * @return the matching image
	 * @throws NoSuchImageException if a matching image could not be found
	 */
	@Override
	public Image findByIsDaiDienAndCateId(long categoryId, boolean isDaiDien)
		throws NoSuchImageException {

		Image image = fetchByIsDaiDienAndCateId(categoryId, isDaiDien);

		if (image == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("categoryId=");
			msg.append(categoryId);

			msg.append(", isDaiDien=");
			msg.append(isDaiDien);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchImageException(msg.toString());
		}

		return image;
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
	@Override
	public Image fetchByIsDaiDienAndCateId(
		long categoryId, boolean isDaiDien, boolean useFinderCache) {

		return fetchByIsDaiDienAndCateId(categoryId, isDaiDien);
	}

	/**
	 * Returns the image where categoryId = &#63; and isDaiDien = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param categoryId the category ID
	 * @param isDaiDien the is dai dien
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching image, or <code>null</code> if a matching image could not be found
	 */
	@Override
	public Image fetchByIsDaiDienAndCateId(long categoryId, boolean isDaiDien) {
		Object[] finderArgs = new Object[] {categoryId, isDaiDien};

		Object result = finderCache.getResult(
			_finderPathFetchByIsDaiDienAndCateId, finderArgs, this);

		if (result instanceof Image) {
			Image image = (Image)result;

			if ((categoryId != image.getCategoryId()) ||
				(isDaiDien != image.isIsDaiDien())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_IMAGE_WHERE);

			query.append(_FINDER_COLUMN_ISDAIDIENANDCATEID_CATEGORYID_2);

			query.append(_FINDER_COLUMN_ISDAIDIENANDCATEID_ISDAIDIEN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				qPos.add(isDaiDien);

				List<Image> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByIsDaiDienAndCateId, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"ImagePersistenceImpl.fetchByIsDaiDienAndCateId(long, boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Image image = list.get(0);

					result = image;

					cacheResult(image);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchByIsDaiDienAndCateId, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Image)result;
		}
	}

	/**
	 * Removes the image where categoryId = &#63; and isDaiDien = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param isDaiDien the is dai dien
	 * @return the image that was removed
	 */
	@Override
	public Image removeByIsDaiDienAndCateId(long categoryId, boolean isDaiDien)
		throws NoSuchImageException {

		Image image = findByIsDaiDienAndCateId(categoryId, isDaiDien);

		return remove(image);
	}

	/**
	 * Returns the number of images where categoryId = &#63; and isDaiDien = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param isDaiDien the is dai dien
	 * @return the number of matching images
	 */
	@Override
	public int countByIsDaiDienAndCateId(long categoryId, boolean isDaiDien) {
		FinderPath finderPath = _finderPathCountByIsDaiDienAndCateId;

		Object[] finderArgs = new Object[] {categoryId, isDaiDien};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_IMAGE_WHERE);

			query.append(_FINDER_COLUMN_ISDAIDIENANDCATEID_CATEGORYID_2);

			query.append(_FINDER_COLUMN_ISDAIDIENANDCATEID_ISDAIDIEN_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				qPos.add(isDaiDien);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ISDAIDIENANDCATEID_CATEGORYID_2 =
		"image.categoryId = ? AND ";

	private static final String _FINDER_COLUMN_ISDAIDIENANDCATEID_ISDAIDIEN_2 =
		"image.isDaiDien = ?";

	public ImagePersistenceImpl() {
		setModelClass(Image.class);

		setModelImplClass(ImageImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the image in the entity cache if it is enabled.
	 *
	 * @param image the image
	 */
	@Override
	public void cacheResult(Image image) {
		entityCache.putResult(
			entityCacheEnabled, ImageImpl.class, image.getPrimaryKey(), image);

		finderCache.putResult(
			_finderPathFetchByIsDaiDienAndCateId,
			new Object[] {image.getCategoryId(), image.isIsDaiDien()}, image);

		image.resetOriginalValues();
	}

	/**
	 * Caches the images in the entity cache if it is enabled.
	 *
	 * @param images the images
	 */
	@Override
	public void cacheResult(List<Image> images) {
		for (Image image : images) {
			if (entityCache.getResult(
					entityCacheEnabled, ImageImpl.class,
					image.getPrimaryKey()) == null) {

				cacheResult(image);
			}
			else {
				image.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all images.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ImageImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the image.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Image image) {
		entityCache.removeResult(
			entityCacheEnabled, ImageImpl.class, image.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((ImageModelImpl)image, true);
	}

	@Override
	public void clearCache(List<Image> images) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Image image : images) {
			entityCache.removeResult(
				entityCacheEnabled, ImageImpl.class, image.getPrimaryKey());

			clearUniqueFindersCache((ImageModelImpl)image, true);
		}
	}

	protected void cacheUniqueFindersCache(ImageModelImpl imageModelImpl) {
		Object[] args = new Object[] {
			imageModelImpl.getCategoryId(), imageModelImpl.isIsDaiDien()
		};

		finderCache.putResult(
			_finderPathCountByIsDaiDienAndCateId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByIsDaiDienAndCateId, args, imageModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		ImageModelImpl imageModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				imageModelImpl.getCategoryId(), imageModelImpl.isIsDaiDien()
			};

			finderCache.removeResult(
				_finderPathCountByIsDaiDienAndCateId, args);
			finderCache.removeResult(
				_finderPathFetchByIsDaiDienAndCateId, args);
		}

		if ((imageModelImpl.getColumnBitmask() &
			 _finderPathFetchByIsDaiDienAndCateId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				imageModelImpl.getOriginalCategoryId(),
				imageModelImpl.getOriginalIsDaiDien()
			};

			finderCache.removeResult(
				_finderPathCountByIsDaiDienAndCateId, args);
			finderCache.removeResult(
				_finderPathFetchByIsDaiDienAndCateId, args);
		}
	}

	/**
	 * Creates a new image with the primary key. Does not add the image to the database.
	 *
	 * @param imageId the primary key for the new image
	 * @return the new image
	 */
	@Override
	public Image create(long imageId) {
		Image image = new ImageImpl();

		image.setNew(true);
		image.setPrimaryKey(imageId);

		image.setCompanyId(CompanyThreadLocal.getCompanyId());

		return image;
	}

	/**
	 * Removes the image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param imageId the primary key of the image
	 * @return the image that was removed
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	@Override
	public Image remove(long imageId) throws NoSuchImageException {
		return remove((Serializable)imageId);
	}

	/**
	 * Removes the image with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the image
	 * @return the image that was removed
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	@Override
	public Image remove(Serializable primaryKey) throws NoSuchImageException {
		Session session = null;

		try {
			session = openSession();

			Image image = (Image)session.get(ImageImpl.class, primaryKey);

			if (image == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchImageException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(image);
		}
		catch (NoSuchImageException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Image removeImpl(Image image) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(image)) {
				image = (Image)session.get(
					ImageImpl.class, image.getPrimaryKeyObj());
			}

			if (image != null) {
				session.delete(image);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (image != null) {
			clearCache(image);
		}

		return image;
	}

	@Override
	public Image updateImpl(Image image) {
		boolean isNew = image.isNew();

		if (!(image instanceof ImageModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(image.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(image);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in image proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Image implementation " +
					image.getClass());
		}

		ImageModelImpl imageModelImpl = (ImageModelImpl)image;

		Session session = null;

		try {
			session = openSession();

			if (image.isNew()) {
				session.save(image);

				image.setNew(false);
			}
			else {
				image = (Image)session.merge(image);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {imageModelImpl.getCategoryId()};

			finderCache.removeResult(_finderPathCountByCategoryId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCategoryId, args);

			args = new Object[] {
				imageModelImpl.getGroupId(), imageModelImpl.getCompanyId(),
				imageModelImpl.getCategoryId()
			};

			finderCache.removeResult(_finderPathCountByFindAll, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindAll, args);

			args = new Object[] {
				imageModelImpl.getGroupId(), imageModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByFindGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindGroup, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((imageModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCategoryId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					imageModelImpl.getOriginalCategoryId()
				};

				finderCache.removeResult(_finderPathCountByCategoryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCategoryId, args);

				args = new Object[] {imageModelImpl.getCategoryId()};

				finderCache.removeResult(_finderPathCountByCategoryId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCategoryId, args);
			}

			if ((imageModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindAll.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					imageModelImpl.getOriginalGroupId(),
					imageModelImpl.getOriginalCompanyId(),
					imageModelImpl.getOriginalCategoryId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);

				args = new Object[] {
					imageModelImpl.getGroupId(), imageModelImpl.getCompanyId(),
					imageModelImpl.getCategoryId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);
			}

			if ((imageModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindGroup.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					imageModelImpl.getOriginalGroupId(),
					imageModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroup, args);

				args = new Object[] {
					imageModelImpl.getGroupId(), imageModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindGroup, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, ImageImpl.class, image.getPrimaryKey(), image,
			false);

		clearUniqueFindersCache(imageModelImpl, false);
		cacheUniqueFindersCache(imageModelImpl);

		image.resetOriginalValues();

		return image;
	}

	/**
	 * Returns the image with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the image
	 * @return the image
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	@Override
	public Image findByPrimaryKey(Serializable primaryKey)
		throws NoSuchImageException {

		Image image = fetchByPrimaryKey(primaryKey);

		if (image == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchImageException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return image;
	}

	/**
	 * Returns the image with the primary key or throws a <code>NoSuchImageException</code> if it could not be found.
	 *
	 * @param imageId the primary key of the image
	 * @return the image
	 * @throws NoSuchImageException if a image with the primary key could not be found
	 */
	@Override
	public Image findByPrimaryKey(long imageId) throws NoSuchImageException {
		return findByPrimaryKey((Serializable)imageId);
	}

	/**
	 * Returns the image with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param imageId the primary key of the image
	 * @return the image, or <code>null</code> if a image with the primary key could not be found
	 */
	@Override
	public Image fetchByPrimaryKey(long imageId) {
		return fetchByPrimaryKey((Serializable)imageId);
	}

	/**
	 * Returns all the images.
	 *
	 * @return the images
	 */
	@Override
	public List<Image> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Image> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Image> findAll(
		int start, int end, OrderByComparator<Image> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
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
	@Override
	public List<Image> findAll(
		int start, int end, OrderByComparator<Image> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Image> list = (List<Image>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_IMAGE);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_IMAGE;

				if (pagination) {
					sql = sql.concat(ImageModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Image>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Image>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the images from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Image image : findAll()) {
			remove(image);
		}
	}

	/**
	 * Returns the number of images.
	 *
	 * @return the number of images
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_IMAGE);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "imageId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_IMAGE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ImageModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the image persistence.
	 */
	@Activate
	public void activate() {
		ImageModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		ImageModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByCategoryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategoryId",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCategoryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategoryId",
			new String[] {Long.class.getName()},
			ImageModelImpl.CATEGORYID_COLUMN_BITMASK |
			ImageModelImpl.THUTU_COLUMN_BITMASK);

		_finderPathCountByCategoryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindAll",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindAll",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			},
			ImageModelImpl.GROUPID_COLUMN_BITMASK |
			ImageModelImpl.COMPANYID_COLUMN_BITMASK |
			ImageModelImpl.CATEGORYID_COLUMN_BITMASK |
			ImageModelImpl.THUTU_COLUMN_BITMASK);

		_finderPathCountByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindAll",
			new String[] {
				Long.class.getName(), Long.class.getName(), Long.class.getName()
			});

		_finderPathWithPaginationFindByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindGroup",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ImageImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindGroup",
			new String[] {Long.class.getName(), Long.class.getName()},
			ImageModelImpl.GROUPID_COLUMN_BITMASK |
			ImageModelImpl.COMPANYID_COLUMN_BITMASK |
			ImageModelImpl.THUTU_COLUMN_BITMASK);

		_finderPathCountByFindGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindGroup",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathFetchByIsDaiDienAndCateId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, ImageImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByIsDaiDienAndCateId",
			new String[] {Long.class.getName(), Boolean.class.getName()},
			ImageModelImpl.CATEGORYID_COLUMN_BITMASK |
			ImageModelImpl.ISDAIDIEN_COLUMN_BITMASK);

		_finderPathCountByIsDaiDienAndCateId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByIsDaiDienAndCateId",
			new String[] {Long.class.getName(), Boolean.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ImageImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = portal_albumPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.Album.service.model.Image"),
			true);
	}

	@Override
	@Reference(
		target = portal_albumPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = portal_albumPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_IMAGE =
		"SELECT image FROM Image image";

	private static final String _SQL_SELECT_IMAGE_WHERE =
		"SELECT image FROM Image image WHERE ";

	private static final String _SQL_COUNT_IMAGE =
		"SELECT COUNT(image) FROM Image image";

	private static final String _SQL_COUNT_IMAGE_WHERE =
		"SELECT COUNT(image) FROM Image image WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "image.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Image exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Image exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ImagePersistenceImpl.class);

	static {
		try {
			Class.forName(portal_albumPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}