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

import com.ecoit.lichcongtac.services.exception.NoSuchPermissionGroupRelException;
import com.ecoit.lichcongtac.services.model.PermissionGroupRel;
import com.ecoit.lichcongtac.services.model.impl.PermissionGroupRelImpl;
import com.ecoit.lichcongtac.services.model.impl.PermissionGroupRelModelImpl;
import com.ecoit.lichcongtac.services.service.persistence.PermissionGroupRelPK;
import com.ecoit.lichcongtac.services.service.persistence.PermissionGroupRelPersistence;
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
 * The persistence implementation for the permission group rel service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PermissionGroupRelPersistence.class)
public class PermissionGroupRelPersistenceImpl
	extends BasePersistenceImpl<PermissionGroupRel>
	implements PermissionGroupRelPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PermissionGroupRelUtil</code> to access the permission group rel persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PermissionGroupRelImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroup;
	private FinderPath _finderPathWithoutPaginationFindByGroup;
	private FinderPath _finderPathCountByGroup;

	/**
	 * Returns all the permission group rels where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the matching permission group rels
	 */
	@Override
	public List<PermissionGroupRel> findByGroup(long userPermissionGroupId) {
		return findByGroup(
			userPermissionGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the permission group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of permission group rels
	 * @param end the upper bound of the range of permission group rels (not inclusive)
	 * @return the range of matching permission group rels
	 */
	@Override
	public List<PermissionGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end) {

		return findByGroup(userPermissionGroupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the permission group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of permission group rels
	 * @param end the upper bound of the range of permission group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching permission group rels
	 */
	@Override
	public List<PermissionGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end,
		OrderByComparator<PermissionGroupRel> orderByComparator) {

		return findByGroup(
			userPermissionGroupId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the permission group rels where userPermissionGroupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param start the lower bound of the range of permission group rels
	 * @param end the upper bound of the range of permission group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching permission group rels
	 */
	@Override
	public List<PermissionGroupRel> findByGroup(
		long userPermissionGroupId, int start, int end,
		OrderByComparator<PermissionGroupRel> orderByComparator,
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

		List<PermissionGroupRel> list = null;

		if (useFinderCache) {
			list = (List<PermissionGroupRel>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (PermissionGroupRel permissionGroupRel : list) {
					if (userPermissionGroupId !=
							permissionGroupRel.getUserPermissionGroupId()) {

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

			query.append(_SQL_SELECT_PERMISSIONGROUPREL_WHERE);

			query.append(_FINDER_COLUMN_GROUP_USERPERMISSIONGROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(PermissionGroupRelModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(userPermissionGroupId);

				list = (List<PermissionGroupRel>)QueryUtil.list(
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
	 * Returns the first permission group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission group rel
	 * @throws NoSuchPermissionGroupRelException if a matching permission group rel could not be found
	 */
	@Override
	public PermissionGroupRel findByGroup_First(
			long userPermissionGroupId,
			OrderByComparator<PermissionGroupRel> orderByComparator)
		throws NoSuchPermissionGroupRelException {

		PermissionGroupRel permissionGroupRel = fetchByGroup_First(
			userPermissionGroupId, orderByComparator);

		if (permissionGroupRel != null) {
			return permissionGroupRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userPermissionGroupId=");
		msg.append(userPermissionGroupId);

		msg.append("}");

		throw new NoSuchPermissionGroupRelException(msg.toString());
	}

	/**
	 * Returns the first permission group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching permission group rel, or <code>null</code> if a matching permission group rel could not be found
	 */
	@Override
	public PermissionGroupRel fetchByGroup_First(
		long userPermissionGroupId,
		OrderByComparator<PermissionGroupRel> orderByComparator) {

		List<PermissionGroupRel> list = findByGroup(
			userPermissionGroupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last permission group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission group rel
	 * @throws NoSuchPermissionGroupRelException if a matching permission group rel could not be found
	 */
	@Override
	public PermissionGroupRel findByGroup_Last(
			long userPermissionGroupId,
			OrderByComparator<PermissionGroupRel> orderByComparator)
		throws NoSuchPermissionGroupRelException {

		PermissionGroupRel permissionGroupRel = fetchByGroup_Last(
			userPermissionGroupId, orderByComparator);

		if (permissionGroupRel != null) {
			return permissionGroupRel;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("userPermissionGroupId=");
		msg.append(userPermissionGroupId);

		msg.append("}");

		throw new NoSuchPermissionGroupRelException(msg.toString());
	}

	/**
	 * Returns the last permission group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching permission group rel, or <code>null</code> if a matching permission group rel could not be found
	 */
	@Override
	public PermissionGroupRel fetchByGroup_Last(
		long userPermissionGroupId,
		OrderByComparator<PermissionGroupRel> orderByComparator) {

		int count = countByGroup(userPermissionGroupId);

		if (count == 0) {
			return null;
		}

		List<PermissionGroupRel> list = findByGroup(
			userPermissionGroupId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the permission group rels before and after the current permission group rel in the ordered set where userPermissionGroupId = &#63;.
	 *
	 * @param permissionGroupRelPK the primary key of the current permission group rel
	 * @param userPermissionGroupId the user permission group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next permission group rel
	 * @throws NoSuchPermissionGroupRelException if a permission group rel with the primary key could not be found
	 */
	@Override
	public PermissionGroupRel[] findByGroup_PrevAndNext(
			PermissionGroupRelPK permissionGroupRelPK,
			long userPermissionGroupId,
			OrderByComparator<PermissionGroupRel> orderByComparator)
		throws NoSuchPermissionGroupRelException {

		PermissionGroupRel permissionGroupRel = findByPrimaryKey(
			permissionGroupRelPK);

		Session session = null;

		try {
			session = openSession();

			PermissionGroupRel[] array = new PermissionGroupRelImpl[3];

			array[0] = getByGroup_PrevAndNext(
				session, permissionGroupRel, userPermissionGroupId,
				orderByComparator, true);

			array[1] = permissionGroupRel;

			array[2] = getByGroup_PrevAndNext(
				session, permissionGroupRel, userPermissionGroupId,
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

	protected PermissionGroupRel getByGroup_PrevAndNext(
		Session session, PermissionGroupRel permissionGroupRel,
		long userPermissionGroupId,
		OrderByComparator<PermissionGroupRel> orderByComparator,
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

		query.append(_SQL_SELECT_PERMISSIONGROUPREL_WHERE);

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
			query.append(PermissionGroupRelModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(userPermissionGroupId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						permissionGroupRel)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<PermissionGroupRel> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the permission group rels where userPermissionGroupId = &#63; from the database.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 */
	@Override
	public void removeByGroup(long userPermissionGroupId) {
		for (PermissionGroupRel permissionGroupRel :
				findByGroup(
					userPermissionGroupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(permissionGroupRel);
		}
	}

	/**
	 * Returns the number of permission group rels where userPermissionGroupId = &#63;.
	 *
	 * @param userPermissionGroupId the user permission group ID
	 * @return the number of matching permission group rels
	 */
	@Override
	public int countByGroup(long userPermissionGroupId) {
		FinderPath finderPath = _finderPathCountByGroup;

		Object[] finderArgs = new Object[] {userPermissionGroupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_PERMISSIONGROUPREL_WHERE);

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
		"permissionGroupRel.id.userPermissionGroupId = ?";

	public PermissionGroupRelPersistenceImpl() {
		setModelClass(PermissionGroupRel.class);

		setModelImplClass(PermissionGroupRelImpl.class);
		setModelPKClass(PermissionGroupRelPK.class);
	}

	/**
	 * Caches the permission group rel in the entity cache if it is enabled.
	 *
	 * @param permissionGroupRel the permission group rel
	 */
	@Override
	public void cacheResult(PermissionGroupRel permissionGroupRel) {
		entityCache.putResult(
			entityCacheEnabled, PermissionGroupRelImpl.class,
			permissionGroupRel.getPrimaryKey(), permissionGroupRel);

		permissionGroupRel.resetOriginalValues();
	}

	/**
	 * Caches the permission group rels in the entity cache if it is enabled.
	 *
	 * @param permissionGroupRels the permission group rels
	 */
	@Override
	public void cacheResult(List<PermissionGroupRel> permissionGroupRels) {
		for (PermissionGroupRel permissionGroupRel : permissionGroupRels) {
			if (entityCache.getResult(
					entityCacheEnabled, PermissionGroupRelImpl.class,
					permissionGroupRel.getPrimaryKey()) == null) {

				cacheResult(permissionGroupRel);
			}
			else {
				permissionGroupRel.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all permission group rels.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(PermissionGroupRelImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the permission group rel.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PermissionGroupRel permissionGroupRel) {
		entityCache.removeResult(
			entityCacheEnabled, PermissionGroupRelImpl.class,
			permissionGroupRel.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<PermissionGroupRel> permissionGroupRels) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (PermissionGroupRel permissionGroupRel : permissionGroupRels) {
			entityCache.removeResult(
				entityCacheEnabled, PermissionGroupRelImpl.class,
				permissionGroupRel.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, PermissionGroupRelImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new permission group rel with the primary key. Does not add the permission group rel to the database.
	 *
	 * @param permissionGroupRelPK the primary key for the new permission group rel
	 * @return the new permission group rel
	 */
	@Override
	public PermissionGroupRel create(
		PermissionGroupRelPK permissionGroupRelPK) {

		PermissionGroupRel permissionGroupRel = new PermissionGroupRelImpl();

		permissionGroupRel.setNew(true);
		permissionGroupRel.setPrimaryKey(permissionGroupRelPK);

		return permissionGroupRel;
	}

	/**
	 * Removes the permission group rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param permissionGroupRelPK the primary key of the permission group rel
	 * @return the permission group rel that was removed
	 * @throws NoSuchPermissionGroupRelException if a permission group rel with the primary key could not be found
	 */
	@Override
	public PermissionGroupRel remove(PermissionGroupRelPK permissionGroupRelPK)
		throws NoSuchPermissionGroupRelException {

		return remove((Serializable)permissionGroupRelPK);
	}

	/**
	 * Removes the permission group rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the permission group rel
	 * @return the permission group rel that was removed
	 * @throws NoSuchPermissionGroupRelException if a permission group rel with the primary key could not be found
	 */
	@Override
	public PermissionGroupRel remove(Serializable primaryKey)
		throws NoSuchPermissionGroupRelException {

		Session session = null;

		try {
			session = openSession();

			PermissionGroupRel permissionGroupRel =
				(PermissionGroupRel)session.get(
					PermissionGroupRelImpl.class, primaryKey);

			if (permissionGroupRel == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPermissionGroupRelException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(permissionGroupRel);
		}
		catch (NoSuchPermissionGroupRelException noSuchEntityException) {
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
	protected PermissionGroupRel removeImpl(
		PermissionGroupRel permissionGroupRel) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(permissionGroupRel)) {
				permissionGroupRel = (PermissionGroupRel)session.get(
					PermissionGroupRelImpl.class,
					permissionGroupRel.getPrimaryKeyObj());
			}

			if (permissionGroupRel != null) {
				session.delete(permissionGroupRel);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (permissionGroupRel != null) {
			clearCache(permissionGroupRel);
		}

		return permissionGroupRel;
	}

	@Override
	public PermissionGroupRel updateImpl(
		PermissionGroupRel permissionGroupRel) {

		boolean isNew = permissionGroupRel.isNew();

		if (!(permissionGroupRel instanceof PermissionGroupRelModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(permissionGroupRel.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					permissionGroupRel);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in permissionGroupRel proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom PermissionGroupRel implementation " +
					permissionGroupRel.getClass());
		}

		PermissionGroupRelModelImpl permissionGroupRelModelImpl =
			(PermissionGroupRelModelImpl)permissionGroupRel;

		Session session = null;

		try {
			session = openSession();

			if (permissionGroupRel.isNew()) {
				session.save(permissionGroupRel);

				permissionGroupRel.setNew(false);
			}
			else {
				permissionGroupRel = (PermissionGroupRel)session.merge(
					permissionGroupRel);
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
				permissionGroupRelModelImpl.getUserPermissionGroupId()
			};

			finderCache.removeResult(_finderPathCountByGroup, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((permissionGroupRelModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					permissionGroupRelModelImpl.
						getOriginalUserPermissionGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);

				args = new Object[] {
					permissionGroupRelModelImpl.getUserPermissionGroupId()
				};

				finderCache.removeResult(_finderPathCountByGroup, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, PermissionGroupRelImpl.class,
			permissionGroupRel.getPrimaryKey(), permissionGroupRel, false);

		permissionGroupRel.resetOriginalValues();

		return permissionGroupRel;
	}

	/**
	 * Returns the permission group rel with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the permission group rel
	 * @return the permission group rel
	 * @throws NoSuchPermissionGroupRelException if a permission group rel with the primary key could not be found
	 */
	@Override
	public PermissionGroupRel findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPermissionGroupRelException {

		PermissionGroupRel permissionGroupRel = fetchByPrimaryKey(primaryKey);

		if (permissionGroupRel == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPermissionGroupRelException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return permissionGroupRel;
	}

	/**
	 * Returns the permission group rel with the primary key or throws a <code>NoSuchPermissionGroupRelException</code> if it could not be found.
	 *
	 * @param permissionGroupRelPK the primary key of the permission group rel
	 * @return the permission group rel
	 * @throws NoSuchPermissionGroupRelException if a permission group rel with the primary key could not be found
	 */
	@Override
	public PermissionGroupRel findByPrimaryKey(
			PermissionGroupRelPK permissionGroupRelPK)
		throws NoSuchPermissionGroupRelException {

		return findByPrimaryKey((Serializable)permissionGroupRelPK);
	}

	/**
	 * Returns the permission group rel with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param permissionGroupRelPK the primary key of the permission group rel
	 * @return the permission group rel, or <code>null</code> if a permission group rel with the primary key could not be found
	 */
	@Override
	public PermissionGroupRel fetchByPrimaryKey(
		PermissionGroupRelPK permissionGroupRelPK) {

		return fetchByPrimaryKey((Serializable)permissionGroupRelPK);
	}

	/**
	 * Returns all the permission group rels.
	 *
	 * @return the permission group rels
	 */
	@Override
	public List<PermissionGroupRel> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the permission group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission group rels
	 * @param end the upper bound of the range of permission group rels (not inclusive)
	 * @return the range of permission group rels
	 */
	@Override
	public List<PermissionGroupRel> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the permission group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission group rels
	 * @param end the upper bound of the range of permission group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of permission group rels
	 */
	@Override
	public List<PermissionGroupRel> findAll(
		int start, int end,
		OrderByComparator<PermissionGroupRel> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the permission group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PermissionGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of permission group rels
	 * @param end the upper bound of the range of permission group rels (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of permission group rels
	 */
	@Override
	public List<PermissionGroupRel> findAll(
		int start, int end,
		OrderByComparator<PermissionGroupRel> orderByComparator,
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

		List<PermissionGroupRel> list = null;

		if (useFinderCache) {
			list = (List<PermissionGroupRel>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_PERMISSIONGROUPREL);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_PERMISSIONGROUPREL;

				sql = sql.concat(PermissionGroupRelModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<PermissionGroupRel>)QueryUtil.list(
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
	 * Removes all the permission group rels from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PermissionGroupRel permissionGroupRel : findAll()) {
			remove(permissionGroupRel);
		}
	}

	/**
	 * Returns the number of permission group rels.
	 *
	 * @return the number of permission group rels
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_PERMISSIONGROUPREL);

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
		return "permissionGroupRelPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PERMISSIONGROUPREL;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PermissionGroupRelModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the permission group rel persistence.
	 */
	@Activate
	public void activate() {
		PermissionGroupRelModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		PermissionGroupRelModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			PermissionGroupRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			PermissionGroupRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			PermissionGroupRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled,
			PermissionGroupRelImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup",
			new String[] {Long.class.getName()},
			PermissionGroupRelModelImpl.USERPERMISSIONGROUPID_COLUMN_BITMASK);

		_finderPathCountByGroup = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(PermissionGroupRelImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.lichcongtac.services.model.PermissionGroupRel"),
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

	private static final String _SQL_SELECT_PERMISSIONGROUPREL =
		"SELECT permissionGroupRel FROM PermissionGroupRel permissionGroupRel";

	private static final String _SQL_SELECT_PERMISSIONGROUPREL_WHERE =
		"SELECT permissionGroupRel FROM PermissionGroupRel permissionGroupRel WHERE ";

	private static final String _SQL_COUNT_PERMISSIONGROUPREL =
		"SELECT COUNT(permissionGroupRel) FROM PermissionGroupRel permissionGroupRel";

	private static final String _SQL_COUNT_PERMISSIONGROUPREL_WHERE =
		"SELECT COUNT(permissionGroupRel) FROM PermissionGroupRel permissionGroupRel WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "permissionGroupRel.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PermissionGroupRel exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No PermissionGroupRel exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		PermissionGroupRelPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"userPermissionGroupId", "permissionId"});

	static {
		try {
			Class.forName(ecoit_lichPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}