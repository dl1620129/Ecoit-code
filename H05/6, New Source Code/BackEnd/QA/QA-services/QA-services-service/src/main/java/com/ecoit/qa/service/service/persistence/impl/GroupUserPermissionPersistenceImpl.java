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

import com.ecoit.qa.service.exception.NoSuchGroupUserPermissionException;
import com.ecoit.qa.service.model.GroupUserPermission;
import com.ecoit.qa.service.model.impl.GroupUserPermissionImpl;
import com.ecoit.qa.service.model.impl.GroupUserPermissionModelImpl;
import com.ecoit.qa.service.service.persistence.GroupUserPermissionPK;
import com.ecoit.qa.service.service.persistence.GroupUserPermissionPersistence;
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
 * The persistence implementation for the group user permission service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = GroupUserPermissionPersistence.class)
public class GroupUserPermissionPersistenceImpl
	extends BasePersistenceImpl<GroupUserPermission>
	implements GroupUserPermissionPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GroupUserPermissionUtil</code> to access the group user permission persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GroupUserPermissionImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByPermission;
	private FinderPath _finderPathWithoutPaginationFindByPermission;
	private FinderPath _finderPathCountByPermission;

	/**
	 * Returns all the group user permissions where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @return the matching group user permissions
	 */
	@Override
	public List<GroupUserPermission> findByPermission(long permissionId) {
		return findByPermission(
			permissionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group user permissions where permissionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param permissionId the permission ID
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @return the range of matching group user permissions
	 */
	@Override
	public List<GroupUserPermission> findByPermission(
		long permissionId, int start, int end) {

		return findByPermission(permissionId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the group user permissions where permissionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param permissionId the permission ID
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user permissions
	 */
	@Override
	public List<GroupUserPermission> findByPermission(
		long permissionId, int start, int end,
		OrderByComparator<GroupUserPermission> orderByComparator) {

		return findByPermission(
			permissionId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group user permissions where permissionId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param permissionId the permission ID
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user permissions
	 */
	@Override
	public List<GroupUserPermission> findByPermission(
		long permissionId, int start, int end,
		OrderByComparator<GroupUserPermission> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPermission;
				finderArgs = new Object[] {permissionId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPermission;
			finderArgs = new Object[] {
				permissionId, start, end, orderByComparator
			};
		}

		List<GroupUserPermission> list = null;

		if (useFinderCache) {
			list = (List<GroupUserPermission>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GroupUserPermission groupUserPermission : list) {
					if (permissionId != groupUserPermission.getPermissionId()) {
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

			query.append(_SQL_SELECT_GROUPUSERPERMISSION_WHERE);

			query.append(_FINDER_COLUMN_PERMISSION_PERMISSIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(GroupUserPermissionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(permissionId);

				list = (List<GroupUserPermission>)QueryUtil.list(
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
	 * Returns the first group user permission in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user permission
	 * @throws NoSuchGroupUserPermissionException if a matching group user permission could not be found
	 */
	@Override
	public GroupUserPermission findByPermission_First(
			long permissionId,
			OrderByComparator<GroupUserPermission> orderByComparator)
		throws NoSuchGroupUserPermissionException {

		GroupUserPermission groupUserPermission = fetchByPermission_First(
			permissionId, orderByComparator);

		if (groupUserPermission != null) {
			return groupUserPermission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("permissionId=");
		msg.append(permissionId);

		msg.append("}");

		throw new NoSuchGroupUserPermissionException(msg.toString());
	}

	/**
	 * Returns the first group user permission in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user permission, or <code>null</code> if a matching group user permission could not be found
	 */
	@Override
	public GroupUserPermission fetchByPermission_First(
		long permissionId,
		OrderByComparator<GroupUserPermission> orderByComparator) {

		List<GroupUserPermission> list = findByPermission(
			permissionId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last group user permission in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user permission
	 * @throws NoSuchGroupUserPermissionException if a matching group user permission could not be found
	 */
	@Override
	public GroupUserPermission findByPermission_Last(
			long permissionId,
			OrderByComparator<GroupUserPermission> orderByComparator)
		throws NoSuchGroupUserPermissionException {

		GroupUserPermission groupUserPermission = fetchByPermission_Last(
			permissionId, orderByComparator);

		if (groupUserPermission != null) {
			return groupUserPermission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("permissionId=");
		msg.append(permissionId);

		msg.append("}");

		throw new NoSuchGroupUserPermissionException(msg.toString());
	}

	/**
	 * Returns the last group user permission in the ordered set where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user permission, or <code>null</code> if a matching group user permission could not be found
	 */
	@Override
	public GroupUserPermission fetchByPermission_Last(
		long permissionId,
		OrderByComparator<GroupUserPermission> orderByComparator) {

		int count = countByPermission(permissionId);

		if (count == 0) {
			return null;
		}

		List<GroupUserPermission> list = findByPermission(
			permissionId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the group user permissions before and after the current group user permission in the ordered set where permissionId = &#63;.
	 *
	 * @param groupUserPermissionPK the primary key of the current group user permission
	 * @param permissionId the permission ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user permission
	 * @throws NoSuchGroupUserPermissionException if a group user permission with the primary key could not be found
	 */
	@Override
	public GroupUserPermission[] findByPermission_PrevAndNext(
			GroupUserPermissionPK groupUserPermissionPK, long permissionId,
			OrderByComparator<GroupUserPermission> orderByComparator)
		throws NoSuchGroupUserPermissionException {

		GroupUserPermission groupUserPermission = findByPrimaryKey(
			groupUserPermissionPK);

		Session session = null;

		try {
			session = openSession();

			GroupUserPermission[] array = new GroupUserPermissionImpl[3];

			array[0] = getByPermission_PrevAndNext(
				session, groupUserPermission, permissionId, orderByComparator,
				true);

			array[1] = groupUserPermission;

			array[2] = getByPermission_PrevAndNext(
				session, groupUserPermission, permissionId, orderByComparator,
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

	protected GroupUserPermission getByPermission_PrevAndNext(
		Session session, GroupUserPermission groupUserPermission,
		long permissionId,
		OrderByComparator<GroupUserPermission> orderByComparator,
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

		query.append(_SQL_SELECT_GROUPUSERPERMISSION_WHERE);

		query.append(_FINDER_COLUMN_PERMISSION_PERMISSIONID_2);

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
			query.append(GroupUserPermissionModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(permissionId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						groupUserPermission)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<GroupUserPermission> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the group user permissions where permissionId = &#63; from the database.
	 *
	 * @param permissionId the permission ID
	 */
	@Override
	public void removeByPermission(long permissionId) {
		for (GroupUserPermission groupUserPermission :
				findByPermission(
					permissionId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(groupUserPermission);
		}
	}

	/**
	 * Returns the number of group user permissions where permissionId = &#63;.
	 *
	 * @param permissionId the permission ID
	 * @return the number of matching group user permissions
	 */
	@Override
	public int countByPermission(long permissionId) {
		FinderPath finderPath = _finderPathCountByPermission;

		Object[] finderArgs = new Object[] {permissionId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GROUPUSERPERMISSION_WHERE);

			query.append(_FINDER_COLUMN_PERMISSION_PERMISSIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(permissionId);

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

	private static final String _FINDER_COLUMN_PERMISSION_PERMISSIONID_2 =
		"groupUserPermission.id.permissionId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupUser;
	private FinderPath _finderPathWithoutPaginationFindByGroupUser;
	private FinderPath _finderPathCountByGroupUser;

	/**
	 * Returns all the group user permissions where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching group user permissions
	 */
	@Override
	public List<GroupUserPermission> findByGroupUser(long groupUserId) {
		return findByGroupUser(
			groupUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group user permissions where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @return the range of matching group user permissions
	 */
	@Override
	public List<GroupUserPermission> findByGroupUser(
		long groupUserId, int start, int end) {

		return findByGroupUser(groupUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the group user permissions where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user permissions
	 */
	@Override
	public List<GroupUserPermission> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupUserPermission> orderByComparator) {

		return findByGroupUser(
			groupUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group user permissions where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user permissions
	 */
	@Override
	public List<GroupUserPermission> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupUserPermission> orderByComparator,
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

		List<GroupUserPermission> list = null;

		if (useFinderCache) {
			list = (List<GroupUserPermission>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GroupUserPermission groupUserPermission : list) {
					if (groupUserId != groupUserPermission.getGroupUserId()) {
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

			query.append(_SQL_SELECT_GROUPUSERPERMISSION_WHERE);

			query.append(_FINDER_COLUMN_GROUPUSER_GROUPUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(GroupUserPermissionModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupUserId);

				list = (List<GroupUserPermission>)QueryUtil.list(
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
	 * Returns the first group user permission in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user permission
	 * @throws NoSuchGroupUserPermissionException if a matching group user permission could not be found
	 */
	@Override
	public GroupUserPermission findByGroupUser_First(
			long groupUserId,
			OrderByComparator<GroupUserPermission> orderByComparator)
		throws NoSuchGroupUserPermissionException {

		GroupUserPermission groupUserPermission = fetchByGroupUser_First(
			groupUserId, orderByComparator);

		if (groupUserPermission != null) {
			return groupUserPermission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupUserId=");
		msg.append(groupUserId);

		msg.append("}");

		throw new NoSuchGroupUserPermissionException(msg.toString());
	}

	/**
	 * Returns the first group user permission in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user permission, or <code>null</code> if a matching group user permission could not be found
	 */
	@Override
	public GroupUserPermission fetchByGroupUser_First(
		long groupUserId,
		OrderByComparator<GroupUserPermission> orderByComparator) {

		List<GroupUserPermission> list = findByGroupUser(
			groupUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last group user permission in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user permission
	 * @throws NoSuchGroupUserPermissionException if a matching group user permission could not be found
	 */
	@Override
	public GroupUserPermission findByGroupUser_Last(
			long groupUserId,
			OrderByComparator<GroupUserPermission> orderByComparator)
		throws NoSuchGroupUserPermissionException {

		GroupUserPermission groupUserPermission = fetchByGroupUser_Last(
			groupUserId, orderByComparator);

		if (groupUserPermission != null) {
			return groupUserPermission;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupUserId=");
		msg.append(groupUserId);

		msg.append("}");

		throw new NoSuchGroupUserPermissionException(msg.toString());
	}

	/**
	 * Returns the last group user permission in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user permission, or <code>null</code> if a matching group user permission could not be found
	 */
	@Override
	public GroupUserPermission fetchByGroupUser_Last(
		long groupUserId,
		OrderByComparator<GroupUserPermission> orderByComparator) {

		int count = countByGroupUser(groupUserId);

		if (count == 0) {
			return null;
		}

		List<GroupUserPermission> list = findByGroupUser(
			groupUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the group user permissions before and after the current group user permission in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserPermissionPK the primary key of the current group user permission
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user permission
	 * @throws NoSuchGroupUserPermissionException if a group user permission with the primary key could not be found
	 */
	@Override
	public GroupUserPermission[] findByGroupUser_PrevAndNext(
			GroupUserPermissionPK groupUserPermissionPK, long groupUserId,
			OrderByComparator<GroupUserPermission> orderByComparator)
		throws NoSuchGroupUserPermissionException {

		GroupUserPermission groupUserPermission = findByPrimaryKey(
			groupUserPermissionPK);

		Session session = null;

		try {
			session = openSession();

			GroupUserPermission[] array = new GroupUserPermissionImpl[3];

			array[0] = getByGroupUser_PrevAndNext(
				session, groupUserPermission, groupUserId, orderByComparator,
				true);

			array[1] = groupUserPermission;

			array[2] = getByGroupUser_PrevAndNext(
				session, groupUserPermission, groupUserId, orderByComparator,
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

	protected GroupUserPermission getByGroupUser_PrevAndNext(
		Session session, GroupUserPermission groupUserPermission,
		long groupUserId,
		OrderByComparator<GroupUserPermission> orderByComparator,
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

		query.append(_SQL_SELECT_GROUPUSERPERMISSION_WHERE);

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
			query.append(GroupUserPermissionModelImpl.ORDER_BY_JPQL);
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
						groupUserPermission)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<GroupUserPermission> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the group user permissions where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	@Override
	public void removeByGroupUser(long groupUserId) {
		for (GroupUserPermission groupUserPermission :
				findByGroupUser(
					groupUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(groupUserPermission);
		}
	}

	/**
	 * Returns the number of group user permissions where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching group user permissions
	 */
	@Override
	public int countByGroupUser(long groupUserId) {
		FinderPath finderPath = _finderPathCountByGroupUser;

		Object[] finderArgs = new Object[] {groupUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GROUPUSERPERMISSION_WHERE);

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
		"groupUserPermission.id.groupUserId = ?";

	public GroupUserPermissionPersistenceImpl() {
		setModelClass(GroupUserPermission.class);

		setModelImplClass(GroupUserPermissionImpl.class);
		setModelPKClass(GroupUserPermissionPK.class);
	}

	/**
	 * Caches the group user permission in the entity cache if it is enabled.
	 *
	 * @param groupUserPermission the group user permission
	 */
	@Override
	public void cacheResult(GroupUserPermission groupUserPermission) {
		entityCache.putResult(
			entityCacheEnabled, GroupUserPermissionImpl.class,
			groupUserPermission.getPrimaryKey(), groupUserPermission);

		groupUserPermission.resetOriginalValues();
	}

	/**
	 * Caches the group user permissions in the entity cache if it is enabled.
	 *
	 * @param groupUserPermissions the group user permissions
	 */
	@Override
	public void cacheResult(List<GroupUserPermission> groupUserPermissions) {
		for (GroupUserPermission groupUserPermission : groupUserPermissions) {
			if (entityCache.getResult(
					entityCacheEnabled, GroupUserPermissionImpl.class,
					groupUserPermission.getPrimaryKey()) == null) {

				cacheResult(groupUserPermission);
			}
			else {
				groupUserPermission.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all group user permissions.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GroupUserPermissionImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the group user permission.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GroupUserPermission groupUserPermission) {
		entityCache.removeResult(
			entityCacheEnabled, GroupUserPermissionImpl.class,
			groupUserPermission.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GroupUserPermission> groupUserPermissions) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GroupUserPermission groupUserPermission : groupUserPermissions) {
			entityCache.removeResult(
				entityCacheEnabled, GroupUserPermissionImpl.class,
				groupUserPermission.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, GroupUserPermissionImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new group user permission with the primary key. Does not add the group user permission to the database.
	 *
	 * @param groupUserPermissionPK the primary key for the new group user permission
	 * @return the new group user permission
	 */
	@Override
	public GroupUserPermission create(
		GroupUserPermissionPK groupUserPermissionPK) {

		GroupUserPermission groupUserPermission = new GroupUserPermissionImpl();

		groupUserPermission.setNew(true);
		groupUserPermission.setPrimaryKey(groupUserPermissionPK);

		return groupUserPermission;
	}

	/**
	 * Removes the group user permission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserPermissionPK the primary key of the group user permission
	 * @return the group user permission that was removed
	 * @throws NoSuchGroupUserPermissionException if a group user permission with the primary key could not be found
	 */
	@Override
	public GroupUserPermission remove(
			GroupUserPermissionPK groupUserPermissionPK)
		throws NoSuchGroupUserPermissionException {

		return remove((Serializable)groupUserPermissionPK);
	}

	/**
	 * Removes the group user permission with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the group user permission
	 * @return the group user permission that was removed
	 * @throws NoSuchGroupUserPermissionException if a group user permission with the primary key could not be found
	 */
	@Override
	public GroupUserPermission remove(Serializable primaryKey)
		throws NoSuchGroupUserPermissionException {

		Session session = null;

		try {
			session = openSession();

			GroupUserPermission groupUserPermission =
				(GroupUserPermission)session.get(
					GroupUserPermissionImpl.class, primaryKey);

			if (groupUserPermission == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGroupUserPermissionException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(groupUserPermission);
		}
		catch (NoSuchGroupUserPermissionException noSuchEntityException) {
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
	protected GroupUserPermission removeImpl(
		GroupUserPermission groupUserPermission) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(groupUserPermission)) {
				groupUserPermission = (GroupUserPermission)session.get(
					GroupUserPermissionImpl.class,
					groupUserPermission.getPrimaryKeyObj());
			}

			if (groupUserPermission != null) {
				session.delete(groupUserPermission);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (groupUserPermission != null) {
			clearCache(groupUserPermission);
		}

		return groupUserPermission;
	}

	@Override
	public GroupUserPermission updateImpl(
		GroupUserPermission groupUserPermission) {

		boolean isNew = groupUserPermission.isNew();

		if (!(groupUserPermission instanceof GroupUserPermissionModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(groupUserPermission.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					groupUserPermission);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in groupUserPermission proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GroupUserPermission implementation " +
					groupUserPermission.getClass());
		}

		GroupUserPermissionModelImpl groupUserPermissionModelImpl =
			(GroupUserPermissionModelImpl)groupUserPermission;

		Session session = null;

		try {
			session = openSession();

			if (groupUserPermission.isNew()) {
				session.save(groupUserPermission);

				groupUserPermission.setNew(false);
			}
			else {
				groupUserPermission = (GroupUserPermission)session.merge(
					groupUserPermission);
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
				groupUserPermissionModelImpl.getPermissionId()
			};

			finderCache.removeResult(_finderPathCountByPermission, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByPermission, args);

			args = new Object[] {groupUserPermissionModelImpl.getGroupUserId()};

			finderCache.removeResult(_finderPathCountByGroupUser, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupUser, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((groupUserPermissionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByPermission.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					groupUserPermissionModelImpl.getOriginalPermissionId()
				};

				finderCache.removeResult(_finderPathCountByPermission, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPermission, args);

				args = new Object[] {
					groupUserPermissionModelImpl.getPermissionId()
				};

				finderCache.removeResult(_finderPathCountByPermission, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPermission, args);
			}

			if ((groupUserPermissionModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupUser.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					groupUserPermissionModelImpl.getOriginalGroupUserId()
				};

				finderCache.removeResult(_finderPathCountByGroupUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupUser, args);

				args = new Object[] {
					groupUserPermissionModelImpl.getGroupUserId()
				};

				finderCache.removeResult(_finderPathCountByGroupUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupUser, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, GroupUserPermissionImpl.class,
			groupUserPermission.getPrimaryKey(), groupUserPermission, false);

		groupUserPermission.resetOriginalValues();

		return groupUserPermission;
	}

	/**
	 * Returns the group user permission with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the group user permission
	 * @return the group user permission
	 * @throws NoSuchGroupUserPermissionException if a group user permission with the primary key could not be found
	 */
	@Override
	public GroupUserPermission findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGroupUserPermissionException {

		GroupUserPermission groupUserPermission = fetchByPrimaryKey(primaryKey);

		if (groupUserPermission == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGroupUserPermissionException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return groupUserPermission;
	}

	/**
	 * Returns the group user permission with the primary key or throws a <code>NoSuchGroupUserPermissionException</code> if it could not be found.
	 *
	 * @param groupUserPermissionPK the primary key of the group user permission
	 * @return the group user permission
	 * @throws NoSuchGroupUserPermissionException if a group user permission with the primary key could not be found
	 */
	@Override
	public GroupUserPermission findByPrimaryKey(
			GroupUserPermissionPK groupUserPermissionPK)
		throws NoSuchGroupUserPermissionException {

		return findByPrimaryKey((Serializable)groupUserPermissionPK);
	}

	/**
	 * Returns the group user permission with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupUserPermissionPK the primary key of the group user permission
	 * @return the group user permission, or <code>null</code> if a group user permission with the primary key could not be found
	 */
	@Override
	public GroupUserPermission fetchByPrimaryKey(
		GroupUserPermissionPK groupUserPermissionPK) {

		return fetchByPrimaryKey((Serializable)groupUserPermissionPK);
	}

	/**
	 * Returns all the group user permissions.
	 *
	 * @return the group user permissions
	 */
	@Override
	public List<GroupUserPermission> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group user permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @return the range of group user permissions
	 */
	@Override
	public List<GroupUserPermission> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the group user permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group user permissions
	 */
	@Override
	public List<GroupUserPermission> findAll(
		int start, int end,
		OrderByComparator<GroupUserPermission> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group user permissions.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserPermissionModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user permissions
	 * @param end the upper bound of the range of group user permissions (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group user permissions
	 */
	@Override
	public List<GroupUserPermission> findAll(
		int start, int end,
		OrderByComparator<GroupUserPermission> orderByComparator,
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

		List<GroupUserPermission> list = null;

		if (useFinderCache) {
			list = (List<GroupUserPermission>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GROUPUSERPERMISSION);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GROUPUSERPERMISSION;

				sql = sql.concat(GroupUserPermissionModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<GroupUserPermission>)QueryUtil.list(
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
	 * Removes all the group user permissions from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GroupUserPermission groupUserPermission : findAll()) {
			remove(groupUserPermission);
		}
	}

	/**
	 * Returns the number of group user permissions.
	 *
	 * @return the number of group user permissions
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GROUPUSERPERMISSION);

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
		return "groupUserPermissionPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GROUPUSERPERMISSION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GroupUserPermissionModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the group user permission persistence.
	 */
	@Activate
	public void activate() {
		GroupUserPermissionModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		GroupUserPermissionModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GroupUserPermissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GroupUserPermissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByPermission = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GroupUserPermissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByPermission",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByPermission = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GroupUserPermissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByPermission",
			new String[] {Long.class.getName()},
			GroupUserPermissionModelImpl.PERMISSIONID_COLUMN_BITMASK);

		_finderPathCountByPermission = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByPermission",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GroupUserPermissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupUser",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			GroupUserPermissionImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupUser",
			new String[] {Long.class.getName()},
			GroupUserPermissionModelImpl.GROUPUSERID_COLUMN_BITMASK);

		_finderPathCountByGroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupUser",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(GroupUserPermissionImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.qa.service.model.GroupUserPermission"),
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

	private static final String _SQL_SELECT_GROUPUSERPERMISSION =
		"SELECT groupUserPermission FROM GroupUserPermission groupUserPermission";

	private static final String _SQL_SELECT_GROUPUSERPERMISSION_WHERE =
		"SELECT groupUserPermission FROM GroupUserPermission groupUserPermission WHERE ";

	private static final String _SQL_COUNT_GROUPUSERPERMISSION =
		"SELECT COUNT(groupUserPermission) FROM GroupUserPermission groupUserPermission";

	private static final String _SQL_COUNT_GROUPUSERPERMISSION_WHERE =
		"SELECT COUNT(groupUserPermission) FROM GroupUserPermission groupUserPermission WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "groupUserPermission.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GroupUserPermission exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No GroupUserPermission exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GroupUserPermissionPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"groupUserId", "permissionId"});

	static {
		try {
			Class.forName(ecoit_qaPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}