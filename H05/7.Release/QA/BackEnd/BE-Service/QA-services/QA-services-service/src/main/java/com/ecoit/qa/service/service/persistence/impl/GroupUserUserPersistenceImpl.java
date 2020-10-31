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

package com.ecoit.qa.service.service.persistence.impl;

import com.ecoit.qa.service.exception.NoSuchGroupUserUserException;
import com.ecoit.qa.service.model.GroupUserUser;
import com.ecoit.qa.service.model.impl.GroupUserUserImpl;
import com.ecoit.qa.service.model.impl.GroupUserUserModelImpl;
import com.ecoit.qa.service.service.persistence.GroupUserUserPK;
import com.ecoit.qa.service.service.persistence.GroupUserUserPersistence;
import com.ecoit.qa.service.service.persistence.impl.constants.ecoit_qaPersistenceConstants;

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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the group user user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = GroupUserUserPersistence.class)
public class GroupUserUserPersistenceImpl
	extends BasePersistenceImpl<GroupUserUser>
	implements GroupUserUserPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GroupUserUserUtil</code> to access the group user user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GroupUserUserImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUser;
	private FinderPath _finderPathWithoutPaginationFindByUser;
	private FinderPath _finderPathCountByUser;

	/**
	 * Returns all the group user users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching group user users
	 */
	@Override
	public List<GroupUserUser> findByUser(long userId) {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group user users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @return the range of matching group user users
	 */
	@Override
	public List<GroupUserUser> findByUser(long userId, int start, int end) {
		return findByUser(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the group user users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user users
	 */
	@Override
	public List<GroupUserUser> findByUser(
		long userId, int start, int end,
		OrderByComparator<GroupUserUser> orderByComparator) {

		return findByUser(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group user users where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user users
	 */
	@Override
	public List<GroupUserUser> findByUser(
		long userId, int start, int end,
		OrderByComparator<GroupUserUser> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUser;
				finderArgs = new Object[] {userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUser;
			finderArgs = new Object[] {userId, start, end, orderByComparator};
		}

		List<GroupUserUser> list = null;

		if (useFinderCache) {
			list = (List<GroupUserUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GroupUserUser groupUserUser : list) {
					if (userId != groupUserUser.getUserId()) {
						list = null;

						break;
					}
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

			query.append(_SQL_SELECT_GROUPUSERUSER_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(GroupUserUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<GroupUserUser>)QueryUtil.list(
					q, getDialect(), start, end);

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
	 * Returns the first group user user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user user
	 * @throws NoSuchGroupUserUserException if a matching group user user could not be found
	 */
	@Override
	public GroupUserUser findByUser_First(
			long userId, OrderByComparator<GroupUserUser> orderByComparator)
		throws NoSuchGroupUserUserException {

		GroupUserUser groupUserUser = fetchByUser_First(
			userId, orderByComparator);

		if (groupUserUser != null) {
			return groupUserUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchGroupUserUserException(msg.toString());
	}

	/**
	 * Returns the first group user user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user user, or <code>null</code> if a matching group user user could not be found
	 */
	@Override
	public GroupUserUser fetchByUser_First(
		long userId, OrderByComparator<GroupUserUser> orderByComparator) {

		List<GroupUserUser> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last group user user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user user
	 * @throws NoSuchGroupUserUserException if a matching group user user could not be found
	 */
	@Override
	public GroupUserUser findByUser_Last(
			long userId, OrderByComparator<GroupUserUser> orderByComparator)
		throws NoSuchGroupUserUserException {

		GroupUserUser groupUserUser = fetchByUser_Last(
			userId, orderByComparator);

		if (groupUserUser != null) {
			return groupUserUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchGroupUserUserException(msg.toString());
	}

	/**
	 * Returns the last group user user in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user user, or <code>null</code> if a matching group user user could not be found
	 */
	@Override
	public GroupUserUser fetchByUser_Last(
		long userId, OrderByComparator<GroupUserUser> orderByComparator) {

		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<GroupUserUser> list = findByUser(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the group user users before and after the current group user user in the ordered set where userId = &#63;.
	 *
	 * @param groupUserUserPK the primary key of the current group user user
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user user
	 * @throws NoSuchGroupUserUserException if a group user user with the primary key could not be found
	 */
	@Override
	public GroupUserUser[] findByUser_PrevAndNext(
			GroupUserUserPK groupUserUserPK, long userId,
			OrderByComparator<GroupUserUser> orderByComparator)
		throws NoSuchGroupUserUserException {

		GroupUserUser groupUserUser = findByPrimaryKey(groupUserUserPK);

		Session session = null;

		try {
			session = openSession();

			GroupUserUser[] array = new GroupUserUserImpl[3];

			array[0] = getByUser_PrevAndNext(
				session, groupUserUser, userId, orderByComparator, true);

			array[1] = groupUserUser;

			array[2] = getByUser_PrevAndNext(
				session, groupUserUser, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GroupUserUser getByUser_PrevAndNext(
		Session session, GroupUserUser groupUserUser, long userId,
		OrderByComparator<GroupUserUser> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GROUPUSERUSER_WHERE);

		query.append(_FINDER_COLUMN_USER_USERID_2);

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
			query.append(GroupUserUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						groupUserUser)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<GroupUserUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the group user users where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUser(long userId) {
		for (GroupUserUser groupUserUser :
				findByUser(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(groupUserUser);
		}
	}

	/**
	 * Returns the number of group user users where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching group user users
	 */
	@Override
	public int countByUser(long userId) {
		FinderPath finderPath = _finderPathCountByUser;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GROUPUSERUSER_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				count = (Long)q.uniqueResult();

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

	private static final String _FINDER_COLUMN_USER_USERID_2 =
		"groupUserUser.id.userId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupUser;
	private FinderPath _finderPathWithoutPaginationFindByGroupUser;
	private FinderPath _finderPathCountByGroupUser;

	/**
	 * Returns all the group user users where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching group user users
	 */
	@Override
	public List<GroupUserUser> findByGroupUser(long groupUserId) {
		return findByGroupUser(
			groupUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group user users where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @return the range of matching group user users
	 */
	@Override
	public List<GroupUserUser> findByGroupUser(
		long groupUserId, int start, int end) {

		return findByGroupUser(groupUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the group user users where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user users
	 */
	@Override
	public List<GroupUserUser> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupUserUser> orderByComparator) {

		return findByGroupUser(
			groupUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group user users where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user users
	 */
	@Override
	public List<GroupUserUser> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupUserUser> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroupUser;
				finderArgs = new Object[] {groupUserId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroupUser;
			finderArgs = new Object[] {
				groupUserId, start, end, orderByComparator
			};
		}

		List<GroupUserUser> list = null;

		if (useFinderCache) {
			list = (List<GroupUserUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GroupUserUser groupUserUser : list) {
					if (groupUserId != groupUserUser.getGroupUserId()) {
						list = null;

						break;
					}
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

			query.append(_SQL_SELECT_GROUPUSERUSER_WHERE);

			query.append(_FINDER_COLUMN_GROUPUSER_GROUPUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(GroupUserUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupUserId);

				list = (List<GroupUserUser>)QueryUtil.list(
					q, getDialect(), start, end);

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
	 * Returns the first group user user in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user user
	 * @throws NoSuchGroupUserUserException if a matching group user user could not be found
	 */
	@Override
	public GroupUserUser findByGroupUser_First(
			long groupUserId,
			OrderByComparator<GroupUserUser> orderByComparator)
		throws NoSuchGroupUserUserException {

		GroupUserUser groupUserUser = fetchByGroupUser_First(
			groupUserId, orderByComparator);

		if (groupUserUser != null) {
			return groupUserUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupUserId=");
		msg.append(groupUserId);

		msg.append("}");

		throw new NoSuchGroupUserUserException(msg.toString());
	}

	/**
	 * Returns the first group user user in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user user, or <code>null</code> if a matching group user user could not be found
	 */
	@Override
	public GroupUserUser fetchByGroupUser_First(
		long groupUserId, OrderByComparator<GroupUserUser> orderByComparator) {

		List<GroupUserUser> list = findByGroupUser(
			groupUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last group user user in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user user
	 * @throws NoSuchGroupUserUserException if a matching group user user could not be found
	 */
	@Override
	public GroupUserUser findByGroupUser_Last(
			long groupUserId,
			OrderByComparator<GroupUserUser> orderByComparator)
		throws NoSuchGroupUserUserException {

		GroupUserUser groupUserUser = fetchByGroupUser_Last(
			groupUserId, orderByComparator);

		if (groupUserUser != null) {
			return groupUserUser;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupUserId=");
		msg.append(groupUserId);

		msg.append("}");

		throw new NoSuchGroupUserUserException(msg.toString());
	}

	/**
	 * Returns the last group user user in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user user, or <code>null</code> if a matching group user user could not be found
	 */
	@Override
	public GroupUserUser fetchByGroupUser_Last(
		long groupUserId, OrderByComparator<GroupUserUser> orderByComparator) {

		int count = countByGroupUser(groupUserId);

		if (count == 0) {
			return null;
		}

		List<GroupUserUser> list = findByGroupUser(
			groupUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the group user users before and after the current group user user in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserUserPK the primary key of the current group user user
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user user
	 * @throws NoSuchGroupUserUserException if a group user user with the primary key could not be found
	 */
	@Override
	public GroupUserUser[] findByGroupUser_PrevAndNext(
			GroupUserUserPK groupUserUserPK, long groupUserId,
			OrderByComparator<GroupUserUser> orderByComparator)
		throws NoSuchGroupUserUserException {

		GroupUserUser groupUserUser = findByPrimaryKey(groupUserUserPK);

		Session session = null;

		try {
			session = openSession();

			GroupUserUser[] array = new GroupUserUserImpl[3];

			array[0] = getByGroupUser_PrevAndNext(
				session, groupUserUser, groupUserId, orderByComparator, true);

			array[1] = groupUserUser;

			array[2] = getByGroupUser_PrevAndNext(
				session, groupUserUser, groupUserId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GroupUserUser getByGroupUser_PrevAndNext(
		Session session, GroupUserUser groupUserUser, long groupUserId,
		OrderByComparator<GroupUserUser> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GROUPUSERUSER_WHERE);

		query.append(_FINDER_COLUMN_GROUPUSER_GROUPUSERID_2);

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
			query.append(GroupUserUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupUserId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						groupUserUser)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<GroupUserUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the group user users where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	@Override
	public void removeByGroupUser(long groupUserId) {
		for (GroupUserUser groupUserUser :
				findByGroupUser(
					groupUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(groupUserUser);
		}
	}

	/**
	 * Returns the number of group user users where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching group user users
	 */
	@Override
	public int countByGroupUser(long groupUserId) {
		FinderPath finderPath = _finderPathCountByGroupUser;

		Object[] finderArgs = new Object[] {groupUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GROUPUSERUSER_WHERE);

			query.append(_FINDER_COLUMN_GROUPUSER_GROUPUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupUserId);

				count = (Long)q.uniqueResult();

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

	private static final String _FINDER_COLUMN_GROUPUSER_GROUPUSERID_2 =
		"groupUserUser.id.groupUserId = ?";

	public GroupUserUserPersistenceImpl() {
		setModelClass(GroupUserUser.class);

		setModelImplClass(GroupUserUserImpl.class);
		setModelPKClass(GroupUserUserPK.class);
	}

	/**
	 * Caches the group user user in the entity cache if it is enabled.
	 *
	 * @param groupUserUser the group user user
	 */
	@Override
	public void cacheResult(GroupUserUser groupUserUser) {
		entityCache.putResult(
			entityCacheEnabled, GroupUserUserImpl.class,
			groupUserUser.getPrimaryKey(), groupUserUser);

		groupUserUser.resetOriginalValues();
	}

	/**
	 * Caches the group user users in the entity cache if it is enabled.
	 *
	 * @param groupUserUsers the group user users
	 */
	@Override
	public void cacheResult(List<GroupUserUser> groupUserUsers) {
		for (GroupUserUser groupUserUser : groupUserUsers) {
			if (entityCache.getResult(
					entityCacheEnabled, GroupUserUserImpl.class,
					groupUserUser.getPrimaryKey()) == null) {

				cacheResult(groupUserUser);
			}
			else {
				groupUserUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all group user users.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GroupUserUserImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the group user user.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GroupUserUser groupUserUser) {
		entityCache.removeResult(
			entityCacheEnabled, GroupUserUserImpl.class,
			groupUserUser.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GroupUserUser> groupUserUsers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GroupUserUser groupUserUser : groupUserUsers) {
			entityCache.removeResult(
				entityCacheEnabled, GroupUserUserImpl.class,
				groupUserUser.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, GroupUserUserImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new group user user with the primary key. Does not add the group user user to the database.
	 *
	 * @param groupUserUserPK the primary key for the new group user user
	 * @return the new group user user
	 */
	@Override
	public GroupUserUser create(GroupUserUserPK groupUserUserPK) {
		GroupUserUser groupUserUser = new GroupUserUserImpl();

		groupUserUser.setNew(true);
		groupUserUser.setPrimaryKey(groupUserUserPK);

		return groupUserUser;
	}

	/**
	 * Removes the group user user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserUserPK the primary key of the group user user
	 * @return the group user user that was removed
	 * @throws NoSuchGroupUserUserException if a group user user with the primary key could not be found
	 */
	@Override
	public GroupUserUser remove(GroupUserUserPK groupUserUserPK)
		throws NoSuchGroupUserUserException {

		return remove((Serializable)groupUserUserPK);
	}

	/**
	 * Removes the group user user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the group user user
	 * @return the group user user that was removed
	 * @throws NoSuchGroupUserUserException if a group user user with the primary key could not be found
	 */
	@Override
	public GroupUserUser remove(Serializable primaryKey)
		throws NoSuchGroupUserUserException {

		Session session = null;

		try {
			session = openSession();

			GroupUserUser groupUserUser = (GroupUserUser)session.get(
				GroupUserUserImpl.class, primaryKey);

			if (groupUserUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGroupUserUserException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(groupUserUser);
		}
		catch (NoSuchGroupUserUserException noSuchEntityException) {
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
	protected GroupUserUser removeImpl(GroupUserUser groupUserUser) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(groupUserUser)) {
				groupUserUser = (GroupUserUser)session.get(
					GroupUserUserImpl.class, groupUserUser.getPrimaryKeyObj());
			}

			if (groupUserUser != null) {
				session.delete(groupUserUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (groupUserUser != null) {
			clearCache(groupUserUser);
		}

		return groupUserUser;
	}

	@Override
	public GroupUserUser updateImpl(GroupUserUser groupUserUser) {
		boolean isNew = groupUserUser.isNew();

		if (!(groupUserUser instanceof GroupUserUserModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(groupUserUser.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					groupUserUser);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in groupUserUser proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GroupUserUser implementation " +
					groupUserUser.getClass());
		}

		GroupUserUserModelImpl groupUserUserModelImpl =
			(GroupUserUserModelImpl)groupUserUser;

		Session session = null;

		try {
			session = openSession();

			if (groupUserUser.isNew()) {
				session.save(groupUserUser);

				groupUserUser.setNew(false);
			}
			else {
				groupUserUser = (GroupUserUser)session.merge(groupUserUser);
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
			Object[] args = new Object[] {groupUserUserModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUser, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUser, args);

			args = new Object[] {groupUserUserModelImpl.getGroupUserId()};

			finderCache.removeResult(_finderPathCountByGroupUser, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupUser, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((groupUserUserModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUser.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					groupUserUserModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUser, args);

				args = new Object[] {groupUserUserModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUser, args);
			}

			if ((groupUserUserModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupUser.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					groupUserUserModelImpl.getOriginalGroupUserId()
				};

				finderCache.removeResult(_finderPathCountByGroupUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupUser, args);

				args = new Object[] {groupUserUserModelImpl.getGroupUserId()};

				finderCache.removeResult(_finderPathCountByGroupUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupUser, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, GroupUserUserImpl.class,
			groupUserUser.getPrimaryKey(), groupUserUser, false);

		groupUserUser.resetOriginalValues();

		return groupUserUser;
	}

	/**
	 * Returns the group user user with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the group user user
	 * @return the group user user
	 * @throws NoSuchGroupUserUserException if a group user user with the primary key could not be found
	 */
	@Override
	public GroupUserUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGroupUserUserException {

		GroupUserUser groupUserUser = fetchByPrimaryKey(primaryKey);

		if (groupUserUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGroupUserUserException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return groupUserUser;
	}

	/**
	 * Returns the group user user with the primary key or throws a <code>NoSuchGroupUserUserException</code> if it could not be found.
	 *
	 * @param groupUserUserPK the primary key of the group user user
	 * @return the group user user
	 * @throws NoSuchGroupUserUserException if a group user user with the primary key could not be found
	 */
	@Override
	public GroupUserUser findByPrimaryKey(GroupUserUserPK groupUserUserPK)
		throws NoSuchGroupUserUserException {

		return findByPrimaryKey((Serializable)groupUserUserPK);
	}

	/**
	 * Returns the group user user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupUserUserPK the primary key of the group user user
	 * @return the group user user, or <code>null</code> if a group user user with the primary key could not be found
	 */
	@Override
	public GroupUserUser fetchByPrimaryKey(GroupUserUserPK groupUserUserPK) {
		return fetchByPrimaryKey((Serializable)groupUserUserPK);
	}

	/**
	 * Returns all the group user users.
	 *
	 * @return the group user users
	 */
	@Override
	public List<GroupUserUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group user users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @return the range of group user users
	 */
	@Override
	public List<GroupUserUser> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the group user users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group user users
	 */
	@Override
	public List<GroupUserUser> findAll(
		int start, int end,
		OrderByComparator<GroupUserUser> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group user users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user users
	 * @param end the upper bound of the range of group user users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group user users
	 */
	@Override
	public List<GroupUserUser> findAll(
		int start, int end, OrderByComparator<GroupUserUser> orderByComparator,
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

		List<GroupUserUser> list = null;

		if (useFinderCache) {
			list = (List<GroupUserUser>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GROUPUSERUSER);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GROUPUSERUSER;

				sql = sql.concat(GroupUserUserModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<GroupUserUser>)QueryUtil.list(
					q, getDialect(), start, end);

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
	 * Removes all the group user users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GroupUserUser groupUserUser : findAll()) {
			remove(groupUserUser);
		}
	}

	/**
	 * Returns the number of group user users.
	 *
	 * @return the number of group user users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GROUPUSERUSER);

				count = (Long)q.uniqueResult();

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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "groupUserUserPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GROUPUSERUSER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GroupUserUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the group user user persistence.
	 */
	@Activate
	public void activate() {
		GroupUserUserModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		GroupUserUserModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] {Long.class.getName()},
			GroupUserUserModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupUser",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupUser",
			new String[] {Long.class.getName()},
			GroupUserUserModelImpl.GROUPUSERID_COLUMN_BITMASK);

		_finderPathCountByGroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupUser",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(GroupUserUserImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = ecoit_qaPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.ecoit.qa.service.model.GroupUserUser"),
			true);
	}

	@Override
	@Reference(
		target = ecoit_qaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ecoit_qaPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_GROUPUSERUSER =
		"SELECT groupUserUser FROM GroupUserUser groupUserUser";

	private static final String _SQL_SELECT_GROUPUSERUSER_WHERE =
		"SELECT groupUserUser FROM GroupUserUser groupUserUser WHERE ";

	private static final String _SQL_COUNT_GROUPUSERUSER =
		"SELECT COUNT(groupUserUser) FROM GroupUserUser groupUserUser";

	private static final String _SQL_COUNT_GROUPUSERUSER_WHERE =
		"SELECT COUNT(groupUserUser) FROM GroupUserUser groupUserUser WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "groupUserUser.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GroupUserUser exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No GroupUserUser exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GroupUserUserPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"groupUserId", "userId"});

	static {
		try {
			Class.forName(ecoit_qaPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}