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

import com.ecoit.elegaldocument.exception.NoSuchGroupFieldException;
import com.ecoit.elegaldocument.model.GroupField;
import com.ecoit.elegaldocument.model.impl.GroupFieldImpl;
import com.ecoit.elegaldocument.model.impl.GroupFieldModelImpl;
import com.ecoit.elegaldocument.service.persistence.GroupFieldPK;
import com.ecoit.elegaldocument.service.persistence.GroupFieldPersistence;
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
 * The persistence implementation for the group field service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = GroupFieldPersistence.class)
public class GroupFieldPersistenceImpl
	extends BasePersistenceImpl<GroupField> implements GroupFieldPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GroupFieldUtil</code> to access the group field persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GroupFieldImpl.class.getName();

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
	 * Returns all the group fields where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching group fields
	 */
	@Override
	public List<GroupField> findByGroupUser(long groupUserId) {
		return findByGroupUser(
			groupUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group fields where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group fields
	 * @param end the upper bound of the range of group fields (not inclusive)
	 * @return the range of matching group fields
	 */
	@Override
	public List<GroupField> findByGroupUser(
		long groupUserId, int start, int end) {

		return findByGroupUser(groupUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the group fields where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group fields
	 * @param end the upper bound of the range of group fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group fields
	 */
	@Override
	public List<GroupField> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupField> orderByComparator) {

		return findByGroupUser(
			groupUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group fields where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupFieldModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group fields
	 * @param end the upper bound of the range of group fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group fields
	 */
	@Override
	public List<GroupField> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupField> orderByComparator,
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

		List<GroupField> list = null;

		if (useFinderCache) {
			list = (List<GroupField>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GroupField groupField : list) {
					if (groupUserId != groupField.getGroupUserId()) {
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

			query.append(_SQL_SELECT_GROUPFIELD_WHERE);

			query.append(_FINDER_COLUMN_GROUPUSER_GROUPUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(GroupFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupUserId);

				list = (List<GroupField>)QueryUtil.list(
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
	 * Returns the first group field in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group field
	 * @throws NoSuchGroupFieldException if a matching group field could not be found
	 */
	@Override
	public GroupField findByGroupUser_First(
			long groupUserId, OrderByComparator<GroupField> orderByComparator)
		throws NoSuchGroupFieldException {

		GroupField groupField = fetchByGroupUser_First(
			groupUserId, orderByComparator);

		if (groupField != null) {
			return groupField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupUserId=");
		msg.append(groupUserId);

		msg.append("}");

		throw new NoSuchGroupFieldException(msg.toString());
	}

	/**
	 * Returns the first group field in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group field, or <code>null</code> if a matching group field could not be found
	 */
	@Override
	public GroupField fetchByGroupUser_First(
		long groupUserId, OrderByComparator<GroupField> orderByComparator) {

		List<GroupField> list = findByGroupUser(
			groupUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last group field in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group field
	 * @throws NoSuchGroupFieldException if a matching group field could not be found
	 */
	@Override
	public GroupField findByGroupUser_Last(
			long groupUserId, OrderByComparator<GroupField> orderByComparator)
		throws NoSuchGroupFieldException {

		GroupField groupField = fetchByGroupUser_Last(
			groupUserId, orderByComparator);

		if (groupField != null) {
			return groupField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupUserId=");
		msg.append(groupUserId);

		msg.append("}");

		throw new NoSuchGroupFieldException(msg.toString());
	}

	/**
	 * Returns the last group field in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group field, or <code>null</code> if a matching group field could not be found
	 */
	@Override
	public GroupField fetchByGroupUser_Last(
		long groupUserId, OrderByComparator<GroupField> orderByComparator) {

		int count = countByGroupUser(groupUserId);

		if (count == 0) {
			return null;
		}

		List<GroupField> list = findByGroupUser(
			groupUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the group fields before and after the current group field in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupFieldPK the primary key of the current group field
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group field
	 * @throws NoSuchGroupFieldException if a group field with the primary key could not be found
	 */
	@Override
	public GroupField[] findByGroupUser_PrevAndNext(
			GroupFieldPK groupFieldPK, long groupUserId,
			OrderByComparator<GroupField> orderByComparator)
		throws NoSuchGroupFieldException {

		GroupField groupField = findByPrimaryKey(groupFieldPK);

		Session session = null;

		try {
			session = openSession();

			GroupField[] array = new GroupFieldImpl[3];

			array[0] = getByGroupUser_PrevAndNext(
				session, groupField, groupUserId, orderByComparator, true);

			array[1] = groupField;

			array[2] = getByGroupUser_PrevAndNext(
				session, groupField, groupUserId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GroupField getByGroupUser_PrevAndNext(
		Session session, GroupField groupField, long groupUserId,
		OrderByComparator<GroupField> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GROUPFIELD_WHERE);

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
			query.append(GroupFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupUserId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(groupField)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<GroupField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the group fields where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	@Override
	public void removeByGroupUser(long groupUserId) {
		for (GroupField groupField :
				findByGroupUser(
					groupUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(groupField);
		}
	}

	/**
	 * Returns the number of group fields where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching group fields
	 */
	@Override
	public int countByGroupUser(long groupUserId) {
		FinderPath finderPath = _finderPathCountByGroupUser;

		Object[] finderArgs = new Object[] {groupUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GROUPFIELD_WHERE);

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
		"groupField.id.groupUserId = ?";

	private FinderPath _finderPathWithPaginationFindByField;
	private FinderPath _finderPathWithoutPaginationFindByField;
	private FinderPath _finderPathCountByField;

	/**
	 * Returns all the group fields where fieldid = &#63;.
	 *
	 * @param fieldid the fieldid
	 * @return the matching group fields
	 */
	@Override
	public List<GroupField> findByField(long fieldid) {
		return findByField(fieldid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group fields where fieldid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupFieldModelImpl</code>.
	 * </p>
	 *
	 * @param fieldid the fieldid
	 * @param start the lower bound of the range of group fields
	 * @param end the upper bound of the range of group fields (not inclusive)
	 * @return the range of matching group fields
	 */
	@Override
	public List<GroupField> findByField(long fieldid, int start, int end) {
		return findByField(fieldid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the group fields where fieldid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupFieldModelImpl</code>.
	 * </p>
	 *
	 * @param fieldid the fieldid
	 * @param start the lower bound of the range of group fields
	 * @param end the upper bound of the range of group fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group fields
	 */
	@Override
	public List<GroupField> findByField(
		long fieldid, int start, int end,
		OrderByComparator<GroupField> orderByComparator) {

		return findByField(fieldid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group fields where fieldid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupFieldModelImpl</code>.
	 * </p>
	 *
	 * @param fieldid the fieldid
	 * @param start the lower bound of the range of group fields
	 * @param end the upper bound of the range of group fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group fields
	 */
	@Override
	public List<GroupField> findByField(
		long fieldid, int start, int end,
		OrderByComparator<GroupField> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByField;
				finderArgs = new Object[] {fieldid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByField;
			finderArgs = new Object[] {fieldid, start, end, orderByComparator};
		}

		List<GroupField> list = null;

		if (useFinderCache) {
			list = (List<GroupField>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GroupField groupField : list) {
					if (fieldid != groupField.getFieldid()) {
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

			query.append(_SQL_SELECT_GROUPFIELD_WHERE);

			query.append(_FINDER_COLUMN_FIELD_FIELDID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(GroupFieldModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fieldid);

				list = (List<GroupField>)QueryUtil.list(
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
	 * Returns the first group field in the ordered set where fieldid = &#63;.
	 *
	 * @param fieldid the fieldid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group field
	 * @throws NoSuchGroupFieldException if a matching group field could not be found
	 */
	@Override
	public GroupField findByField_First(
			long fieldid, OrderByComparator<GroupField> orderByComparator)
		throws NoSuchGroupFieldException {

		GroupField groupField = fetchByField_First(fieldid, orderByComparator);

		if (groupField != null) {
			return groupField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fieldid=");
		msg.append(fieldid);

		msg.append("}");

		throw new NoSuchGroupFieldException(msg.toString());
	}

	/**
	 * Returns the first group field in the ordered set where fieldid = &#63;.
	 *
	 * @param fieldid the fieldid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group field, or <code>null</code> if a matching group field could not be found
	 */
	@Override
	public GroupField fetchByField_First(
		long fieldid, OrderByComparator<GroupField> orderByComparator) {

		List<GroupField> list = findByField(fieldid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last group field in the ordered set where fieldid = &#63;.
	 *
	 * @param fieldid the fieldid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group field
	 * @throws NoSuchGroupFieldException if a matching group field could not be found
	 */
	@Override
	public GroupField findByField_Last(
			long fieldid, OrderByComparator<GroupField> orderByComparator)
		throws NoSuchGroupFieldException {

		GroupField groupField = fetchByField_Last(fieldid, orderByComparator);

		if (groupField != null) {
			return groupField;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("fieldid=");
		msg.append(fieldid);

		msg.append("}");

		throw new NoSuchGroupFieldException(msg.toString());
	}

	/**
	 * Returns the last group field in the ordered set where fieldid = &#63;.
	 *
	 * @param fieldid the fieldid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group field, or <code>null</code> if a matching group field could not be found
	 */
	@Override
	public GroupField fetchByField_Last(
		long fieldid, OrderByComparator<GroupField> orderByComparator) {

		int count = countByField(fieldid);

		if (count == 0) {
			return null;
		}

		List<GroupField> list = findByField(
			fieldid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the group fields before and after the current group field in the ordered set where fieldid = &#63;.
	 *
	 * @param groupFieldPK the primary key of the current group field
	 * @param fieldid the fieldid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group field
	 * @throws NoSuchGroupFieldException if a group field with the primary key could not be found
	 */
	@Override
	public GroupField[] findByField_PrevAndNext(
			GroupFieldPK groupFieldPK, long fieldid,
			OrderByComparator<GroupField> orderByComparator)
		throws NoSuchGroupFieldException {

		GroupField groupField = findByPrimaryKey(groupFieldPK);

		Session session = null;

		try {
			session = openSession();

			GroupField[] array = new GroupFieldImpl[3];

			array[0] = getByField_PrevAndNext(
				session, groupField, fieldid, orderByComparator, true);

			array[1] = groupField;

			array[2] = getByField_PrevAndNext(
				session, groupField, fieldid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected GroupField getByField_PrevAndNext(
		Session session, GroupField groupField, long fieldid,
		OrderByComparator<GroupField> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_GROUPFIELD_WHERE);

		query.append(_FINDER_COLUMN_FIELD_FIELDID_2);

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
			query.append(GroupFieldModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(fieldid);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(groupField)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<GroupField> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the group fields where fieldid = &#63; from the database.
	 *
	 * @param fieldid the fieldid
	 */
	@Override
	public void removeByField(long fieldid) {
		for (GroupField groupField :
				findByField(
					fieldid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(groupField);
		}
	}

	/**
	 * Returns the number of group fields where fieldid = &#63;.
	 *
	 * @param fieldid the fieldid
	 * @return the number of matching group fields
	 */
	@Override
	public int countByField(long fieldid) {
		FinderPath finderPath = _finderPathCountByField;

		Object[] finderArgs = new Object[] {fieldid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GROUPFIELD_WHERE);

			query.append(_FINDER_COLUMN_FIELD_FIELDID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(fieldid);

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

	private static final String _FINDER_COLUMN_FIELD_FIELDID_2 =
		"groupField.id.fieldid = ?";

	public GroupFieldPersistenceImpl() {
		setModelClass(GroupField.class);

		setModelImplClass(GroupFieldImpl.class);
		setModelPKClass(GroupFieldPK.class);
	}

	/**
	 * Caches the group field in the entity cache if it is enabled.
	 *
	 * @param groupField the group field
	 */
	@Override
	public void cacheResult(GroupField groupField) {
		entityCache.putResult(
			entityCacheEnabled, GroupFieldImpl.class,
			groupField.getPrimaryKey(), groupField);

		groupField.resetOriginalValues();
	}

	/**
	 * Caches the group fields in the entity cache if it is enabled.
	 *
	 * @param groupFields the group fields
	 */
	@Override
	public void cacheResult(List<GroupField> groupFields) {
		for (GroupField groupField : groupFields) {
			if (entityCache.getResult(
					entityCacheEnabled, GroupFieldImpl.class,
					groupField.getPrimaryKey()) == null) {

				cacheResult(groupField);
			}
			else {
				groupField.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all group fields.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GroupFieldImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the group field.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GroupField groupField) {
		entityCache.removeResult(
			entityCacheEnabled, GroupFieldImpl.class,
			groupField.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GroupField> groupFields) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GroupField groupField : groupFields) {
			entityCache.removeResult(
				entityCacheEnabled, GroupFieldImpl.class,
				groupField.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, GroupFieldImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new group field with the primary key. Does not add the group field to the database.
	 *
	 * @param groupFieldPK the primary key for the new group field
	 * @return the new group field
	 */
	@Override
	public GroupField create(GroupFieldPK groupFieldPK) {
		GroupField groupField = new GroupFieldImpl();

		groupField.setNew(true);
		groupField.setPrimaryKey(groupFieldPK);

		return groupField;
	}

	/**
	 * Removes the group field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupFieldPK the primary key of the group field
	 * @return the group field that was removed
	 * @throws NoSuchGroupFieldException if a group field with the primary key could not be found
	 */
	@Override
	public GroupField remove(GroupFieldPK groupFieldPK)
		throws NoSuchGroupFieldException {

		return remove((Serializable)groupFieldPK);
	}

	/**
	 * Removes the group field with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the group field
	 * @return the group field that was removed
	 * @throws NoSuchGroupFieldException if a group field with the primary key could not be found
	 */
	@Override
	public GroupField remove(Serializable primaryKey)
		throws NoSuchGroupFieldException {

		Session session = null;

		try {
			session = openSession();

			GroupField groupField = (GroupField)session.get(
				GroupFieldImpl.class, primaryKey);

			if (groupField == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGroupFieldException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(groupField);
		}
		catch (NoSuchGroupFieldException noSuchEntityException) {
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
	protected GroupField removeImpl(GroupField groupField) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(groupField)) {
				groupField = (GroupField)session.get(
					GroupFieldImpl.class, groupField.getPrimaryKeyObj());
			}

			if (groupField != null) {
				session.delete(groupField);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (groupField != null) {
			clearCache(groupField);
		}

		return groupField;
	}

	@Override
	public GroupField updateImpl(GroupField groupField) {
		boolean isNew = groupField.isNew();

		if (!(groupField instanceof GroupFieldModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(groupField.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(groupField);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in groupField proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GroupField implementation " +
					groupField.getClass());
		}

		GroupFieldModelImpl groupFieldModelImpl =
			(GroupFieldModelImpl)groupField;

		Session session = null;

		try {
			session = openSession();

			if (groupField.isNew()) {
				session.save(groupField);

				groupField.setNew(false);
			}
			else {
				groupField = (GroupField)session.merge(groupField);
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
			Object[] args = new Object[] {groupFieldModelImpl.getGroupUserId()};

			finderCache.removeResult(_finderPathCountByGroupUser, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupUser, args);

			args = new Object[] {groupFieldModelImpl.getFieldid()};

			finderCache.removeResult(_finderPathCountByField, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByField, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((groupFieldModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupUser.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					groupFieldModelImpl.getOriginalGroupUserId()
				};

				finderCache.removeResult(_finderPathCountByGroupUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupUser, args);

				args = new Object[] {groupFieldModelImpl.getGroupUserId()};

				finderCache.removeResult(_finderPathCountByGroupUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupUser, args);
			}

			if ((groupFieldModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByField.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					groupFieldModelImpl.getOriginalFieldid()
				};

				finderCache.removeResult(_finderPathCountByField, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByField, args);

				args = new Object[] {groupFieldModelImpl.getFieldid()};

				finderCache.removeResult(_finderPathCountByField, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByField, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, GroupFieldImpl.class,
			groupField.getPrimaryKey(), groupField, false);

		groupField.resetOriginalValues();

		return groupField;
	}

	/**
	 * Returns the group field with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the group field
	 * @return the group field
	 * @throws NoSuchGroupFieldException if a group field with the primary key could not be found
	 */
	@Override
	public GroupField findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGroupFieldException {

		GroupField groupField = fetchByPrimaryKey(primaryKey);

		if (groupField == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGroupFieldException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return groupField;
	}

	/**
	 * Returns the group field with the primary key or throws a <code>NoSuchGroupFieldException</code> if it could not be found.
	 *
	 * @param groupFieldPK the primary key of the group field
	 * @return the group field
	 * @throws NoSuchGroupFieldException if a group field with the primary key could not be found
	 */
	@Override
	public GroupField findByPrimaryKey(GroupFieldPK groupFieldPK)
		throws NoSuchGroupFieldException {

		return findByPrimaryKey((Serializable)groupFieldPK);
	}

	/**
	 * Returns the group field with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupFieldPK the primary key of the group field
	 * @return the group field, or <code>null</code> if a group field with the primary key could not be found
	 */
	@Override
	public GroupField fetchByPrimaryKey(GroupFieldPK groupFieldPK) {
		return fetchByPrimaryKey((Serializable)groupFieldPK);
	}

	/**
	 * Returns all the group fields.
	 *
	 * @return the group fields
	 */
	@Override
	public List<GroupField> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group fields
	 * @param end the upper bound of the range of group fields (not inclusive)
	 * @return the range of group fields
	 */
	@Override
	public List<GroupField> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the group fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group fields
	 * @param end the upper bound of the range of group fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group fields
	 */
	@Override
	public List<GroupField> findAll(
		int start, int end, OrderByComparator<GroupField> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group fields.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupFieldModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group fields
	 * @param end the upper bound of the range of group fields (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group fields
	 */
	@Override
	public List<GroupField> findAll(
		int start, int end, OrderByComparator<GroupField> orderByComparator,
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

		List<GroupField> list = null;

		if (useFinderCache) {
			list = (List<GroupField>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GROUPFIELD);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GROUPFIELD;

				sql = sql.concat(GroupFieldModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<GroupField>)QueryUtil.list(
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
	 * Removes all the group fields from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GroupField groupField : findAll()) {
			remove(groupField);
		}
	}

	/**
	 * Returns the number of group fields.
	 *
	 * @return the number of group fields
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GROUPFIELD);

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
		return "groupFieldPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GROUPFIELD;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GroupFieldModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the group field persistence.
	 */
	@Activate
	public void activate() {
		GroupFieldModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		GroupFieldModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupUser",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupUser",
			new String[] {Long.class.getName()},
			GroupFieldModelImpl.GROUPUSERID_COLUMN_BITMASK);

		_finderPathCountByGroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupUser",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByField = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByField",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByField = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupFieldImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByField",
			new String[] {Long.class.getName()},
			GroupFieldModelImpl.FIELDID_COLUMN_BITMASK);

		_finderPathCountByField = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByField",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(GroupFieldImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.GroupField"),
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

	private static final String _SQL_SELECT_GROUPFIELD =
		"SELECT groupField FROM GroupField groupField";

	private static final String _SQL_SELECT_GROUPFIELD_WHERE =
		"SELECT groupField FROM GroupField groupField WHERE ";

	private static final String _SQL_COUNT_GROUPFIELD =
		"SELECT COUNT(groupField) FROM GroupField groupField";

	private static final String _SQL_COUNT_GROUPFIELD_WHERE =
		"SELECT COUNT(groupField) FROM GroupField groupField WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "groupField.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GroupField exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No GroupField exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GroupFieldPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"groupUserId", "fieldid"});

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}