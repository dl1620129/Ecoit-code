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

package com.ecoit.mr.service.persistence.impl;

import com.ecoit.mr.exception.NoSuchUserGroupException;
import com.ecoit.mr.model.UserGroup;
import com.ecoit.mr.model.impl.UserGroupImpl;
import com.ecoit.mr.model.impl.UserGroupModelImpl;
import com.ecoit.mr.service.persistence.UserGroupPK;
import com.ecoit.mr.service.persistence.UserGroupPersistence;
import com.ecoit.mr.service.persistence.impl.constants.ecoit_mrPersistenceConstants;

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
 * The persistence implementation for the user group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UserGroupPersistence.class)
public class UserGroupPersistenceImpl
	extends BasePersistenceImpl<UserGroup> implements UserGroupPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserGroupUtil</code> to access the user group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserGroupImpl.class.getName();

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
	 * Returns all the user groups where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user groups
	 */
	@Override
	public List<UserGroup> findByUser(long userId) {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user groups where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @return the range of matching user groups
	 */
	@Override
	public List<UserGroup> findByUser(long userId, int start, int end) {
		return findByUser(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user groups where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user groups
	 */
	@Override
	public List<UserGroup> findByUser(
		long userId, int start, int end,
		OrderByComparator<UserGroup> orderByComparator) {

		return findByUser(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user groups where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user groups
	 */
	@Override
	public List<UserGroup> findByUser(
		long userId, int start, int end,
		OrderByComparator<UserGroup> orderByComparator,
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

		List<UserGroup> list = null;

		if (useFinderCache) {
			list = (List<UserGroup>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserGroup userGroup : list) {
					if (userId != userGroup.getUserId()) {
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

			query.append(_SQL_SELECT_USERGROUP_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(UserGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<UserGroup>)QueryUtil.list(
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
	 * Returns the first user group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group
	 * @throws NoSuchUserGroupException if a matching user group could not be found
	 */
	@Override
	public UserGroup findByUser_First(
			long userId, OrderByComparator<UserGroup> orderByComparator)
		throws NoSuchUserGroupException {

		UserGroup userGroup = fetchByUser_First(userId, orderByComparator);

		if (userGroup != null) {
			return userGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchUserGroupException(msg.toString());
	}

	/**
	 * Returns the first user group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group, or <code>null</code> if a matching user group could not be found
	 */
	@Override
	public UserGroup fetchByUser_First(
		long userId, OrderByComparator<UserGroup> orderByComparator) {

		List<UserGroup> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group
	 * @throws NoSuchUserGroupException if a matching user group could not be found
	 */
	@Override
	public UserGroup findByUser_Last(
			long userId, OrderByComparator<UserGroup> orderByComparator)
		throws NoSuchUserGroupException {

		UserGroup userGroup = fetchByUser_Last(userId, orderByComparator);

		if (userGroup != null) {
			return userGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchUserGroupException(msg.toString());
	}

	/**
	 * Returns the last user group in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group, or <code>null</code> if a matching user group could not be found
	 */
	@Override
	public UserGroup fetchByUser_Last(
		long userId, OrderByComparator<UserGroup> orderByComparator) {

		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<UserGroup> list = findByUser(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user groups before and after the current user group in the ordered set where userId = &#63;.
	 *
	 * @param userGroupPK the primary key of the current user group
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user group
	 * @throws NoSuchUserGroupException if a user group with the primary key could not be found
	 */
	@Override
	public UserGroup[] findByUser_PrevAndNext(
			UserGroupPK userGroupPK, long userId,
			OrderByComparator<UserGroup> orderByComparator)
		throws NoSuchUserGroupException {

		UserGroup userGroup = findByPrimaryKey(userGroupPK);

		Session session = null;

		try {
			session = openSession();

			UserGroup[] array = new UserGroupImpl[3];

			array[0] = getByUser_PrevAndNext(
				session, userGroup, userId, orderByComparator, true);

			array[1] = userGroup;

			array[2] = getByUser_PrevAndNext(
				session, userGroup, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserGroup getByUser_PrevAndNext(
		Session session, UserGroup userGroup, long userId,
		OrderByComparator<UserGroup> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERGROUP_WHERE);

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
			query.append(UserGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userGroup)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<UserGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user groups where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUser(long userId) {
		for (UserGroup userGroup :
				findByUser(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userGroup);
		}
	}

	/**
	 * Returns the number of user groups where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user groups
	 */
	@Override
	public int countByUser(long userId) {
		FinderPath finderPath = _finderPathCountByUser;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERGROUP_WHERE);

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
		"userGroup.id.userId = ?";

	private FinderPath _finderPathWithPaginationFindByGroup;
	private FinderPath _finderPathWithoutPaginationFindByGroup;
	private FinderPath _finderPathCountByGroup;

	/**
	 * Returns all the user groups where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the matching user groups
	 */
	@Override
	public List<UserGroup> findByGroup(long userPermissionGroupId) {
		return findByGroup(
			userPermissionGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user groups where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @return the range of matching user groups
	 */
	@Override
	public List<UserGroup> findByGroup(
		long userPermissionGroupId, int start, int end) {

		return findByGroup(userPermissionGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user groups where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user groups
	 */
	@Override
	public List<UserGroup> findByGroup(
		long userPermissionGroupId, int start, int end,
		OrderByComparator<UserGroup> orderByComparator) {

		return findByGroup(
			userPermissionGroupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user groups where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user groups
	 */
	@Override
	public List<UserGroup> findByGroup(
		long userPermissionGroupId, int start, int end,
		OrderByComparator<UserGroup> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroup;
				finderArgs = new Object[] {userPermissionGroupId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroup;
			finderArgs = new Object[] {
				userPermissionGroupId, start, end, orderByComparator
			};
		}

		List<UserGroup> list = null;

		if (useFinderCache) {
			list = (List<UserGroup>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserGroup userGroup : list) {
					if (userPermissionGroupId !=
							userGroup.getUserPermissionGroupId()) {

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

			query.append(_SQL_SELECT_USERGROUP_WHERE);

			query.append(_FINDER_COLUMN_GROUP_USERPERMISSIONGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(UserGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userPermissionGroupId);

				list = (List<UserGroup>)QueryUtil.list(
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
	 * Returns the first user group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group
	 * @throws NoSuchUserGroupException if a matching user group could not be found
	 */
	@Override
	public UserGroup findByGroup_First(
			long userPermissionGroupId,
			OrderByComparator<UserGroup> orderByComparator)
		throws NoSuchUserGroupException {

		UserGroup userGroup = fetchByGroup_First(
			userPermissionGroupId, orderByComparator);

		if (userGroup != null) {
			return userGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userPermissionGroupId=");
		msg.append(userPermissionGroupId);

		msg.append("}");

		throw new NoSuchUserGroupException(msg.toString());
	}

	/**
	 * Returns the first user group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group, or <code>null</code> if a matching user group could not be found
	 */
	@Override
	public UserGroup fetchByGroup_First(
		long userPermissionGroupId,
		OrderByComparator<UserGroup> orderByComparator) {

		List<UserGroup> list = findByGroup(
			userPermissionGroupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group
	 * @throws NoSuchUserGroupException if a matching user group could not be found
	 */
	@Override
	public UserGroup findByGroup_Last(
			long userPermissionGroupId,
			OrderByComparator<UserGroup> orderByComparator)
		throws NoSuchUserGroupException {

		UserGroup userGroup = fetchByGroup_Last(
			userPermissionGroupId, orderByComparator);

		if (userGroup != null) {
			return userGroup;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userPermissionGroupId=");
		msg.append(userPermissionGroupId);

		msg.append("}");

		throw new NoSuchUserGroupException(msg.toString());
	}

	/**
	 * Returns the last user group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group, or <code>null</code> if a matching user group could not be found
	 */
	@Override
	public UserGroup fetchByGroup_Last(
		long userPermissionGroupId,
		OrderByComparator<UserGroup> orderByComparator) {

		int count = countByGroup(userPermissionGroupId);

		if (count == 0) {
			return null;
		}

		List<UserGroup> list = findByGroup(
			userPermissionGroupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user groups before and after the current user group in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userGroupPK the primary key of the current user group
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user group
	 * @throws NoSuchUserGroupException if a user group with the primary key could not be found
	 */
	@Override
	public UserGroup[] findByGroup_PrevAndNext(
			UserGroupPK userGroupPK, long userPermissionGroupId,
			OrderByComparator<UserGroup> orderByComparator)
		throws NoSuchUserGroupException {

		UserGroup userGroup = findByPrimaryKey(userGroupPK);

		Session session = null;

		try {
			session = openSession();

			UserGroup[] array = new UserGroupImpl[3];

			array[0] = getByGroup_PrevAndNext(
				session, userGroup, userPermissionGroupId, orderByComparator,
				true);

			array[1] = userGroup;

			array[2] = getByGroup_PrevAndNext(
				session, userGroup, userPermissionGroupId, orderByComparator,
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

	protected UserGroup getByGroup_PrevAndNext(
		Session session, UserGroup userGroup, long userPermissionGroupId,
		OrderByComparator<UserGroup> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERGROUP_WHERE);

		query.append(_FINDER_COLUMN_GROUP_USERPERMISSIONGROUPID_2);

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
			query.append(UserGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userPermissionGroupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userGroup)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<UserGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user groups where userPermissionGroupId = &#63; from the database.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 */
	@Override
	public void removeByGroup(long userPermissionGroupId) {
		for (UserGroup userGroup :
				findByGroup(
					userPermissionGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(userGroup);
		}
	}

	/**
	 * Returns the number of user groups where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the number of matching user groups
	 */
	@Override
	public int countByGroup(long userPermissionGroupId) {
		FinderPath finderPath = _finderPathCountByGroup;

		Object[] finderArgs = new Object[] {userPermissionGroupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERGROUP_WHERE);

			query.append(_FINDER_COLUMN_GROUP_USERPERMISSIONGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userPermissionGroupId);

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

	private static final String _FINDER_COLUMN_GROUP_USERPERMISSIONGROUPID_2 =
		"userGroup.id.userPermissionGroupId = ?";

	public UserGroupPersistenceImpl() {
		setModelClass(UserGroup.class);

		setModelImplClass(UserGroupImpl.class);
		setModelPKClass(UserGroupPK.class);
	}

	/**
	 * Caches the user group in the entity cache if it is enabled.
	 *
	 * @param userGroup the user group
	 */
	@Override
	public void cacheResult(UserGroup userGroup) {
		entityCache.putResult(
			entityCacheEnabled, UserGroupImpl.class, userGroup.getPrimaryKey(),
			userGroup);

		userGroup.resetOriginalValues();
	}

	/**
	 * Caches the user groups in the entity cache if it is enabled.
	 *
	 * @param userGroups the user groups
	 */
	@Override
	public void cacheResult(List<UserGroup> userGroups) {
		for (UserGroup userGroup : userGroups) {
			if (entityCache.getResult(
					entityCacheEnabled, UserGroupImpl.class,
					userGroup.getPrimaryKey()) == null) {

				cacheResult(userGroup);
			}
			else {
				userGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user groups.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserGroupImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user group.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserGroup userGroup) {
		entityCache.removeResult(
			entityCacheEnabled, UserGroupImpl.class, userGroup.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserGroup> userGroups) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserGroup userGroup : userGroups) {
			entityCache.removeResult(
				entityCacheEnabled, UserGroupImpl.class,
				userGroup.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, UserGroupImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new user group with the primary key. Does not add the user group to the database.
	 *
	 * @param userGroupPK the primary key for the new user group
	 * @return the new user group
	 */
	@Override
	public UserGroup create(UserGroupPK userGroupPK) {
		UserGroup userGroup = new UserGroupImpl();

		userGroup.setNew(true);
		userGroup.setPrimaryKey(userGroupPK);

		return userGroup;
	}

	/**
	 * Removes the user group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userGroupPK the primary key of the user group
	 * @return the user group that was removed
	 * @throws NoSuchUserGroupException if a user group with the primary key could not be found
	 */
	@Override
	public UserGroup remove(UserGroupPK userGroupPK)
		throws NoSuchUserGroupException {

		return remove((Serializable)userGroupPK);
	}

	/**
	 * Removes the user group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user group
	 * @return the user group that was removed
	 * @throws NoSuchUserGroupException if a user group with the primary key could not be found
	 */
	@Override
	public UserGroup remove(Serializable primaryKey)
		throws NoSuchUserGroupException {

		Session session = null;

		try {
			session = openSession();

			UserGroup userGroup = (UserGroup)session.get(
				UserGroupImpl.class, primaryKey);

			if (userGroup == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserGroupException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userGroup);
		}
		catch (NoSuchUserGroupException noSuchEntityException) {
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
	protected UserGroup removeImpl(UserGroup userGroup) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userGroup)) {
				userGroup = (UserGroup)session.get(
					UserGroupImpl.class, userGroup.getPrimaryKeyObj());
			}

			if (userGroup != null) {
				session.delete(userGroup);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userGroup != null) {
			clearCache(userGroup);
		}

		return userGroup;
	}

	@Override
	public UserGroup updateImpl(UserGroup userGroup) {
		boolean isNew = userGroup.isNew();

		if (!(userGroup instanceof UserGroupModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userGroup.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(userGroup);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userGroup proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserGroup implementation " +
					userGroup.getClass());
		}

		UserGroupModelImpl userGroupModelImpl = (UserGroupModelImpl)userGroup;

		Session session = null;

		try {
			session = openSession();

			if (userGroup.isNew()) {
				session.save(userGroup);

				userGroup.setNew(false);
			}
			else {
				userGroup = (UserGroup)session.merge(userGroup);
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
			Object[] args = new Object[] {userGroupModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUser, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUser, args);

			args = new Object[] {userGroupModelImpl.getUserPermissionGroupId()};

			finderCache.removeResult(_finderPathCountByGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((userGroupModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUser.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					userGroupModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUser, args);

				args = new Object[] {userGroupModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUser, args);
			}

			if ((userGroupModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					userGroupModelImpl.getOriginalUserPermissionGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);

				args = new Object[] {
					userGroupModelImpl.getUserPermissionGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, UserGroupImpl.class, userGroup.getPrimaryKey(),
			userGroup, false);

		userGroup.resetOriginalValues();

		return userGroup;
	}

	/**
	 * Returns the user group with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user group
	 * @return the user group
	 * @throws NoSuchUserGroupException if a user group with the primary key could not be found
	 */
	@Override
	public UserGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserGroupException {

		UserGroup userGroup = fetchByPrimaryKey(primaryKey);

		if (userGroup == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserGroupException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userGroup;
	}

	/**
	 * Returns the user group with the primary key or throws a <code>NoSuchUserGroupException</code> if it could not be found.
	 *
	 * @param userGroupPK the primary key of the user group
	 * @return the user group
	 * @throws NoSuchUserGroupException if a user group with the primary key could not be found
	 */
	@Override
	public UserGroup findByPrimaryKey(UserGroupPK userGroupPK)
		throws NoSuchUserGroupException {

		return findByPrimaryKey((Serializable)userGroupPK);
	}

	/**
	 * Returns the user group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userGroupPK the primary key of the user group
	 * @return the user group, or <code>null</code> if a user group with the primary key could not be found
	 */
	@Override
	public UserGroup fetchByPrimaryKey(UserGroupPK userGroupPK) {
		return fetchByPrimaryKey((Serializable)userGroupPK);
	}

	/**
	 * Returns all the user groups.
	 *
	 * @return the user groups
	 */
	@Override
	public List<UserGroup> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @return the range of user groups
	 */
	@Override
	public List<UserGroup> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user groups
	 */
	@Override
	public List<UserGroup> findAll(
		int start, int end, OrderByComparator<UserGroup> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user groups
	 * @param end the upper bound of the range of user groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user groups
	 */
	@Override
	public List<UserGroup> findAll(
		int start, int end, OrderByComparator<UserGroup> orderByComparator,
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

		List<UserGroup> list = null;

		if (useFinderCache) {
			list = (List<UserGroup>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERGROUP);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERGROUP;

				sql = sql.concat(UserGroupModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<UserGroup>)QueryUtil.list(
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
	 * Removes all the user groups from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserGroup userGroup : findAll()) {
			remove(userGroup);
		}
	}

	/**
	 * Returns the number of user groups.
	 *
	 * @return the number of user groups
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERGROUP);

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
		return "userGroupPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERGROUP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserGroupModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user group persistence.
	 */
	@Activate
	public void activate() {
		UserGroupModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		UserGroupModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] {Long.class.getName()},
			UserGroupModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] {Long.class.getName()},
			UserGroupModelImpl.USERPERMISSIONGROUPID_COLUMN_BITMASK);

		_finderPathCountByGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(UserGroupImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = ecoit_mrPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.ecoit.mr.model.UserGroup"),
			true);
	}

	@Override
	@Reference(
		target = ecoit_mrPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ecoit_mrPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_USERGROUP =
		"SELECT userGroup FROM UserGroup userGroup";

	private static final String _SQL_SELECT_USERGROUP_WHERE =
		"SELECT userGroup FROM UserGroup userGroup WHERE ";

	private static final String _SQL_COUNT_USERGROUP =
		"SELECT COUNT(userGroup) FROM UserGroup userGroup";

	private static final String _SQL_COUNT_USERGROUP_WHERE =
		"SELECT COUNT(userGroup) FROM UserGroup userGroup WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userGroup.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserGroup exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserGroup exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserGroupPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"userId", "userPermissionGroupId"});

	static {
		try {
			Class.forName(ecoit_mrPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}