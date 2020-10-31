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

package com.software.cms.service.persistence.impl;

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
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.software.cms.exception.NoSuchMapCateLayoutException;
import com.software.cms.model.MapCateLayout;
import com.software.cms.model.impl.MapCateLayoutImpl;
import com.software.cms.model.impl.MapCateLayoutModelImpl;
import com.software.cms.service.persistence.MapCateLayoutPersistence;
import com.software.cms.service.persistence.impl.constants.soft_cmsPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the map cate layout service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @generated
 */
@Component(service = MapCateLayoutPersistence.class)
public class MapCateLayoutPersistenceImpl
	extends BasePersistenceImpl<MapCateLayout>
	implements MapCateLayoutPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>MapCateLayoutUtil</code> to access the map cate layout persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		MapCateLayoutImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the map cate layouts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching map cate layouts
	 */
	@Override
	public List<MapCateLayout> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the map cate layouts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @return the range of matching map cate layouts
	 */
	@Override
	public List<MapCateLayout> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the map cate layouts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching map cate layouts
	 */
	@Override
	public List<MapCateLayout> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the map cate layouts where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching map cate layouts
	 */
	@Override
	public List<MapCateLayout> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<MapCateLayout> list = null;

		if (useFinderCache) {
			list = (List<MapCateLayout>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MapCateLayout mapCateLayout : list) {
					if (!uuid.equals(mapCateLayout.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_MAPCATELAYOUT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MapCateLayoutModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<MapCateLayout>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first map cate layout in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout findByUuid_First(
			String uuid, OrderByComparator<MapCateLayout> orderByComparator)
		throws NoSuchMapCateLayoutException {

		MapCateLayout mapCateLayout = fetchByUuid_First(
			uuid, orderByComparator);

		if (mapCateLayout != null) {
			return mapCateLayout;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMapCateLayoutException(sb.toString());
	}

	/**
	 * Returns the first map cate layout in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout fetchByUuid_First(
		String uuid, OrderByComparator<MapCateLayout> orderByComparator) {

		List<MapCateLayout> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last map cate layout in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout findByUuid_Last(
			String uuid, OrderByComparator<MapCateLayout> orderByComparator)
		throws NoSuchMapCateLayoutException {

		MapCateLayout mapCateLayout = fetchByUuid_Last(uuid, orderByComparator);

		if (mapCateLayout != null) {
			return mapCateLayout;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchMapCateLayoutException(sb.toString());
	}

	/**
	 * Returns the last map cate layout in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout fetchByUuid_Last(
		String uuid, OrderByComparator<MapCateLayout> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<MapCateLayout> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the map cate layouts before and after the current map cate layout in the ordered set where uuid = &#63;.
	 *
	 * @param mapCateLayoutId the primary key of the current map cate layout
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next map cate layout
	 * @throws NoSuchMapCateLayoutException if a map cate layout with the primary key could not be found
	 */
	@Override
	public MapCateLayout[] findByUuid_PrevAndNext(
			long mapCateLayoutId, String uuid,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws NoSuchMapCateLayoutException {

		uuid = Objects.toString(uuid, "");

		MapCateLayout mapCateLayout = findByPrimaryKey(mapCateLayoutId);

		Session session = null;

		try {
			session = openSession();

			MapCateLayout[] array = new MapCateLayoutImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, mapCateLayout, uuid, orderByComparator, true);

			array[1] = mapCateLayout;

			array[2] = getByUuid_PrevAndNext(
				session, mapCateLayout, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MapCateLayout getByUuid_PrevAndNext(
		Session session, MapCateLayout mapCateLayout, String uuid,
		OrderByComparator<MapCateLayout> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_MAPCATELAYOUT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MapCateLayoutModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						mapCateLayout)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MapCateLayout> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the map cate layouts where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (MapCateLayout mapCateLayout :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(mapCateLayout);
		}
	}

	/**
	 * Returns the number of map cate layouts where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching map cate layouts
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MAPCATELAYOUT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"mapCateLayout.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(mapCateLayout.uuid IS NULL OR mapCateLayout.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the map cate layout where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchMapCateLayoutException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout findByUUID_G(String uuid, long groupId)
		throws NoSuchMapCateLayoutException {

		MapCateLayout mapCateLayout = fetchByUUID_G(uuid, groupId);

		if (mapCateLayout == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMapCateLayoutException(sb.toString());
		}

		return mapCateLayout;
	}

	/**
	 * Returns the map cate layout where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the map cate layout where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof MapCateLayout) {
			MapCateLayout mapCateLayout = (MapCateLayout)result;

			if (!Objects.equals(uuid, mapCateLayout.getUuid()) ||
				(groupId != mapCateLayout.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_MAPCATELAYOUT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<MapCateLayout> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					MapCateLayout mapCateLayout = list.get(0);

					result = mapCateLayout;

					cacheResult(mapCateLayout);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUUID_G, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (MapCateLayout)result;
		}
	}

	/**
	 * Removes the map cate layout where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the map cate layout that was removed
	 */
	@Override
	public MapCateLayout removeByUUID_G(String uuid, long groupId)
		throws NoSuchMapCateLayoutException {

		MapCateLayout mapCateLayout = findByUUID_G(uuid, groupId);

		return remove(mapCateLayout);
	}

	/**
	 * Returns the number of map cate layouts where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching map cate layouts
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MAPCATELAYOUT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"mapCateLayout.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(mapCateLayout.uuid IS NULL OR mapCateLayout.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"mapCateLayout.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the map cate layouts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching map cate layouts
	 */
	@Override
	public List<MapCateLayout> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the map cate layouts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @return the range of matching map cate layouts
	 */
	@Override
	public List<MapCateLayout> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the map cate layouts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching map cate layouts
	 */
	@Override
	public List<MapCateLayout> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the map cate layouts where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching map cate layouts
	 */
	@Override
	public List<MapCateLayout> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator,
		boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<MapCateLayout> list = null;

		if (useFinderCache) {
			list = (List<MapCateLayout>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MapCateLayout mapCateLayout : list) {
					if (!uuid.equals(mapCateLayout.getUuid()) ||
						(companyId != mapCateLayout.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_MAPCATELAYOUT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MapCateLayoutModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<MapCateLayout>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first map cate layout in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws NoSuchMapCateLayoutException {

		MapCateLayout mapCateLayout = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (mapCateLayout != null) {
			return mapCateLayout;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMapCateLayoutException(sb.toString());
	}

	/**
	 * Returns the first map cate layout in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<MapCateLayout> orderByComparator) {

		List<MapCateLayout> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last map cate layout in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws NoSuchMapCateLayoutException {

		MapCateLayout mapCateLayout = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (mapCateLayout != null) {
			return mapCateLayout;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchMapCateLayoutException(sb.toString());
	}

	/**
	 * Returns the last map cate layout in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<MapCateLayout> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<MapCateLayout> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the map cate layouts before and after the current map cate layout in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param mapCateLayoutId the primary key of the current map cate layout
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next map cate layout
	 * @throws NoSuchMapCateLayoutException if a map cate layout with the primary key could not be found
	 */
	@Override
	public MapCateLayout[] findByUuid_C_PrevAndNext(
			long mapCateLayoutId, String uuid, long companyId,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws NoSuchMapCateLayoutException {

		uuid = Objects.toString(uuid, "");

		MapCateLayout mapCateLayout = findByPrimaryKey(mapCateLayoutId);

		Session session = null;

		try {
			session = openSession();

			MapCateLayout[] array = new MapCateLayoutImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, mapCateLayout, uuid, companyId, orderByComparator,
				true);

			array[1] = mapCateLayout;

			array[2] = getByUuid_C_PrevAndNext(
				session, mapCateLayout, uuid, companyId, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MapCateLayout getByUuid_C_PrevAndNext(
		Session session, MapCateLayout mapCateLayout, String uuid,
		long companyId, OrderByComparator<MapCateLayout> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_MAPCATELAYOUT_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MapCateLayoutModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						mapCateLayout)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MapCateLayout> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the map cate layouts where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (MapCateLayout mapCateLayout :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(mapCateLayout);
		}
	}

	/**
	 * Returns the number of map cate layouts where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching map cate layouts
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MAPCATELAYOUT_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"mapCateLayout.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(mapCateLayout.uuid IS NULL OR mapCateLayout.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"mapCateLayout.companyId = ?";

	private FinderPath _finderPathFetchByCategoryId;
	private FinderPath _finderPathCountByCategoryId;

	/**
	 * Returns the map cate layout where categoryId = &#63; or throws a <code>NoSuchMapCateLayoutException</code> if it could not be found.
	 *
	 * @param categoryId the category ID
	 * @return the matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout findByCategoryId(long categoryId)
		throws NoSuchMapCateLayoutException {

		MapCateLayout mapCateLayout = fetchByCategoryId(categoryId);

		if (mapCateLayout == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("categoryId=");
			sb.append(categoryId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMapCateLayoutException(sb.toString());
		}

		return mapCateLayout;
	}

	/**
	 * Returns the map cate layout where categoryId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param categoryId the category ID
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout fetchByCategoryId(long categoryId) {
		return fetchByCategoryId(categoryId, true);
	}

	/**
	 * Returns the map cate layout where categoryId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param categoryId the category ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout fetchByCategoryId(
		long categoryId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {categoryId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCategoryId, finderArgs, this);
		}

		if (result instanceof MapCateLayout) {
			MapCateLayout mapCateLayout = (MapCateLayout)result;

			if (categoryId != mapCateLayout.getCategoryId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_MAPCATELAYOUT_WHERE);

			sb.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(categoryId);

				List<MapCateLayout> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCategoryId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {categoryId};
							}

							_log.warn(
								"MapCateLayoutPersistenceImpl.fetchByCategoryId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MapCateLayout mapCateLayout = list.get(0);

					result = mapCateLayout;

					cacheResult(mapCateLayout);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByCategoryId, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (MapCateLayout)result;
		}
	}

	/**
	 * Removes the map cate layout where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @return the map cate layout that was removed
	 */
	@Override
	public MapCateLayout removeByCategoryId(long categoryId)
		throws NoSuchMapCateLayoutException {

		MapCateLayout mapCateLayout = findByCategoryId(categoryId);

		return remove(mapCateLayout);
	}

	/**
	 * Returns the number of map cate layouts where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching map cate layouts
	 */
	@Override
	public int countByCategoryId(long categoryId) {
		FinderPath finderPath = _finderPathCountByCategoryId;

		Object[] finderArgs = new Object[] {categoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_MAPCATELAYOUT_WHERE);

			sb.append(_FINDER_COLUMN_CATEGORYID_CATEGORYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(categoryId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CATEGORYID_CATEGORYID_2 =
		"mapCateLayout.categoryId = ?";

	private FinderPath _finderPathFetchByCategoryIdAndType;
	private FinderPath _finderPathCountByCategoryIdAndType;

	/**
	 * Returns the map cate layout where categoryId = &#63; and type = &#63; or throws a <code>NoSuchMapCateLayoutException</code> if it could not be found.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @return the matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout findByCategoryIdAndType(long categoryId, int type)
		throws NoSuchMapCateLayoutException {

		MapCateLayout mapCateLayout = fetchByCategoryIdAndType(
			categoryId, type);

		if (mapCateLayout == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("categoryId=");
			sb.append(categoryId);

			sb.append(", type=");
			sb.append(type);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMapCateLayoutException(sb.toString());
		}

		return mapCateLayout;
	}

	/**
	 * Returns the map cate layout where categoryId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout fetchByCategoryIdAndType(long categoryId, int type) {
		return fetchByCategoryIdAndType(categoryId, type, true);
	}

	/**
	 * Returns the map cate layout where categoryId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout fetchByCategoryIdAndType(
		long categoryId, int type, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {categoryId, type};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCategoryIdAndType, finderArgs, this);
		}

		if (result instanceof MapCateLayout) {
			MapCateLayout mapCateLayout = (MapCateLayout)result;

			if ((categoryId != mapCateLayout.getCategoryId()) ||
				(type != mapCateLayout.getType())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_MAPCATELAYOUT_WHERE);

			sb.append(_FINDER_COLUMN_CATEGORYIDANDTYPE_CATEGORYID_2);

			sb.append(_FINDER_COLUMN_CATEGORYIDANDTYPE_TYPE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(categoryId);

				queryPos.add(type);

				List<MapCateLayout> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCategoryIdAndType, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {categoryId, type};
							}

							_log.warn(
								"MapCateLayoutPersistenceImpl.fetchByCategoryIdAndType(long, int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MapCateLayout mapCateLayout = list.get(0);

					result = mapCateLayout;

					cacheResult(mapCateLayout);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByCategoryIdAndType, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (MapCateLayout)result;
		}
	}

	/**
	 * Removes the map cate layout where categoryId = &#63; and type = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @return the map cate layout that was removed
	 */
	@Override
	public MapCateLayout removeByCategoryIdAndType(long categoryId, int type)
		throws NoSuchMapCateLayoutException {

		MapCateLayout mapCateLayout = findByCategoryIdAndType(categoryId, type);

		return remove(mapCateLayout);
	}

	/**
	 * Returns the number of map cate layouts where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @return the number of matching map cate layouts
	 */
	@Override
	public int countByCategoryIdAndType(long categoryId, int type) {
		FinderPath finderPath = _finderPathCountByCategoryIdAndType;

		Object[] finderArgs = new Object[] {categoryId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MAPCATELAYOUT_WHERE);

			sb.append(_FINDER_COLUMN_CATEGORYIDANDTYPE_CATEGORYID_2);

			sb.append(_FINDER_COLUMN_CATEGORYIDANDTYPE_TYPE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(categoryId);

				queryPos.add(type);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_CATEGORYIDANDTYPE_CATEGORYID_2 =
		"mapCateLayout.categoryId = ? AND ";

	private static final String _FINDER_COLUMN_CATEGORYIDANDTYPE_TYPE_2 =
		"mapCateLayout.type = ?";

	private FinderPath _finderPathWithPaginationFindByByType;
	private FinderPath _finderPathWithoutPaginationFindByByType;
	private FinderPath _finderPathCountByByType;

	/**
	 * Returns all the map cate layouts where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @return the matching map cate layouts
	 */
	@Override
	public List<MapCateLayout> findByByType(long groupId, int type) {
		return findByByType(
			groupId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the map cate layouts where groupId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @return the range of matching map cate layouts
	 */
	@Override
	public List<MapCateLayout> findByByType(
		long groupId, int type, int start, int end) {

		return findByByType(groupId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the map cate layouts where groupId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching map cate layouts
	 */
	@Override
	public List<MapCateLayout> findByByType(
		long groupId, int type, int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator) {

		return findByByType(groupId, type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the map cate layouts where groupId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching map cate layouts
	 */
	@Override
	public List<MapCateLayout> findByByType(
		long groupId, int type, int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByByType;
				finderArgs = new Object[] {groupId, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByByType;
			finderArgs = new Object[] {
				groupId, type, start, end, orderByComparator
			};
		}

		List<MapCateLayout> list = null;

		if (useFinderCache) {
			list = (List<MapCateLayout>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MapCateLayout mapCateLayout : list) {
					if ((groupId != mapCateLayout.getGroupId()) ||
						(type != mapCateLayout.getType())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_MAPCATELAYOUT_WHERE);

			sb.append(_FINDER_COLUMN_BYTYPE_GROUPID_2);

			sb.append(_FINDER_COLUMN_BYTYPE_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MapCateLayoutModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(type);

				list = (List<MapCateLayout>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first map cate layout in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout findByByType_First(
			long groupId, int type,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws NoSuchMapCateLayoutException {

		MapCateLayout mapCateLayout = fetchByByType_First(
			groupId, type, orderByComparator);

		if (mapCateLayout != null) {
			return mapCateLayout;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchMapCateLayoutException(sb.toString());
	}

	/**
	 * Returns the first map cate layout in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout fetchByByType_First(
		long groupId, int type,
		OrderByComparator<MapCateLayout> orderByComparator) {

		List<MapCateLayout> list = findByByType(
			groupId, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last map cate layout in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout findByByType_Last(
			long groupId, int type,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws NoSuchMapCateLayoutException {

		MapCateLayout mapCateLayout = fetchByByType_Last(
			groupId, type, orderByComparator);

		if (mapCateLayout != null) {
			return mapCateLayout;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchMapCateLayoutException(sb.toString());
	}

	/**
	 * Returns the last map cate layout in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout fetchByByType_Last(
		long groupId, int type,
		OrderByComparator<MapCateLayout> orderByComparator) {

		int count = countByByType(groupId, type);

		if (count == 0) {
			return null;
		}

		List<MapCateLayout> list = findByByType(
			groupId, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the map cate layouts before and after the current map cate layout in the ordered set where groupId = &#63; and type = &#63;.
	 *
	 * @param mapCateLayoutId the primary key of the current map cate layout
	 * @param groupId the group ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next map cate layout
	 * @throws NoSuchMapCateLayoutException if a map cate layout with the primary key could not be found
	 */
	@Override
	public MapCateLayout[] findByByType_PrevAndNext(
			long mapCateLayoutId, long groupId, int type,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws NoSuchMapCateLayoutException {

		MapCateLayout mapCateLayout = findByPrimaryKey(mapCateLayoutId);

		Session session = null;

		try {
			session = openSession();

			MapCateLayout[] array = new MapCateLayoutImpl[3];

			array[0] = getByByType_PrevAndNext(
				session, mapCateLayout, groupId, type, orderByComparator, true);

			array[1] = mapCateLayout;

			array[2] = getByByType_PrevAndNext(
				session, mapCateLayout, groupId, type, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MapCateLayout getByByType_PrevAndNext(
		Session session, MapCateLayout mapCateLayout, long groupId, int type,
		OrderByComparator<MapCateLayout> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_MAPCATELAYOUT_WHERE);

		sb.append(_FINDER_COLUMN_BYTYPE_GROUPID_2);

		sb.append(_FINDER_COLUMN_BYTYPE_TYPE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MapCateLayoutModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(type);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						mapCateLayout)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MapCateLayout> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the map cate layouts where groupId = &#63; and type = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 */
	@Override
	public void removeByByType(long groupId, int type) {
		for (MapCateLayout mapCateLayout :
				findByByType(
					groupId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(mapCateLayout);
		}
	}

	/**
	 * Returns the number of map cate layouts where groupId = &#63; and type = &#63;.
	 *
	 * @param groupId the group ID
	 * @param type the type
	 * @return the number of matching map cate layouts
	 */
	@Override
	public int countByByType(long groupId, int type) {
		FinderPath finderPath = _finderPathCountByByType;

		Object[] finderArgs = new Object[] {groupId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MAPCATELAYOUT_WHERE);

			sb.append(_FINDER_COLUMN_BYTYPE_GROUPID_2);

			sb.append(_FINDER_COLUMN_BYTYPE_TYPE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(type);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BYTYPE_GROUPID_2 =
		"mapCateLayout.groupId = ? AND ";

	private static final String _FINDER_COLUMN_BYTYPE_TYPE_2 =
		"mapCateLayout.type = ?";

	private FinderPath _finderPathFetchByByLayoutIdAndType;
	private FinderPath _finderPathCountByByLayoutIdAndType;

	/**
	 * Returns the map cate layout where layoutId = &#63; and type = &#63; or throws a <code>NoSuchMapCateLayoutException</code> if it could not be found.
	 *
	 * @param layoutId the layout ID
	 * @param type the type
	 * @return the matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout findByByLayoutIdAndType(long layoutId, int type)
		throws NoSuchMapCateLayoutException {

		MapCateLayout mapCateLayout = fetchByByLayoutIdAndType(layoutId, type);

		if (mapCateLayout == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("layoutId=");
			sb.append(layoutId);

			sb.append(", type=");
			sb.append(type);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchMapCateLayoutException(sb.toString());
		}

		return mapCateLayout;
	}

	/**
	 * Returns the map cate layout where layoutId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param layoutId the layout ID
	 * @param type the type
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout fetchByByLayoutIdAndType(long layoutId, int type) {
		return fetchByByLayoutIdAndType(layoutId, type, true);
	}

	/**
	 * Returns the map cate layout where layoutId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param layoutId the layout ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout fetchByByLayoutIdAndType(
		long layoutId, int type, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {layoutId, type};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByByLayoutIdAndType, finderArgs, this);
		}

		if (result instanceof MapCateLayout) {
			MapCateLayout mapCateLayout = (MapCateLayout)result;

			if ((layoutId != mapCateLayout.getLayoutId()) ||
				(type != mapCateLayout.getType())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_MAPCATELAYOUT_WHERE);

			sb.append(_FINDER_COLUMN_BYLAYOUTIDANDTYPE_LAYOUTID_2);

			sb.append(_FINDER_COLUMN_BYLAYOUTIDANDTYPE_TYPE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(layoutId);

				queryPos.add(type);

				List<MapCateLayout> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByByLayoutIdAndType, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {layoutId, type};
							}

							_log.warn(
								"MapCateLayoutPersistenceImpl.fetchByByLayoutIdAndType(long, int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					MapCateLayout mapCateLayout = list.get(0);

					result = mapCateLayout;

					cacheResult(mapCateLayout);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByByLayoutIdAndType, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (MapCateLayout)result;
		}
	}

	/**
	 * Removes the map cate layout where layoutId = &#63; and type = &#63; from the database.
	 *
	 * @param layoutId the layout ID
	 * @param type the type
	 * @return the map cate layout that was removed
	 */
	@Override
	public MapCateLayout removeByByLayoutIdAndType(long layoutId, int type)
		throws NoSuchMapCateLayoutException {

		MapCateLayout mapCateLayout = findByByLayoutIdAndType(layoutId, type);

		return remove(mapCateLayout);
	}

	/**
	 * Returns the number of map cate layouts where layoutId = &#63; and type = &#63;.
	 *
	 * @param layoutId the layout ID
	 * @param type the type
	 * @return the number of matching map cate layouts
	 */
	@Override
	public int countByByLayoutIdAndType(long layoutId, int type) {
		FinderPath finderPath = _finderPathCountByByLayoutIdAndType;

		Object[] finderArgs = new Object[] {layoutId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MAPCATELAYOUT_WHERE);

			sb.append(_FINDER_COLUMN_BYLAYOUTIDANDTYPE_LAYOUTID_2);

			sb.append(_FINDER_COLUMN_BYLAYOUTIDANDTYPE_TYPE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(layoutId);

				queryPos.add(type);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_BYLAYOUTIDANDTYPE_LAYOUTID_2 =
		"mapCateLayout.layoutId = ? AND ";

	private static final String _FINDER_COLUMN_BYLAYOUTIDANDTYPE_TYPE_2 =
		"mapCateLayout.type = ?";

	private FinderPath _finderPathWithPaginationFindByCheckCategoryIdAndType;
	private FinderPath _finderPathWithoutPaginationFindByCheckCategoryIdAndType;
	private FinderPath _finderPathCountByCheckCategoryIdAndType;

	/**
	 * Returns all the map cate layouts where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @return the matching map cate layouts
	 */
	@Override
	public List<MapCateLayout> findByCheckCategoryIdAndType(
		long categoryId, int type) {

		return findByCheckCategoryIdAndType(
			categoryId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the map cate layouts where categoryId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @return the range of matching map cate layouts
	 */
	@Override
	public List<MapCateLayout> findByCheckCategoryIdAndType(
		long categoryId, int type, int start, int end) {

		return findByCheckCategoryIdAndType(categoryId, type, start, end, null);
	}

	/**
	 * Returns an ordered range of all the map cate layouts where categoryId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching map cate layouts
	 */
	@Override
	public List<MapCateLayout> findByCheckCategoryIdAndType(
		long categoryId, int type, int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator) {

		return findByCheckCategoryIdAndType(
			categoryId, type, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the map cate layouts where categoryId = &#63; and type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching map cate layouts
	 */
	@Override
	public List<MapCateLayout> findByCheckCategoryIdAndType(
		long categoryId, int type, int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCheckCategoryIdAndType;
				finderArgs = new Object[] {categoryId, type};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCheckCategoryIdAndType;
			finderArgs = new Object[] {
				categoryId, type, start, end, orderByComparator
			};
		}

		List<MapCateLayout> list = null;

		if (useFinderCache) {
			list = (List<MapCateLayout>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MapCateLayout mapCateLayout : list) {
					if ((categoryId != mapCateLayout.getCategoryId()) ||
						(type != mapCateLayout.getType())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_MAPCATELAYOUT_WHERE);

			sb.append(_FINDER_COLUMN_CHECKCATEGORYIDANDTYPE_CATEGORYID_2);

			sb.append(_FINDER_COLUMN_CHECKCATEGORYIDANDTYPE_TYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(MapCateLayoutModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(categoryId);

				queryPos.add(type);

				list = (List<MapCateLayout>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first map cate layout in the ordered set where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout findByCheckCategoryIdAndType_First(
			long categoryId, int type,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws NoSuchMapCateLayoutException {

		MapCateLayout mapCateLayout = fetchByCheckCategoryIdAndType_First(
			categoryId, type, orderByComparator);

		if (mapCateLayout != null) {
			return mapCateLayout;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("categoryId=");
		sb.append(categoryId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchMapCateLayoutException(sb.toString());
	}

	/**
	 * Returns the first map cate layout in the ordered set where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout fetchByCheckCategoryIdAndType_First(
		long categoryId, int type,
		OrderByComparator<MapCateLayout> orderByComparator) {

		List<MapCateLayout> list = findByCheckCategoryIdAndType(
			categoryId, type, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last map cate layout in the ordered set where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout
	 * @throws NoSuchMapCateLayoutException if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout findByCheckCategoryIdAndType_Last(
			long categoryId, int type,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws NoSuchMapCateLayoutException {

		MapCateLayout mapCateLayout = fetchByCheckCategoryIdAndType_Last(
			categoryId, type, orderByComparator);

		if (mapCateLayout != null) {
			return mapCateLayout;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("categoryId=");
		sb.append(categoryId);

		sb.append(", type=");
		sb.append(type);

		sb.append("}");

		throw new NoSuchMapCateLayoutException(sb.toString());
	}

	/**
	 * Returns the last map cate layout in the ordered set where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching map cate layout, or <code>null</code> if a matching map cate layout could not be found
	 */
	@Override
	public MapCateLayout fetchByCheckCategoryIdAndType_Last(
		long categoryId, int type,
		OrderByComparator<MapCateLayout> orderByComparator) {

		int count = countByCheckCategoryIdAndType(categoryId, type);

		if (count == 0) {
			return null;
		}

		List<MapCateLayout> list = findByCheckCategoryIdAndType(
			categoryId, type, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the map cate layouts before and after the current map cate layout in the ordered set where categoryId = &#63; and type = &#63;.
	 *
	 * @param mapCateLayoutId the primary key of the current map cate layout
	 * @param categoryId the category ID
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next map cate layout
	 * @throws NoSuchMapCateLayoutException if a map cate layout with the primary key could not be found
	 */
	@Override
	public MapCateLayout[] findByCheckCategoryIdAndType_PrevAndNext(
			long mapCateLayoutId, long categoryId, int type,
			OrderByComparator<MapCateLayout> orderByComparator)
		throws NoSuchMapCateLayoutException {

		MapCateLayout mapCateLayout = findByPrimaryKey(mapCateLayoutId);

		Session session = null;

		try {
			session = openSession();

			MapCateLayout[] array = new MapCateLayoutImpl[3];

			array[0] = getByCheckCategoryIdAndType_PrevAndNext(
				session, mapCateLayout, categoryId, type, orderByComparator,
				true);

			array[1] = mapCateLayout;

			array[2] = getByCheckCategoryIdAndType_PrevAndNext(
				session, mapCateLayout, categoryId, type, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected MapCateLayout getByCheckCategoryIdAndType_PrevAndNext(
		Session session, MapCateLayout mapCateLayout, long categoryId, int type,
		OrderByComparator<MapCateLayout> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_MAPCATELAYOUT_WHERE);

		sb.append(_FINDER_COLUMN_CHECKCATEGORYIDANDTYPE_CATEGORYID_2);

		sb.append(_FINDER_COLUMN_CHECKCATEGORYIDANDTYPE_TYPE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(MapCateLayoutModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(categoryId);

		queryPos.add(type);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						mapCateLayout)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<MapCateLayout> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the map cate layouts where categoryId = &#63; and type = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 */
	@Override
	public void removeByCheckCategoryIdAndType(long categoryId, int type) {
		for (MapCateLayout mapCateLayout :
				findByCheckCategoryIdAndType(
					categoryId, type, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(mapCateLayout);
		}
	}

	/**
	 * Returns the number of map cate layouts where categoryId = &#63; and type = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param type the type
	 * @return the number of matching map cate layouts
	 */
	@Override
	public int countByCheckCategoryIdAndType(long categoryId, int type) {
		FinderPath finderPath = _finderPathCountByCheckCategoryIdAndType;

		Object[] finderArgs = new Object[] {categoryId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_MAPCATELAYOUT_WHERE);

			sb.append(_FINDER_COLUMN_CHECKCATEGORYIDANDTYPE_CATEGORYID_2);

			sb.append(_FINDER_COLUMN_CHECKCATEGORYIDANDTYPE_TYPE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(categoryId);

				queryPos.add(type);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_CHECKCATEGORYIDANDTYPE_CATEGORYID_2 =
			"mapCateLayout.categoryId = ? AND ";

	private static final String _FINDER_COLUMN_CHECKCATEGORYIDANDTYPE_TYPE_2 =
		"mapCateLayout.type = ?";

	public MapCateLayoutPersistenceImpl() {
		setModelClass(MapCateLayout.class);

		setModelImplClass(MapCateLayoutImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the map cate layout in the entity cache if it is enabled.
	 *
	 * @param mapCateLayout the map cate layout
	 */
	@Override
	public void cacheResult(MapCateLayout mapCateLayout) {
		entityCache.putResult(
			entityCacheEnabled, MapCateLayoutImpl.class,
			mapCateLayout.getPrimaryKey(), mapCateLayout);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {mapCateLayout.getUuid(), mapCateLayout.getGroupId()},
			mapCateLayout);

		finderCache.putResult(
			_finderPathFetchByCategoryId,
			new Object[] {mapCateLayout.getCategoryId()}, mapCateLayout);

		finderCache.putResult(
			_finderPathFetchByCategoryIdAndType,
			new Object[] {
				mapCateLayout.getCategoryId(), mapCateLayout.getType()
			},
			mapCateLayout);

		finderCache.putResult(
			_finderPathFetchByByLayoutIdAndType,
			new Object[] {mapCateLayout.getLayoutId(), mapCateLayout.getType()},
			mapCateLayout);

		mapCateLayout.resetOriginalValues();
	}

	/**
	 * Caches the map cate layouts in the entity cache if it is enabled.
	 *
	 * @param mapCateLayouts the map cate layouts
	 */
	@Override
	public void cacheResult(List<MapCateLayout> mapCateLayouts) {
		for (MapCateLayout mapCateLayout : mapCateLayouts) {
			if (entityCache.getResult(
					entityCacheEnabled, MapCateLayoutImpl.class,
					mapCateLayout.getPrimaryKey()) == null) {

				cacheResult(mapCateLayout);
			}
			else {
				mapCateLayout.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all map cate layouts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MapCateLayoutImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the map cate layout.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MapCateLayout mapCateLayout) {
		entityCache.removeResult(
			entityCacheEnabled, MapCateLayoutImpl.class,
			mapCateLayout.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((MapCateLayoutModelImpl)mapCateLayout, true);
	}

	@Override
	public void clearCache(List<MapCateLayout> mapCateLayouts) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MapCateLayout mapCateLayout : mapCateLayouts) {
			entityCache.removeResult(
				entityCacheEnabled, MapCateLayoutImpl.class,
				mapCateLayout.getPrimaryKey());

			clearUniqueFindersCache(
				(MapCateLayoutModelImpl)mapCateLayout, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, MapCateLayoutImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		MapCateLayoutModelImpl mapCateLayoutModelImpl) {

		Object[] args = new Object[] {
			mapCateLayoutModelImpl.getUuid(),
			mapCateLayoutModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, mapCateLayoutModelImpl, false);

		args = new Object[] {mapCateLayoutModelImpl.getCategoryId()};

		finderCache.putResult(
			_finderPathCountByCategoryId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByCategoryId, args, mapCateLayoutModelImpl, false);

		args = new Object[] {
			mapCateLayoutModelImpl.getCategoryId(),
			mapCateLayoutModelImpl.getType()
		};

		finderCache.putResult(
			_finderPathCountByCategoryIdAndType, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByCategoryIdAndType, args, mapCateLayoutModelImpl,
			false);

		args = new Object[] {
			mapCateLayoutModelImpl.getLayoutId(),
			mapCateLayoutModelImpl.getType()
		};

		finderCache.putResult(
			_finderPathCountByByLayoutIdAndType, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByByLayoutIdAndType, args, mapCateLayoutModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		MapCateLayoutModelImpl mapCateLayoutModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				mapCateLayoutModelImpl.getUuid(),
				mapCateLayoutModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((mapCateLayoutModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				mapCateLayoutModelImpl.getOriginalUuid(),
				mapCateLayoutModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				mapCateLayoutModelImpl.getCategoryId()
			};

			finderCache.removeResult(_finderPathCountByCategoryId, args);
			finderCache.removeResult(_finderPathFetchByCategoryId, args);
		}

		if ((mapCateLayoutModelImpl.getColumnBitmask() &
			 _finderPathFetchByCategoryId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				mapCateLayoutModelImpl.getOriginalCategoryId()
			};

			finderCache.removeResult(_finderPathCountByCategoryId, args);
			finderCache.removeResult(_finderPathFetchByCategoryId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				mapCateLayoutModelImpl.getCategoryId(),
				mapCateLayoutModelImpl.getType()
			};

			finderCache.removeResult(_finderPathCountByCategoryIdAndType, args);
			finderCache.removeResult(_finderPathFetchByCategoryIdAndType, args);
		}

		if ((mapCateLayoutModelImpl.getColumnBitmask() &
			 _finderPathFetchByCategoryIdAndType.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				mapCateLayoutModelImpl.getOriginalCategoryId(),
				mapCateLayoutModelImpl.getOriginalType()
			};

			finderCache.removeResult(_finderPathCountByCategoryIdAndType, args);
			finderCache.removeResult(_finderPathFetchByCategoryIdAndType, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				mapCateLayoutModelImpl.getLayoutId(),
				mapCateLayoutModelImpl.getType()
			};

			finderCache.removeResult(_finderPathCountByByLayoutIdAndType, args);
			finderCache.removeResult(_finderPathFetchByByLayoutIdAndType, args);
		}

		if ((mapCateLayoutModelImpl.getColumnBitmask() &
			 _finderPathFetchByByLayoutIdAndType.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				mapCateLayoutModelImpl.getOriginalLayoutId(),
				mapCateLayoutModelImpl.getOriginalType()
			};

			finderCache.removeResult(_finderPathCountByByLayoutIdAndType, args);
			finderCache.removeResult(_finderPathFetchByByLayoutIdAndType, args);
		}
	}

	/**
	 * Creates a new map cate layout with the primary key. Does not add the map cate layout to the database.
	 *
	 * @param mapCateLayoutId the primary key for the new map cate layout
	 * @return the new map cate layout
	 */
	@Override
	public MapCateLayout create(long mapCateLayoutId) {
		MapCateLayout mapCateLayout = new MapCateLayoutImpl();

		mapCateLayout.setNew(true);
		mapCateLayout.setPrimaryKey(mapCateLayoutId);

		String uuid = PortalUUIDUtil.generate();

		mapCateLayout.setUuid(uuid);

		mapCateLayout.setCompanyId(CompanyThreadLocal.getCompanyId());

		return mapCateLayout;
	}

	/**
	 * Removes the map cate layout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param mapCateLayoutId the primary key of the map cate layout
	 * @return the map cate layout that was removed
	 * @throws NoSuchMapCateLayoutException if a map cate layout with the primary key could not be found
	 */
	@Override
	public MapCateLayout remove(long mapCateLayoutId)
		throws NoSuchMapCateLayoutException {

		return remove((Serializable)mapCateLayoutId);
	}

	/**
	 * Removes the map cate layout with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the map cate layout
	 * @return the map cate layout that was removed
	 * @throws NoSuchMapCateLayoutException if a map cate layout with the primary key could not be found
	 */
	@Override
	public MapCateLayout remove(Serializable primaryKey)
		throws NoSuchMapCateLayoutException {

		Session session = null;

		try {
			session = openSession();

			MapCateLayout mapCateLayout = (MapCateLayout)session.get(
				MapCateLayoutImpl.class, primaryKey);

			if (mapCateLayout == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMapCateLayoutException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(mapCateLayout);
		}
		catch (NoSuchMapCateLayoutException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected MapCateLayout removeImpl(MapCateLayout mapCateLayout) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(mapCateLayout)) {
				mapCateLayout = (MapCateLayout)session.get(
					MapCateLayoutImpl.class, mapCateLayout.getPrimaryKeyObj());
			}

			if (mapCateLayout != null) {
				session.delete(mapCateLayout);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (mapCateLayout != null) {
			clearCache(mapCateLayout);
		}

		return mapCateLayout;
	}

	@Override
	public MapCateLayout updateImpl(MapCateLayout mapCateLayout) {
		boolean isNew = mapCateLayout.isNew();

		if (!(mapCateLayout instanceof MapCateLayoutModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(mapCateLayout.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					mapCateLayout);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in mapCateLayout proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom MapCateLayout implementation " +
					mapCateLayout.getClass());
		}

		MapCateLayoutModelImpl mapCateLayoutModelImpl =
			(MapCateLayoutModelImpl)mapCateLayout;

		if (Validator.isNull(mapCateLayout.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			mapCateLayout.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (mapCateLayout.isNew()) {
				session.save(mapCateLayout);

				mapCateLayout.setNew(false);
			}
			else {
				mapCateLayout = (MapCateLayout)session.merge(mapCateLayout);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {mapCateLayoutModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				mapCateLayoutModelImpl.getUuid(),
				mapCateLayoutModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {
				mapCateLayoutModelImpl.getGroupId(),
				mapCateLayoutModelImpl.getType()
			};

			finderCache.removeResult(_finderPathCountByByType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByByType, args);

			args = new Object[] {
				mapCateLayoutModelImpl.getCategoryId(),
				mapCateLayoutModelImpl.getType()
			};

			finderCache.removeResult(
				_finderPathCountByCheckCategoryIdAndType, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCheckCategoryIdAndType, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((mapCateLayoutModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					mapCateLayoutModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {mapCateLayoutModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((mapCateLayoutModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					mapCateLayoutModelImpl.getOriginalUuid(),
					mapCateLayoutModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					mapCateLayoutModelImpl.getUuid(),
					mapCateLayoutModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((mapCateLayoutModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByByType.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					mapCateLayoutModelImpl.getOriginalGroupId(),
					mapCateLayoutModelImpl.getOriginalType()
				};

				finderCache.removeResult(_finderPathCountByByType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByByType, args);

				args = new Object[] {
					mapCateLayoutModelImpl.getGroupId(),
					mapCateLayoutModelImpl.getType()
				};

				finderCache.removeResult(_finderPathCountByByType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByByType, args);
			}

			if ((mapCateLayoutModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCheckCategoryIdAndType.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					mapCateLayoutModelImpl.getOriginalCategoryId(),
					mapCateLayoutModelImpl.getOriginalType()
				};

				finderCache.removeResult(
					_finderPathCountByCheckCategoryIdAndType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCheckCategoryIdAndType,
					args);

				args = new Object[] {
					mapCateLayoutModelImpl.getCategoryId(),
					mapCateLayoutModelImpl.getType()
				};

				finderCache.removeResult(
					_finderPathCountByCheckCategoryIdAndType, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCheckCategoryIdAndType,
					args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, MapCateLayoutImpl.class,
			mapCateLayout.getPrimaryKey(), mapCateLayout, false);

		clearUniqueFindersCache(mapCateLayoutModelImpl, false);
		cacheUniqueFindersCache(mapCateLayoutModelImpl);

		mapCateLayout.resetOriginalValues();

		return mapCateLayout;
	}

	/**
	 * Returns the map cate layout with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the map cate layout
	 * @return the map cate layout
	 * @throws NoSuchMapCateLayoutException if a map cate layout with the primary key could not be found
	 */
	@Override
	public MapCateLayout findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMapCateLayoutException {

		MapCateLayout mapCateLayout = fetchByPrimaryKey(primaryKey);

		if (mapCateLayout == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMapCateLayoutException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return mapCateLayout;
	}

	/**
	 * Returns the map cate layout with the primary key or throws a <code>NoSuchMapCateLayoutException</code> if it could not be found.
	 *
	 * @param mapCateLayoutId the primary key of the map cate layout
	 * @return the map cate layout
	 * @throws NoSuchMapCateLayoutException if a map cate layout with the primary key could not be found
	 */
	@Override
	public MapCateLayout findByPrimaryKey(long mapCateLayoutId)
		throws NoSuchMapCateLayoutException {

		return findByPrimaryKey((Serializable)mapCateLayoutId);
	}

	/**
	 * Returns the map cate layout with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param mapCateLayoutId the primary key of the map cate layout
	 * @return the map cate layout, or <code>null</code> if a map cate layout with the primary key could not be found
	 */
	@Override
	public MapCateLayout fetchByPrimaryKey(long mapCateLayoutId) {
		return fetchByPrimaryKey((Serializable)mapCateLayoutId);
	}

	/**
	 * Returns all the map cate layouts.
	 *
	 * @return the map cate layouts
	 */
	@Override
	public List<MapCateLayout> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the map cate layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @return the range of map cate layouts
	 */
	@Override
	public List<MapCateLayout> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the map cate layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of map cate layouts
	 */
	@Override
	public List<MapCateLayout> findAll(
		int start, int end,
		OrderByComparator<MapCateLayout> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the map cate layouts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>MapCateLayoutModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of map cate layouts
	 * @param end the upper bound of the range of map cate layouts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of map cate layouts
	 */
	@Override
	public List<MapCateLayout> findAll(
		int start, int end, OrderByComparator<MapCateLayout> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<MapCateLayout> list = null;

		if (useFinderCache) {
			list = (List<MapCateLayout>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_MAPCATELAYOUT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_MAPCATELAYOUT;

				sql = sql.concat(MapCateLayoutModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<MapCateLayout>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the map cate layouts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MapCateLayout mapCateLayout : findAll()) {
			remove(mapCateLayout);
		}
	}

	/**
	 * Returns the number of map cate layouts.
	 *
	 * @return the number of map cate layouts
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_MAPCATELAYOUT);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "mapCateLayoutId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_MAPCATELAYOUT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MapCateLayoutModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the map cate layout persistence.
	 */
	@Activate
	public void activate() {
		MapCateLayoutModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		MapCateLayoutModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MapCateLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MapCateLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MapCateLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MapCateLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			MapCateLayoutModelImpl.UUID_COLUMN_BITMASK |
			MapCateLayoutModelImpl.LAYOUTID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MapCateLayoutImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			MapCateLayoutModelImpl.UUID_COLUMN_BITMASK |
			MapCateLayoutModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MapCateLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MapCateLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			MapCateLayoutModelImpl.UUID_COLUMN_BITMASK |
			MapCateLayoutModelImpl.COMPANYID_COLUMN_BITMASK |
			MapCateLayoutModelImpl.LAYOUTID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathFetchByCategoryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MapCateLayoutImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCategoryId",
			new String[] {Long.class.getName()},
			MapCateLayoutModelImpl.CATEGORYID_COLUMN_BITMASK);

		_finderPathCountByCategoryId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategoryId",
			new String[] {Long.class.getName()});

		_finderPathFetchByCategoryIdAndType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MapCateLayoutImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByCategoryIdAndType",
			new String[] {Long.class.getName(), Integer.class.getName()},
			MapCateLayoutModelImpl.CATEGORYID_COLUMN_BITMASK |
			MapCateLayoutModelImpl.TYPE_COLUMN_BITMASK);

		_finderPathCountByCategoryIdAndType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCategoryIdAndType",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByByType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MapCateLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByByType",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByByType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MapCateLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByByType",
			new String[] {Long.class.getName(), Integer.class.getName()},
			MapCateLayoutModelImpl.GROUPID_COLUMN_BITMASK |
			MapCateLayoutModelImpl.TYPE_COLUMN_BITMASK |
			MapCateLayoutModelImpl.LAYOUTID_COLUMN_BITMASK);

		_finderPathCountByByType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByByType",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathFetchByByLayoutIdAndType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MapCateLayoutImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByByLayoutIdAndType",
			new String[] {Long.class.getName(), Integer.class.getName()},
			MapCateLayoutModelImpl.LAYOUTID_COLUMN_BITMASK |
			MapCateLayoutModelImpl.TYPE_COLUMN_BITMASK);

		_finderPathCountByByLayoutIdAndType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByByLayoutIdAndType",
			new String[] {Long.class.getName(), Integer.class.getName()});

		_finderPathWithPaginationFindByCheckCategoryIdAndType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, MapCateLayoutImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCheckCategoryIdAndType",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCheckCategoryIdAndType =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, MapCateLayoutImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByCheckCategoryIdAndType",
				new String[] {Long.class.getName(), Integer.class.getName()},
				MapCateLayoutModelImpl.CATEGORYID_COLUMN_BITMASK |
				MapCateLayoutModelImpl.TYPE_COLUMN_BITMASK |
				MapCateLayoutModelImpl.LAYOUTID_COLUMN_BITMASK);

		_finderPathCountByCheckCategoryIdAndType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCheckCategoryIdAndType",
			new String[] {Long.class.getName(), Integer.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(MapCateLayoutImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = soft_cmsPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.software.cms.model.MapCateLayout"),
			true);
	}

	@Override
	@Reference(
		target = soft_cmsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = soft_cmsPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_MAPCATELAYOUT =
		"SELECT mapCateLayout FROM MapCateLayout mapCateLayout";

	private static final String _SQL_SELECT_MAPCATELAYOUT_WHERE =
		"SELECT mapCateLayout FROM MapCateLayout mapCateLayout WHERE ";

	private static final String _SQL_COUNT_MAPCATELAYOUT =
		"SELECT COUNT(mapCateLayout) FROM MapCateLayout mapCateLayout";

	private static final String _SQL_COUNT_MAPCATELAYOUT_WHERE =
		"SELECT COUNT(mapCateLayout) FROM MapCateLayout mapCateLayout WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "mapCateLayout.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No MapCateLayout exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No MapCateLayout exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		MapCateLayoutPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type"});

	static {
		try {
			Class.forName(soft_cmsPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}