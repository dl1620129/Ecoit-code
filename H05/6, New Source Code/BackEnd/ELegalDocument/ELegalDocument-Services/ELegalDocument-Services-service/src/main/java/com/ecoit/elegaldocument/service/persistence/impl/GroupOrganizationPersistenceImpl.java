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

import com.ecoit.elegaldocument.exception.NoSuchGroupOrganizationException;
import com.ecoit.elegaldocument.model.GroupOrganization;
import com.ecoit.elegaldocument.model.impl.GroupOrganizationImpl;
import com.ecoit.elegaldocument.model.impl.GroupOrganizationModelImpl;
import com.ecoit.elegaldocument.service.persistence.GroupOrganizationPK;
import com.ecoit.elegaldocument.service.persistence.GroupOrganizationPersistence;
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
 * The persistence implementation for the group organization service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Liverpool
 * @generated
 */
@Component(service = GroupOrganizationPersistence.class)
public class GroupOrganizationPersistenceImpl
	extends BasePersistenceImpl<GroupOrganization>
	implements GroupOrganizationPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GroupOrganizationUtil</code> to access the group organization persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GroupOrganizationImpl.class.getName();

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
	 * Returns all the group organizations where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the matching group organizations
	 */
	@Override
	public List<GroupOrganization> findByGroupUser(long groupUserId) {
		return findByGroupUser(
			groupUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group organizations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @return the range of matching group organizations
	 */
	@Override
	public List<GroupOrganization> findByGroupUser(
		long groupUserId, int start, int end) {

		return findByGroupUser(groupUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the group organizations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group organizations
	 */
	@Override
	public List<GroupOrganization> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupOrganization> orderByComparator) {

		return findByGroupUser(
			groupUserId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group organizations where groupUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param groupUserId the group user ID
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group organizations
	 */
	@Override
	public List<GroupOrganization> findByGroupUser(
		long groupUserId, int start, int end,
		OrderByComparator<GroupOrganization> orderByComparator,
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

		List<GroupOrganization> list = null;

		if (useFinderCache) {
			list = (List<GroupOrganization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GroupOrganization groupOrganization : list) {
					if (groupUserId != groupOrganization.getGroupUserId()) {
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

			query.append(_SQL_SELECT_GROUPORGANIZATION_WHERE);

			query.append(_FINDER_COLUMN_GROUPUSER_GROUPUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(GroupOrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupUserId);

				list = (List<GroupOrganization>)QueryUtil.list(
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
	 * Returns the first group organization in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group organization
	 * @throws NoSuchGroupOrganizationException if a matching group organization could not be found
	 */
	@Override
	public GroupOrganization findByGroupUser_First(
			long groupUserId,
			OrderByComparator<GroupOrganization> orderByComparator)
		throws NoSuchGroupOrganizationException {

		GroupOrganization groupOrganization = fetchByGroupUser_First(
			groupUserId, orderByComparator);

		if (groupOrganization != null) {
			return groupOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupUserId=");
		msg.append(groupUserId);

		msg.append("}");

		throw new NoSuchGroupOrganizationException(msg.toString());
	}

	/**
	 * Returns the first group organization in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group organization, or <code>null</code> if a matching group organization could not be found
	 */
	@Override
	public GroupOrganization fetchByGroupUser_First(
		long groupUserId,
		OrderByComparator<GroupOrganization> orderByComparator) {

		List<GroupOrganization> list = findByGroupUser(
			groupUserId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last group organization in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group organization
	 * @throws NoSuchGroupOrganizationException if a matching group organization could not be found
	 */
	@Override
	public GroupOrganization findByGroupUser_Last(
			long groupUserId,
			OrderByComparator<GroupOrganization> orderByComparator)
		throws NoSuchGroupOrganizationException {

		GroupOrganization groupOrganization = fetchByGroupUser_Last(
			groupUserId, orderByComparator);

		if (groupOrganization != null) {
			return groupOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupUserId=");
		msg.append(groupUserId);

		msg.append("}");

		throw new NoSuchGroupOrganizationException(msg.toString());
	}

	/**
	 * Returns the last group organization in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group organization, or <code>null</code> if a matching group organization could not be found
	 */
	@Override
	public GroupOrganization fetchByGroupUser_Last(
		long groupUserId,
		OrderByComparator<GroupOrganization> orderByComparator) {

		int count = countByGroupUser(groupUserId);

		if (count == 0) {
			return null;
		}

		List<GroupOrganization> list = findByGroupUser(
			groupUserId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the group organizations before and after the current group organization in the ordered set where groupUserId = &#63;.
	 *
	 * @param groupOrganizationPK the primary key of the current group organization
	 * @param groupUserId the group user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group organization
	 * @throws NoSuchGroupOrganizationException if a group organization with the primary key could not be found
	 */
	@Override
	public GroupOrganization[] findByGroupUser_PrevAndNext(
			GroupOrganizationPK groupOrganizationPK, long groupUserId,
			OrderByComparator<GroupOrganization> orderByComparator)
		throws NoSuchGroupOrganizationException {

		GroupOrganization groupOrganization = findByPrimaryKey(
			groupOrganizationPK);

		Session session = null;

		try {
			session = openSession();

			GroupOrganization[] array = new GroupOrganizationImpl[3];

			array[0] = getByGroupUser_PrevAndNext(
				session, groupOrganization, groupUserId, orderByComparator,
				true);

			array[1] = groupOrganization;

			array[2] = getByGroupUser_PrevAndNext(
				session, groupOrganization, groupUserId, orderByComparator,
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

	protected GroupOrganization getByGroupUser_PrevAndNext(
		Session session, GroupOrganization groupOrganization, long groupUserId,
		OrderByComparator<GroupOrganization> orderByComparator,
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

		query.append(_SQL_SELECT_GROUPORGANIZATION_WHERE);

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
			query.append(GroupOrganizationModelImpl.ORDER_BY_JPQL);
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
						groupOrganization)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<GroupOrganization> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the group organizations where groupUserId = &#63; from the database.
	 *
	 * @param groupUserId the group user ID
	 */
	@Override
	public void removeByGroupUser(long groupUserId) {
		for (GroupOrganization groupOrganization :
				findByGroupUser(
					groupUserId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(groupOrganization);
		}
	}

	/**
	 * Returns the number of group organizations where groupUserId = &#63;.
	 *
	 * @param groupUserId the group user ID
	 * @return the number of matching group organizations
	 */
	@Override
	public int countByGroupUser(long groupUserId) {
		FinderPath finderPath = _finderPathCountByGroupUser;

		Object[] finderArgs = new Object[] {groupUserId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GROUPORGANIZATION_WHERE);

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
		"groupOrganization.id.groupUserId = ?";

	private FinderPath _finderPathWithPaginationFindByOrganization;
	private FinderPath _finderPathWithoutPaginationFindByOrganization;
	private FinderPath _finderPathCountByOrganization;

	/**
	 * Returns all the group organizations where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @return the matching group organizations
	 */
	@Override
	public List<GroupOrganization> findByOrganization(long organizationid) {
		return findByOrganization(
			organizationid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group organizations where organizationid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationid the organizationid
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @return the range of matching group organizations
	 */
	@Override
	public List<GroupOrganization> findByOrganization(
		long organizationid, int start, int end) {

		return findByOrganization(organizationid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the group organizations where organizationid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationid the organizationid
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group organizations
	 */
	@Override
	public List<GroupOrganization> findByOrganization(
		long organizationid, int start, int end,
		OrderByComparator<GroupOrganization> orderByComparator) {

		return findByOrganization(
			organizationid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group organizations where organizationid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param organizationid the organizationid
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group organizations
	 */
	@Override
	public List<GroupOrganization> findByOrganization(
		long organizationid, int start, int end,
		OrderByComparator<GroupOrganization> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByOrganization;
				finderArgs = new Object[] {organizationid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByOrganization;
			finderArgs = new Object[] {
				organizationid, start, end, orderByComparator
			};
		}

		List<GroupOrganization> list = null;

		if (useFinderCache) {
			list = (List<GroupOrganization>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GroupOrganization groupOrganization : list) {
					if (organizationid !=
							groupOrganization.getOrganizationid()) {

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

			query.append(_SQL_SELECT_GROUPORGANIZATION_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(GroupOrganizationModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationid);

				list = (List<GroupOrganization>)QueryUtil.list(
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
	 * Returns the first group organization in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group organization
	 * @throws NoSuchGroupOrganizationException if a matching group organization could not be found
	 */
	@Override
	public GroupOrganization findByOrganization_First(
			long organizationid,
			OrderByComparator<GroupOrganization> orderByComparator)
		throws NoSuchGroupOrganizationException {

		GroupOrganization groupOrganization = fetchByOrganization_First(
			organizationid, orderByComparator);

		if (groupOrganization != null) {
			return groupOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationid=");
		msg.append(organizationid);

		msg.append("}");

		throw new NoSuchGroupOrganizationException(msg.toString());
	}

	/**
	 * Returns the first group organization in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group organization, or <code>null</code> if a matching group organization could not be found
	 */
	@Override
	public GroupOrganization fetchByOrganization_First(
		long organizationid,
		OrderByComparator<GroupOrganization> orderByComparator) {

		List<GroupOrganization> list = findByOrganization(
			organizationid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last group organization in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group organization
	 * @throws NoSuchGroupOrganizationException if a matching group organization could not be found
	 */
	@Override
	public GroupOrganization findByOrganization_Last(
			long organizationid,
			OrderByComparator<GroupOrganization> orderByComparator)
		throws NoSuchGroupOrganizationException {

		GroupOrganization groupOrganization = fetchByOrganization_Last(
			organizationid, orderByComparator);

		if (groupOrganization != null) {
			return groupOrganization;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("organizationid=");
		msg.append(organizationid);

		msg.append("}");

		throw new NoSuchGroupOrganizationException(msg.toString());
	}

	/**
	 * Returns the last group organization in the ordered set where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group organization, or <code>null</code> if a matching group organization could not be found
	 */
	@Override
	public GroupOrganization fetchByOrganization_Last(
		long organizationid,
		OrderByComparator<GroupOrganization> orderByComparator) {

		int count = countByOrganization(organizationid);

		if (count == 0) {
			return null;
		}

		List<GroupOrganization> list = findByOrganization(
			organizationid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the group organizations before and after the current group organization in the ordered set where organizationid = &#63;.
	 *
	 * @param groupOrganizationPK the primary key of the current group organization
	 * @param organizationid the organizationid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group organization
	 * @throws NoSuchGroupOrganizationException if a group organization with the primary key could not be found
	 */
	@Override
	public GroupOrganization[] findByOrganization_PrevAndNext(
			GroupOrganizationPK groupOrganizationPK, long organizationid,
			OrderByComparator<GroupOrganization> orderByComparator)
		throws NoSuchGroupOrganizationException {

		GroupOrganization groupOrganization = findByPrimaryKey(
			groupOrganizationPK);

		Session session = null;

		try {
			session = openSession();

			GroupOrganization[] array = new GroupOrganizationImpl[3];

			array[0] = getByOrganization_PrevAndNext(
				session, groupOrganization, organizationid, orderByComparator,
				true);

			array[1] = groupOrganization;

			array[2] = getByOrganization_PrevAndNext(
				session, groupOrganization, organizationid, orderByComparator,
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

	protected GroupOrganization getByOrganization_PrevAndNext(
		Session session, GroupOrganization groupOrganization,
		long organizationid,
		OrderByComparator<GroupOrganization> orderByComparator,
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

		query.append(_SQL_SELECT_GROUPORGANIZATION_WHERE);

		query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

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
			query.append(GroupOrganizationModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(organizationid);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						groupOrganization)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<GroupOrganization> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the group organizations where organizationid = &#63; from the database.
	 *
	 * @param organizationid the organizationid
	 */
	@Override
	public void removeByOrganization(long organizationid) {
		for (GroupOrganization groupOrganization :
				findByOrganization(
					organizationid, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(groupOrganization);
		}
	}

	/**
	 * Returns the number of group organizations where organizationid = &#63;.
	 *
	 * @param organizationid the organizationid
	 * @return the number of matching group organizations
	 */
	@Override
	public int countByOrganization(long organizationid) {
		FinderPath finderPath = _finderPathCountByOrganization;

		Object[] finderArgs = new Object[] {organizationid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_GROUPORGANIZATION_WHERE);

			query.append(_FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(organizationid);

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

	private static final String _FINDER_COLUMN_ORGANIZATION_ORGANIZATIONID_2 =
		"groupOrganization.id.organizationid = ?";

	public GroupOrganizationPersistenceImpl() {
		setModelClass(GroupOrganization.class);

		setModelImplClass(GroupOrganizationImpl.class);
		setModelPKClass(GroupOrganizationPK.class);
	}

	/**
	 * Caches the group organization in the entity cache if it is enabled.
	 *
	 * @param groupOrganization the group organization
	 */
	@Override
	public void cacheResult(GroupOrganization groupOrganization) {
		entityCache.putResult(
			entityCacheEnabled, GroupOrganizationImpl.class,
			groupOrganization.getPrimaryKey(), groupOrganization);

		groupOrganization.resetOriginalValues();
	}

	/**
	 * Caches the group organizations in the entity cache if it is enabled.
	 *
	 * @param groupOrganizations the group organizations
	 */
	@Override
	public void cacheResult(List<GroupOrganization> groupOrganizations) {
		for (GroupOrganization groupOrganization : groupOrganizations) {
			if (entityCache.getResult(
					entityCacheEnabled, GroupOrganizationImpl.class,
					groupOrganization.getPrimaryKey()) == null) {

				cacheResult(groupOrganization);
			}
			else {
				groupOrganization.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all group organizations.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GroupOrganizationImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the group organization.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GroupOrganization groupOrganization) {
		entityCache.removeResult(
			entityCacheEnabled, GroupOrganizationImpl.class,
			groupOrganization.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GroupOrganization> groupOrganizations) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GroupOrganization groupOrganization : groupOrganizations) {
			entityCache.removeResult(
				entityCacheEnabled, GroupOrganizationImpl.class,
				groupOrganization.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, GroupOrganizationImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new group organization with the primary key. Does not add the group organization to the database.
	 *
	 * @param groupOrganizationPK the primary key for the new group organization
	 * @return the new group organization
	 */
	@Override
	public GroupOrganization create(GroupOrganizationPK groupOrganizationPK) {
		GroupOrganization groupOrganization = new GroupOrganizationImpl();

		groupOrganization.setNew(true);
		groupOrganization.setPrimaryKey(groupOrganizationPK);

		return groupOrganization;
	}

	/**
	 * Removes the group organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupOrganizationPK the primary key of the group organization
	 * @return the group organization that was removed
	 * @throws NoSuchGroupOrganizationException if a group organization with the primary key could not be found
	 */
	@Override
	public GroupOrganization remove(GroupOrganizationPK groupOrganizationPK)
		throws NoSuchGroupOrganizationException {

		return remove((Serializable)groupOrganizationPK);
	}

	/**
	 * Removes the group organization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the group organization
	 * @return the group organization that was removed
	 * @throws NoSuchGroupOrganizationException if a group organization with the primary key could not be found
	 */
	@Override
	public GroupOrganization remove(Serializable primaryKey)
		throws NoSuchGroupOrganizationException {

		Session session = null;

		try {
			session = openSession();

			GroupOrganization groupOrganization =
				(GroupOrganization)session.get(
					GroupOrganizationImpl.class, primaryKey);

			if (groupOrganization == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGroupOrganizationException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(groupOrganization);
		}
		catch (NoSuchGroupOrganizationException noSuchEntityException) {
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
	protected GroupOrganization removeImpl(
		GroupOrganization groupOrganization) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(groupOrganization)) {
				groupOrganization = (GroupOrganization)session.get(
					GroupOrganizationImpl.class,
					groupOrganization.getPrimaryKeyObj());
			}

			if (groupOrganization != null) {
				session.delete(groupOrganization);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (groupOrganization != null) {
			clearCache(groupOrganization);
		}

		return groupOrganization;
	}

	@Override
	public GroupOrganization updateImpl(GroupOrganization groupOrganization) {
		boolean isNew = groupOrganization.isNew();

		if (!(groupOrganization instanceof GroupOrganizationModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(groupOrganization.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					groupOrganization);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in groupOrganization proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GroupOrganization implementation " +
					groupOrganization.getClass());
		}

		GroupOrganizationModelImpl groupOrganizationModelImpl =
			(GroupOrganizationModelImpl)groupOrganization;

		Session session = null;

		try {
			session = openSession();

			if (groupOrganization.isNew()) {
				session.save(groupOrganization);

				groupOrganization.setNew(false);
			}
			else {
				groupOrganization = (GroupOrganization)session.merge(
					groupOrganization);
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
				groupOrganizationModelImpl.getGroupUserId()
			};

			finderCache.removeResult(_finderPathCountByGroupUser, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroupUser, args);

			args = new Object[] {
				groupOrganizationModelImpl.getOrganizationid()
			};

			finderCache.removeResult(_finderPathCountByOrganization, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByOrganization, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((groupOrganizationModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroupUser.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					groupOrganizationModelImpl.getOriginalGroupUserId()
				};

				finderCache.removeResult(_finderPathCountByGroupUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupUser, args);

				args = new Object[] {
					groupOrganizationModelImpl.getGroupUserId()
				};

				finderCache.removeResult(_finderPathCountByGroupUser, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroupUser, args);
			}

			if ((groupOrganizationModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByOrganization.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					groupOrganizationModelImpl.getOriginalOrganizationid()
				};

				finderCache.removeResult(_finderPathCountByOrganization, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOrganization, args);

				args = new Object[] {
					groupOrganizationModelImpl.getOrganizationid()
				};

				finderCache.removeResult(_finderPathCountByOrganization, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByOrganization, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, GroupOrganizationImpl.class,
			groupOrganization.getPrimaryKey(), groupOrganization, false);

		groupOrganization.resetOriginalValues();

		return groupOrganization;
	}

	/**
	 * Returns the group organization with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the group organization
	 * @return the group organization
	 * @throws NoSuchGroupOrganizationException if a group organization with the primary key could not be found
	 */
	@Override
	public GroupOrganization findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGroupOrganizationException {

		GroupOrganization groupOrganization = fetchByPrimaryKey(primaryKey);

		if (groupOrganization == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGroupOrganizationException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return groupOrganization;
	}

	/**
	 * Returns the group organization with the primary key or throws a <code>NoSuchGroupOrganizationException</code> if it could not be found.
	 *
	 * @param groupOrganizationPK the primary key of the group organization
	 * @return the group organization
	 * @throws NoSuchGroupOrganizationException if a group organization with the primary key could not be found
	 */
	@Override
	public GroupOrganization findByPrimaryKey(
			GroupOrganizationPK groupOrganizationPK)
		throws NoSuchGroupOrganizationException {

		return findByPrimaryKey((Serializable)groupOrganizationPK);
	}

	/**
	 * Returns the group organization with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupOrganizationPK the primary key of the group organization
	 * @return the group organization, or <code>null</code> if a group organization with the primary key could not be found
	 */
	@Override
	public GroupOrganization fetchByPrimaryKey(
		GroupOrganizationPK groupOrganizationPK) {

		return fetchByPrimaryKey((Serializable)groupOrganizationPK);
	}

	/**
	 * Returns all the group organizations.
	 *
	 * @return the group organizations
	 */
	@Override
	public List<GroupOrganization> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @return the range of group organizations
	 */
	@Override
	public List<GroupOrganization> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the group organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group organizations
	 */
	@Override
	public List<GroupOrganization> findAll(
		int start, int end,
		OrderByComparator<GroupOrganization> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group organizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupOrganizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group organizations
	 * @param end the upper bound of the range of group organizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group organizations
	 */
	@Override
	public List<GroupOrganization> findAll(
		int start, int end,
		OrderByComparator<GroupOrganization> orderByComparator,
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

		List<GroupOrganization> list = null;

		if (useFinderCache) {
			list = (List<GroupOrganization>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GROUPORGANIZATION);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GROUPORGANIZATION;

				sql = sql.concat(GroupOrganizationModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<GroupOrganization>)QueryUtil.list(
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
	 * Removes all the group organizations from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GroupOrganization groupOrganization : findAll()) {
			remove(groupOrganization);
		}
	}

	/**
	 * Returns the number of group organizations.
	 *
	 * @return the number of group organizations
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GROUPORGANIZATION);

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
		return "groupOrganizationPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GROUPORGANIZATION;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GroupOrganizationModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the group organization persistence.
	 */
	@Activate
	public void activate() {
		GroupOrganizationModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		GroupOrganizationModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupOrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupOrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupOrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupUser",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupOrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupUser",
			new String[] {Long.class.getName()},
			GroupOrganizationModelImpl.GROUPUSERID_COLUMN_BITMASK);

		_finderPathCountByGroupUser = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupUser",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByOrganization = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupOrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByOrganization",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByOrganization = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupOrganizationImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByOrganization",
			new String[] {Long.class.getName()},
			GroupOrganizationModelImpl.ORGANIZATIONID_COLUMN_BITMASK);

		_finderPathCountByOrganization = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByOrganization",
			new String[] {Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(GroupOrganizationImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.ecoit.elegaldocument.model.GroupOrganization"),
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

	private static final String _SQL_SELECT_GROUPORGANIZATION =
		"SELECT groupOrganization FROM GroupOrganization groupOrganization";

	private static final String _SQL_SELECT_GROUPORGANIZATION_WHERE =
		"SELECT groupOrganization FROM GroupOrganization groupOrganization WHERE ";

	private static final String _SQL_COUNT_GROUPORGANIZATION =
		"SELECT COUNT(groupOrganization) FROM GroupOrganization groupOrganization";

	private static final String _SQL_COUNT_GROUPORGANIZATION_WHERE =
		"SELECT COUNT(groupOrganization) FROM GroupOrganization groupOrganization WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "groupOrganization.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GroupOrganization exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No GroupOrganization exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GroupOrganizationPersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"groupUserId", "organizationid"});

	static {
		try {
			Class.forName(ecoit_docPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}