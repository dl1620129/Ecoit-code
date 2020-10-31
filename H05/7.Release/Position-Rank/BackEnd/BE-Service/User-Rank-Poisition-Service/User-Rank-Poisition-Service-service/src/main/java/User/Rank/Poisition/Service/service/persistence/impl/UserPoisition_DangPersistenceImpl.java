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

import User.Rank.Poisition.Service.exception.NoSuchUserPoisition_DangException;
import User.Rank.Poisition.Service.model.UserPoisition_Dang;
import User.Rank.Poisition.Service.model.impl.UserPoisition_DangImpl;
import User.Rank.Poisition.Service.model.impl.UserPoisition_DangModelImpl;
import User.Rank.Poisition.Service.service.persistence.UserPoisition_DangPersistence;
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
 * The persistence implementation for the user poisition_ dang service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UserPoisition_DangPersistence.class)
@ProviderType
public class UserPoisition_DangPersistenceImpl
	extends BasePersistenceImpl<UserPoisition_Dang>
	implements UserPoisition_DangPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserPoisition_DangUtil</code> to access the user poisition_ dang persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserPoisition_DangImpl.class.getName();

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
	 * Returns all the user poisition_ dangs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching user poisition_ dangs
	 */
	@Override
	public List<UserPoisition_Dang> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user poisition_ dangs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @return the range of matching user poisition_ dangs
	 */
	@Override
	public List<UserPoisition_Dang> findByUuid(
		String uuid, int start, int end) {

		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user poisition_ dangs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user poisition_ dangs
	 */
	@Deprecated
	@Override
	public List<UserPoisition_Dang> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserPoisition_Dang> orderByComparator,
		boolean useFinderCache) {

		return findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user poisition_ dangs where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user poisition_ dangs
	 */
	@Override
	public List<UserPoisition_Dang> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<UserPoisition_Dang> orderByComparator) {

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

		List<UserPoisition_Dang> list =
			(List<UserPoisition_Dang>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserPoisition_Dang userPoisition_Dang : list) {
				if (!uuid.equals(userPoisition_Dang.getUuid())) {
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

			query.append(_SQL_SELECT_USERPOISITION_DANG_WHERE);

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
				query.append(UserPoisition_DangModelImpl.ORDER_BY_JPQL);
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
					list = (List<UserPoisition_Dang>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserPoisition_Dang>)QueryUtil.list(
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
	 * Returns the first user poisition_ dang in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a matching user poisition_ dang could not be found
	 */
	@Override
	public UserPoisition_Dang findByUuid_First(
			String uuid,
			OrderByComparator<UserPoisition_Dang> orderByComparator)
		throws NoSuchUserPoisition_DangException {

		UserPoisition_Dang userPoisition_Dang = fetchByUuid_First(
			uuid, orderByComparator);

		if (userPoisition_Dang != null) {
			return userPoisition_Dang;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchUserPoisition_DangException(msg.toString());
	}

	/**
	 * Returns the first user poisition_ dang in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user poisition_ dang, or <code>null</code> if a matching user poisition_ dang could not be found
	 */
	@Override
	public UserPoisition_Dang fetchByUuid_First(
		String uuid, OrderByComparator<UserPoisition_Dang> orderByComparator) {

		List<UserPoisition_Dang> list = findByUuid(
			uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user poisition_ dang in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a matching user poisition_ dang could not be found
	 */
	@Override
	public UserPoisition_Dang findByUuid_Last(
			String uuid,
			OrderByComparator<UserPoisition_Dang> orderByComparator)
		throws NoSuchUserPoisition_DangException {

		UserPoisition_Dang userPoisition_Dang = fetchByUuid_Last(
			uuid, orderByComparator);

		if (userPoisition_Dang != null) {
			return userPoisition_Dang;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchUserPoisition_DangException(msg.toString());
	}

	/**
	 * Returns the last user poisition_ dang in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user poisition_ dang, or <code>null</code> if a matching user poisition_ dang could not be found
	 */
	@Override
	public UserPoisition_Dang fetchByUuid_Last(
		String uuid, OrderByComparator<UserPoisition_Dang> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<UserPoisition_Dang> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user poisition_ dangs before and after the current user poisition_ dang in the ordered set where uuid = &#63;.
	 *
	 * @param userPoisitionDangId the primary key of the current user poisition_ dang
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a user poisition_ dang with the primary key could not be found
	 */
	@Override
	public UserPoisition_Dang[] findByUuid_PrevAndNext(
			long userPoisitionDangId, String uuid,
			OrderByComparator<UserPoisition_Dang> orderByComparator)
		throws NoSuchUserPoisition_DangException {

		uuid = Objects.toString(uuid, "");

		UserPoisition_Dang userPoisition_Dang = findByPrimaryKey(
			userPoisitionDangId);

		Session session = null;

		try {
			session = openSession();

			UserPoisition_Dang[] array = new UserPoisition_DangImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, userPoisition_Dang, uuid, orderByComparator, true);

			array[1] = userPoisition_Dang;

			array[2] = getByUuid_PrevAndNext(
				session, userPoisition_Dang, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserPoisition_Dang getByUuid_PrevAndNext(
		Session session, UserPoisition_Dang userPoisition_Dang, String uuid,
		OrderByComparator<UserPoisition_Dang> orderByComparator,
		boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERPOISITION_DANG_WHERE);

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
			query.append(UserPoisition_DangModelImpl.ORDER_BY_JPQL);
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
						userPoisition_Dang)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<UserPoisition_Dang> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user poisition_ dangs where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (UserPoisition_Dang userPoisition_Dang :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userPoisition_Dang);
		}
	}

	/**
	 * Returns the number of user poisition_ dangs where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching user poisition_ dangs
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERPOISITION_DANG_WHERE);

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
		"userPoisition_Dang.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(userPoisition_Dang.uuid IS NULL OR userPoisition_Dang.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the user poisition_ dang where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchUserPoisition_DangException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a matching user poisition_ dang could not be found
	 */
	@Override
	public UserPoisition_Dang findByUUID_G(String uuid, long groupId)
		throws NoSuchUserPoisition_DangException {

		UserPoisition_Dang userPoisition_Dang = fetchByUUID_G(uuid, groupId);

		if (userPoisition_Dang == null) {
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

			throw new NoSuchUserPoisition_DangException(msg.toString());
		}

		return userPoisition_Dang;
	}

	/**
	 * Returns the user poisition_ dang where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user poisition_ dang, or <code>null</code> if a matching user poisition_ dang could not be found
	 */
	@Deprecated
	@Override
	public UserPoisition_Dang fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the user poisition_ dang where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching user poisition_ dang, or <code>null</code> if a matching user poisition_ dang could not be found
	 */
	@Override
	public UserPoisition_Dang fetchByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] {uuid, groupId};

		Object result = finderCache.getResult(
			_finderPathFetchByUUID_G, finderArgs, this);

		if (result instanceof UserPoisition_Dang) {
			UserPoisition_Dang userPoisition_Dang = (UserPoisition_Dang)result;

			if (!Objects.equals(uuid, userPoisition_Dang.getUuid()) ||
				(groupId != userPoisition_Dang.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_USERPOISITION_DANG_WHERE);

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

				List<UserPoisition_Dang> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByUUID_G, finderArgs, list);
				}
				else {
					UserPoisition_Dang userPoisition_Dang = list.get(0);

					result = userPoisition_Dang;

					cacheResult(userPoisition_Dang);
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
			return (UserPoisition_Dang)result;
		}
	}

	/**
	 * Removes the user poisition_ dang where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the user poisition_ dang that was removed
	 */
	@Override
	public UserPoisition_Dang removeByUUID_G(String uuid, long groupId)
		throws NoSuchUserPoisition_DangException {

		UserPoisition_Dang userPoisition_Dang = findByUUID_G(uuid, groupId);

		return remove(userPoisition_Dang);
	}

	/**
	 * Returns the number of user poisition_ dangs where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching user poisition_ dangs
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERPOISITION_DANG_WHERE);

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
		"userPoisition_Dang.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(userPoisition_Dang.uuid IS NULL OR userPoisition_Dang.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"userPoisition_Dang.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the user poisition_ dangs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching user poisition_ dangs
	 */
	@Override
	public List<UserPoisition_Dang> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user poisition_ dangs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @return the range of matching user poisition_ dangs
	 */
	@Override
	public List<UserPoisition_Dang> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user poisition_ dangs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user poisition_ dangs
	 */
	@Deprecated
	@Override
	public List<UserPoisition_Dang> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserPoisition_Dang> orderByComparator,
		boolean useFinderCache) {

		return findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user poisition_ dangs where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user poisition_ dangs
	 */
	@Override
	public List<UserPoisition_Dang> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<UserPoisition_Dang> orderByComparator) {

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

		List<UserPoisition_Dang> list =
			(List<UserPoisition_Dang>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserPoisition_Dang userPoisition_Dang : list) {
				if (!uuid.equals(userPoisition_Dang.getUuid()) ||
					(companyId != userPoisition_Dang.getCompanyId())) {

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

			query.append(_SQL_SELECT_USERPOISITION_DANG_WHERE);

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
				query.append(UserPoisition_DangModelImpl.ORDER_BY_JPQL);
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
					list = (List<UserPoisition_Dang>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserPoisition_Dang>)QueryUtil.list(
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
	 * Returns the first user poisition_ dang in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a matching user poisition_ dang could not be found
	 */
	@Override
	public UserPoisition_Dang findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<UserPoisition_Dang> orderByComparator)
		throws NoSuchUserPoisition_DangException {

		UserPoisition_Dang userPoisition_Dang = fetchByUuid_C_First(
			uuid, companyId, orderByComparator);

		if (userPoisition_Dang != null) {
			return userPoisition_Dang;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchUserPoisition_DangException(msg.toString());
	}

	/**
	 * Returns the first user poisition_ dang in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user poisition_ dang, or <code>null</code> if a matching user poisition_ dang could not be found
	 */
	@Override
	public UserPoisition_Dang fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<UserPoisition_Dang> orderByComparator) {

		List<UserPoisition_Dang> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user poisition_ dang in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a matching user poisition_ dang could not be found
	 */
	@Override
	public UserPoisition_Dang findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<UserPoisition_Dang> orderByComparator)
		throws NoSuchUserPoisition_DangException {

		UserPoisition_Dang userPoisition_Dang = fetchByUuid_C_Last(
			uuid, companyId, orderByComparator);

		if (userPoisition_Dang != null) {
			return userPoisition_Dang;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchUserPoisition_DangException(msg.toString());
	}

	/**
	 * Returns the last user poisition_ dang in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user poisition_ dang, or <code>null</code> if a matching user poisition_ dang could not be found
	 */
	@Override
	public UserPoisition_Dang fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<UserPoisition_Dang> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<UserPoisition_Dang> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user poisition_ dangs before and after the current user poisition_ dang in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param userPoisitionDangId the primary key of the current user poisition_ dang
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a user poisition_ dang with the primary key could not be found
	 */
	@Override
	public UserPoisition_Dang[] findByUuid_C_PrevAndNext(
			long userPoisitionDangId, String uuid, long companyId,
			OrderByComparator<UserPoisition_Dang> orderByComparator)
		throws NoSuchUserPoisition_DangException {

		uuid = Objects.toString(uuid, "");

		UserPoisition_Dang userPoisition_Dang = findByPrimaryKey(
			userPoisitionDangId);

		Session session = null;

		try {
			session = openSession();

			UserPoisition_Dang[] array = new UserPoisition_DangImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, userPoisition_Dang, uuid, companyId, orderByComparator,
				true);

			array[1] = userPoisition_Dang;

			array[2] = getByUuid_C_PrevAndNext(
				session, userPoisition_Dang, uuid, companyId, orderByComparator,
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

	protected UserPoisition_Dang getByUuid_C_PrevAndNext(
		Session session, UserPoisition_Dang userPoisition_Dang, String uuid,
		long companyId, OrderByComparator<UserPoisition_Dang> orderByComparator,
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

		query.append(_SQL_SELECT_USERPOISITION_DANG_WHERE);

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
			query.append(UserPoisition_DangModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						userPoisition_Dang)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<UserPoisition_Dang> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user poisition_ dangs where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (UserPoisition_Dang userPoisition_Dang :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(userPoisition_Dang);
		}
	}

	/**
	 * Returns the number of user poisition_ dangs where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching user poisition_ dangs
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERPOISITION_DANG_WHERE);

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
		"userPoisition_Dang.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(userPoisition_Dang.uuid IS NULL OR userPoisition_Dang.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"userPoisition_Dang.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByFindAll;
	private FinderPath _finderPathWithoutPaginationFindByFindAll;
	private FinderPath _finderPathCountByFindAll;

	/**
	 * Returns all the user poisition_ dangs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the matching user poisition_ dangs
	 */
	@Override
	public List<UserPoisition_Dang> findByFindAll(
		long groupId, long companyId) {

		return findByFindAll(
			groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user poisition_ dangs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @return the range of matching user poisition_ dangs
	 */
	@Override
	public List<UserPoisition_Dang> findByFindAll(
		long groupId, long companyId, int start, int end) {

		return findByFindAll(groupId, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user poisition_ dangs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByFindAll(long,long, int, int, OrderByComparator)}
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user poisition_ dangs
	 */
	@Deprecated
	@Override
	public List<UserPoisition_Dang> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<UserPoisition_Dang> orderByComparator,
		boolean useFinderCache) {

		return findByFindAll(groupId, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user poisition_ dangs where groupId = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user poisition_ dangs
	 */
	@Override
	public List<UserPoisition_Dang> findByFindAll(
		long groupId, long companyId, int start, int end,
		OrderByComparator<UserPoisition_Dang> orderByComparator) {

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

		List<UserPoisition_Dang> list =
			(List<UserPoisition_Dang>)finderCache.getResult(
				finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (UserPoisition_Dang userPoisition_Dang : list) {
				if ((groupId != userPoisition_Dang.getGroupId()) ||
					(companyId != userPoisition_Dang.getCompanyId())) {

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

			query.append(_SQL_SELECT_USERPOISITION_DANG_WHERE);

			query.append(_FINDER_COLUMN_FINDALL_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDALL_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(UserPoisition_DangModelImpl.ORDER_BY_JPQL);
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
					list = (List<UserPoisition_Dang>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserPoisition_Dang>)QueryUtil.list(
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
	 * Returns the first user poisition_ dang in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a matching user poisition_ dang could not be found
	 */
	@Override
	public UserPoisition_Dang findByFindAll_First(
			long groupId, long companyId,
			OrderByComparator<UserPoisition_Dang> orderByComparator)
		throws NoSuchUserPoisition_DangException {

		UserPoisition_Dang userPoisition_Dang = fetchByFindAll_First(
			groupId, companyId, orderByComparator);

		if (userPoisition_Dang != null) {
			return userPoisition_Dang;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchUserPoisition_DangException(msg.toString());
	}

	/**
	 * Returns the first user poisition_ dang in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user poisition_ dang, or <code>null</code> if a matching user poisition_ dang could not be found
	 */
	@Override
	public UserPoisition_Dang fetchByFindAll_First(
		long groupId, long companyId,
		OrderByComparator<UserPoisition_Dang> orderByComparator) {

		List<UserPoisition_Dang> list = findByFindAll(
			groupId, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user poisition_ dang in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a matching user poisition_ dang could not be found
	 */
	@Override
	public UserPoisition_Dang findByFindAll_Last(
			long groupId, long companyId,
			OrderByComparator<UserPoisition_Dang> orderByComparator)
		throws NoSuchUserPoisition_DangException {

		UserPoisition_Dang userPoisition_Dang = fetchByFindAll_Last(
			groupId, companyId, orderByComparator);

		if (userPoisition_Dang != null) {
			return userPoisition_Dang;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchUserPoisition_DangException(msg.toString());
	}

	/**
	 * Returns the last user poisition_ dang in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user poisition_ dang, or <code>null</code> if a matching user poisition_ dang could not be found
	 */
	@Override
	public UserPoisition_Dang fetchByFindAll_Last(
		long groupId, long companyId,
		OrderByComparator<UserPoisition_Dang> orderByComparator) {

		int count = countByFindAll(groupId, companyId);

		if (count == 0) {
			return null;
		}

		List<UserPoisition_Dang> list = findByFindAll(
			groupId, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user poisition_ dangs before and after the current user poisition_ dang in the ordered set where groupId = &#63; and companyId = &#63;.
	 *
	 * @param userPoisitionDangId the primary key of the current user poisition_ dang
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a user poisition_ dang with the primary key could not be found
	 */
	@Override
	public UserPoisition_Dang[] findByFindAll_PrevAndNext(
			long userPoisitionDangId, long groupId, long companyId,
			OrderByComparator<UserPoisition_Dang> orderByComparator)
		throws NoSuchUserPoisition_DangException {

		UserPoisition_Dang userPoisition_Dang = findByPrimaryKey(
			userPoisitionDangId);

		Session session = null;

		try {
			session = openSession();

			UserPoisition_Dang[] array = new UserPoisition_DangImpl[3];

			array[0] = getByFindAll_PrevAndNext(
				session, userPoisition_Dang, groupId, companyId,
				orderByComparator, true);

			array[1] = userPoisition_Dang;

			array[2] = getByFindAll_PrevAndNext(
				session, userPoisition_Dang, groupId, companyId,
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

	protected UserPoisition_Dang getByFindAll_PrevAndNext(
		Session session, UserPoisition_Dang userPoisition_Dang, long groupId,
		long companyId, OrderByComparator<UserPoisition_Dang> orderByComparator,
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

		query.append(_SQL_SELECT_USERPOISITION_DANG_WHERE);

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
			query.append(UserPoisition_DangModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(
						userPoisition_Dang)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<UserPoisition_Dang> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user poisition_ dangs where groupId = &#63; and companyId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 */
	@Override
	public void removeByFindAll(long groupId, long companyId) {
		for (UserPoisition_Dang userPoisition_Dang :
				findByFindAll(
					groupId, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(userPoisition_Dang);
		}
	}

	/**
	 * Returns the number of user poisition_ dangs where groupId = &#63; and companyId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param companyId the company ID
	 * @return the number of matching user poisition_ dangs
	 */
	@Override
	public int countByFindAll(long groupId, long companyId) {
		FinderPath finderPath = _finderPathCountByFindAll;

		Object[] finderArgs = new Object[] {groupId, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_USERPOISITION_DANG_WHERE);

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
		"userPoisition_Dang.groupId = ? AND ";

	private static final String _FINDER_COLUMN_FINDALL_COMPANYID_2 =
		"userPoisition_Dang.companyId = ?";

	public UserPoisition_DangPersistenceImpl() {
		setModelClass(UserPoisition_Dang.class);

		setModelImplClass(UserPoisition_DangImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the user poisition_ dang in the entity cache if it is enabled.
	 *
	 * @param userPoisition_Dang the user poisition_ dang
	 */
	@Override
	public void cacheResult(UserPoisition_Dang userPoisition_Dang) {
		entityCache.putResult(
			entityCacheEnabled, UserPoisition_DangImpl.class,
			userPoisition_Dang.getPrimaryKey(), userPoisition_Dang);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {
				userPoisition_Dang.getUuid(), userPoisition_Dang.getGroupId()
			},
			userPoisition_Dang);

		userPoisition_Dang.resetOriginalValues();
	}

	/**
	 * Caches the user poisition_ dangs in the entity cache if it is enabled.
	 *
	 * @param userPoisition_Dangs the user poisition_ dangs
	 */
	@Override
	public void cacheResult(List<UserPoisition_Dang> userPoisition_Dangs) {
		for (UserPoisition_Dang userPoisition_Dang : userPoisition_Dangs) {
			if (entityCache.getResult(
					entityCacheEnabled, UserPoisition_DangImpl.class,
					userPoisition_Dang.getPrimaryKey()) == null) {

				cacheResult(userPoisition_Dang);
			}
			else {
				userPoisition_Dang.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user poisition_ dangs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserPoisition_DangImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user poisition_ dang.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserPoisition_Dang userPoisition_Dang) {
		entityCache.removeResult(
			entityCacheEnabled, UserPoisition_DangImpl.class,
			userPoisition_Dang.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(
			(UserPoisition_DangModelImpl)userPoisition_Dang, true);
	}

	@Override
	public void clearCache(List<UserPoisition_Dang> userPoisition_Dangs) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserPoisition_Dang userPoisition_Dang : userPoisition_Dangs) {
			entityCache.removeResult(
				entityCacheEnabled, UserPoisition_DangImpl.class,
				userPoisition_Dang.getPrimaryKey());

			clearUniqueFindersCache(
				(UserPoisition_DangModelImpl)userPoisition_Dang, true);
		}
	}

	protected void cacheUniqueFindersCache(
		UserPoisition_DangModelImpl userPoisition_DangModelImpl) {

		Object[] args = new Object[] {
			userPoisition_DangModelImpl.getUuid(),
			userPoisition_DangModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, userPoisition_DangModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		UserPoisition_DangModelImpl userPoisition_DangModelImpl,
		boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				userPoisition_DangModelImpl.getUuid(),
				userPoisition_DangModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((userPoisition_DangModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				userPoisition_DangModelImpl.getOriginalUuid(),
				userPoisition_DangModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}
	}

	/**
	 * Creates a new user poisition_ dang with the primary key. Does not add the user poisition_ dang to the database.
	 *
	 * @param userPoisitionDangId the primary key for the new user poisition_ dang
	 * @return the new user poisition_ dang
	 */
	@Override
	public UserPoisition_Dang create(long userPoisitionDangId) {
		UserPoisition_Dang userPoisition_Dang = new UserPoisition_DangImpl();

		userPoisition_Dang.setNew(true);
		userPoisition_Dang.setPrimaryKey(userPoisitionDangId);

		String uuid = PortalUUIDUtil.generate();

		userPoisition_Dang.setUuid(uuid);

		userPoisition_Dang.setCompanyId(CompanyThreadLocal.getCompanyId());

		return userPoisition_Dang;
	}

	/**
	 * Removes the user poisition_ dang with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userPoisitionDangId the primary key of the user poisition_ dang
	 * @return the user poisition_ dang that was removed
	 * @throws NoSuchUserPoisition_DangException if a user poisition_ dang with the primary key could not be found
	 */
	@Override
	public UserPoisition_Dang remove(long userPoisitionDangId)
		throws NoSuchUserPoisition_DangException {

		return remove((Serializable)userPoisitionDangId);
	}

	/**
	 * Removes the user poisition_ dang with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user poisition_ dang
	 * @return the user poisition_ dang that was removed
	 * @throws NoSuchUserPoisition_DangException if a user poisition_ dang with the primary key could not be found
	 */
	@Override
	public UserPoisition_Dang remove(Serializable primaryKey)
		throws NoSuchUserPoisition_DangException {

		Session session = null;

		try {
			session = openSession();

			UserPoisition_Dang userPoisition_Dang =
				(UserPoisition_Dang)session.get(
					UserPoisition_DangImpl.class, primaryKey);

			if (userPoisition_Dang == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserPoisition_DangException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userPoisition_Dang);
		}
		catch (NoSuchUserPoisition_DangException nsee) {
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
	protected UserPoisition_Dang removeImpl(
		UserPoisition_Dang userPoisition_Dang) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userPoisition_Dang)) {
				userPoisition_Dang = (UserPoisition_Dang)session.get(
					UserPoisition_DangImpl.class,
					userPoisition_Dang.getPrimaryKeyObj());
			}

			if (userPoisition_Dang != null) {
				session.delete(userPoisition_Dang);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (userPoisition_Dang != null) {
			clearCache(userPoisition_Dang);
		}

		return userPoisition_Dang;
	}

	@Override
	public UserPoisition_Dang updateImpl(
		UserPoisition_Dang userPoisition_Dang) {

		boolean isNew = userPoisition_Dang.isNew();

		if (!(userPoisition_Dang instanceof UserPoisition_DangModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userPoisition_Dang.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					userPoisition_Dang);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userPoisition_Dang proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserPoisition_Dang implementation " +
					userPoisition_Dang.getClass());
		}

		UserPoisition_DangModelImpl userPoisition_DangModelImpl =
			(UserPoisition_DangModelImpl)userPoisition_Dang;

		if (Validator.isNull(userPoisition_Dang.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			userPoisition_Dang.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (userPoisition_Dang.getCreateDate() == null)) {
			if (serviceContext == null) {
				userPoisition_Dang.setCreateDate(now);
			}
			else {
				userPoisition_Dang.setCreateDate(
					serviceContext.getCreateDate(now));
			}
		}

		if (!userPoisition_DangModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				userPoisition_Dang.setModifiedDate(now);
			}
			else {
				userPoisition_Dang.setModifiedDate(
					serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (userPoisition_Dang.isNew()) {
				session.save(userPoisition_Dang);

				userPoisition_Dang.setNew(false);
			}
			else {
				userPoisition_Dang = (UserPoisition_Dang)session.merge(
					userPoisition_Dang);
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
			Object[] args = new Object[] {
				userPoisition_DangModelImpl.getUuid()
			};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				userPoisition_DangModelImpl.getUuid(),
				userPoisition_DangModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {
				userPoisition_DangModelImpl.getGroupId(),
				userPoisition_DangModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByFindAll, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindAll, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((userPoisition_DangModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					userPoisition_DangModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {userPoisition_DangModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((userPoisition_DangModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					userPoisition_DangModelImpl.getOriginalUuid(),
					userPoisition_DangModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					userPoisition_DangModelImpl.getUuid(),
					userPoisition_DangModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((userPoisition_DangModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindAll.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					userPoisition_DangModelImpl.getOriginalGroupId(),
					userPoisition_DangModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);

				args = new Object[] {
					userPoisition_DangModelImpl.getGroupId(),
					userPoisition_DangModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByFindAll, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindAll, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, UserPoisition_DangImpl.class,
			userPoisition_Dang.getPrimaryKey(), userPoisition_Dang, false);

		clearUniqueFindersCache(userPoisition_DangModelImpl, false);
		cacheUniqueFindersCache(userPoisition_DangModelImpl);

		userPoisition_Dang.resetOriginalValues();

		return userPoisition_Dang;
	}

	/**
	 * Returns the user poisition_ dang with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user poisition_ dang
	 * @return the user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a user poisition_ dang with the primary key could not be found
	 */
	@Override
	public UserPoisition_Dang findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserPoisition_DangException {

		UserPoisition_Dang userPoisition_Dang = fetchByPrimaryKey(primaryKey);

		if (userPoisition_Dang == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserPoisition_DangException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userPoisition_Dang;
	}

	/**
	 * Returns the user poisition_ dang with the primary key or throws a <code>NoSuchUserPoisition_DangException</code> if it could not be found.
	 *
	 * @param userPoisitionDangId the primary key of the user poisition_ dang
	 * @return the user poisition_ dang
	 * @throws NoSuchUserPoisition_DangException if a user poisition_ dang with the primary key could not be found
	 */
	@Override
	public UserPoisition_Dang findByPrimaryKey(long userPoisitionDangId)
		throws NoSuchUserPoisition_DangException {

		return findByPrimaryKey((Serializable)userPoisitionDangId);
	}

	/**
	 * Returns the user poisition_ dang with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userPoisitionDangId the primary key of the user poisition_ dang
	 * @return the user poisition_ dang, or <code>null</code> if a user poisition_ dang with the primary key could not be found
	 */
	@Override
	public UserPoisition_Dang fetchByPrimaryKey(long userPoisitionDangId) {
		return fetchByPrimaryKey((Serializable)userPoisitionDangId);
	}

	/**
	 * Returns all the user poisition_ dangs.
	 *
	 * @return the user poisition_ dangs
	 */
	@Override
	public List<UserPoisition_Dang> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user poisition_ dangs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @return the range of user poisition_ dangs
	 */
	@Override
	public List<UserPoisition_Dang> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user poisition_ dangs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user poisition_ dangs
	 */
	@Deprecated
	@Override
	public List<UserPoisition_Dang> findAll(
		int start, int end,
		OrderByComparator<UserPoisition_Dang> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the user poisition_ dangs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>UserPoisition_DangModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of user poisition_ dangs
	 * @param end the upper bound of the range of user poisition_ dangs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user poisition_ dangs
	 */
	@Override
	public List<UserPoisition_Dang> findAll(
		int start, int end,
		OrderByComparator<UserPoisition_Dang> orderByComparator) {

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

		List<UserPoisition_Dang> list =
			(List<UserPoisition_Dang>)finderCache.getResult(
				finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERPOISITION_DANG);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERPOISITION_DANG;

				if (pagination) {
					sql = sql.concat(UserPoisition_DangModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<UserPoisition_Dang>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<UserPoisition_Dang>)QueryUtil.list(
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
	 * Removes all the user poisition_ dangs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserPoisition_Dang userPoisition_Dang : findAll()) {
			remove(userPoisition_Dang);
		}
	}

	/**
	 * Returns the number of user poisition_ dangs.
	 *
	 * @return the number of user poisition_ dangs
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERPOISITION_DANG);

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
		return "userPoisitionDangId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERPOISITION_DANG;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserPoisition_DangModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user poisition_ dang persistence.
	 */
	@Activate
	public void activate() {
		UserPoisition_DangModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		UserPoisition_DangModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			UserPoisition_DangImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			UserPoisition_DangImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			UserPoisition_DangImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			UserPoisition_DangImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			UserPoisition_DangModelImpl.UUID_COLUMN_BITMASK |
			UserPoisition_DangModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			UserPoisition_DangImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			UserPoisition_DangModelImpl.UUID_COLUMN_BITMASK |
			UserPoisition_DangModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			UserPoisition_DangImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			UserPoisition_DangImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			UserPoisition_DangModelImpl.UUID_COLUMN_BITMASK |
			UserPoisition_DangModelImpl.COMPANYID_COLUMN_BITMASK |
			UserPoisition_DangModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			UserPoisition_DangImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindAll",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			UserPoisition_DangImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindAll",
			new String[] {Long.class.getName(), Long.class.getName()},
			UserPoisition_DangModelImpl.GROUPID_COLUMN_BITMASK |
			UserPoisition_DangModelImpl.COMPANYID_COLUMN_BITMASK |
			UserPoisition_DangModelImpl.CREATEDATE_COLUMN_BITMASK);

		_finderPathCountByFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindAll",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(UserPoisition_DangImpl.class.getName());
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
				"value.object.column.bitmask.enabled.User.Rank.Poisition.Service.model.UserPoisition_Dang"),
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

	private static final String _SQL_SELECT_USERPOISITION_DANG =
		"SELECT userPoisition_Dang FROM UserPoisition_Dang userPoisition_Dang";

	private static final String _SQL_SELECT_USERPOISITION_DANG_WHERE =
		"SELECT userPoisition_Dang FROM UserPoisition_Dang userPoisition_Dang WHERE ";

	private static final String _SQL_COUNT_USERPOISITION_DANG =
		"SELECT COUNT(userPoisition_Dang) FROM UserPoisition_Dang userPoisition_Dang";

	private static final String _SQL_COUNT_USERPOISITION_DANG_WHERE =
		"SELECT COUNT(userPoisition_Dang) FROM UserPoisition_Dang userPoisition_Dang WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userPoisition_Dang.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserPoisition_Dang exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserPoisition_Dang exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserPoisition_DangPersistenceImpl.class);

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