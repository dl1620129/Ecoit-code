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

package com.ecoit.lichcongtac.services.service.persistence.impl;

import com.ecoit.lichcongtac.services.exception.NoSuchUserGroupRelException;
import com.ecoit.lichcongtac.services.model.UserGroupRel;
import com.ecoit.lichcongtac.services.model.impl.UserGroupRelImpl;
import com.ecoit.lichcongtac.services.model.impl.UserGroupRelModelImpl;
import com.ecoit.lichcongtac.services.service.persistence.UserGroupRelPK;
import com.ecoit.lichcongtac.services.service.persistence.UserGroupRelPersistence;
import com.ecoit.lichcongtac.services.service.persistence.impl.constants.ecoit_lichPersistenceConstants;

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
 * The persistence implementation for the user group rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = UserGroupRelPersistence.class)
public class UserGroupRelPersistenceImpl
	extends BasePersistenceImpl<UserGroupRel>
	implements UserGroupRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>UserGroupRelUtil</code> to access the user group rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		UserGroupRelImpl.class.getName();

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
	 * Returns all the user group rels where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the matching user group rels
	 */
	@Override
	public List<UserGroupRel> findByUser(long userId) {
		return findByUser(userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user group rels where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @return the range of matching user group rels
	 */
	@Override
	public List<UserGroupRel> findByUser(long userId, int start, int end) {
		return findByUser(userId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user group rels where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user group rels
	 */
	@Override
	public List<UserGroupRel> findByUser(
		long userId, int start, int end,
		OrderByComparator<UserGroupRel> orderByComparator) {

		return findByUser(userId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user group rels where userId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userId the user ID
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user group rels
	 */
	@Override
	public List<UserGroupRel> findByUser(
		long userId, int start, int end,
		OrderByComparator<UserGroupRel> orderByComparator,
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

		List<UserGroupRel> list = null;

		if (useFinderCache) {
			list = (List<UserGroupRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserGroupRel userGroupRel : list) {
					if (userId != userGroupRel.getUserId()) {
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

			query.append(_SQL_SELECT_USERGROUPREL_WHERE);

			query.append(_FINDER_COLUMN_USER_USERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(UserGroupRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userId);

				list = (List<UserGroupRel>)QueryUtil.list(
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
	 * Returns the first user group rel in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group rel
	 * @throws NoSuchUserGroupRelException if a matching user group rel could not be found
	 */
	@Override
	public UserGroupRel findByUser_First(
			long userId, OrderByComparator<UserGroupRel> orderByComparator)
		throws NoSuchUserGroupRelException {

		UserGroupRel userGroupRel = fetchByUser_First(
			userId, orderByComparator);

		if (userGroupRel != null) {
			return userGroupRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchUserGroupRelException(msg.toString());
	}

	/**
	 * Returns the first user group rel in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group rel, or <code>null</code> if a matching user group rel could not be found
	 */
	@Override
	public UserGroupRel fetchByUser_First(
		long userId, OrderByComparator<UserGroupRel> orderByComparator) {

		List<UserGroupRel> list = findByUser(userId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user group rel in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group rel
	 * @throws NoSuchUserGroupRelException if a matching user group rel could not be found
	 */
	@Override
	public UserGroupRel findByUser_Last(
			long userId, OrderByComparator<UserGroupRel> orderByComparator)
		throws NoSuchUserGroupRelException {

		UserGroupRel userGroupRel = fetchByUser_Last(userId, orderByComparator);

		if (userGroupRel != null) {
			return userGroupRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userId=");
		msg.append(userId);

		msg.append("}");

		throw new NoSuchUserGroupRelException(msg.toString());
	}

	/**
	 * Returns the last user group rel in the ordered set where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group rel, or <code>null</code> if a matching user group rel could not be found
	 */
	@Override
	public UserGroupRel fetchByUser_Last(
		long userId, OrderByComparator<UserGroupRel> orderByComparator) {

		int count = countByUser(userId);

		if (count == 0) {
			return null;
		}

		List<UserGroupRel> list = findByUser(
			userId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user group rels before and after the current user group rel in the ordered set where userId = &#63;.
	 *
	 * @param userGroupRelPK the primary key of the current user group rel
	 * @param userId the user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user group rel
	 * @throws NoSuchUserGroupRelException if a user group rel with the primary key could not be found
	 */
	@Override
	public UserGroupRel[] findByUser_PrevAndNext(
			UserGroupRelPK userGroupRelPK, long userId,
			OrderByComparator<UserGroupRel> orderByComparator)
		throws NoSuchUserGroupRelException {

		UserGroupRel userGroupRel = findByPrimaryKey(userGroupRelPK);

		Session session = null;

		try {
			session = openSession();

			UserGroupRel[] array = new UserGroupRelImpl[3];

			array[0] = getByUser_PrevAndNext(
				session, userGroupRel, userId, orderByComparator, true);

			array[1] = userGroupRel;

			array[2] = getByUser_PrevAndNext(
				session, userGroupRel, userId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected UserGroupRel getByUser_PrevAndNext(
		Session session, UserGroupRel userGroupRel, long userId,
		OrderByComparator<UserGroupRel> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERGROUPREL_WHERE);

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
			query.append(UserGroupRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userGroupRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<UserGroupRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user group rels where userId = &#63; from the database.
	 *
	 * @param userId the user ID
	 */
	@Override
	public void removeByUser(long userId) {
		for (UserGroupRel userGroupRel :
				findByUser(
					userId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(userGroupRel);
		}
	}

	/**
	 * Returns the number of user group rels where userId = &#63;.
	 *
	 * @param userId the user ID
	 * @return the number of matching user group rels
	 */
	@Override
	public int countByUser(long userId) {
		FinderPath finderPath = _finderPathCountByUser;

		Object[] finderArgs = new Object[] {userId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERGROUPREL_WHERE);

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
		"userGroupRel.id.userId = ?";

	private FinderPath _finderPathWithPaginationFindByGroup;
	private FinderPath _finderPathWithoutPaginationFindByGroup;
	private FinderPath _finderPathCountByGroup;

	/**
	 * Returns all the user group rels where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the matching user group rels
	 */
	@Override
	public List<UserGroupRel> findByGroup(long userPermissionGroupId) {
		return findByGroup(
			userPermissionGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @return the range of matching user group rels
	 */
	@Override
	public List<UserGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end) {

		return findByGroup(userPermissionGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the user group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching user group rels
	 */
	@Override
	public List<UserGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end,
		OrderByComparator<UserGroupRel> orderByComparator) {

		return findByGroup(
			userPermissionGroupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching user group rels
	 */
	@Override
	public List<UserGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end,
		OrderByComparator<UserGroupRel> orderByComparator,
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

		List<UserGroupRel> list = null;

		if (useFinderCache) {
			list = (List<UserGroupRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (UserGroupRel userGroupRel : list) {
					if (userPermissionGroupId !=
							userGroupRel.getUserPermissionGroupId()) {

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

			query.append(_SQL_SELECT_USERGROUPREL_WHERE);

			query.append(_FINDER_COLUMN_GROUP_USERPERMISSIONGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(UserGroupRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userPermissionGroupId);

				list = (List<UserGroupRel>)QueryUtil.list(
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
	 * Returns the first user group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group rel
	 * @throws NoSuchUserGroupRelException if a matching user group rel could not be found
	 */
	@Override
	public UserGroupRel findByGroup_First(
			long userPermissionGroupId,
			OrderByComparator<UserGroupRel> orderByComparator)
		throws NoSuchUserGroupRelException {

		UserGroupRel userGroupRel = fetchByGroup_First(
			userPermissionGroupId, orderByComparator);

		if (userGroupRel != null) {
			return userGroupRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userPermissionGroupId=");
		msg.append(userPermissionGroupId);

		msg.append("}");

		throw new NoSuchUserGroupRelException(msg.toString());
	}

	/**
	 * Returns the first user group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching user group rel, or <code>null</code> if a matching user group rel could not be found
	 */
	@Override
	public UserGroupRel fetchByGroup_First(
		long userPermissionGroupId,
		OrderByComparator<UserGroupRel> orderByComparator) {

		List<UserGroupRel> list = findByGroup(
			userPermissionGroupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last user group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group rel
	 * @throws NoSuchUserGroupRelException if a matching user group rel could not be found
	 */
	@Override
	public UserGroupRel findByGroup_Last(
			long userPermissionGroupId,
			OrderByComparator<UserGroupRel> orderByComparator)
		throws NoSuchUserGroupRelException {

		UserGroupRel userGroupRel = fetchByGroup_Last(
			userPermissionGroupId, orderByComparator);

		if (userGroupRel != null) {
			return userGroupRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userPermissionGroupId=");
		msg.append(userPermissionGroupId);

		msg.append("}");

		throw new NoSuchUserGroupRelException(msg.toString());
	}

	/**
	 * Returns the last user group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching user group rel, or <code>null</code> if a matching user group rel could not be found
	 */
	@Override
	public UserGroupRel fetchByGroup_Last(
		long userPermissionGroupId,
		OrderByComparator<UserGroupRel> orderByComparator) {

		int count = countByGroup(userPermissionGroupId);

		if (count == 0) {
			return null;
		}

		List<UserGroupRel> list = findByGroup(
			userPermissionGroupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the user group rels before and after the current user group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userGroupRelPK the primary key of the current user group rel
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next user group rel
	 * @throws NoSuchUserGroupRelException if a user group rel with the primary key could not be found
	 */
	@Override
	public UserGroupRel[] findByGroup_PrevAndNext(
			UserGroupRelPK userGroupRelPK, long userPermissionGroupId,
			OrderByComparator<UserGroupRel> orderByComparator)
		throws NoSuchUserGroupRelException {

		UserGroupRel userGroupRel = findByPrimaryKey(userGroupRelPK);

		Session session = null;

		try {
			session = openSession();

			UserGroupRel[] array = new UserGroupRelImpl[3];

			array[0] = getByGroup_PrevAndNext(
				session, userGroupRel, userPermissionGroupId, orderByComparator,
				true);

			array[1] = userGroupRel;

			array[2] = getByGroup_PrevAndNext(
				session, userGroupRel, userPermissionGroupId, orderByComparator,
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

	protected UserGroupRel getByGroup_PrevAndNext(
		Session session, UserGroupRel userGroupRel, long userPermissionGroupId,
		OrderByComparator<UserGroupRel> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_USERGROUPREL_WHERE);

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
			query.append(UserGroupRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userPermissionGroupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(userGroupRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<UserGroupRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the user group rels where userPermissionGroupId = &#63; from the database.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 */
	@Override
	public void removeByGroup(long userPermissionGroupId) {
		for (UserGroupRel userGroupRel :
				findByGroup(
					userPermissionGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(userGroupRel);
		}
	}

	/**
	 * Returns the number of user group rels where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the number of matching user group rels
	 */
	@Override
	public int countByGroup(long userPermissionGroupId) {
		FinderPath finderPath = _finderPathCountByGroup;

		Object[] finderArgs = new Object[] {userPermissionGroupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_USERGROUPREL_WHERE);

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
		"userGroupRel.id.userPermissionGroupId = ?";

	public UserGroupRelPersistenceImpl() {
		setModelClass(UserGroupRel.class);

		setModelImplClass(UserGroupRelImpl.class);
		setModelPKClass(UserGroupRelPK.class);
	}

	/**
	 * Caches the user group rel in the entity cache if it is enabled.
	 *
	 * @param userGroupRel the user group rel
	 */
	@Override
	public void cacheResult(UserGroupRel userGroupRel) {
		entityCache.putResult(
			entityCacheEnabled, UserGroupRelImpl.class,
			userGroupRel.getPrimaryKey(), userGroupRel);

		userGroupRel.resetOriginalValues();
	}

	/**
	 * Caches the user group rels in the entity cache if it is enabled.
	 *
	 * @param userGroupRels the user group rels
	 */
	@Override
	public void cacheResult(List<UserGroupRel> userGroupRels) {
		for (UserGroupRel userGroupRel : userGroupRels) {
			if (entityCache.getResult(
					entityCacheEnabled, UserGroupRelImpl.class,
					userGroupRel.getPrimaryKey()) == null) {

				cacheResult(userGroupRel);
			}
			else {
				userGroupRel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all user group rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(UserGroupRelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the user group rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(UserGroupRel userGroupRel) {
		entityCache.removeResult(
			entityCacheEnabled, UserGroupRelImpl.class,
			userGroupRel.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<UserGroupRel> userGroupRels) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (UserGroupRel userGroupRel : userGroupRels) {
			entityCache.removeResult(
				entityCacheEnabled, UserGroupRelImpl.class,
				userGroupRel.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, UserGroupRelImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new user group rel with the primary key. Does not add the user group rel to the database.
	 *
	 * @param userGroupRelPK the primary key for the new user group rel
	 * @return the new user group rel
	 */
	@Override
	public UserGroupRel create(UserGroupRelPK userGroupRelPK) {
		UserGroupRel userGroupRel = new UserGroupRelImpl();

		userGroupRel.setNew(true);
		userGroupRel.setPrimaryKey(userGroupRelPK);

		return userGroupRel;
	}

	/**
	 * Removes the user group rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userGroupRelPK the primary key of the user group rel
	 * @return the user group rel that was removed
	 * @throws NoSuchUserGroupRelException if a user group rel with the primary key could not be found
	 */
	@Override
	public UserGroupRel remove(UserGroupRelPK userGroupRelPK)
		throws NoSuchUserGroupRelException {

		return remove((Serializable)userGroupRelPK);
	}

	/**
	 * Removes the user group rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the user group rel
	 * @return the user group rel that was removed
	 * @throws NoSuchUserGroupRelException if a user group rel with the primary key could not be found
	 */
	@Override
	public UserGroupRel remove(Serializable primaryKey)
		throws NoSuchUserGroupRelException {

		Session session = null;

		try {
			session = openSession();

			UserGroupRel userGroupRel = (UserGroupRel)session.get(
				UserGroupRelImpl.class, primaryKey);

			if (userGroupRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchUserGroupRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(userGroupRel);
		}
		catch (NoSuchUserGroupRelException noSuchEntityException) {
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
	protected UserGroupRel removeImpl(UserGroupRel userGroupRel) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(userGroupRel)) {
				userGroupRel = (UserGroupRel)session.get(
					UserGroupRelImpl.class, userGroupRel.getPrimaryKeyObj());
			}

			if (userGroupRel != null) {
				session.delete(userGroupRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (userGroupRel != null) {
			clearCache(userGroupRel);
		}

		return userGroupRel;
	}

	@Override
	public UserGroupRel updateImpl(UserGroupRel userGroupRel) {
		boolean isNew = userGroupRel.isNew();

		if (!(userGroupRel instanceof UserGroupRelModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(userGroupRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					userGroupRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in userGroupRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom UserGroupRel implementation " +
					userGroupRel.getClass());
		}

		UserGroupRelModelImpl userGroupRelModelImpl =
			(UserGroupRelModelImpl)userGroupRel;

		Session session = null;

		try {
			session = openSession();

			if (userGroupRel.isNew()) {
				session.save(userGroupRel);

				userGroupRel.setNew(false);
			}
			else {
				userGroupRel = (UserGroupRel)session.merge(userGroupRel);
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
			Object[] args = new Object[] {userGroupRelModelImpl.getUserId()};

			finderCache.removeResult(_finderPathCountByUser, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUser, args);

			args = new Object[] {
				userGroupRelModelImpl.getUserPermissionGroupId()
			};

			finderCache.removeResult(_finderPathCountByGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((userGroupRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUser.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					userGroupRelModelImpl.getOriginalUserId()
				};

				finderCache.removeResult(_finderPathCountByUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUser, args);

				args = new Object[] {userGroupRelModelImpl.getUserId()};

				finderCache.removeResult(_finderPathCountByUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUser, args);
			}

			if ((userGroupRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					userGroupRelModelImpl.getOriginalUserPermissionGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);

				args = new Object[] {
					userGroupRelModelImpl.getUserPermissionGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, UserGroupRelImpl.class,
			userGroupRel.getPrimaryKey(), userGroupRel, false);

		userGroupRel.resetOriginalValues();

		return userGroupRel;
	}

	/**
	 * Returns the user group rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the user group rel
	 * @return the user group rel
	 * @throws NoSuchUserGroupRelException if a user group rel with the primary key could not be found
	 */
	@Override
	public UserGroupRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchUserGroupRelException {

		UserGroupRel userGroupRel = fetchByPrimaryKey(primaryKey);

		if (userGroupRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchUserGroupRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return userGroupRel;
	}

	/**
	 * Returns the user group rel with the primary key or throws a <code>NoSuchUserGroupRelException</code> if it could not be found.
	 *
	 * @param userGroupRelPK the primary key of the user group rel
	 * @return the user group rel
	 * @throws NoSuchUserGroupRelException if a user group rel with the primary key could not be found
	 */
	@Override
	public UserGroupRel findByPrimaryKey(UserGroupRelPK userGroupRelPK)
		throws NoSuchUserGroupRelException {

		return findByPrimaryKey((Serializable)userGroupRelPK);
	}

	/**
	 * Returns the user group rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userGroupRelPK the primary key of the user group rel
	 * @return the user group rel, or <code>null</code> if a user group rel with the primary key could not be found
	 */
	@Override
	public UserGroupRel fetchByPrimaryKey(UserGroupRelPK userGroupRelPK) {
		return fetchByPrimaryKey((Serializable)userGroupRelPK);
	}

	/**
	 * Returns all the user group rels.
	 *
	 * @return the user group rels
	 */
	@Override
	public List<UserGroupRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the user group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @return the range of user group rels
	 */
	@Override
	public List<UserGroupRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the user group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of user group rels
	 */
	@Override
	public List<UserGroupRel> findAll(
		int start, int end, OrderByComparator<UserGroupRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the user group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>UserGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of user group rels
	 * @param end the upper bound of the range of user group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of user group rels
	 */
	@Override
	public List<UserGroupRel> findAll(
		int start, int end, OrderByComparator<UserGroupRel> orderByComparator,
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

		List<UserGroupRel> list = null;

		if (useFinderCache) {
			list = (List<UserGroupRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_USERGROUPREL);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_USERGROUPREL;

				sql = sql.concat(UserGroupRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<UserGroupRel>)QueryUtil.list(
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
	 * Removes all the user group rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (UserGroupRel userGroupRel : findAll()) {
			remove(userGroupRel);
		}
	}

	/**
	 * Returns the number of user group rels.
	 *
	 * @return the number of user group rels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_USERGROUPREL);

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
		return "userGroupRelPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_USERGROUPREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return UserGroupRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the user group rel persistence.
	 */
	@Activate
	public void activate() {
		UserGroupRelModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		UserGroupRelModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserGroupRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserGroupRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserGroupRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUser",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserGroupRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUser",
			new String[] {Long.class.getName()},
			UserGroupRelModelImpl.USERID_COLUMN_BITMASK);

		_finderPathCountByUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUser",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserGroupRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, UserGroupRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] {Long.class.getName()},
			UserGroupRelModelImpl.USERPERMISSIONGROUPID_COLUMN_BITMASK);

		_finderPathCountByGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(UserGroupRelImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = ecoit_lichPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.ecoit.lichcongtac.services.model.UserGroupRel"),
			true);
	}

	@Override
	@Reference(
		target = ecoit_lichPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ecoit_lichPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_USERGROUPREL =
		"SELECT userGroupRel FROM UserGroupRel userGroupRel";

	private static final String _SQL_SELECT_USERGROUPREL_WHERE =
		"SELECT userGroupRel FROM UserGroupRel userGroupRel WHERE ";

	private static final String _SQL_COUNT_USERGROUPREL =
		"SELECT COUNT(userGroupRel) FROM UserGroupRel userGroupRel";

	private static final String _SQL_COUNT_USERGROUPREL_WHERE =
		"SELECT COUNT(userGroupRel) FROM UserGroupRel userGroupRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "userGroupRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No UserGroupRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No UserGroupRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		UserGroupRelPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"userId", "userPermissionGroupId"});

	static {
		try {
			Class.forName(ecoit_lichPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}