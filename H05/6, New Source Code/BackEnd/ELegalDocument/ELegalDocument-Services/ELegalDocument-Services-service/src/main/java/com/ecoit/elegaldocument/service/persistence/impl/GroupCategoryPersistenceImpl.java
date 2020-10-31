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

package com.ecoit.elegaldocument.service.persistence.impl;

import com.ecoit.elegaldocument.exception.NoSuchGroupCategoryException;
import com.ecoit.elegaldocument.model.GroupCategory;
import com.ecoit.elegaldocument.model.impl.GroupCategoryImpl;
import com.ecoit.elegaldocument.model.impl.GroupCategoryModelImpl;
import com.ecoit.elegaldocument.service.persistence.GroupCategoryPK;
import com.ecoit.elegaldocument.service.persistence.GroupCategoryPersistence;
import com.ecoit.elegaldocument.service.persistence.impl.constants.ecoit_docPersistenceConstants;

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
 * The persistence implementation for the group category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = GroupCategoryPersistence.class)
public class GroupCategoryPersistenceImpl
	extends BasePersistenceImpl<GroupCategory>
	implements GroupCategoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GroupCategoryUtil</code> to access the group category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GroupCategoryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroupUser;
	private FinderPath _finderPathWithoutPaginationFindByGroupUser;
	private FinderPath _finderPathCountByGroupUser;

	/**
	 * Returns all the group categories where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching group categories
	 */
	@Override
	public List<GroupCategory> findByGroupUser(long groupUserId) {
		return findByGroupUser(
			groupUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group categories where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @return the range of matching group categories
	 */
	@Override
	public List<GroupCategory> findByGroupUser(
		long groupUserId, int start, int end) {

		return findByGroupUser(groupUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the group categories where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group categories
	 */
	@Override
	public List<GroupCategory> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupCategory> orderByComparator) {

		return findByGroupUser(
			groupUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group categories where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group categories
	 */
	@Override
	public List<GroupCategory> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupCategory> orderByComparator,
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

		List<GroupCategory> list = null;

		if (useFinderCache) {
			list = (List<GroupCategory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GroupCategory groupCategory : list) {
					if (groupUserId != groupCategory.getGroupUserId()) {
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

			query.append(_SQL_SELECT_GROUPCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUPUSER_GROUPUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(GroupCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupUserId);

				list = (List<GroupCategory>)QueryUtil.list(
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
	 * Returns the first group category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group category
	 * @throws NoSuchGroupCategoryException if a matching group category could not be found
	 */
	@Override
	public GroupCategory findByGroupUser_First(
			long groupUserId,
			OrderByComparator<GroupCategory> orderByComparator)
		throws NoSuchGroupCategoryException {

		GroupCategory groupCategory = fetchByGroupUser_First(
			groupUserId, orderByComparator);

		if (groupCategory != null) {
			return groupCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupUserId=");
		msg.append(groupUserId);

		msg.append("}");

		throw new NoSuchGroupCategoryException(msg.toString());
	}

	/**
	 * Returns the first group category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group category, or <code>null</code> if a matching group category could not be found
	 */
	@Override
	public GroupCategory fetchByGroupUser_First(
		long groupUserId, OrderByComparator<GroupCategory> orderByComparator) {

		List<GroupCategory> list = findByGroupUser(
			groupUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last group category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group category
	 * @throws NoSuchGroupCategoryException if a matching group category could not be found
	 */
	@Override
	public GroupCategory findByGroupUser_Last(
			long groupUserId,
			OrderByComparator<GroupCategory> orderByComparator)
		throws NoSuchGroupCategoryException {

		GroupCategory groupCategory = fetchByGroupUser_Last(
			groupUserId, orderByComparator);

		if (groupCategory != null) {
			return groupCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupUserId=");
		msg.append(groupUserId);

		msg.append("}");

		throw new NoSuchGroupCategoryException(msg.toString());
	}

	/**
	 * Returns the last group category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group category, or <code>null</code> if a matching group category could not be found
	 */
	@Override
	public GroupCategory fetchByGroupUser_Last(
		long groupUserId, OrderByComparator<GroupCategory> orderByComparator) {

		int count = countByGroupUser(groupUserId);

		if (count == 0) {
			return null;
		}

		List<GroupCategory> list = findByGroupUser(
			groupUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the group categories before and after the current group category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupCategoryPK the primary key of the current group category
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group category
	 * @throws NoSuchGroupCategoryException if a group category with the primary key could not be found
	 */
	@Override
	public GroupCategory[] findByGroupUser_PrevAndNext(
			GroupCategoryPK groupCategoryPK, long groupUserId,
			OrderByComparator<GroupCategory> orderByComparator)
		throws NoSuchGroupCategoryException {

		GroupCategory groupCategory = findByPrimaryKey(groupCategoryPK);

		Session session = null;

		try {
			session = openSession();

			GroupCategory[] array = new GroupCategoryImpl[3];

			array[0] = getByGroupUser_PrevAndNext(
				session, groupCategory, groupUserId, orderByComparator, true);

			array[1] = groupCategory;

			array[2] = getByGroupUser_PrevAndNext(
				session, groupCategory, groupUserId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GroupCategory getByGroupUser_PrevAndNext(
		Session session, GroupCategory groupCategory, long groupUserId,
		OrderByComparator<GroupCategory> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GROUPCATEGORY_WHERE);

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
			query.append(GroupCategoryModelImpl.ORDER_BY_JPQL);
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
						groupCategory)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<GroupCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the group categories where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	@Override
	public void removeByGroupUser(long groupUserId) {
		for (GroupCategory groupCategory :
				findByGroupUser(
					groupUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(groupCategory);
		}
	}

	/**
	 * Returns the number of group categories where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching group categories
	 */
	@Override
	public int countByGroupUser(long groupUserId) {
		FinderPath finderPath = _finderPathCountByGroupUser;

		Object[] finderArgs = new Object[] {groupUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GROUPCATEGORY_WHERE);

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
		"groupCategory.id.groupUserId = ?";

	private FinderPath _finderPathWithPaginationFindByCategory;
	private FinderPath _finderPathWithoutPaginationFindByCategory;
	private FinderPath _finderPathCountByCategory;

	/**
	 * Returns all the group categories where typeid = &#63;.
	 *
	 * @param typeid the typeid
	 * @return the matching group categories
	 */
	@Override
	public List<GroupCategory> findByCategory(long typeid) {
		return findByCategory(
			typeid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group categories where typeid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param typeid the typeid
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @return the range of matching group categories
	 */
	@Override
	public List<GroupCategory> findByCategory(long typeid, int start, int end) {
		return findByCategory(typeid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the group categories where typeid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param typeid the typeid
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group categories
	 */
	@Override
	public List<GroupCategory> findByCategory(
		long typeid, int start, int end,
		OrderByComparator<GroupCategory> orderByComparator) {

		return findByCategory(typeid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group categories where typeid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param typeid the typeid
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group categories
	 */
	@Override
	public List<GroupCategory> findByCategory(
		long typeid, int start, int end,
		OrderByComparator<GroupCategory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCategory;
				finderArgs = new Object[] {typeid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCategory;
			finderArgs = new Object[] {typeid, start, end, orderByComparator};
		}

		List<GroupCategory> list = null;

		if (useFinderCache) {
			list = (List<GroupCategory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GroupCategory groupCategory : list) {
					if (typeid != groupCategory.getTypeid()) {
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

			query.append(_SQL_SELECT_GROUPCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_TYPEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(GroupCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeid);

				list = (List<GroupCategory>)QueryUtil.list(
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
	 * Returns the first group category in the ordered set where typeid = &#63;.
	 *
	 * @param typeid the typeid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group category
	 * @throws NoSuchGroupCategoryException if a matching group category could not be found
	 */
	@Override
	public GroupCategory findByCategory_First(
			long typeid, OrderByComparator<GroupCategory> orderByComparator)
		throws NoSuchGroupCategoryException {

		GroupCategory groupCategory = fetchByCategory_First(
			typeid, orderByComparator);

		if (groupCategory != null) {
			return groupCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeid=");
		msg.append(typeid);

		msg.append("}");

		throw new NoSuchGroupCategoryException(msg.toString());
	}

	/**
	 * Returns the first group category in the ordered set where typeid = &#63;.
	 *
	 * @param typeid the typeid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group category, or <code>null</code> if a matching group category could not be found
	 */
	@Override
	public GroupCategory fetchByCategory_First(
		long typeid, OrderByComparator<GroupCategory> orderByComparator) {

		List<GroupCategory> list = findByCategory(
			typeid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last group category in the ordered set where typeid = &#63;.
	 *
	 * @param typeid the typeid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group category
	 * @throws NoSuchGroupCategoryException if a matching group category could not be found
	 */
	@Override
	public GroupCategory findByCategory_Last(
			long typeid, OrderByComparator<GroupCategory> orderByComparator)
		throws NoSuchGroupCategoryException {

		GroupCategory groupCategory = fetchByCategory_Last(
			typeid, orderByComparator);

		if (groupCategory != null) {
			return groupCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("typeid=");
		msg.append(typeid);

		msg.append("}");

		throw new NoSuchGroupCategoryException(msg.toString());
	}

	/**
	 * Returns the last group category in the ordered set where typeid = &#63;.
	 *
	 * @param typeid the typeid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group category, or <code>null</code> if a matching group category could not be found
	 */
	@Override
	public GroupCategory fetchByCategory_Last(
		long typeid, OrderByComparator<GroupCategory> orderByComparator) {

		int count = countByCategory(typeid);

		if (count == 0) {
			return null;
		}

		List<GroupCategory> list = findByCategory(
			typeid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the group categories before and after the current group category in the ordered set where typeid = &#63;.
	 *
	 * @param groupCategoryPK the primary key of the current group category
	 * @param typeid the typeid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group category
	 * @throws NoSuchGroupCategoryException if a group category with the primary key could not be found
	 */
	@Override
	public GroupCategory[] findByCategory_PrevAndNext(
			GroupCategoryPK groupCategoryPK, long typeid,
			OrderByComparator<GroupCategory> orderByComparator)
		throws NoSuchGroupCategoryException {

		GroupCategory groupCategory = findByPrimaryKey(groupCategoryPK);

		Session session = null;

		try {
			session = openSession();

			GroupCategory[] array = new GroupCategoryImpl[3];

			array[0] = getByCategory_PrevAndNext(
				session, groupCategory, typeid, orderByComparator, true);

			array[1] = groupCategory;

			array[2] = getByCategory_PrevAndNext(
				session, groupCategory, typeid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GroupCategory getByCategory_PrevAndNext(
		Session session, GroupCategory groupCategory, long typeid,
		OrderByComparator<GroupCategory> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GROUPCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORY_TYPEID_2);

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
			query.append(GroupCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(typeid);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						groupCategory)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<GroupCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the group categories where typeid = &#63; from the database.
	 *
	 * @param typeid the typeid
	 */
	@Override
	public void removeByCategory(long typeid) {
		for (GroupCategory groupCategory :
				findByCategory(
					typeid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(groupCategory);
		}
	}

	/**
	 * Returns the number of group categories where typeid = &#63;.
	 *
	 * @param typeid the typeid
	 * @return the number of matching group categories
	 */
	@Override
	public int countByCategory(long typeid) {
		FinderPath finderPath = _finderPathCountByCategory;

		Object[] finderArgs = new Object[] {typeid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GROUPCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_TYPEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(typeid);

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

	private static final String _FINDER_COLUMN_CATEGORY_TYPEID_2 =
		"groupCategory.id.typeid = ?";

	public GroupCategoryPersistenceImpl() {
		setModelClass(GroupCategory.class);

		setModelImplClass(GroupCategoryImpl.class);
		setModelPKClass(GroupCategoryPK.class);
	}

	/**
	 * Caches the group category in the entity cache if it is enabled.
	 *
	 * @param groupCategory the group category
	 */
	@Override
	public void cacheResult(GroupCategory groupCategory) {
		entityCache.putResult(
			entityCacheEnabled, GroupCategoryImpl.class,
			groupCategory.getPrimaryKey(), groupCategory);

		groupCategory.resetOriginalValues();
	}

	/**
	 * Caches the group categories in the entity cache if it is enabled.
	 *
	 * @param groupCategories the group categories
	 */
	@Override
	public void cacheResult(List<GroupCategory> groupCategories) {
		for (GroupCategory groupCategory : groupCategories) {
			if (entityCache.getResult(
					entityCacheEnabled, GroupCategoryImpl.class,
					groupCategory.getPrimaryKey()) == null) {

				cacheResult(groupCategory);
			}
			else {
				groupCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all group categories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GroupCategoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the group category.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GroupCategory groupCategory) {
		entityCache.removeResult(
			entityCacheEnabled, GroupCategoryImpl.class,
			groupCategory.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GroupCategory> groupCategories) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GroupCategory groupCategory : groupCategories) {
			entityCache.removeResult(
				entityCacheEnabled, GroupCategoryImpl.class,
				groupCategory.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, GroupCategoryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new group category with the primary key. Does not add the group category to the database.
	 *
	 * @param groupCategoryPK the primary key for the new group category
	 * @return the new group category
	 */
	@Override
	public GroupCategory create(GroupCategoryPK groupCategoryPK) {
		GroupCategory groupCategory = new GroupCategoryImpl();

		groupCategory.setNew(true);
		groupCategory.setPrimaryKey(groupCategoryPK);

		return groupCategory;
	}

	/**
	 * Removes the group category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupCategoryPK the primary key of the group category
	 * @return the group category that was removed
	 * @throws NoSuchGroupCategoryException if a group category with the primary key could not be found
	 */
	@Override
	public GroupCategory remove(GroupCategoryPK groupCategoryPK)
		throws NoSuchGroupCategoryException {

		return remove((Serializable)groupCategoryPK);
	}

	/**
	 * Removes the group category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the group category
	 * @return the group category that was removed
	 * @throws NoSuchGroupCategoryException if a group category with the primary key could not be found
	 */
	@Override
	public GroupCategory remove(Serializable primaryKey)
		throws NoSuchGroupCategoryException {

		Session session = null;

		try {
			session = openSession();

			GroupCategory groupCategory = (GroupCategory)session.get(
				GroupCategoryImpl.class, primaryKey);

			if (groupCategory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGroupCategoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(groupCategory);
		}
		catch (NoSuchGroupCategoryException noSuchEntityException) {
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
	protected GroupCategory removeImpl(GroupCategory groupCategory) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(groupCategory)) {
				groupCategory = (GroupCategory)session.get(
					GroupCategoryImpl.class, groupCategory.getPrimaryKeyObj());
			}

			if (groupCategory != null) {
				session.delete(groupCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (groupCategory != null) {
			clearCache(groupCategory);
		}

		return groupCategory;
	}

	@Override
	public GroupCategory updateImpl(GroupCategory groupCategory) {
		boolean isNew = groupCategory.isNew();

		if (!(groupCategory instanceof GroupCategoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(groupCategory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					groupCategory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in groupCategory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GroupCategory implementation " +
					groupCategory.getClass());
		}

		GroupCategoryModelImpl groupCategoryModelImpl =
			(GroupCategoryModelImpl)groupCategory;

		Session session = null;

		try {
			session = openSession();

			if (groupCategory.isNew()) {
				session.save(groupCategory);

				groupCategory.setNew(false);
			}
			else {
				groupCategory = (GroupCategory)session.merge(groupCategory);
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
				groupCategoryModelImpl.getGroupUserId()
			};

			finderCache.removeResult(_finderPathCountByGroupUser, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupUser, args);

			args = new Object[] {groupCategoryModelImpl.getTypeid()};

			finderCache.removeResult(_finderPathCountByCategory, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCategory, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((groupCategoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupUser.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					groupCategoryModelImpl.getOriginalGroupUserId()
				};

				finderCache.removeResult(_finderPathCountByGroupUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupUser, args);

				args = new Object[] {groupCategoryModelImpl.getGroupUserId()};

				finderCache.removeResult(_finderPathCountByGroupUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupUser, args);
			}

			if ((groupCategoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCategory.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					groupCategoryModelImpl.getOriginalTypeid()
				};

				finderCache.removeResult(_finderPathCountByCategory, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCategory, args);

				args = new Object[] {groupCategoryModelImpl.getTypeid()};

				finderCache.removeResult(_finderPathCountByCategory, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCategory, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, GroupCategoryImpl.class,
			groupCategory.getPrimaryKey(), groupCategory, false);

		groupCategory.resetOriginalValues();

		return groupCategory;
	}

	/**
	 * Returns the group category with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the group category
	 * @return the group category
	 * @throws NoSuchGroupCategoryException if a group category with the primary key could not be found
	 */
	@Override
	public GroupCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGroupCategoryException {

		GroupCategory groupCategory = fetchByPrimaryKey(primaryKey);

		if (groupCategory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGroupCategoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return groupCategory;
	}

	/**
	 * Returns the group category with the primary key or throws a <code>NoSuchGroupCategoryException</code> if it could not be found.
	 *
	 * @param groupCategoryPK the primary key of the group category
	 * @return the group category
	 * @throws NoSuchGroupCategoryException if a group category with the primary key could not be found
	 */
	@Override
	public GroupCategory findByPrimaryKey(GroupCategoryPK groupCategoryPK)
		throws NoSuchGroupCategoryException {

		return findByPrimaryKey((Serializable)groupCategoryPK);
	}

	/**
	 * Returns the group category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupCategoryPK the primary key of the group category
	 * @return the group category, or <code>null</code> if a group category with the primary key could not be found
	 */
	@Override
	public GroupCategory fetchByPrimaryKey(GroupCategoryPK groupCategoryPK) {
		return fetchByPrimaryKey((Serializable)groupCategoryPK);
	}

	/**
	 * Returns all the group categories.
	 *
	 * @return the group categories
	 */
	@Override
	public List<GroupCategory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @return the range of group categories
	 */
	@Override
	public List<GroupCategory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the group categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group categories
	 */
	@Override
	public List<GroupCategory> findAll(
		int start, int end,
		OrderByComparator<GroupCategory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group categories
	 * @param end the upper bound of the range of group categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group categories
	 */
	@Override
	public List<GroupCategory> findAll(
		int start, int end, OrderByComparator<GroupCategory> orderByComparator,
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

		List<GroupCategory> list = null;

		if (useFinderCache) {
			list = (List<GroupCategory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GROUPCATEGORY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GROUPCATEGORY;

				sql = sql.concat(GroupCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<GroupCategory>)QueryUtil.list(
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
	 * Removes all the group categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GroupCategory groupCategory : findAll()) {
			remove(groupCategory);
		}
	}

	/**
	 * Returns the number of group categories.
	 *
	 * @return the number of group categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GROUPCATEGORY);

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
		return "groupCategoryPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GROUPCATEGORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GroupCategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the group category persistence.
	 */
	@Activate
	public void activate() {
		GroupCategoryModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		GroupCategoryModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupUser",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupUser",
			new String[] {Long.class.getName()},
			GroupCategoryModelImpl.GROUPUSERID_COLUMN_BITMASK);

		_finderPathCountByGroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupUser",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByCategory = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategory",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCategory = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] {Long.class.getName()},
			GroupCategoryModelImpl.TYPEID_COLUMN_BITMASK);

		_finderPathCountByCategory = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(GroupCategoryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = ecoit_docPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.GroupCategory"),
			true);
	}

	@Override
	@Reference(
		target = ecoit_docPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = ecoit_docPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_GROUPCATEGORY =
		"SELECT groupCategory FROM GroupCategory groupCategory";

	private static final String _SQL_SELECT_GROUPCATEGORY_WHERE =
		"SELECT groupCategory FROM GroupCategory groupCategory WHERE ";

	private static final String _SQL_COUNT_GROUPCATEGORY =
		"SELECT COUNT(groupCategory) FROM GroupCategory groupCategory";

	private static final String _SQL_COUNT_GROUPCATEGORY_WHERE =
		"SELECT COUNT(groupCategory) FROM GroupCategory groupCategory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "groupCategory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GroupCategory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No GroupCategory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GroupCategoryPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"groupUserId", "typeid"});

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}