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

import com.ecoit.qa.service.exception.NoSuchGroupUserCategoryException;
import com.ecoit.qa.service.model.GroupUserCategory;
import com.ecoit.qa.service.model.impl.GroupUserCategoryImpl;
import com.ecoit.qa.service.model.impl.GroupUserCategoryModelImpl;
import com.ecoit.qa.service.service.persistence.GroupUserCategoryPK;
import com.ecoit.qa.service.service.persistence.GroupUserCategoryPersistence;
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
 * The persistence implementation for the group user category service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = GroupUserCategoryPersistence.class)
public class GroupUserCategoryPersistenceImpl
	extends BasePersistenceImpl<GroupUserCategory>
	implements GroupUserCategoryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GroupUserCategoryUtil</code> to access the group user category persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GroupUserCategoryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCategory;
	private FinderPath _finderPathWithoutPaginationFindByCategory;
	private FinderPath _finderPathCountByCategory;

	/**
	 * Returns all the group user categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the matching group user categories
	 */
	@Override
	public List<GroupUserCategory> findByCategory(long categoryId) {
		return findByCategory(
			categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group user categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @return the range of matching group user categories
	 */
	@Override
	public List<GroupUserCategory> findByCategory(
		long categoryId, int start, int end) {

		return findByCategory(categoryId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the group user categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user categories
	 */
	@Override
	public List<GroupUserCategory> findByCategory(
		long categoryId, int start, int end,
		OrderByComparator<GroupUserCategory> orderByComparator) {

		return findByCategory(categoryId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group user categories where categoryId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param categoryId the category ID
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user categories
	 */
	@Override
	public List<GroupUserCategory> findByCategory(
		long categoryId, int start, int end,
		OrderByComparator<GroupUserCategory> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCategory;
				finderArgs = new Object[] {categoryId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCategory;
			finderArgs = new Object[] {
				categoryId, start, end, orderByComparator
			};
		}

		List<GroupUserCategory> list = null;

		if (useFinderCache) {
			list = (List<GroupUserCategory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GroupUserCategory groupUserCategory : list) {
					if (categoryId != groupUserCategory.getCategoryId()) {
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

			query.append(_SQL_SELECT_GROUPUSERCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(GroupUserCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

				list = (List<GroupUserCategory>)QueryUtil.list(
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
	 * Returns the first group user category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user category
	 * @throws NoSuchGroupUserCategoryException if a matching group user category could not be found
	 */
	@Override
	public GroupUserCategory findByCategory_First(
			long categoryId,
			OrderByComparator<GroupUserCategory> orderByComparator)
		throws NoSuchGroupUserCategoryException {

		GroupUserCategory groupUserCategory = fetchByCategory_First(
			categoryId, orderByComparator);

		if (groupUserCategory != null) {
			return groupUserCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append("}");

		throw new NoSuchGroupUserCategoryException(msg.toString());
	}

	/**
	 * Returns the first group user category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user category, or <code>null</code> if a matching group user category could not be found
	 */
	@Override
	public GroupUserCategory fetchByCategory_First(
		long categoryId,
		OrderByComparator<GroupUserCategory> orderByComparator) {

		List<GroupUserCategory> list = findByCategory(
			categoryId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last group user category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user category
	 * @throws NoSuchGroupUserCategoryException if a matching group user category could not be found
	 */
	@Override
	public GroupUserCategory findByCategory_Last(
			long categoryId,
			OrderByComparator<GroupUserCategory> orderByComparator)
		throws NoSuchGroupUserCategoryException {

		GroupUserCategory groupUserCategory = fetchByCategory_Last(
			categoryId, orderByComparator);

		if (groupUserCategory != null) {
			return groupUserCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("categoryId=");
		msg.append(categoryId);

		msg.append("}");

		throw new NoSuchGroupUserCategoryException(msg.toString());
	}

	/**
	 * Returns the last group user category in the ordered set where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user category, or <code>null</code> if a matching group user category could not be found
	 */
	@Override
	public GroupUserCategory fetchByCategory_Last(
		long categoryId,
		OrderByComparator<GroupUserCategory> orderByComparator) {

		int count = countByCategory(categoryId);

		if (count == 0) {
			return null;
		}

		List<GroupUserCategory> list = findByCategory(
			categoryId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the group user categories before and after the current group user category in the ordered set where categoryId = &#63;.
	 *
	 * @param groupUserCategoryPK the primary key of the current group user category
	 * @param categoryId the category ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user category
	 * @throws NoSuchGroupUserCategoryException if a group user category with the primary key could not be found
	 */
	@Override
	public GroupUserCategory[] findByCategory_PrevAndNext(
			GroupUserCategoryPK groupUserCategoryPK, long categoryId,
			OrderByComparator<GroupUserCategory> orderByComparator)
		throws NoSuchGroupUserCategoryException {

		GroupUserCategory groupUserCategory = findByPrimaryKey(
			groupUserCategoryPK);

		Session session = null;

		try {
			session = openSession();

			GroupUserCategory[] array = new GroupUserCategoryImpl[3];

			array[0] = getByCategory_PrevAndNext(
				session, groupUserCategory, categoryId, orderByComparator,
				true);

			array[1] = groupUserCategory;

			array[2] = getByCategory_PrevAndNext(
				session, groupUserCategory, categoryId, orderByComparator,
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

	protected GroupUserCategory getByCategory_PrevAndNext(
		Session session, GroupUserCategory groupUserCategory, long categoryId,
		OrderByComparator<GroupUserCategory> orderByComparator,
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

		query.append(_SQL_SELECT_GROUPUSERCATEGORY_WHERE);

		query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

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
			query.append(GroupUserCategoryModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(categoryId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						groupUserCategory)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<GroupUserCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the group user categories where categoryId = &#63; from the database.
	 *
	 * @param categoryId the category ID
	 */
	@Override
	public void removeByCategory(long categoryId) {
		for (GroupUserCategory groupUserCategory :
				findByCategory(
					categoryId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(groupUserCategory);
		}
	}

	/**
	 * Returns the number of group user categories where categoryId = &#63;.
	 *
	 * @param categoryId the category ID
	 * @return the number of matching group user categories
	 */
	@Override
	public int countByCategory(long categoryId) {
		FinderPath finderPath = _finderPathCountByCategory;

		Object[] finderArgs = new Object[] {categoryId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GROUPUSERCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_CATEGORY_CATEGORYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(categoryId);

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

	private static final String _FINDER_COLUMN_CATEGORY_CATEGORYID_2 =
		"groupUserCategory.id.categoryId = ?";

	private FinderPath _finderPathWithPaginationFindByGroupUser;
	private FinderPath _finderPathWithoutPaginationFindByGroupUser;
	private FinderPath _finderPathCountByGroupUser;

	/**
	 * Returns all the group user categories where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching group user categories
	 */
	@Override
	public List<GroupUserCategory> findByGroupUser(long groupUserId) {
		return findByGroupUser(
			groupUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group user categories where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @return the range of matching group user categories
	 */
	@Override
	public List<GroupUserCategory> findByGroupUser(
		long groupUserId, int start, int end) {

		return findByGroupUser(groupUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the group user categories where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group user categories
	 */
	@Override
	public List<GroupUserCategory> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupUserCategory> orderByComparator) {

		return findByGroupUser(
			groupUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group user categories where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group user categories
	 */
	@Override
	public List<GroupUserCategory> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupUserCategory> orderByComparator,
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

		List<GroupUserCategory> list = null;

		if (useFinderCache) {
			list = (List<GroupUserCategory>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GroupUserCategory groupUserCategory : list) {
					if (groupUserId != groupUserCategory.getGroupUserId()) {
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

			query.append(_SQL_SELECT_GROUPUSERCATEGORY_WHERE);

			query.append(_FINDER_COLUMN_GROUPUSER_GROUPUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(GroupUserCategoryModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupUserId);

				list = (List<GroupUserCategory>)QueryUtil.list(
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
	 * Returns the first group user category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user category
	 * @throws NoSuchGroupUserCategoryException if a matching group user category could not be found
	 */
	@Override
	public GroupUserCategory findByGroupUser_First(
			long groupUserId,
			OrderByComparator<GroupUserCategory> orderByComparator)
		throws NoSuchGroupUserCategoryException {

		GroupUserCategory groupUserCategory = fetchByGroupUser_First(
			groupUserId, orderByComparator);

		if (groupUserCategory != null) {
			return groupUserCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupUserId=");
		msg.append(groupUserId);

		msg.append("}");

		throw new NoSuchGroupUserCategoryException(msg.toString());
	}

	/**
	 * Returns the first group user category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user category, or <code>null</code> if a matching group user category could not be found
	 */
	@Override
	public GroupUserCategory fetchByGroupUser_First(
		long groupUserId,
		OrderByComparator<GroupUserCategory> orderByComparator) {

		List<GroupUserCategory> list = findByGroupUser(
			groupUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last group user category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user category
	 * @throws NoSuchGroupUserCategoryException if a matching group user category could not be found
	 */
	@Override
	public GroupUserCategory findByGroupUser_Last(
			long groupUserId,
			OrderByComparator<GroupUserCategory> orderByComparator)
		throws NoSuchGroupUserCategoryException {

		GroupUserCategory groupUserCategory = fetchByGroupUser_Last(
			groupUserId, orderByComparator);

		if (groupUserCategory != null) {
			return groupUserCategory;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupUserId=");
		msg.append(groupUserId);

		msg.append("}");

		throw new NoSuchGroupUserCategoryException(msg.toString());
	}

	/**
	 * Returns the last group user category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user category, or <code>null</code> if a matching group user category could not be found
	 */
	@Override
	public GroupUserCategory fetchByGroupUser_Last(
		long groupUserId,
		OrderByComparator<GroupUserCategory> orderByComparator) {

		int count = countByGroupUser(groupUserId);

		if (count == 0) {
			return null;
		}

		List<GroupUserCategory> list = findByGroupUser(
			groupUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the group user categories before and after the current group user category in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserCategoryPK the primary key of the current group user category
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user category
	 * @throws NoSuchGroupUserCategoryException if a group user category with the primary key could not be found
	 */
	@Override
	public GroupUserCategory[] findByGroupUser_PrevAndNext(
			GroupUserCategoryPK groupUserCategoryPK, long groupUserId,
			OrderByComparator<GroupUserCategory> orderByComparator)
		throws NoSuchGroupUserCategoryException {

		GroupUserCategory groupUserCategory = findByPrimaryKey(
			groupUserCategoryPK);

		Session session = null;

		try {
			session = openSession();

			GroupUserCategory[] array = new GroupUserCategoryImpl[3];

			array[0] = getByGroupUser_PrevAndNext(
				session, groupUserCategory, groupUserId, orderByComparator,
				true);

			array[1] = groupUserCategory;

			array[2] = getByGroupUser_PrevAndNext(
				session, groupUserCategory, groupUserId, orderByComparator,
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

	protected GroupUserCategory getByGroupUser_PrevAndNext(
		Session session, GroupUserCategory groupUserCategory, long groupUserId,
		OrderByComparator<GroupUserCategory> orderByComparator,
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

		query.append(_SQL_SELECT_GROUPUSERCATEGORY_WHERE);

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
			query.append(GroupUserCategoryModelImpl.ORDER_BY_JPQL);
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
						groupUserCategory)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<GroupUserCategory> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the group user categories where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	@Override
	public void removeByGroupUser(long groupUserId) {
		for (GroupUserCategory groupUserCategory :
				findByGroupUser(
					groupUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(groupUserCategory);
		}
	}

	/**
	 * Returns the number of group user categories where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching group user categories
	 */
	@Override
	public int countByGroupUser(long groupUserId) {
		FinderPath finderPath = _finderPathCountByGroupUser;

		Object[] finderArgs = new Object[] {groupUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GROUPUSERCATEGORY_WHERE);

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
		"groupUserCategory.id.groupUserId = ?";

	public GroupUserCategoryPersistenceImpl() {
		setModelClass(GroupUserCategory.class);

		setModelImplClass(GroupUserCategoryImpl.class);
		setModelPKClass(GroupUserCategoryPK.class);
	}

	/**
	 * Caches the group user category in the entity cache if it is enabled.
	 *
	 * @param groupUserCategory the group user category
	 */
	@Override
	public void cacheResult(GroupUserCategory groupUserCategory) {
		entityCache.putResult(
			entityCacheEnabled, GroupUserCategoryImpl.class,
			groupUserCategory.getPrimaryKey(), groupUserCategory);

		groupUserCategory.resetOriginalValues();
	}

	/**
	 * Caches the group user categories in the entity cache if it is enabled.
	 *
	 * @param groupUserCategories the group user categories
	 */
	@Override
	public void cacheResult(List<GroupUserCategory> groupUserCategories) {
		for (GroupUserCategory groupUserCategory : groupUserCategories) {
			if (entityCache.getResult(
					entityCacheEnabled, GroupUserCategoryImpl.class,
					groupUserCategory.getPrimaryKey()) == null) {

				cacheResult(groupUserCategory);
			}
			else {
				groupUserCategory.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all group user categories.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GroupUserCategoryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the group user category.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GroupUserCategory groupUserCategory) {
		entityCache.removeResult(
			entityCacheEnabled, GroupUserCategoryImpl.class,
			groupUserCategory.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GroupUserCategory> groupUserCategories) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GroupUserCategory groupUserCategory : groupUserCategories) {
			entityCache.removeResult(
				entityCacheEnabled, GroupUserCategoryImpl.class,
				groupUserCategory.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, GroupUserCategoryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new group user category with the primary key. Does not add the group user category to the database.
	 *
	 * @param groupUserCategoryPK the primary key for the new group user category
	 * @return the new group user category
	 */
	@Override
	public GroupUserCategory create(GroupUserCategoryPK groupUserCategoryPK) {
		GroupUserCategory groupUserCategory = new GroupUserCategoryImpl();

		groupUserCategory.setNew(true);
		groupUserCategory.setPrimaryKey(groupUserCategoryPK);

		return groupUserCategory;
	}

	/**
	 * Removes the group user category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserCategoryPK the primary key of the group user category
	 * @return the group user category that was removed
	 * @throws NoSuchGroupUserCategoryException if a group user category with the primary key could not be found
	 */
	@Override
	public GroupUserCategory remove(GroupUserCategoryPK groupUserCategoryPK)
		throws NoSuchGroupUserCategoryException {

		return remove((Serializable)groupUserCategoryPK);
	}

	/**
	 * Removes the group user category with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the group user category
	 * @return the group user category that was removed
	 * @throws NoSuchGroupUserCategoryException if a group user category with the primary key could not be found
	 */
	@Override
	public GroupUserCategory remove(Serializable primaryKey)
		throws NoSuchGroupUserCategoryException {

		Session session = null;

		try {
			session = openSession();

			GroupUserCategory groupUserCategory =
				(GroupUserCategory)session.get(
					GroupUserCategoryImpl.class, primaryKey);

			if (groupUserCategory == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGroupUserCategoryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(groupUserCategory);
		}
		catch (NoSuchGroupUserCategoryException noSuchEntityException) {
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
	protected GroupUserCategory removeImpl(
		GroupUserCategory groupUserCategory) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(groupUserCategory)) {
				groupUserCategory = (GroupUserCategory)session.get(
					GroupUserCategoryImpl.class,
					groupUserCategory.getPrimaryKeyObj());
			}

			if (groupUserCategory != null) {
				session.delete(groupUserCategory);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (groupUserCategory != null) {
			clearCache(groupUserCategory);
		}

		return groupUserCategory;
	}

	@Override
	public GroupUserCategory updateImpl(GroupUserCategory groupUserCategory) {
		boolean isNew = groupUserCategory.isNew();

		if (!(groupUserCategory instanceof GroupUserCategoryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(groupUserCategory.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					groupUserCategory);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in groupUserCategory proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GroupUserCategory implementation " +
					groupUserCategory.getClass());
		}

		GroupUserCategoryModelImpl groupUserCategoryModelImpl =
			(GroupUserCategoryModelImpl)groupUserCategory;

		Session session = null;

		try {
			session = openSession();

			if (groupUserCategory.isNew()) {
				session.save(groupUserCategory);

				groupUserCategory.setNew(false);
			}
			else {
				groupUserCategory = (GroupUserCategory)session.merge(
					groupUserCategory);
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
				groupUserCategoryModelImpl.getCategoryId()
			};

			finderCache.removeResult(_finderPathCountByCategory, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByCategory, args);

			args = new Object[] {groupUserCategoryModelImpl.getGroupUserId()};

			finderCache.removeResult(_finderPathCountByGroupUser, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupUser, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((groupUserCategoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByCategory.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					groupUserCategoryModelImpl.getOriginalCategoryId()
				};

				finderCache.removeResult(_finderPathCountByCategory, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCategory, args);

				args = new Object[] {
					groupUserCategoryModelImpl.getCategoryId()
				};

				finderCache.removeResult(_finderPathCountByCategory, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByCategory, args);
			}

			if ((groupUserCategoryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupUser.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					groupUserCategoryModelImpl.getOriginalGroupUserId()
				};

				finderCache.removeResult(_finderPathCountByGroupUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupUser, args);

				args = new Object[] {
					groupUserCategoryModelImpl.getGroupUserId()
				};

				finderCache.removeResult(_finderPathCountByGroupUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupUser, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, GroupUserCategoryImpl.class,
			groupUserCategory.getPrimaryKey(), groupUserCategory, false);

		groupUserCategory.resetOriginalValues();

		return groupUserCategory;
	}

	/**
	 * Returns the group user category with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the group user category
	 * @return the group user category
	 * @throws NoSuchGroupUserCategoryException if a group user category with the primary key could not be found
	 */
	@Override
	public GroupUserCategory findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGroupUserCategoryException {

		GroupUserCategory groupUserCategory = fetchByPrimaryKey(primaryKey);

		if (groupUserCategory == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGroupUserCategoryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return groupUserCategory;
	}

	/**
	 * Returns the group user category with the primary key or throws a <code>NoSuchGroupUserCategoryException</code> if it could not be found.
	 *
	 * @param groupUserCategoryPK the primary key of the group user category
	 * @return the group user category
	 * @throws NoSuchGroupUserCategoryException if a group user category with the primary key could not be found
	 */
	@Override
	public GroupUserCategory findByPrimaryKey(
			GroupUserCategoryPK groupUserCategoryPK)
		throws NoSuchGroupUserCategoryException {

		return findByPrimaryKey((Serializable)groupUserCategoryPK);
	}

	/**
	 * Returns the group user category with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupUserCategoryPK the primary key of the group user category
	 * @return the group user category, or <code>null</code> if a group user category with the primary key could not be found
	 */
	@Override
	public GroupUserCategory fetchByPrimaryKey(
		GroupUserCategoryPK groupUserCategoryPK) {

		return fetchByPrimaryKey((Serializable)groupUserCategoryPK);
	}

	/**
	 * Returns all the group user categories.
	 *
	 * @return the group user categories
	 */
	@Override
	public List<GroupUserCategory> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group user categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @return the range of group user categories
	 */
	@Override
	public List<GroupUserCategory> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the group user categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group user categories
	 */
	@Override
	public List<GroupUserCategory> findAll(
		int start, int end,
		OrderByComparator<GroupUserCategory> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group user categories.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserCategoryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group user categories
	 * @param end the upper bound of the range of group user categories (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group user categories
	 */
	@Override
	public List<GroupUserCategory> findAll(
		int start, int end,
		OrderByComparator<GroupUserCategory> orderByComparator,
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

		List<GroupUserCategory> list = null;

		if (useFinderCache) {
			list = (List<GroupUserCategory>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GROUPUSERCATEGORY);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GROUPUSERCATEGORY;

				sql = sql.concat(GroupUserCategoryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<GroupUserCategory>)QueryUtil.list(
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
	 * Removes all the group user categories from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GroupUserCategory groupUserCategory : findAll()) {
			remove(groupUserCategory);
		}
	}

	/**
	 * Returns the number of group user categories.
	 *
	 * @return the number of group user categories
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GROUPUSERCATEGORY);

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
		return "groupUserCategoryPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GROUPUSERCATEGORY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GroupUserCategoryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the group user category persistence.
	 */
	@Activate
	public void activate() {
		GroupUserCategoryModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		GroupUserCategoryModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByCategory = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCategory",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByCategory = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCategory",
			new String[] {Long.class.getName()},
			GroupUserCategoryModelImpl.CATEGORYID_COLUMN_BITMASK);

		_finderPathCountByCategory = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCategory",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByGroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupUser",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserCategoryImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupUser",
			new String[] {Long.class.getName()},
			GroupUserCategoryModelImpl.GROUPUSERID_COLUMN_BITMASK);

		_finderPathCountByGroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupUser",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(GroupUserCategoryImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.qa.service.model.GroupUserCategory"),
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

	private static final String _SQL_SELECT_GROUPUSERCATEGORY =
		"SELECT groupUserCategory FROM GroupUserCategory groupUserCategory";

	private static final String _SQL_SELECT_GROUPUSERCATEGORY_WHERE =
		"SELECT groupUserCategory FROM GroupUserCategory groupUserCategory WHERE ";

	private static final String _SQL_COUNT_GROUPUSERCATEGORY =
		"SELECT COUNT(groupUserCategory) FROM GroupUserCategory groupUserCategory";

	private static final String _SQL_COUNT_GROUPUSERCATEGORY_WHERE =
		"SELECT COUNT(groupUserCategory) FROM GroupUserCategory groupUserCategory WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "groupUserCategory.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GroupUserCategory exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No GroupUserCategory exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GroupUserCategoryPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"groupUserId", "categoryId"});

	static {
		try {
			Class.forName(ecoit_qaPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}