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

package User.Rank.Poisition.Service.service.persistence.impl;

import User.Rank.Poisition.Service.exception.NoSuchUserChucDanhException;
import User.Rank.Poisition.Service.model.UserChucDanh;
import User.Rank.Poisition.Service.model.impl.UserChucDanhImpl;
import User.Rank.Poisition.Service.model.impl.UserChucDanhModelImpl;
import User.Rank.Poisition.Service.service.persistence.UserChucDanhPersistence;
import User.Rank.Poisition.Service.service.persistence.impl.constants.portal_userPersistenceConstants;

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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

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
 * The persistence implementation for the user chuc danh service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UserChucDanhPersistence.class)
@ProviderType
public class UserChucDanhPersistenceImpl
	extends BasePersistenceImpl<UserChucDanh>
	implements UserChucDanhPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserChucDanhUtil</code> to access the user chuc danh persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserChucDanhImpl.class.getName();

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
	 * Returns all the user chuc danhs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user chuc danhs
	 */
	@Override
	public List<UserChucDanh> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user chuc danhs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @return the range of matching user chuc danhs
	 */
	@Override
	public List<UserChucDanh> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user chuc danhs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user chuc danhs
	 */
	@Deprecated
	@Override
	public List<UserChucDanh> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserChucDanh> orderByComparator,
		boolean useFinderCache) {

		return findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user chuc danhs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user chuc danhs
	 */
	@Override
	public List<UserChucDanh> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserChucDanh> orderByComparator) {

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

		List<UserChucDanh> list = (List<UserChucDanh>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserChucDanh userChucDanh : list) {
				if (!uuid.equals(userChucDanh.getUuid())) {
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

			query.append(_SQL_SELECT_USERCHUCDANH_WHERE);

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
				query.append(UserChucDanhModelImpl.ORDER_BY_JPQL);
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
					list = (List<UserChucDanh>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserChucDanh>)QueryUtil.list(
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
	 * Returns the first user chuc danh in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	@Override
	public UserChucDanh findByUuid_First(
			String uuid, OrderByComparator<UserChucDanh> orderByComparator)
		throws NoSuchUserChucDanhException {

		UserChucDanh userChucDanh = fetchByUuid_First(uuid, orderByComparator);

		if (userChucDanh != null) {
			return userChucDanh;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchUserChucDanhException(msg.toString());
	}

	/**
	 * Returns the first user chuc danh in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	@Override
	public UserChucDanh fetchByUuid_First(
		String uuid, OrderByComparator<UserChucDanh> orderByComparator) {

		List<UserChucDanh> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user chuc danh in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	@Override
	public UserChucDanh findByUuid_Last(
			String uuid, OrderByComparator<UserChucDanh> orderByComparator)
		throws NoSuchUserChucDanhException {

		UserChucDanh userChucDanh = fetchByUuid_Last(uuid, orderByComparator);

		if (userChucDanh != null) {
			return userChucDanh;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchUserChucDanhException(msg.toString());
	}

	/**
	 * Returns the last user chuc danh in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	@Override
	public UserChucDanh fetchByUuid_Last(
		String uuid, OrderByComparator<UserChucDanh> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserChucDanh> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user chuc danhs before and after the current user chuc danh in the ordered set where uuid = &#63;.
	 *
	 * @param userChucDanhId the primary key of the current user chuc danh
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user chuc danh
	 * @throws NoSuchUserChucDanhException if a user chuc danh with the primary key could not be found
	 */
	@Override
	public UserChucDanh[] findByUuid_PrevAndNext(
			long userChucDanhId, String uuid,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws NoSuchUserChucDanhException {

		uuid = Objects.toString(uuid, "");

		UserChucDanh userChucDanh = findByPrimaryKey(userChucDanhId);

		Session session = null;

		try {
			session = openSession();

			UserChucDanh[] array = new UserChucDanhImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, userChucDanh, uuid, orderByComparator, true);

			array[1] = userChucDanh;

			array[2] = getByUuid_PrevAndNext(
				session, userChucDanh, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserChucDanh getByUuid_PrevAndNext(
		Session session, UserChucDanh userChucDanh, String uuid,
		OrderByComparator<UserChucDanh> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERCHUCDANH_WHERE);

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
			query.append(UserChucDanhModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(userChucDanh)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<UserChucDanh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user chuc danhs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserChucDanh userChucDanh :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userChucDanh);
		}
	}

	/**
	 * Returns the number of user chuc danhs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user chuc danhs
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERCHUCDANH_WHERE);

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
		"userChucDanh.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(userChucDanh.uuid IS NULL OR userChucDanh.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the user chuc danh where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUserChucDanhException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	@Override
	public UserChucDanh findByUUID_G(String uuid, long groupId)
		throws NoSuchUserChucDanhException {

		UserChucDanh userChucDanh = fetchByUUID_G(uuid, groupId);

		if (userChucDanh == null) {
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

			throw new NoSuchUserChucDanhException(msg.toString());
		}

		return userChucDanh;
	}

	/**
	 * Returns the user chuc danh where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	@Deprecated
	@Override
	public UserChucDanh fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the user chuc danh where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	@Override
	public UserChucDanh fetchByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] {uuid, groupId};

		Object result = finderCache.getResult(
			_finderPathFetchByUUID_G, finderArgs, this);

		if (result instanceof UserChucDanh) {
			UserChucDanh userChucDanh = (UserChucDanh)result;

			if (!Objects.equals(uuid, userChucDanh.getUuid()) ||
				(groupId != userChucDanh.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_USERCHUCDANH_WHERE);

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

				List<UserChucDanh> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByUUID_G, finderArgs, list);
				}
				else {
					UserChucDanh userChucDanh = list.get(0);

					result = userChucDanh;

					cacheResult(userChucDanh);
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
			return (UserChucDanh)result;
		}
	}

	/**
	 * Removes the user chuc danh where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user chuc danh that was removed
	 */
	@Override
	public UserChucDanh removeByUUID_G(String uuid, long groupId)
		throws NoSuchUserChucDanhException {

		UserChucDanh userChucDanh = findByUUID_G(uuid, groupId);

		return remove(userChucDanh);
	}

	/**
	 * Returns the number of user chuc danhs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user chuc danhs
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERCHUCDANH_WHERE);

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
		"userChucDanh.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(userChucDanh.uuid IS NULL OR userChucDanh.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"userChucDanh.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the user chuc danhs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user chuc danhs
	 */
	@Override
	public List<UserChucDanh> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user chuc danhs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @return the range of matching user chuc danhs
	 */
	@Override
	public List<UserChucDanh> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user chuc danhs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user chuc danhs
	 */
	@Deprecated
	@Override
	public List<UserChucDanh> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserChucDanh> orderByComparator,
		boolean useFinderCache) {

		return findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user chuc danhs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user chuc danhs
	 */
	@Override
	public List<UserChucDanh> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserChucDanh> orderByComparator) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid_C;
			finderArgs = new Object[] {uuid, companyId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<UserChucDanh> list = (List<UserChucDanh>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserChucDanh userChucDanh : list) {
				if (!uuid.equals(userChucDanh.getUuid()) ||
					(companyId != userChucDanh.getCompanyId())) {

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

			query.append(_SQL_SELECT_USERCHUCDANH_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(UserChucDanhModelImpl.ORDER_BY_JPQL);
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

				qPos.add(companyId);

				if (!pagination) {
					list = (List<UserChucDanh>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserChucDanh>)QueryUtil.list(
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
	 * Returns the first user chuc danh in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	@Override
	public UserChucDanh findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws NoSuchUserChucDanhException {

		UserChucDanh userChucDanh = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (userChucDanh != null) {
			return userChucDanh;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchUserChucDanhException(msg.toString());
	}

	/**
	 * Returns the first user chuc danh in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	@Override
	public UserChucDanh fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UserChucDanh> orderByComparator) {

		List<UserChucDanh> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user chuc danh in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	@Override
	public UserChucDanh findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws NoSuchUserChucDanhException {

		UserChucDanh userChucDanh = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (userChucDanh != null) {
			return userChucDanh;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchUserChucDanhException(msg.toString());
	}

	/**
	 * Returns the last user chuc danh in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	@Override
	public UserChucDanh fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UserChucDanh> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<UserChucDanh> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user chuc danhs before and after the current user chuc danh in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param userChucDanhId the primary key of the current user chuc danh
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user chuc danh
	 * @throws NoSuchUserChucDanhException if a user chuc danh with the primary key could not be found
	 */
	@Override
	public UserChucDanh[] findByUuid_C_PrevAndNext(
			long userChucDanhId, String uuid, long companyId,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws NoSuchUserChucDanhException {

		uuid = Objects.toString(uuid, "");

		UserChucDanh userChucDanh = findByPrimaryKey(userChucDanhId);

		Session session = null;

		try {
			session = openSession();

			UserChucDanh[] array = new UserChucDanhImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, userChucDanh, uuid, companyId, orderByComparator,
				true);

			array[1] = userChucDanh;

			array[2] = getByUuid_C_PrevAndNext(
				session, userChucDanh, uuid, companyId, orderByComparator,
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

	protected UserChucDanh getByUuid_C_PrevAndNext(
		Session session, UserChucDanh userChucDanh, String uuid, long companyId,
		OrderByComparator<UserChucDanh> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_USERCHUCDANH_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(UserChucDanhModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userChucDanh)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<UserChucDanh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user chuc danhs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (UserChucDanh userChucDanh :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(userChucDanh);
		}
	}

	/**
	 * Returns the number of user chuc danhs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user chuc danhs
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERCHUCDANH_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

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

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"userChucDanh.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(userChucDanh.uuid IS NULL OR userChucDanh.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"userChucDanh.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByFindAll;
	private FinderPath _finderPathWithoutPaginationFindByFindAll;
	private FinderPath _finderPathCountByFindAll;

	/**
	 * Returns all the user chuc danhs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching user chuc danhs
	 */
	@Override
	public List<UserChucDanh> findByFindAll(long groupId, long companyId) {
		return findByFindAll(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user chuc danhs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @return the range of matching user chuc danhs
	 */
	@Override
	public List<UserChucDanh> findByFindAll(
		long groupId, long companyId, int start, int end) {

		return findByFindAll(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user chuc danhs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByFindAll(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user chuc danhs
	 */
	@Deprecated
	@Override
	public List<UserChucDanh> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<UserChucDanh> orderByComparator,
		boolean useFinderCache) {

		return findByFindAll(groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user chuc danhs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user chuc danhs
	 */
	@Override
	public List<UserChucDanh> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<UserChucDanh> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByFindAll;
			finderArgs = new Object[] {groupId, companyId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByFindAll;
			finderArgs = new Object[] {
				groupId, companyId, start, end, orderByComparator
			};
		}

		List<UserChucDanh> list = (List<UserChucDanh>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserChucDanh userChucDanh : list) {
				if ((groupId != userChucDanh.getGroupId()) ||
					(companyId != userChucDanh.getCompanyId())) {

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

			query.append(_SQL_SELECT_USERCHUCDANH_WHERE);

			query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(UserChucDanhModelImpl.ORDER_BY_JPQL);
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
					list = (List<UserChucDanh>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserChucDanh>)QueryUtil.list(
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
	 * Returns the first user chuc danh in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	@Override
	public UserChucDanh findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws NoSuchUserChucDanhException {

		UserChucDanh userChucDanh = fetchByFindAll_First(
			groupId, companyId, orderByComparator);

		if (userChucDanh != null) {
			return userChucDanh;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchUserChucDanhException(msg.toString());
	}

	/**
	 * Returns the first user chuc danh in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	@Override
	public UserChucDanh fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<UserChucDanh> orderByComparator) {

		List<UserChucDanh> list = findByFindAll(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user chuc danh in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user chuc danh
	 * @throws NoSuchUserChucDanhException if a matching user chuc danh could not be found
	 */
	@Override
	public UserChucDanh findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws NoSuchUserChucDanhException {

		UserChucDanh userChucDanh = fetchByFindAll_Last(
			groupId, companyId, orderByComparator);

		if (userChucDanh != null) {
			return userChucDanh;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchUserChucDanhException(msg.toString());
	}

	/**
	 * Returns the last user chuc danh in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user chuc danh, or <code>null</code> if a matching user chuc danh could not be found
	 */
	@Override
	public UserChucDanh fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<UserChucDanh> orderByComparator) {

		int count = countByFindAll(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<UserChucDanh> list = findByFindAll(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user chuc danhs before and after the current user chuc danh in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param userChucDanhId the primary key of the current user chuc danh
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user chuc danh
	 * @throws NoSuchUserChucDanhException if a user chuc danh with the primary key could not be found
	 */
	@Override
	public UserChucDanh[] findByFindAll_PrevAndNext(
			long userChucDanhId, long groupId, long companyId,
			OrderByComparator<UserChucDanh> orderByComparator)
		throws NoSuchUserChucDanhException {

		UserChucDanh userChucDanh = findByPrimaryKey(userChucDanhId);

		Session session = null;

		try {
			session = openSession();

			UserChucDanh[] array = new UserChucDanhImpl[3];

			array[0] = getByFindAll_PrevAndNext(
				session, userChucDanh, groupId, companyId, orderByComparator,
				true);

			array[1] = userChucDanh;

			array[2] = getByFindAll_PrevAndNext(
				session, userChucDanh, groupId, companyId, orderByComparator,
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

	protected UserChucDanh getByFindAll_PrevAndNext(
		Session session, UserChucDanh userChucDanh, long groupId,
		long companyId, OrderByComparator<UserChucDanh> orderByComparator,
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

		query.append(_SQL_SELECT_USERCHUCDANH_WHERE);

		query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

		query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

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
			query.append(UserChucDanhModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(userChucDanh)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<UserChucDanh> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user chuc danhs where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByFindAll(long groupId, long companyId) {
		for (UserChucDanh userChucDanh :
				findByFindAll(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(userChucDanh);
		}
	}

	/**
	 * Returns the number of user chuc danhs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching user chuc danhs
	 */
	@Override
	public int countByFindAll(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByFindAll;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERCHUCDANH_WHERE);

			query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

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

	private static final String _FINDER_COLUMN_FINDALL_GROUPID_2 =
		"userChucDanh.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDALL_COMPANYID_2 =
		"userChucDanh.companyId = ?";

	public UserChucDanhPersistenceImpl() {
		setModelClass(UserChucDanh.class);

		setModelImplClass(UserChucDanhImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the user chuc danh in the entity cache if it is enabled.
	 *
	 * @param userChucDanh the user chuc danh
	 */
	@Override
	public void cacheResult(UserChucDanh userChucDanh) {
		entityCache.putResult(
			entityCacheEnabled, UserChucDanhImpl.class,
			userChucDanh.getPrimaryKey(), userChucDanh);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {userChucDanh.getUuid(), userChucDanh.getGroupId()},
			userChucDanh);

		userChucDanh.resetOriginalValues();
	}

	/**
	 * Caches the user chuc danhs in the entity cache if it is enabled.
	 *
	 * @param userChucDanhs the user chuc danhs
	 */
	@Override
	public void cacheResult(List<UserChucDanh> userChucDanhs) {
		for (UserChucDanh userChucDanh : userChucDanhs) {
			if (entityCache.getResult(
					entityCacheEnabled, UserChucDanhImpl.class,
					userChucDanh.getPrimaryKey()) == null) {

				cacheResult(userChucDanh);
			}
			else {
				userChucDanh.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user chuc danhs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserChucDanhImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user chuc danh.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserChucDanh userChucDanh) {
		entityCache.removeResult(
			entityCacheEnabled, UserChucDanhImpl.class,
			userChucDanh.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((UserChucDanhModelImpl)userChucDanh, true);
	}

	@Override
	public void clearCache(List<UserChucDanh> userChucDanhs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserChucDanh userChucDanh : userChucDanhs) {
			entityCache.removeResult(
				entityCacheEnabled, UserChucDanhImpl.class,
				userChucDanh.getPrimaryKey());

			clearUniqueFindersCache((UserChucDanhModelImpl)userChucDanh, true);
		}
	}

	protected void cacheUniqueFindersCache(
		UserChucDanhModelImpl userChucDanhModelImpl) {

		Object[] args = new Object[] {
			userChucDanhModelImpl.getUuid(), userChucDanhModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, userChucDanhModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		UserChucDanhModelImpl userChucDanhModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				userChucDanhModelImpl.getUuid(),
				userChucDanhModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((userChucDanhModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				userChucDanhModelImpl.getOriginalUuid(),
				userChucDanhModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new user chuc danh with the primary key. Does not add the user chuc danh to the database.
	 *
	 * @param userChucDanhId the primary key for the new user chuc danh
	 * @return the new user chuc danh
	 */
	@Override
	public UserChucDanh create(long userChucDanhId) {
		UserChucDanh userChucDanh = new UserChucDanhImpl();

		userChucDanh.setNew(true);
		userChucDanh.setPrimaryKey(userChucDanhId);

		String uuid = PortalUUIDUtil.generate();

		userChucDanh.setUuid(uuid);

		userChucDanh.setCompanyId(CompanyThreadLocal.getCompanyId());

		return userChucDanh;
	}

	/**
	 * Removes the user chuc danh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userChucDanhId the primary key of the user chuc danh
	 * @return the user chuc danh that was removed
	 * @throws NoSuchUserChucDanhException if a user chuc danh with the primary key could not be found
	 */
	@Override
	public UserChucDanh remove(long userChucDanhId)
		throws NoSuchUserChucDanhException {

		return remove((Serializable)userChucDanhId);
	}

	/**
	 * Removes the user chuc danh with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user chuc danh
	 * @return the user chuc danh that was removed
	 * @throws NoSuchUserChucDanhException if a user chuc danh with the primary key could not be found
	 */
	@Override
	public UserChucDanh remove(Serializable primaryKey)
		throws NoSuchUserChucDanhException {

		Session session = null;

		try {
			session = openSession();

			UserChucDanh userChucDanh = (UserChucDanh)session.get(
				UserChucDanhImpl.class, primaryKey);

			if (userChucDanh == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserChucDanhException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userChucDanh);
		}
		catch (NoSuchUserChucDanhException nsee) {
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
	protected UserChucDanh removeImpl(UserChucDanh userChucDanh) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userChucDanh)) {
				userChucDanh = (UserChucDanh)session.get(
					UserChucDanhImpl.class, userChucDanh.getPrimaryKeyObj());
			}

			if (userChucDanh != null) {
				session.delete(userChucDanh);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userChucDanh != null) {
			clearCache(userChucDanh);
		}

		return userChucDanh;
	}

	@Override
	public UserChucDanh updateImpl(UserChucDanh userChucDanh) {
		boolean isNew = userChucDanh.isNew();

		if (!(userChucDanh instanceof UserChucDanhModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userChucDanh.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					userChucDanh);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userChucDanh proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserChucDanh implementation " +
					userChucDanh.getClass());
		}

		UserChucDanhModelImpl userChucDanhModelImpl =
			(UserChucDanhModelImpl)userChucDanh;

		if (Validator.isNull(userChucDanh.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			userChucDanh.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (userChucDanh.getCreateDate() == null)) {
			if (serviceContext == null) {
				userChucDanh.setCreateDate(now);
			}
			else {
				userChucDanh.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!userChucDanhModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userChucDanh.setModifiedDate(now);
			}
			else {
				userChucDanh.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (userChucDanh.isNew()) {
				session.save(userChucDanh);

				userChucDanh.setNew(false);
			}
			else {
				userChucDanh = (UserChucDanh)session.merge(userChucDanh);
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
			Object[] args = new Object[] {userChucDanhModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				userChucDanhModelImpl.getUuid(),
				userChucDanhModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {
				userChucDanhModelImpl.getGroupId(),
				userChucDanhModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByFindAll, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindAll, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((userChucDanhModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					userChucDanhModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {userChucDanhModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((userChucDanhModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					userChucDanhModelImpl.getOriginalUuid(),
					userChucDanhModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					userChucDanhModelImpl.getUuid(),
					userChucDanhModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((userChucDanhModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindAll.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					userChucDanhModelImpl.getOriginalGroupId(),
					userChucDanhModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);

				args = new Object[] {
					userChucDanhModelImpl.getGroupId(),
					userChucDanhModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, UserChucDanhImpl.class,
			userChucDanh.getPrimaryKey(), userChucDanh, false);

		clearUniqueFindersCache(userChucDanhModelImpl, false);
		cacheUniqueFindersCache(userChucDanhModelImpl);

		userChucDanh.resetOriginalValues();

		return userChucDanh;
	}

	/**
	 * Returns the user chuc danh with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user chuc danh
	 * @return the user chuc danh
	 * @throws NoSuchUserChucDanhException if a user chuc danh with the primary key could not be found
	 */
	@Override
	public UserChucDanh findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserChucDanhException {

		UserChucDanh userChucDanh = fetchByPrimaryKey(primaryKey);

		if (userChucDanh == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserChucDanhException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userChucDanh;
	}

	/**
	 * Returns the user chuc danh with the primary key or throws a <code>NoSuchUserChucDanhException</code> if it could not be found.
	 *
	 * @param userChucDanhId the primary key of the user chuc danh
	 * @return the user chuc danh
	 * @throws NoSuchUserChucDanhException if a user chuc danh with the primary key could not be found
	 */
	@Override
	public UserChucDanh findByPrimaryKey(long userChucDanhId)
		throws NoSuchUserChucDanhException {

		return findByPrimaryKey((Serializable)userChucDanhId);
	}

	/**
	 * Returns the user chuc danh with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userChucDanhId the primary key of the user chuc danh
	 * @return the user chuc danh, or <code>null</code> if a user chuc danh with the primary key could not be found
	 */
	@Override
	public UserChucDanh fetchByPrimaryKey(long userChucDanhId) {
		return fetchByPrimaryKey((Serializable)userChucDanhId);
	}

	/**
	 * Returns all the user chuc danhs.
	 *
	 * @return the user chuc danhs
	 */
	@Override
	public List<UserChucDanh> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user chuc danhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @return the range of user chuc danhs
	 */
	@Override
	public List<UserChucDanh> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user chuc danhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user chuc danhs
	 */
	@Deprecated
	@Override
	public List<UserChucDanh> findAll(
		int start, int end, OrderByComparator<UserChucDanh> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user chuc danhs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserChucDanhModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user chuc danhs
	 * @param end the upper bound of the range of user chuc danhs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user chuc danhs
	 */
	@Override
	public List<UserChucDanh> findAll(
		int start, int end, OrderByComparator<UserChucDanh> orderByComparator) {

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

		List<UserChucDanh> list = (List<UserChucDanh>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERCHUCDANH);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERCHUCDANH;

				if (pagination) {
					sql = sql.concat(UserChucDanhModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserChucDanh>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserChucDanh>)QueryUtil.list(
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
	 * Removes all the user chuc danhs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserChucDanh userChucDanh : findAll()) {
			remove(userChucDanh);
		}
	}

	/**
	 * Returns the number of user chuc danhs.
	 *
	 * @return the number of user chuc danhs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERCHUCDANH);

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
		return "userChucDanhId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERCHUCDANH;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserChucDanhModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user chuc danh persistence.
	 */
	@Activate
	public void activate() {
		UserChucDanhModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		UserChucDanhModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserChucDanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserChucDanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserChucDanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserChucDanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			UserChucDanhModelImpl.UUID_COLUMN_BITMASK |
			UserChucDanhModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserChucDanhImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			UserChucDanhModelImpl.UUID_COLUMN_BITMASK |
			UserChucDanhModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserChucDanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserChucDanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			UserChucDanhModelImpl.UUID_COLUMN_BITMASK |
			UserChucDanhModelImpl.COMPANYID_COLUMN_BITMASK |
			UserChucDanhModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserChucDanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindAll",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserChucDanhImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindAll",
			new String[] {Long.class.getName(), Long.class.getName()},
			UserChucDanhModelImpl.GROUPID_COLUMN_BITMASK |
			UserChucDanhModelImpl.COMPANYID_COLUMN_BITMASK |
			UserChucDanhModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindAll",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(UserChucDanhImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = portal_userPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.User.Rank.Poisition.Service.model.UserChucDanh"),
			true);
	}

	@Override
	@Reference(
		target = portal_userPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = portal_userPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_USERCHUCDANH =
		"SELECT userChucDanh FROM UserChucDanh userChucDanh";

	private static final String _SQL_SELECT_USERCHUCDANH_WHERE =
		"SELECT userChucDanh FROM UserChucDanh userChucDanh WHERE ";

	private static final String _SQL_COUNT_USERCHUCDANH =
		"SELECT COUNT(userChucDanh) FROM UserChucDanh userChucDanh";

	private static final String _SQL_COUNT_USERCHUCDANH_WHERE =
		"SELECT COUNT(userChucDanh) FROM UserChucDanh userChucDanh WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userChucDanh.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserChucDanh exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserChucDanh exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserChucDanhPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(portal_userPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}