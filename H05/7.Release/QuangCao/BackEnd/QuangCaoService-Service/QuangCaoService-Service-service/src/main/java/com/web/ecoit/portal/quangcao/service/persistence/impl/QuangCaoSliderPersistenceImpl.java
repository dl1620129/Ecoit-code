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

package com.web.ecoit.portal.quangcao.service.persistence.impl;

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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import com.web.ecoit.portal.quangcao.exception.NoSuchQuangCaoSliderException;
import com.web.ecoit.portal.quangcao.model.QuangCaoSlider;
import com.web.ecoit.portal.quangcao.model.impl.QuangCaoSliderImpl;
import com.web.ecoit.portal.quangcao.model.impl.QuangCaoSliderModelImpl;
import com.web.ecoit.portal.quangcao.service.persistence.QuangCaoSliderPersistence;
import com.web.ecoit.portal.quangcao.service.persistence.impl.constants.soft_advPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the quang cao slider service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = QuangCaoSliderPersistence.class)
@ProviderType
public class QuangCaoSliderPersistenceImpl
	extends BasePersistenceImpl<QuangCaoSlider>
	implements QuangCaoSliderPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>QuangCaoSliderUtil</code> to access the quang cao slider persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		QuangCaoSliderImpl.class.getName();

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
	 * Returns all the quang cao sliders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching quang cao sliders
	 */
	@Override
	public List<QuangCaoSlider> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quang cao sliders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @return the range of matching quang cao sliders
	 */
	@Override
	public List<QuangCaoSlider> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quang cao sliders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quang cao sliders
	 */
	@Deprecated
	@Override
	public List<QuangCaoSlider> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<QuangCaoSlider> orderByComparator,
		boolean useFinderCache) {

		return findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the quang cao sliders where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quang cao sliders
	 */
	@Override
	public List<QuangCaoSlider> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<QuangCaoSlider> orderByComparator) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid;
			finderArgs = new Object[] {uuid};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<QuangCaoSlider> list = (List<QuangCaoSlider>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (QuangCaoSlider quangCaoSlider : list) {
				if (!uuid.equals(quangCaoSlider.getUuid())) {
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

			query.append(_SQL_SELECT_QUANGCAOSLIDER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(QuangCaoSliderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<QuangCaoSlider>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<QuangCaoSlider>)QueryUtil.list(
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
	 * Returns the first quang cao slider in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a matching quang cao slider could not be found
	 */
	@Override
	public QuangCaoSlider findByUuid_First(
			String uuid, OrderByComparator<QuangCaoSlider> orderByComparator)
		throws NoSuchQuangCaoSliderException {

		QuangCaoSlider quangCaoSlider = fetchByUuid_First(
			uuid, orderByComparator);

		if (quangCaoSlider != null) {
			return quangCaoSlider;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchQuangCaoSliderException(msg.toString());
	}

	/**
	 * Returns the first quang cao slider in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	@Override
	public QuangCaoSlider fetchByUuid_First(
		String uuid, OrderByComparator<QuangCaoSlider> orderByComparator) {

		List<QuangCaoSlider> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last quang cao slider in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a matching quang cao slider could not be found
	 */
	@Override
	public QuangCaoSlider findByUuid_Last(
			String uuid, OrderByComparator<QuangCaoSlider> orderByComparator)
		throws NoSuchQuangCaoSliderException {

		QuangCaoSlider quangCaoSlider = fetchByUuid_Last(
			uuid, orderByComparator);

		if (quangCaoSlider != null) {
			return quangCaoSlider;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchQuangCaoSliderException(msg.toString());
	}

	/**
	 * Returns the last quang cao slider in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	@Override
	public QuangCaoSlider fetchByUuid_Last(
		String uuid, OrderByComparator<QuangCaoSlider> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<QuangCaoSlider> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the quang cao sliders before and after the current quang cao slider in the ordered set where uuid = &#63;.
	 *
	 * @param quangCaoSliderId the primary key of the current quang cao slider
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a quang cao slider with the primary key could not be found
	 */
	@Override
	public QuangCaoSlider[] findByUuid_PrevAndNext(
			long quangCaoSliderId, String uuid,
			OrderByComparator<QuangCaoSlider> orderByComparator)
		throws NoSuchQuangCaoSliderException {

		uuid = Objects.toString(uuid, "");

		QuangCaoSlider quangCaoSlider = findByPrimaryKey(quangCaoSliderId);

		Session session = null;

		try {
			session = openSession();

			QuangCaoSlider[] array = new QuangCaoSliderImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, quangCaoSlider, uuid, orderByComparator, true);

			array[1] = quangCaoSlider;

			array[2] = getByUuid_PrevAndNext(
				session, quangCaoSlider, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected QuangCaoSlider getByUuid_PrevAndNext(
		Session session, QuangCaoSlider quangCaoSlider, String uuid,
		OrderByComparator<QuangCaoSlider> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_QUANGCAOSLIDER_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

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
			query.append(QuangCaoSliderModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						quangCaoSlider)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<QuangCaoSlider> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the quang cao sliders where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (QuangCaoSlider quangCaoSlider :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(quangCaoSlider);
		}
	}

	/**
	 * Returns the number of quang cao sliders where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching quang cao sliders
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUANGCAOSLIDER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"quangCaoSlider.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(quangCaoSlider.uuid IS NULL OR quangCaoSlider.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the quang cao slider where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchQuangCaoSliderException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a matching quang cao slider could not be found
	 */
	@Override
	public QuangCaoSlider findByUUID_G(String uuid, long groupId)
		throws NoSuchQuangCaoSliderException {

		QuangCaoSlider quangCaoSlider = fetchByUUID_G(uuid, groupId);

		if (quangCaoSlider == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchQuangCaoSliderException(msg.toString());
		}

		return quangCaoSlider;
	}

	/**
	 * Returns the quang cao slider where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	@Deprecated
	@Override
	public QuangCaoSlider fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the quang cao slider where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	@Override
	public QuangCaoSlider fetchByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] {uuid, groupId};

		Object result = finderCache.getResult(
			_finderPathFetchByUUID_G, finderArgs, this);

		if (result instanceof QuangCaoSlider) {
			QuangCaoSlider quangCaoSlider = (QuangCaoSlider)result;

			if (!Objects.equals(uuid, quangCaoSlider.getUuid()) ||
				(groupId != quangCaoSlider.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_QUANGCAOSLIDER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<QuangCaoSlider> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByUUID_G, finderArgs, list);
				}
				else {
					QuangCaoSlider quangCaoSlider = list.get(0);

					result = quangCaoSlider;

					cacheResult(quangCaoSlider);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByUUID_G, finderArgs);

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
			return (QuangCaoSlider)result;
		}
	}

	/**
	 * Removes the quang cao slider where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the quang cao slider that was removed
	 */
	@Override
	public QuangCaoSlider removeByUUID_G(String uuid, long groupId)
		throws NoSuchQuangCaoSliderException {

		QuangCaoSlider quangCaoSlider = findByUUID_G(uuid, groupId);

		return remove(quangCaoSlider);
	}

	/**
	 * Returns the number of quang cao sliders where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching quang cao sliders
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_QUANGCAOSLIDER_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"quangCaoSlider.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(quangCaoSlider.uuid IS NULL OR quangCaoSlider.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"quangCaoSlider.groupId = ?";

	private FinderPath _finderPathWithPaginationFindBybyQuangCaoIdAndGroupId;
	private FinderPath _finderPathWithoutPaginationFindBybyQuangCaoIdAndGroupId;
	private FinderPath _finderPathCountBybyQuangCaoIdAndGroupId;

	/**
	 * Returns all the quang cao sliders where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @return the matching quang cao sliders
	 */
	@Override
	public List<QuangCaoSlider> findBybyQuangCaoIdAndGroupId(
		long quangCaoId, long groupId) {

		return findBybyQuangCaoIdAndGroupId(
			quangCaoId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quang cao sliders where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @return the range of matching quang cao sliders
	 */
	@Override
	public List<QuangCaoSlider> findBybyQuangCaoIdAndGroupId(
		long quangCaoId, long groupId, int start, int end) {

		return findBybyQuangCaoIdAndGroupId(
			quangCaoId, groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quang cao sliders where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findBybyQuangCaoIdAndGroupId(long,long, int, int, OrderByComparator)}
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quang cao sliders
	 */
	@Deprecated
	@Override
	public List<QuangCaoSlider> findBybyQuangCaoIdAndGroupId(
		long quangCaoId, long groupId, int start, int end,
		OrderByComparator<QuangCaoSlider> orderByComparator,
		boolean useFinderCache) {

		return findBybyQuangCaoIdAndGroupId(
			quangCaoId, groupId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the quang cao sliders where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quang cao sliders
	 */
	@Override
	public List<QuangCaoSlider> findBybyQuangCaoIdAndGroupId(
		long quangCaoId, long groupId, int start, int end,
		OrderByComparator<QuangCaoSlider> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath =
				_finderPathWithoutPaginationFindBybyQuangCaoIdAndGroupId;
			finderArgs = new Object[] {quangCaoId, groupId};
		}
		else {
			finderPath = _finderPathWithPaginationFindBybyQuangCaoIdAndGroupId;
			finderArgs = new Object[] {
				quangCaoId, groupId, start, end, orderByComparator
			};
		}

		List<QuangCaoSlider> list = (List<QuangCaoSlider>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (QuangCaoSlider quangCaoSlider : list) {
				if ((quangCaoId != quangCaoSlider.getQuangCaoId()) ||
					(groupId != quangCaoSlider.getGroupId())) {

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

			query.append(_SQL_SELECT_QUANGCAOSLIDER_WHERE);

			query.append(_FINDER_COLUMN_BYQUANGCAOIDANDGROUPID_QUANGCAOID_2);

			query.append(_FINDER_COLUMN_BYQUANGCAOIDANDGROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(QuangCaoSliderModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(quangCaoId);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<QuangCaoSlider>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<QuangCaoSlider>)QueryUtil.list(
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
	 * Returns the first quang cao slider in the ordered set where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a matching quang cao slider could not be found
	 */
	@Override
	public QuangCaoSlider findBybyQuangCaoIdAndGroupId_First(
			long quangCaoId, long groupId,
			OrderByComparator<QuangCaoSlider> orderByComparator)
		throws NoSuchQuangCaoSliderException {

		QuangCaoSlider quangCaoSlider = fetchBybyQuangCaoIdAndGroupId_First(
			quangCaoId, groupId, orderByComparator);

		if (quangCaoSlider != null) {
			return quangCaoSlider;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("quangCaoId=");
		msg.append(quangCaoId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchQuangCaoSliderException(msg.toString());
	}

	/**
	 * Returns the first quang cao slider in the ordered set where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	@Override
	public QuangCaoSlider fetchBybyQuangCaoIdAndGroupId_First(
		long quangCaoId, long groupId,
		OrderByComparator<QuangCaoSlider> orderByComparator) {

		List<QuangCaoSlider> list = findBybyQuangCaoIdAndGroupId(
			quangCaoId, groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last quang cao slider in the ordered set where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a matching quang cao slider could not be found
	 */
	@Override
	public QuangCaoSlider findBybyQuangCaoIdAndGroupId_Last(
			long quangCaoId, long groupId,
			OrderByComparator<QuangCaoSlider> orderByComparator)
		throws NoSuchQuangCaoSliderException {

		QuangCaoSlider quangCaoSlider = fetchBybyQuangCaoIdAndGroupId_Last(
			quangCaoId, groupId, orderByComparator);

		if (quangCaoSlider != null) {
			return quangCaoSlider;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("quangCaoId=");
		msg.append(quangCaoId);

		msg.append(", groupId=");
		msg.append(groupId);

		msg.append("}");

		throw new NoSuchQuangCaoSliderException(msg.toString());
	}

	/**
	 * Returns the last quang cao slider in the ordered set where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	@Override
	public QuangCaoSlider fetchBybyQuangCaoIdAndGroupId_Last(
		long quangCaoId, long groupId,
		OrderByComparator<QuangCaoSlider> orderByComparator) {

		int count = countBybyQuangCaoIdAndGroupId(quangCaoId, groupId);

		if (count == 0) {
			return null;
		}

		List<QuangCaoSlider> list = findBybyQuangCaoIdAndGroupId(
			quangCaoId, groupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the quang cao sliders before and after the current quang cao slider in the ordered set where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoSliderId the primary key of the current quang cao slider
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a quang cao slider with the primary key could not be found
	 */
	@Override
	public QuangCaoSlider[] findBybyQuangCaoIdAndGroupId_PrevAndNext(
			long quangCaoSliderId, long quangCaoId, long groupId,
			OrderByComparator<QuangCaoSlider> orderByComparator)
		throws NoSuchQuangCaoSliderException {

		QuangCaoSlider quangCaoSlider = findByPrimaryKey(quangCaoSliderId);

		Session session = null;

		try {
			session = openSession();

			QuangCaoSlider[] array = new QuangCaoSliderImpl[3];

			array[0] = getBybyQuangCaoIdAndGroupId_PrevAndNext(
				session, quangCaoSlider, quangCaoId, groupId, orderByComparator,
				true);

			array[1] = quangCaoSlider;

			array[2] = getBybyQuangCaoIdAndGroupId_PrevAndNext(
				session, quangCaoSlider, quangCaoId, groupId, orderByComparator,
				false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected QuangCaoSlider getBybyQuangCaoIdAndGroupId_PrevAndNext(
		Session session, QuangCaoSlider quangCaoSlider, long quangCaoId,
		long groupId, OrderByComparator<QuangCaoSlider> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_QUANGCAOSLIDER_WHERE);

		query.append(_FINDER_COLUMN_BYQUANGCAOIDANDGROUPID_QUANGCAOID_2);

		query.append(_FINDER_COLUMN_BYQUANGCAOIDANDGROUPID_GROUPID_2);

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
			query.append(QuangCaoSliderModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(quangCaoId);

		qPos.add(groupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						quangCaoSlider)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<QuangCaoSlider> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the quang cao sliders where quangCaoId = &#63; and groupId = &#63; from the database.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 */
	@Override
	public void removeBybyQuangCaoIdAndGroupId(long quangCaoId, long groupId) {
		for (QuangCaoSlider quangCaoSlider :
				findBybyQuangCaoIdAndGroupId(
					quangCaoId, groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(quangCaoSlider);
		}
	}

	/**
	 * Returns the number of quang cao sliders where quangCaoId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @return the number of matching quang cao sliders
	 */
	@Override
	public int countBybyQuangCaoIdAndGroupId(long quangCaoId, long groupId) {
		FinderPath finderPath = _finderPathCountBybyQuangCaoIdAndGroupId;

		Object[] finderArgs = new Object[] {quangCaoId, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_QUANGCAOSLIDER_WHERE);

			query.append(_FINDER_COLUMN_BYQUANGCAOIDANDGROUPID_QUANGCAOID_2);

			query.append(_FINDER_COLUMN_BYQUANGCAOIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(quangCaoId);

				qPos.add(groupId);

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

	private static final String
		_FINDER_COLUMN_BYQUANGCAOIDANDGROUPID_QUANGCAOID_2 =
			"quangCaoSlider.quangCaoId = ? AND ";

	private static final String
		_FINDER_COLUMN_BYQUANGCAOIDANDGROUPID_GROUPID_2 =
			"quangCaoSlider.groupId = ?";

	private FinderPath _finderPathFetchBybyQuangCaoSliderIdAndGroupId;
	private FinderPath _finderPathCountBybyQuangCaoSliderIdAndGroupId;

	/**
	 * Returns the quang cao slider where quangCaoSliderId = &#63; and groupId = &#63; or throws a <code>NoSuchQuangCaoSliderException</code> if it could not be found.
	 *
	 * @param quangCaoSliderId the quang cao slider ID
	 * @param groupId the group ID
	 * @return the matching quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a matching quang cao slider could not be found
	 */
	@Override
	public QuangCaoSlider findBybyQuangCaoSliderIdAndGroupId(
			long quangCaoSliderId, long groupId)
		throws NoSuchQuangCaoSliderException {

		QuangCaoSlider quangCaoSlider = fetchBybyQuangCaoSliderIdAndGroupId(
			quangCaoSliderId, groupId);

		if (quangCaoSlider == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("quangCaoSliderId=");
			msg.append(quangCaoSliderId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchQuangCaoSliderException(msg.toString());
		}

		return quangCaoSlider;
	}

	/**
	 * Returns the quang cao slider where quangCaoSliderId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBybyQuangCaoSliderIdAndGroupId(long,long)}
	 * @param quangCaoSliderId the quang cao slider ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	@Deprecated
	@Override
	public QuangCaoSlider fetchBybyQuangCaoSliderIdAndGroupId(
		long quangCaoSliderId, long groupId, boolean useFinderCache) {

		return fetchBybyQuangCaoSliderIdAndGroupId(quangCaoSliderId, groupId);
	}

	/**
	 * Returns the quang cao slider where quangCaoSliderId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quangCaoSliderId the quang cao slider ID
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao slider, or <code>null</code> if a matching quang cao slider could not be found
	 */
	@Override
	public QuangCaoSlider fetchBybyQuangCaoSliderIdAndGroupId(
		long quangCaoSliderId, long groupId) {

		Object[] finderArgs = new Object[] {quangCaoSliderId, groupId};

		Object result = finderCache.getResult(
			_finderPathFetchBybyQuangCaoSliderIdAndGroupId, finderArgs, this);

		if (result instanceof QuangCaoSlider) {
			QuangCaoSlider quangCaoSlider = (QuangCaoSlider)result;

			if ((quangCaoSliderId != quangCaoSlider.getQuangCaoSliderId()) ||
				(groupId != quangCaoSlider.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_QUANGCAOSLIDER_WHERE);

			query.append(
				_FINDER_COLUMN_BYQUANGCAOSLIDERIDANDGROUPID_QUANGCAOSLIDERID_2);

			query.append(_FINDER_COLUMN_BYQUANGCAOSLIDERIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(quangCaoSliderId);

				qPos.add(groupId);

				List<QuangCaoSlider> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchBybyQuangCaoSliderIdAndGroupId,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"QuangCaoSliderPersistenceImpl.fetchBybyQuangCaoSliderIdAndGroupId(long, long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					QuangCaoSlider quangCaoSlider = list.get(0);

					result = quangCaoSlider;

					cacheResult(quangCaoSlider);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchBybyQuangCaoSliderIdAndGroupId, finderArgs);

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
			return (QuangCaoSlider)result;
		}
	}

	/**
	 * Removes the quang cao slider where quangCaoSliderId = &#63; and groupId = &#63; from the database.
	 *
	 * @param quangCaoSliderId the quang cao slider ID
	 * @param groupId the group ID
	 * @return the quang cao slider that was removed
	 */
	@Override
	public QuangCaoSlider removeBybyQuangCaoSliderIdAndGroupId(
			long quangCaoSliderId, long groupId)
		throws NoSuchQuangCaoSliderException {

		QuangCaoSlider quangCaoSlider = findBybyQuangCaoSliderIdAndGroupId(
			quangCaoSliderId, groupId);

		return remove(quangCaoSlider);
	}

	/**
	 * Returns the number of quang cao sliders where quangCaoSliderId = &#63; and groupId = &#63;.
	 *
	 * @param quangCaoSliderId the quang cao slider ID
	 * @param groupId the group ID
	 * @return the number of matching quang cao sliders
	 */
	@Override
	public int countBybyQuangCaoSliderIdAndGroupId(
		long quangCaoSliderId, long groupId) {

		FinderPath finderPath = _finderPathCountBybyQuangCaoSliderIdAndGroupId;

		Object[] finderArgs = new Object[] {quangCaoSliderId, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_QUANGCAOSLIDER_WHERE);

			query.append(
				_FINDER_COLUMN_BYQUANGCAOSLIDERIDANDGROUPID_QUANGCAOSLIDERID_2);

			query.append(_FINDER_COLUMN_BYQUANGCAOSLIDERIDANDGROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(quangCaoSliderId);

				qPos.add(groupId);

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

	private static final String
		_FINDER_COLUMN_BYQUANGCAOSLIDERIDANDGROUPID_QUANGCAOSLIDERID_2 =
			"quangCaoSlider.quangCaoSliderId = ? AND ";

	private static final String
		_FINDER_COLUMN_BYQUANGCAOSLIDERIDANDGROUPID_GROUPID_2 =
			"quangCaoSlider.groupId = ?";

	public QuangCaoSliderPersistenceImpl() {
		setModelClass(QuangCaoSlider.class);

		setModelImplClass(QuangCaoSliderImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the quang cao slider in the entity cache if it is enabled.
	 *
	 * @param quangCaoSlider the quang cao slider
	 */
	@Override
	public void cacheResult(QuangCaoSlider quangCaoSlider) {
		entityCache.putResult(
			entityCacheEnabled, QuangCaoSliderImpl.class,
			quangCaoSlider.getPrimaryKey(), quangCaoSlider);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				quangCaoSlider.getUuid(), quangCaoSlider.getGroupId()
			},
			quangCaoSlider);

		finderCache.putResult(
			_finderPathFetchBybyQuangCaoSliderIdAndGroupId,
			new Object[] {
				quangCaoSlider.getQuangCaoSliderId(),
				quangCaoSlider.getGroupId()
			},
			quangCaoSlider);

		quangCaoSlider.resetOriginalValues();
	}

	/**
	 * Caches the quang cao sliders in the entity cache if it is enabled.
	 *
	 * @param quangCaoSliders the quang cao sliders
	 */
	@Override
	public void cacheResult(List<QuangCaoSlider> quangCaoSliders) {
		for (QuangCaoSlider quangCaoSlider : quangCaoSliders) {
			if (entityCache.getResult(
					entityCacheEnabled, QuangCaoSliderImpl.class,
					quangCaoSlider.getPrimaryKey()) == null) {

				cacheResult(quangCaoSlider);
			}
			else {
				quangCaoSlider.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all quang cao sliders.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(QuangCaoSliderImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the quang cao slider.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuangCaoSlider quangCaoSlider) {
		entityCache.removeResult(
			entityCacheEnabled, QuangCaoSliderImpl.class,
			quangCaoSlider.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((QuangCaoSliderModelImpl)quangCaoSlider, true);
	}

	@Override
	public void clearCache(List<QuangCaoSlider> quangCaoSliders) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (QuangCaoSlider quangCaoSlider : quangCaoSliders) {
			entityCache.removeResult(
				entityCacheEnabled, QuangCaoSliderImpl.class,
				quangCaoSlider.getPrimaryKey());

			clearUniqueFindersCache(
				(QuangCaoSliderModelImpl)quangCaoSlider, true);
		}
	}

	protected void cacheUniqueFindersCache(
		QuangCaoSliderModelImpl quangCaoSliderModelImpl) {

		Object[] args = new Object[] {
			quangCaoSliderModelImpl.getUuid(),
			quangCaoSliderModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, quangCaoSliderModelImpl, false);

		args = new Object[] {
			quangCaoSliderModelImpl.getQuangCaoSliderId(),
			quangCaoSliderModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountBybyQuangCaoSliderIdAndGroupId, args,
			Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBybyQuangCaoSliderIdAndGroupId, args,
			quangCaoSliderModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		QuangCaoSliderModelImpl quangCaoSliderModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				quangCaoSliderModelImpl.getUuid(),
				quangCaoSliderModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((quangCaoSliderModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				quangCaoSliderModelImpl.getOriginalUuid(),
				quangCaoSliderModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				quangCaoSliderModelImpl.getQuangCaoSliderId(),
				quangCaoSliderModelImpl.getGroupId()
			};

			finderCache.removeResult(
				_finderPathCountBybyQuangCaoSliderIdAndGroupId, args);
			finderCache.removeResult(
				_finderPathFetchBybyQuangCaoSliderIdAndGroupId, args);
		}

		if ((quangCaoSliderModelImpl.getColumnBitmask() &
			 _finderPathFetchBybyQuangCaoSliderIdAndGroupId.
				 getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				quangCaoSliderModelImpl.getOriginalQuangCaoSliderId(),
				quangCaoSliderModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(
				_finderPathCountBybyQuangCaoSliderIdAndGroupId, args);
			finderCache.removeResult(
				_finderPathFetchBybyQuangCaoSliderIdAndGroupId, args);
		}
	}

	/**
	 * Creates a new quang cao slider with the primary key. Does not add the quang cao slider to the database.
	 *
	 * @param quangCaoSliderId the primary key for the new quang cao slider
	 * @return the new quang cao slider
	 */
	@Override
	public QuangCaoSlider create(long quangCaoSliderId) {
		QuangCaoSlider quangCaoSlider = new QuangCaoSliderImpl();

		quangCaoSlider.setNew(true);
		quangCaoSlider.setPrimaryKey(quangCaoSliderId);

		String uuid = PortalUUIDUtil.generate();

		quangCaoSlider.setUuid(uuid);

		return quangCaoSlider;
	}

	/**
	 * Removes the quang cao slider with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quangCaoSliderId the primary key of the quang cao slider
	 * @return the quang cao slider that was removed
	 * @throws NoSuchQuangCaoSliderException if a quang cao slider with the primary key could not be found
	 */
	@Override
	public QuangCaoSlider remove(long quangCaoSliderId)
		throws NoSuchQuangCaoSliderException {

		return remove((Serializable)quangCaoSliderId);
	}

	/**
	 * Removes the quang cao slider with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the quang cao slider
	 * @return the quang cao slider that was removed
	 * @throws NoSuchQuangCaoSliderException if a quang cao slider with the primary key could not be found
	 */
	@Override
	public QuangCaoSlider remove(Serializable primaryKey)
		throws NoSuchQuangCaoSliderException {

		Session session = null;

		try {
			session = openSession();

			QuangCaoSlider quangCaoSlider = (QuangCaoSlider)session.get(
				QuangCaoSliderImpl.class, primaryKey);

			if (quangCaoSlider == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuangCaoSliderException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(quangCaoSlider);
		}
		catch (NoSuchQuangCaoSliderException nsee) {
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
	protected QuangCaoSlider removeImpl(QuangCaoSlider quangCaoSlider) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(quangCaoSlider)) {
				quangCaoSlider = (QuangCaoSlider)session.get(
					QuangCaoSliderImpl.class,
					quangCaoSlider.getPrimaryKeyObj());
			}

			if (quangCaoSlider != null) {
				session.delete(quangCaoSlider);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (quangCaoSlider != null) {
			clearCache(quangCaoSlider);
		}

		return quangCaoSlider;
	}

	@Override
	public QuangCaoSlider updateImpl(QuangCaoSlider quangCaoSlider) {
		boolean isNew = quangCaoSlider.isNew();

		if (!(quangCaoSlider instanceof QuangCaoSliderModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(quangCaoSlider.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					quangCaoSlider);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in quangCaoSlider proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom QuangCaoSlider implementation " +
					quangCaoSlider.getClass());
		}

		QuangCaoSliderModelImpl quangCaoSliderModelImpl =
			(QuangCaoSliderModelImpl)quangCaoSlider;

		if (Validator.isNull(quangCaoSlider.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			quangCaoSlider.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (quangCaoSlider.getCreateDate() == null)) {
			if (serviceContext == null) {
				quangCaoSlider.setCreateDate(now);
			}
			else {
				quangCaoSlider.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!quangCaoSliderModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				quangCaoSlider.setModifiedDate(now);
			}
			else {
				quangCaoSlider.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (quangCaoSlider.isNew()) {
				session.save(quangCaoSlider);

				quangCaoSlider.setNew(false);
			}
			else {
				quangCaoSlider = (QuangCaoSlider)session.merge(quangCaoSlider);
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
			Object[] args = new Object[] {quangCaoSliderModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				quangCaoSliderModelImpl.getQuangCaoId(),
				quangCaoSliderModelImpl.getGroupId()
			};

			finderCache.removeResult(
				_finderPathCountBybyQuangCaoIdAndGroupId, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindBybyQuangCaoIdAndGroupId, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((quangCaoSliderModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					quangCaoSliderModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {quangCaoSliderModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((quangCaoSliderModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindBybyQuangCaoIdAndGroupId.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					quangCaoSliderModelImpl.getOriginalQuangCaoId(),
					quangCaoSliderModelImpl.getOriginalGroupId()
				};

				finderCache.removeResult(
					_finderPathCountBybyQuangCaoIdAndGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBybyQuangCaoIdAndGroupId,
					args);

				args = new Object[] {
					quangCaoSliderModelImpl.getQuangCaoId(),
					quangCaoSliderModelImpl.getGroupId()
				};

				finderCache.removeResult(
					_finderPathCountBybyQuangCaoIdAndGroupId, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindBybyQuangCaoIdAndGroupId,
					args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, QuangCaoSliderImpl.class,
			quangCaoSlider.getPrimaryKey(), quangCaoSlider, false);

		clearUniqueFindersCache(quangCaoSliderModelImpl, false);
		cacheUniqueFindersCache(quangCaoSliderModelImpl);

		quangCaoSlider.resetOriginalValues();

		return quangCaoSlider;
	}

	/**
	 * Returns the quang cao slider with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the quang cao slider
	 * @return the quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a quang cao slider with the primary key could not be found
	 */
	@Override
	public QuangCaoSlider findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuangCaoSliderException {

		QuangCaoSlider quangCaoSlider = fetchByPrimaryKey(primaryKey);

		if (quangCaoSlider == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuangCaoSliderException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return quangCaoSlider;
	}

	/**
	 * Returns the quang cao slider with the primary key or throws a <code>NoSuchQuangCaoSliderException</code> if it could not be found.
	 *
	 * @param quangCaoSliderId the primary key of the quang cao slider
	 * @return the quang cao slider
	 * @throws NoSuchQuangCaoSliderException if a quang cao slider with the primary key could not be found
	 */
	@Override
	public QuangCaoSlider findByPrimaryKey(long quangCaoSliderId)
		throws NoSuchQuangCaoSliderException {

		return findByPrimaryKey((Serializable)quangCaoSliderId);
	}

	/**
	 * Returns the quang cao slider with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quangCaoSliderId the primary key of the quang cao slider
	 * @return the quang cao slider, or <code>null</code> if a quang cao slider with the primary key could not be found
	 */
	@Override
	public QuangCaoSlider fetchByPrimaryKey(long quangCaoSliderId) {
		return fetchByPrimaryKey((Serializable)quangCaoSliderId);
	}

	/**
	 * Returns all the quang cao sliders.
	 *
	 * @return the quang cao sliders
	 */
	@Override
	public List<QuangCaoSlider> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quang cao sliders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @return the range of quang cao sliders
	 */
	@Override
	public List<QuangCaoSlider> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the quang cao sliders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quang cao sliders
	 */
	@Deprecated
	@Override
	public List<QuangCaoSlider> findAll(
		int start, int end, OrderByComparator<QuangCaoSlider> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the quang cao sliders.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>QuangCaoSliderModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of quang cao sliders
	 * @param end the upper bound of the range of quang cao sliders (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quang cao sliders
	 */
	@Override
	public List<QuangCaoSlider> findAll(
		int start, int end,
		OrderByComparator<QuangCaoSlider> orderByComparator) {

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

		List<QuangCaoSlider> list = (List<QuangCaoSlider>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_QUANGCAOSLIDER);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_QUANGCAOSLIDER;

				if (pagination) {
					sql = sql.concat(QuangCaoSliderModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<QuangCaoSlider>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<QuangCaoSlider>)QueryUtil.list(
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
	 * Removes all the quang cao sliders from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QuangCaoSlider quangCaoSlider : findAll()) {
			remove(quangCaoSlider);
		}
	}

	/**
	 * Returns the number of quang cao sliders.
	 *
	 * @return the number of quang cao sliders
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_QUANGCAOSLIDER);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "quangCaoSliderId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_QUANGCAOSLIDER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QuangCaoSliderModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the quang cao slider persistence.
	 */
	@Activate
	public void activate() {
		QuangCaoSliderModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		QuangCaoSliderModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, QuangCaoSliderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, QuangCaoSliderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, QuangCaoSliderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, QuangCaoSliderImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			QuangCaoSliderModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, QuangCaoSliderImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			QuangCaoSliderModelImpl.UUID_COLUMN_BITMASK |
			QuangCaoSliderModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindBybyQuangCaoIdAndGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, QuangCaoSliderImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findBybyQuangCaoIdAndGroupId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindBybyQuangCaoIdAndGroupId =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled,
				QuangCaoSliderImpl.class,
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findBybyQuangCaoIdAndGroupId",
				new String[] {Long.class.getName(), Long.class.getName()},
				QuangCaoSliderModelImpl.QUANGCAOID_COLUMN_BITMASK |
				QuangCaoSliderModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountBybyQuangCaoIdAndGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybyQuangCaoIdAndGroupId",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathFetchBybyQuangCaoSliderIdAndGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, QuangCaoSliderImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBybyQuangCaoSliderIdAndGroupId",
			new String[] {Long.class.getName(), Long.class.getName()},
			QuangCaoSliderModelImpl.QUANGCAOSLIDERID_COLUMN_BITMASK |
			QuangCaoSliderModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountBybyQuangCaoSliderIdAndGroupId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybyQuangCaoSliderIdAndGroupId",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(QuangCaoSliderImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = soft_advPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.web.ecoit.portal.quangcao.model.QuangCaoSlider"),
			true);
	}

	@Override
	@Reference(
		target = soft_advPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = soft_advPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_QUANGCAOSLIDER =
		"SELECT quangCaoSlider FROM QuangCaoSlider quangCaoSlider";

	private static final String _SQL_SELECT_QUANGCAOSLIDER_WHERE =
		"SELECT quangCaoSlider FROM QuangCaoSlider quangCaoSlider WHERE ";

	private static final String _SQL_COUNT_QUANGCAOSLIDER =
		"SELECT COUNT(quangCaoSlider) FROM QuangCaoSlider quangCaoSlider";

	private static final String _SQL_COUNT_QUANGCAOSLIDER_WHERE =
		"SELECT COUNT(quangCaoSlider) FROM QuangCaoSlider quangCaoSlider WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "quangCaoSlider.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No QuangCaoSlider exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No QuangCaoSlider exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		QuangCaoSliderPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type"});

	static {
		try {
			Class.forName(soft_advPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}