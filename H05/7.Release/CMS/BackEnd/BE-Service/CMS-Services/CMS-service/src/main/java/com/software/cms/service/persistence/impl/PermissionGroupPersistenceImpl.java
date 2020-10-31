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

import com.software.cms.exception.NoSuchPermissionGroupException;
import com.software.cms.model.PermissionGroup;
import com.software.cms.model.impl.PermissionGroupImpl;
import com.software.cms.model.impl.PermissionGroupModelImpl;
import com.software.cms.service.persistence.PermissionGroupPK;
import com.software.cms.service.persistence.PermissionGroupPersistence;
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
 * The persistence implementation for the permission group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @generated
 */
@Component(service = PermissionGroupPersistence.class)
public class PermissionGroupPersistenceImpl
	extends BasePersistenceImpl<PermissionGroup>
	implements PermissionGroupPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PermissionGroupUtil</code> to access the permission group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PermissionGroupImpl.class.getName();

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
	 * Returns all the permission groups where groupId = &#63; and groupuserid = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @return the matching permission groups
	 */
	@Override
	public List<PermissionGroup> findByGroup_GroupUser(
		long groupId, long groupuserid) {

		return findByGroup_GroupUser(
			groupId, groupuserid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the permission groups where groupId = &#63; and groupuserid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @return the range of matching permission groups
	 */
	@Override
	public List<PermissionGroup> findByGroup_GroupUser(
		long groupId, long groupuserid, int start, int end) {

		return findByGroup_GroupUser(groupId, groupuserid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the permission groups where groupId = &#63; and groupuserid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permission groups
	 */
	@Override
	public List<PermissionGroup> findByGroup_GroupUser(
		long groupId, long groupuserid, int start, int end,
		OrderByComparator<PermissionGroup> orderByComparator) {

		return findByGroup_GroupUser(
			groupId, groupuserid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the permission groups where groupId = &#63; and groupuserid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching permission groups
	 */
	@Override
	public List<PermissionGroup> findByGroup_GroupUser(
		long groupId, long groupuserid, int start, int end,
		OrderByComparator<PermissionGroup> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroup_GroupUser;
				finderArgs = new Object[] {groupId, groupuserid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroup_GroupUser;
			finderArgs = new Object[] {
				groupId, groupuserid, start, end, orderByComparator
			};
		}

		List<PermissionGroup> list = null;

		if (useFinderCache) {
			list = (List<PermissionGroup>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PermissionGroup permissionGroup : list) {
					if ((groupId != permissionGroup.getGroupId()) ||
						(groupuserid != permissionGroup.getGroupuserid())) {

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
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_PERMISSIONGROUP_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPUSER_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUP_GROUPUSER_GROUPUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(PermissionGroupModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(groupuserid);

				list = (List<PermissionGroup>)QueryUtil.list(
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
	 * Returns the first permission group in the ordered set where groupId = &#63; and groupuserid = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission group
	 * @throws NoSuchPermissionGroupException if a matching permission group could not be found
	 */
	@Override
	public PermissionGroup findByGroup_GroupUser_First(
			long groupId, long groupuserid,
			OrderByComparator<PermissionGroup> orderByComparator)
		throws NoSuchPermissionGroupException {

		PermissionGroup permissionGroup = fetchByGroup_GroupUser_First(
			groupId, groupuserid, orderByComparator);

		if (permissionGroup != null) {
			return permissionGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", groupuserid=");
		msg.append(groupuserid);

		msg.append("}");

		throw new NoSuchPermissionGroupException(msg.toString());
	}

	/**
	 * Returns the first permission group in the ordered set where groupId = &#63; and groupuserid = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission group, or <code>null</code> if a matching permission group could not be found
	 */
	@Override
	public PermissionGroup fetchByGroup_GroupUser_First(
		long groupId, long groupuserid,
		OrderByComparator<PermissionGroup> orderByComparator) {

		List<PermissionGroup> list = findByGroup_GroupUser(
			groupId, groupuserid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last permission group in the ordered set where groupId = &#63; and groupuserid = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission group
	 * @throws NoSuchPermissionGroupException if a matching permission group could not be found
	 */
	@Override
	public PermissionGroup findByGroup_GroupUser_Last(
			long groupId, long groupuserid,
			OrderByComparator<PermissionGroup> orderByComparator)
		throws NoSuchPermissionGroupException {

		PermissionGroup permissionGroup = fetchByGroup_GroupUser_Last(
			groupId, groupuserid, orderByComparator);

		if (permissionGroup != null) {
			return permissionGroup;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", groupuserid=");
		msg.append(groupuserid);

		msg.append("}");

		throw new NoSuchPermissionGroupException(msg.toString());
	}

	/**
	 * Returns the last permission group in the ordered set where groupId = &#63; and groupuserid = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission group, or <code>null</code> if a matching permission group could not be found
	 */
	@Override
	public PermissionGroup fetchByGroup_GroupUser_Last(
		long groupId, long groupuserid,
		OrderByComparator<PermissionGroup> orderByComparator) {

		int count = countByGroup_GroupUser(groupId, groupuserid);

		if (count == 0) {
			return null;
		}

		List<PermissionGroup> list = findByGroup_GroupUser(
			groupId, groupuserid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the permission groups before and after the current permission group in the ordered set where groupId = &#63; and groupuserid = &#63;.
	 *
	 * @param permissionGroupPK the primary key of the current permission group
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permission group
	 * @throws NoSuchPermissionGroupException if a permission group with the primary key could not be found
	 */
	@Override
	public PermissionGroup[] findByGroup_GroupUser_PrevAndNext(
			PermissionGroupPK permissionGroupPK, long groupId, long groupuserid,
			OrderByComparator<PermissionGroup> orderByComparator)
		throws NoSuchPermissionGroupException {

		PermissionGroup permissionGroup = findByPrimaryKey(permissionGroupPK);

		Session session = null;

		try {
			session = openSession();

			PermissionGroup[] array = new PermissionGroupImpl[3];

			array[0] = getByGroup_GroupUser_PrevAndNext(
				session, permissionGroup, groupId, groupuserid,
				orderByComparator, true);

			array[1] = permissionGroup;

			array[2] = getByGroup_GroupUser_PrevAndNext(
				session, permissionGroup, groupId, groupuserid,
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

	protected PermissionGroup getByGroup_GroupUser_PrevAndNext(
		Session session, PermissionGroup permissionGroup, long groupId,
		long groupuserid, OrderByComparator<PermissionGroup> orderByComparator,
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

		query.append(_SQL_SELECT_PERMISSIONGROUP_WHERE);

		query.append(_FINDER_COLUMN_GROUP_GROUPUSER_GROUPID_2);

		query.append(_FINDER_COLUMN_GROUP_GROUPUSER_GROUPUSERID_2);

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
			query.append(PermissionGroupModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		qPos.add(groupuserid);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						permissionGroup)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<PermissionGroup> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the permission groups where groupId = &#63; and groupuserid = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 */
	@Override
	public void removeByGroup_GroupUser(long groupId, long groupuserid) {
		for (PermissionGroup permissionGroup :
				findByGroup_GroupUser(
					groupId, groupuserid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(permissionGroup);
		}
	}

	/**
	 * Returns the number of permission groups where groupId = &#63; and groupuserid = &#63;.
	 *
	 * @param groupId the group ID
	 * @param groupuserid the groupuserid
	 * @return the number of matching permission groups
	 */
	@Override
	public int countByGroup_GroupUser(long groupId, long groupuserid) {
		FinderPath finderPath = _finderPathCountByGroup_GroupUser;

		Object[] finderArgs = new Object[] {groupId, groupuserid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_PERMISSIONGROUP_WHERE);

			query.append(_FINDER_COLUMN_GROUP_GROUPUSER_GROUPID_2);

			query.append(_FINDER_COLUMN_GROUP_GROUPUSER_GROUPUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				qPos.add(groupuserid);

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

	private static final String _FINDER_COLUMN_GROUP_GROUPUSER_GROUPID_2 =
		"permissionGroup.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUP_GROUPUSER_GROUPUSERID_2 =
		"permissionGroup.id.groupuserid = ?";

	public PermissionGroupPersistenceImpl() {
		setModelClass(PermissionGroup.class);

		setModelImplClass(PermissionGroupImpl.class);
		setModelPKClass(PermissionGroupPK.class);
	}

	/**
	 * Caches the permission group in the entity cache if it is enabled.
	 *
	 * @param permissionGroup the permission group
	 */
	@Override
	public void cacheResult(PermissionGroup permissionGroup) {
		entityCache.putResult(
			entityCacheEnabled, PermissionGroupImpl.class,
			permissionGroup.getPrimaryKey(), permissionGroup);

		permissionGroup.resetOriginalValues();
	}

	/**
	 * Caches the permission groups in the entity cache if it is enabled.
	 *
	 * @param permissionGroups the permission groups
	 */
	@Override
	public void cacheResult(List<PermissionGroup> permissionGroups) {
		for (PermissionGroup permissionGroup : permissionGroups) {
			if (entityCache.getResult(
					entityCacheEnabled, PermissionGroupImpl.class,
					permissionGroup.getPrimaryKey()) == null) {

				cacheResult(permissionGroup);
			}
			else {
				permissionGroup.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all permission groups.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PermissionGroupImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the permission group.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PermissionGroup permissionGroup) {
		entityCache.removeResult(
			entityCacheEnabled, PermissionGroupImpl.class,
			permissionGroup.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PermissionGroup> permissionGroups) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PermissionGroup permissionGroup : permissionGroups) {
			entityCache.removeResult(
				entityCacheEnabled, PermissionGroupImpl.class,
				permissionGroup.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, PermissionGroupImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new permission group with the primary key. Does not add the permission group to the database.
	 *
	 * @param permissionGroupPK the primary key for the new permission group
	 * @return the new permission group
	 */
	@Override
	public PermissionGroup create(PermissionGroupPK permissionGroupPK) {
		PermissionGroup permissionGroup = new PermissionGroupImpl();

		permissionGroup.setNew(true);
		permissionGroup.setPrimaryKey(permissionGroupPK);

		return permissionGroup;
	}

	/**
	 * Removes the permission group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param permissionGroupPK the primary key of the permission group
	 * @return the permission group that was removed
	 * @throws NoSuchPermissionGroupException if a permission group with the primary key could not be found
	 */
	@Override
	public PermissionGroup remove(PermissionGroupPK permissionGroupPK)
		throws NoSuchPermissionGroupException {

		return remove((Serializable)permissionGroupPK);
	}

	/**
	 * Removes the permission group with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the permission group
	 * @return the permission group that was removed
	 * @throws NoSuchPermissionGroupException if a permission group with the primary key could not be found
	 */
	@Override
	public PermissionGroup remove(Serializable primaryKey)
		throws NoSuchPermissionGroupException {

		Session session = null;

		try {
			session = openSession();

			PermissionGroup permissionGroup = (PermissionGroup)session.get(
				PermissionGroupImpl.class, primaryKey);

			if (permissionGroup == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPermissionGroupException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(permissionGroup);
		}
		catch (NoSuchPermissionGroupException noSuchEntityException) {
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
	protected PermissionGroup removeImpl(PermissionGroup permissionGroup) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(permissionGroup)) {
				permissionGroup = (PermissionGroup)session.get(
					PermissionGroupImpl.class,
					permissionGroup.getPrimaryKeyObj());
			}

			if (permissionGroup != null) {
				session.delete(permissionGroup);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (permissionGroup != null) {
			clearCache(permissionGroup);
		}

		return permissionGroup;
	}

	@Override
	public PermissionGroup updateImpl(PermissionGroup permissionGroup) {
		boolean isNew = permissionGroup.isNew();

		if (!(permissionGroup instanceof PermissionGroupModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(permissionGroup.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					permissionGroup);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in permissionGroup proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PermissionGroup implementation " +
					permissionGroup.getClass());
		}

		PermissionGroupModelImpl permissionGroupModelImpl =
			(PermissionGroupModelImpl)permissionGroup;

		Session session = null;

		try {
			session = openSession();

			if (permissionGroup.isNew()) {
				session.save(permissionGroup);

				permissionGroup.setNew(false);
			}
			else {
				permissionGroup = (PermissionGroup)session.merge(
					permissionGroup);
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
				permissionGroupModelImpl.getGroupId(),
				permissionGroupModelImpl.getGroupuserid()
			};

			finderCache.removeResult(_finderPathCountByGroup_GroupUser, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup_GroupUser, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((permissionGroupModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup_GroupUser.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					permissionGroupModelImpl.getOriginalGroupId(),
					permissionGroupModelImpl.getOriginalGroupuserid()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_GroupUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_GroupUser, args);

				args = new Object[] {
					permissionGroupModelImpl.getGroupId(),
					permissionGroupModelImpl.getGroupuserid()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_GroupUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_GroupUser, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, PermissionGroupImpl.class,
			permissionGroup.getPrimaryKey(), permissionGroup, false);

		permissionGroup.resetOriginalValues();

		return permissionGroup;
	}

	/**
	 * Returns the permission group with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the permission group
	 * @return the permission group
	 * @throws NoSuchPermissionGroupException if a permission group with the primary key could not be found
	 */
	@Override
	public PermissionGroup findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPermissionGroupException {

		PermissionGroup permissionGroup = fetchByPrimaryKey(primaryKey);

		if (permissionGroup == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPermissionGroupException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return permissionGroup;
	}

	/**
	 * Returns the permission group with the primary key or throws a <code>NoSuchPermissionGroupException</code> if it could not be found.
	 *
	 * @param permissionGroupPK the primary key of the permission group
	 * @return the permission group
	 * @throws NoSuchPermissionGroupException if a permission group with the primary key could not be found
	 */
	@Override
	public PermissionGroup findByPrimaryKey(PermissionGroupPK permissionGroupPK)
		throws NoSuchPermissionGroupException {

		return findByPrimaryKey((Serializable)permissionGroupPK);
	}

	/**
	 * Returns the permission group with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param permissionGroupPK the primary key of the permission group
	 * @return the permission group, or <code>null</code> if a permission group with the primary key could not be found
	 */
	@Override
	public PermissionGroup fetchByPrimaryKey(
		PermissionGroupPK permissionGroupPK) {

		return fetchByPrimaryKey((Serializable)permissionGroupPK);
	}

	/**
	 * Returns all the permission groups.
	 *
	 * @return the permission groups
	 */
	@Override
	public List<PermissionGroup> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @return the range of permission groups
	 */
	@Override
	public List<PermissionGroup> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of permission groups
	 */
	@Override
	public List<PermissionGroup> findAll(
		int start, int end,
		OrderByComparator<PermissionGroup> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the permission groups.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission groups
	 * @param end the upper bound of the range of permission groups (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of permission groups
	 */
	@Override
	public List<PermissionGroup> findAll(
		int start, int end,
		OrderByComparator<PermissionGroup> orderByComparator,
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

		List<PermissionGroup> list = null;

		if (useFinderCache) {
			list = (List<PermissionGroup>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PERMISSIONGROUP);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PERMISSIONGROUP;

				sql = sql.concat(PermissionGroupModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<PermissionGroup>)QueryUtil.list(
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
	 * Removes all the permission groups from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PermissionGroup permissionGroup : findAll()) {
			remove(permissionGroup);
		}
	}

	/**
	 * Returns the number of permission groups.
	 *
	 * @return the number of permission groups
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PERMISSIONGROUP);

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
		return "permissionGroupPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PERMISSIONGROUP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PermissionGroupModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the permission group persistence.
	 */
	@Activate
	public void activate() {
		PermissionGroupModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		PermissionGroupModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PermissionGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PermissionGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGroup_GroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PermissionGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup_GroupUser",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup_GroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, PermissionGroupImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup_GroupUser",
			new String[] {Long.class.getName(), Long.class.getName()},
			PermissionGroupModelImpl.GROUPID_COLUMN_BITMASK |
			PermissionGroupModelImpl.GROUPUSERID_COLUMN_BITMASK);

		_finderPathCountByGroup_GroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup_GroupUser",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(PermissionGroupImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.software.cms.model.PermissionGroup"),
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

	private static final String _SQL_SELECT_PERMISSIONGROUP =
		"SELECT permissionGroup FROM PermissionGroup permissionGroup";

	private static final String _SQL_SELECT_PERMISSIONGROUP_WHERE =
		"SELECT permissionGroup FROM PermissionGroup permissionGroup WHERE ";

	private static final String _SQL_COUNT_PERMISSIONGROUP =
		"SELECT COUNT(permissionGroup) FROM PermissionGroup permissionGroup";

	private static final String _SQL_COUNT_PERMISSIONGROUP_WHERE =
		"SELECT COUNT(permissionGroup) FROM PermissionGroup permissionGroup WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "permissionGroup.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PermissionGroup exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PermissionGroup exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PermissionGroupPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"permissionId", "groupuserid"});

	static {
		try {
			Class.forName(soft_cmsPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}