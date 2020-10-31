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
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import com.software.cms.exception.NoSuchGroupUserUsersException;
import com.software.cms.model.GroupUserUsers;
import com.software.cms.model.impl.GroupUserUsersImpl;
import com.software.cms.model.impl.GroupUserUsersModelImpl;
import com.software.cms.service.persistence.GroupUserUsersPK;
import com.software.cms.service.persistence.GroupUserUsersPersistence;
import com.software.cms.service.persistence.impl.constants.soft_cmsPersistenceConstants;

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
 * The persistence implementation for the group user users service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @generated
 */
@Component(service = GroupUserUsersPersistence.class)
public class GroupUserUsersPersistenceImpl
	extends BasePersistenceImpl<GroupUserUsers>
	implements GroupUserUsersPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GroupUserUsersUtil</code> to access the group user users persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GroupUserUsersImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroup_GroupUser;
	private FinderPath _finderPathWithoutPaginationFindByGroup_GroupUser;
	private FinderPath _finderPathCountByGroup_GroupUser;

	/**
	 * Returns all the group user userses where groupId = &#63; and groupUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @return the matching group user userses
	 */
	@Override
	public List<GroupUserUsers> findByGroup_GroupUser(
		long groupId, long groupUserId) {

		return findByGroup_GroupUser(
			groupId, groupUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group user userses where groupId = &#63; and groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @return the range of matching group user userses
	 */
	@Override
	public List<GroupUserUsers> findByGroup_GroupUser(
		long groupId, long groupUserId, int start, int end) {

		return findByGroup_GroupUser(groupId, groupUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the group user userses where groupId = &#63; and groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user userses
	 */
	@Override
	public List<GroupUserUsers> findByGroup_GroupUser(
		long groupId, long groupUserId, int start, int end,
		OrderByComparator<GroupUserUsers> orderByComparator) {

		return findByGroup_GroupUser(
			groupId, groupUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group user userses where groupId = &#63; and groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user userses
	 */
	@Override
	public List<GroupUserUsers> findByGroup_GroupUser(
		long groupId, long groupUserId, int start, int end,
		OrderByComparator<GroupUserUsers> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroup_GroupUser;
				finderArgs = new Object[] {groupId, groupUserId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroup_GroupUser;
			finderArgs = new Object[] {
				groupId, groupUserId, start, end, orderByComparator
			};
		}

		List<GroupUserUsers> list = null;

		if (useFinderCache) {
			list = (List<GroupUserUsers>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GroupUserUsers groupUserUsers : list) {
					if ((groupId != groupUserUsers.getGroupId()) ||
						(groupUserId != groupUserUsers.getGroupUserId())) {

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

			sb.append(_SQL_SELECT_GROUPUSERUSERS_WHERE);

			sb.append(_FINDER_COLUMN_GROUP_GROUPUSER_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUP_GROUPUSER_GROUPUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GroupUserUsersModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(groupUserId);

				list = (List<GroupUserUsers>)QueryUtil.list(
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
	 * Returns the first group user users in the ordered set where groupId = &#63; and groupUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user users
	 * @throws NoSuchGroupUserUsersException if a matching group user users could not be found
	 */
	@Override
	public GroupUserUsers findByGroup_GroupUser_First(
			long groupId, long groupUserId,
			OrderByComparator<GroupUserUsers> orderByComparator)
		throws NoSuchGroupUserUsersException {

		GroupUserUsers groupUserUsers = fetchByGroup_GroupUser_First(
			groupId, groupUserId, orderByComparator);

		if (groupUserUsers != null) {
			return groupUserUsers;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", groupUserId=");
		sb.append(groupUserId);

		sb.append("}");

		throw new NoSuchGroupUserUsersException(sb.toString());
	}

	/**
	 * Returns the first group user users in the ordered set where groupId = &#63; and groupUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user users, or <code>null</code> if a matching group user users could not be found
	 */
	@Override
	public GroupUserUsers fetchByGroup_GroupUser_First(
		long groupId, long groupUserId,
		OrderByComparator<GroupUserUsers> orderByComparator) {

		List<GroupUserUsers> list = findByGroup_GroupUser(
			groupId, groupUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last group user users in the ordered set where groupId = &#63; and groupUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user users
	 * @throws NoSuchGroupUserUsersException if a matching group user users could not be found
	 */
	@Override
	public GroupUserUsers findByGroup_GroupUser_Last(
			long groupId, long groupUserId,
			OrderByComparator<GroupUserUsers> orderByComparator)
		throws NoSuchGroupUserUsersException {

		GroupUserUsers groupUserUsers = fetchByGroup_GroupUser_Last(
			groupId, groupUserId, orderByComparator);

		if (groupUserUsers != null) {
			return groupUserUsers;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", groupUserId=");
		sb.append(groupUserId);

		sb.append("}");

		throw new NoSuchGroupUserUsersException(sb.toString());
	}

	/**
	 * Returns the last group user users in the ordered set where groupId = &#63; and groupUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user users, or <code>null</code> if a matching group user users could not be found
	 */
	@Override
	public GroupUserUsers fetchByGroup_GroupUser_Last(
		long groupId, long groupUserId,
		OrderByComparator<GroupUserUsers> orderByComparator) {

		int count = countByGroup_GroupUser(groupId, groupUserId);

		if (count == 0) {
			return null;
		}

		List<GroupUserUsers> list = findByGroup_GroupUser(
			groupId, groupUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the group user userses before and after the current group user users in the ordered set where groupId = &#63; and groupUserId = &#63;.
	 *
	 * @param groupUserUsersPK the primary key of the current group user users
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user users
	 * @throws NoSuchGroupUserUsersException if a group user users with the primary key could not be found
	 */
	@Override
	public GroupUserUsers[] findByGroup_GroupUser_PrevAndNext(
			GroupUserUsersPK groupUserUsersPK, long groupId, long groupUserId,
			OrderByComparator<GroupUserUsers> orderByComparator)
		throws NoSuchGroupUserUsersException {

		GroupUserUsers groupUserUsers = findByPrimaryKey(groupUserUsersPK);

		Session session = null;

		try {
			session = openSession();

			GroupUserUsers[] array = new GroupUserUsersImpl[3];

			array[0] = getByGroup_GroupUser_PrevAndNext(
				session, groupUserUsers, groupId, groupUserId,
				orderByComparator, true);

			array[1] = groupUserUsers;

			array[2] = getByGroup_GroupUser_PrevAndNext(
				session, groupUserUsers, groupId, groupUserId,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GroupUserUsers getByGroup_GroupUser_PrevAndNext(
		Session session, GroupUserUsers groupUserUsers, long groupId,
		long groupUserId, OrderByComparator<GroupUserUsers> orderByComparator,
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

		sb.append(_SQL_SELECT_GROUPUSERUSERS_WHERE);

		sb.append(_FINDER_COLUMN_GROUP_GROUPUSER_GROUPID_2);

		sb.append(_FINDER_COLUMN_GROUP_GROUPUSER_GROUPUSERID_2);

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
			sb.append(GroupUserUsersModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(groupUserId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						groupUserUsers)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GroupUserUsers> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the group user userses where groupId = &#63; and groupUserId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 */
	@Override
	public void removeByGroup_GroupUser(long groupId, long groupUserId) {
		for (GroupUserUsers groupUserUsers :
				findByGroup_GroupUser(
					groupId, groupUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(groupUserUsers);
		}
	}

	/**
	 * Returns the number of group user userses where groupId = &#63; and groupUserId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupUserId the group user ID
	 * @return the number of matching group user userses
	 */
	@Override
	public int countByGroup_GroupUser(long groupId, long groupUserId) {
		FinderPath finderPath = _finderPathCountByGroup_GroupUser;

		Object[] finderArgs = new Object[] {groupId, groupUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_GROUPUSERUSERS_WHERE);

			sb.append(_FINDER_COLUMN_GROUP_GROUPUSER_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUP_GROUPUSER_GROUPUSERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(groupUserId);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPUSER_GROUPID_2 =
		"groupUserUsers.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUP_GROUPUSER_GROUPUSERID_2 =
		"groupUserUsers.id.groupUserId = ?";

	private FinderPath _finderPathWithPaginationFindByGroup_User;
	private FinderPath _finderPathWithoutPaginationFindByGroup_User;
	private FinderPath _finderPathCountByGroup_User;

	/**
	 * Returns all the group user userses where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the matching group user userses
	 */
	@Override
	public List<GroupUserUsers> findByGroup_User(long groupId, long userId) {
		return findByGroup_User(
			groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group user userses where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @return the range of matching group user userses
	 */
	@Override
	public List<GroupUserUsers> findByGroup_User(
		long groupId, long userId, int start, int end) {

		return findByGroup_User(groupId, userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the group user userses where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user userses
	 */
	@Override
	public List<GroupUserUsers> findByGroup_User(
		long groupId, long userId, int start, int end,
		OrderByComparator<GroupUserUsers> orderByComparator) {

		return findByGroup_User(
			groupId, userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group user userses where groupId = &#63; and userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user userses
	 */
	@Override
	public List<GroupUserUsers> findByGroup_User(
		long groupId, long userId, int start, int end,
		OrderByComparator<GroupUserUsers> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroup_User;
				finderArgs = new Object[] {groupId, userId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroup_User;
			finderArgs = new Object[] {
				groupId, userId, start, end, orderByComparator
			};
		}

		List<GroupUserUsers> list = null;

		if (useFinderCache) {
			list = (List<GroupUserUsers>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GroupUserUsers groupUserUsers : list) {
					if ((groupId != groupUserUsers.getGroupId()) ||
						(userId != groupUserUsers.getUserId())) {

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

			sb.append(_SQL_SELECT_GROUPUSERUSERS_WHERE);

			sb.append(_FINDER_COLUMN_GROUP_USER_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUP_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(GroupUserUsersModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

				list = (List<GroupUserUsers>)QueryUtil.list(
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
	 * Returns the first group user users in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user users
	 * @throws NoSuchGroupUserUsersException if a matching group user users could not be found
	 */
	@Override
	public GroupUserUsers findByGroup_User_First(
			long groupId, long userId,
			OrderByComparator<GroupUserUsers> orderByComparator)
		throws NoSuchGroupUserUsersException {

		GroupUserUsers groupUserUsers = fetchByGroup_User_First(
			groupId, userId, orderByComparator);

		if (groupUserUsers != null) {
			return groupUserUsers;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchGroupUserUsersException(sb.toString());
	}

	/**
	 * Returns the first group user users in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user users, or <code>null</code> if a matching group user users could not be found
	 */
	@Override
	public GroupUserUsers fetchByGroup_User_First(
		long groupId, long userId,
		OrderByComparator<GroupUserUsers> orderByComparator) {

		List<GroupUserUsers> list = findByGroup_User(
			groupId, userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last group user users in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user users
	 * @throws NoSuchGroupUserUsersException if a matching group user users could not be found
	 */
	@Override
	public GroupUserUsers findByGroup_User_Last(
			long groupId, long userId,
			OrderByComparator<GroupUserUsers> orderByComparator)
		throws NoSuchGroupUserUsersException {

		GroupUserUsers groupUserUsers = fetchByGroup_User_Last(
			groupId, userId, orderByComparator);

		if (groupUserUsers != null) {
			return groupUserUsers;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("groupId=");
		sb.append(groupId);

		sb.append(", userId=");
		sb.append(userId);

		sb.append("}");

		throw new NoSuchGroupUserUsersException(sb.toString());
	}

	/**
	 * Returns the last group user users in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user users, or <code>null</code> if a matching group user users could not be found
	 */
	@Override
	public GroupUserUsers fetchByGroup_User_Last(
		long groupId, long userId,
		OrderByComparator<GroupUserUsers> orderByComparator) {

		int count = countByGroup_User(groupId, userId);

		if (count == 0) {
			return null;
		}

		List<GroupUserUsers> list = findByGroup_User(
			groupId, userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the group user userses before and after the current group user users in the ordered set where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupUserUsersPK the primary key of the current group user users
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user users
	 * @throws NoSuchGroupUserUsersException if a group user users with the primary key could not be found
	 */
	@Override
	public GroupUserUsers[] findByGroup_User_PrevAndNext(
			GroupUserUsersPK groupUserUsersPK, long groupId, long userId,
			OrderByComparator<GroupUserUsers> orderByComparator)
		throws NoSuchGroupUserUsersException {

		GroupUserUsers groupUserUsers = findByPrimaryKey(groupUserUsersPK);

		Session session = null;

		try {
			session = openSession();

			GroupUserUsers[] array = new GroupUserUsersImpl[3];

			array[0] = getByGroup_User_PrevAndNext(
				session, groupUserUsers, groupId, userId, orderByComparator,
				true);

			array[1] = groupUserUsers;

			array[2] = getByGroup_User_PrevAndNext(
				session, groupUserUsers, groupId, userId, orderByComparator,
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

	protected GroupUserUsers getByGroup_User_PrevAndNext(
		Session session, GroupUserUsers groupUserUsers, long groupId,
		long userId, OrderByComparator<GroupUserUsers> orderByComparator,
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

		sb.append(_SQL_SELECT_GROUPUSERUSERS_WHERE);

		sb.append(_FINDER_COLUMN_GROUP_USER_GROUPID_2);

		sb.append(_FINDER_COLUMN_GROUP_USER_USERID_2);

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
			sb.append(GroupUserUsersModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(groupId);

		queryPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						groupUserUsers)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<GroupUserUsers> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the group user userses where groupId = &#63; and userId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 */
	@Override
	public void removeByGroup_User(long groupId, long userId) {
		for (GroupUserUsers groupUserUsers :
				findByGroup_User(
					groupId, userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(groupUserUsers);
		}
	}

	/**
	 * Returns the number of group user userses where groupId = &#63; and userId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param userId the user ID
	 * @return the number of matching group user userses
	 */
	@Override
	public int countByGroup_User(long groupId, long userId) {
		FinderPath finderPath = _finderPathCountByGroup_User;

		Object[] finderArgs = new Object[] {groupId, userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_GROUPUSERUSERS_WHERE);

			sb.append(_FINDER_COLUMN_GROUP_USER_GROUPID_2);

			sb.append(_FINDER_COLUMN_GROUP_USER_USERID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(groupId);

				queryPos.add(userId);

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

	private static final String _FINDER_COLUMN_GROUP_USER_GROUPID_2 =
		"groupUserUsers.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUP_USER_USERID_2 =
		"groupUserUsers.id.userId = ?";

	public GroupUserUsersPersistenceImpl() {
		setModelClass(GroupUserUsers.class);

		setModelImplClass(GroupUserUsersImpl.class);
		setModelPKClass(GroupUserUsersPK.class);
	}

	/**
	 * Caches the group user users in the entity cache if it is enabled.
	 *
	 * @param groupUserUsers the group user users
	 */
	@Override
	public void cacheResult(GroupUserUsers groupUserUsers) {
		entityCache.putResult(
			entityCacheEnabled, GroupUserUsersImpl.class,
			groupUserUsers.getPrimaryKey(), groupUserUsers);

		groupUserUsers.resetOriginalValues();
	}

	/**
	 * Caches the group user userses in the entity cache if it is enabled.
	 *
	 * @param groupUserUserses the group user userses
	 */
	@Override
	public void cacheResult(List<GroupUserUsers> groupUserUserses) {
		for (GroupUserUsers groupUserUsers : groupUserUserses) {
			if (entityCache.getResult(
					entityCacheEnabled, GroupUserUsersImpl.class,
					groupUserUsers.getPrimaryKey()) == null) {

				cacheResult(groupUserUsers);
			}
			else {
				groupUserUsers.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all group user userses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GroupUserUsersImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the group user users.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GroupUserUsers groupUserUsers) {
		entityCache.removeResult(
			entityCacheEnabled, GroupUserUsersImpl.class,
			groupUserUsers.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GroupUserUsers> groupUserUserses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GroupUserUsers groupUserUsers : groupUserUserses) {
			entityCache.removeResult(
				entityCacheEnabled, GroupUserUsersImpl.class,
				groupUserUsers.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, GroupUserUsersImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new group user users with the primary key. Does not add the group user users to the database.
	 *
	 * @param groupUserUsersPK the primary key for the new group user users
	 * @return the new group user users
	 */
	@Override
	public GroupUserUsers create(GroupUserUsersPK groupUserUsersPK) {
		GroupUserUsers groupUserUsers = new GroupUserUsersImpl();

		groupUserUsers.setNew(true);
		groupUserUsers.setPrimaryKey(groupUserUsersPK);

		return groupUserUsers;
	}

	/**
	 * Removes the group user users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserUsersPK the primary key of the group user users
	 * @return the group user users that was removed
	 * @throws NoSuchGroupUserUsersException if a group user users with the primary key could not be found
	 */
	@Override
	public GroupUserUsers remove(GroupUserUsersPK groupUserUsersPK)
		throws NoSuchGroupUserUsersException {

		return remove((Serializable)groupUserUsersPK);
	}

	/**
	 * Removes the group user users with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the group user users
	 * @return the group user users that was removed
	 * @throws NoSuchGroupUserUsersException if a group user users with the primary key could not be found
	 */
	@Override
	public GroupUserUsers remove(Serializable primaryKey)
		throws NoSuchGroupUserUsersException {

		Session session = null;

		try {
			session = openSession();

			GroupUserUsers groupUserUsers = (GroupUserUsers)session.get(
				GroupUserUsersImpl.class, primaryKey);

			if (groupUserUsers == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGroupUserUsersException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(groupUserUsers);
		}
		catch (NoSuchGroupUserUsersException noSuchEntityException) {
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
	protected GroupUserUsers removeImpl(GroupUserUsers groupUserUsers) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(groupUserUsers)) {
				groupUserUsers = (GroupUserUsers)session.get(
					GroupUserUsersImpl.class,
					groupUserUsers.getPrimaryKeyObj());
			}

			if (groupUserUsers != null) {
				session.delete(groupUserUsers);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (groupUserUsers != null) {
			clearCache(groupUserUsers);
		}

		return groupUserUsers;
	}

	@Override
	public GroupUserUsers updateImpl(GroupUserUsers groupUserUsers) {
		boolean isNew = groupUserUsers.isNew();

		if (!(groupUserUsers instanceof GroupUserUsersModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(groupUserUsers.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					groupUserUsers);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in groupUserUsers proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GroupUserUsers implementation " +
					groupUserUsers.getClass());
		}

		GroupUserUsersModelImpl groupUserUsersModelImpl =
			(GroupUserUsersModelImpl)groupUserUsers;

		Session session = null;

		try {
			session = openSession();

			if (groupUserUsers.isNew()) {
				session.save(groupUserUsers);

				groupUserUsers.setNew(false);
			}
			else {
				groupUserUsers = (GroupUserUsers)session.merge(groupUserUsers);
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
			Object[] args = new Object[] {
				groupUserUsersModelImpl.getGroupId(),
				groupUserUsersModelImpl.getGroupUserId()
			};

			finderCache.removeResult(_finderPathCountByGroup_GroupUser, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup_GroupUser, args);

			args = new Object[] {
				groupUserUsersModelImpl.getGroupId(),
				groupUserUsersModelImpl.getUserId()
			};

			finderCache.removeResult(_finderPathCountByGroup_User, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup_User, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((groupUserUsersModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup_GroupUser.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					groupUserUsersModelImpl.getOriginalGroupId(),
					groupUserUsersModelImpl.getOriginalGroupUserId()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_GroupUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_GroupUser, args);

				args = new Object[] {
					groupUserUsersModelImpl.getGroupId(),
					groupUserUsersModelImpl.getGroupUserId()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_GroupUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_GroupUser, args);
			}

			if ((groupUserUsersModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup_User.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					groupUserUsersModelImpl.getOriginalGroupId(),
					groupUserUsersModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByGroup_User, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_User, args);

				args = new Object[] {
					groupUserUsersModelImpl.getGroupId(),
					groupUserUsersModelImpl.getUserId()
				};

				finderCache.removeResult(_finderPathCountByGroup_User, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_User, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, GroupUserUsersImpl.class,
			groupUserUsers.getPrimaryKey(), groupUserUsers, false);

		groupUserUsers.resetOriginalValues();

		return groupUserUsers;
	}

	/**
	 * Returns the group user users with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the group user users
	 * @return the group user users
	 * @throws NoSuchGroupUserUsersException if a group user users with the primary key could not be found
	 */
	@Override
	public GroupUserUsers findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGroupUserUsersException {

		GroupUserUsers groupUserUsers = fetchByPrimaryKey(primaryKey);

		if (groupUserUsers == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGroupUserUsersException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return groupUserUsers;
	}

	/**
	 * Returns the group user users with the primary key or throws a <code>NoSuchGroupUserUsersException</code> if it could not be found.
	 *
	 * @param groupUserUsersPK the primary key of the group user users
	 * @return the group user users
	 * @throws NoSuchGroupUserUsersException if a group user users with the primary key could not be found
	 */
	@Override
	public GroupUserUsers findByPrimaryKey(GroupUserUsersPK groupUserUsersPK)
		throws NoSuchGroupUserUsersException {

		return findByPrimaryKey((Serializable)groupUserUsersPK);
	}

	/**
	 * Returns the group user users with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupUserUsersPK the primary key of the group user users
	 * @return the group user users, or <code>null</code> if a group user users with the primary key could not be found
	 */
	@Override
	public GroupUserUsers fetchByPrimaryKey(GroupUserUsersPK groupUserUsersPK) {
		return fetchByPrimaryKey((Serializable)groupUserUsersPK);
	}

	/**
	 * Returns all the group user userses.
	 *
	 * @return the group user userses
	 */
	@Override
	public List<GroupUserUsers> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group user userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @return the range of group user userses
	 */
	@Override
	public List<GroupUserUsers> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the group user userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group user userses
	 */
	@Override
	public List<GroupUserUsers> findAll(
		int start, int end,
		OrderByComparator<GroupUserUsers> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group user userses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserUsersModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user userses
	 * @param end the upper bound of the range of group user userses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group user userses
	 */
	@Override
	public List<GroupUserUsers> findAll(
		int start, int end, OrderByComparator<GroupUserUsers> orderByComparator,
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

		List<GroupUserUsers> list = null;

		if (useFinderCache) {
			list = (List<GroupUserUsers>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_GROUPUSERUSERS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_GROUPUSERUSERS;

				sql = sql.concat(GroupUserUsersModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<GroupUserUsers>)QueryUtil.list(
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
	 * Removes all the group user userses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GroupUserUsers groupUserUsers : findAll()) {
			remove(groupUserUsers);
		}
	}

	/**
	 * Returns the number of group user userses.
	 *
	 * @return the number of group user userses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_GROUPUSERUSERS);

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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "groupUserUsersPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GROUPUSERUSERS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GroupUserUsersModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the group user users persistence.
	 */
	@Activate
	public void activate() {
		GroupUserUsersModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		GroupUserUsersModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserUsersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserUsersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGroup_GroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserUsersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup_GroupUser",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup_GroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserUsersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup_GroupUser",
			new String[] {Long.class.getName(), Long.class.getName()},
			GroupUserUsersModelImpl.GROUPID_COLUMN_BITMASK |
			GroupUserUsersModelImpl.GROUPUSERID_COLUMN_BITMASK);

		_finderPathCountByGroup_GroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup_GroupUser",
			new String[] {Long.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByGroup_User = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserUsersImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup_User",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup_User = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserUsersImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup_User",
			new String[] {Long.class.getName(), Long.class.getName()},
			GroupUserUsersModelImpl.GROUPID_COLUMN_BITMASK |
			GroupUserUsersModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByGroup_User = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup_User",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(GroupUserUsersImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.software.cms.model.GroupUserUsers"),
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

	private static final String _SQL_SELECT_GROUPUSERUSERS =
		"SELECT groupUserUsers FROM GroupUserUsers groupUserUsers";

	private static final String _SQL_SELECT_GROUPUSERUSERS_WHERE =
		"SELECT groupUserUsers FROM GroupUserUsers groupUserUsers WHERE ";

	private static final String _SQL_COUNT_GROUPUSERUSERS =
		"SELECT COUNT(groupUserUsers) FROM GroupUserUsers groupUserUsers";

	private static final String _SQL_COUNT_GROUPUSERUSERS_WHERE =
		"SELECT COUNT(groupUserUsers) FROM GroupUserUsers groupUserUsers WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "groupUserUsers.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GroupUserUsers exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No GroupUserUsers exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GroupUserUsersPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"groupUserId", "userId"});

	static {
		try {
			Class.forName(soft_cmsPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}