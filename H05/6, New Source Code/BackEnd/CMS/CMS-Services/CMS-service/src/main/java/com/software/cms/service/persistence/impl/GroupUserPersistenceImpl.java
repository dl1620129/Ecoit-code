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

import com.software.cms.exception.NoSuchGroupUserException;
import com.software.cms.model.GroupUser;
import com.software.cms.model.impl.GroupUserImpl;
import com.software.cms.model.impl.GroupUserModelImpl;
import com.software.cms.service.persistence.GroupUserPersistence;
import com.software.cms.service.persistence.impl.constants.soft_cmsPersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the group user service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author DungNV
 * @generated
 */
@Component(service = GroupUserPersistence.class)
public class GroupUserPersistenceImpl
	extends BasePersistenceImpl<GroupUser> implements GroupUserPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>GroupUserUtil</code> to access the group user persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		GroupUserImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByGroup_Language;
	private FinderPath _finderPathWithoutPaginationFindByGroup_Language;
	private FinderPath _finderPathCountByGroup_Language;

	/**
	 * Returns all the group users where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the matching group users
	 */
	@Override
	public List<GroupUser> findByGroup_Language(long groupId, String language) {
		return findByGroup_Language(
			groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group users where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of group users
	 * @param end the upper bound of the range of group users (not inclusive)
	 * @return the range of matching group users
	 */
	@Override
	public List<GroupUser> findByGroup_Language(
		long groupId, String language, int start, int end) {

		return findByGroup_Language(groupId, language, start, end, null);
	}

	/**
	 * Returns an ordered range of all the group users where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of group users
	 * @param end the upper bound of the range of group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching group users
	 */
	@Override
	public List<GroupUser> findByGroup_Language(
		long groupId, String language, int start, int end,
		OrderByComparator<GroupUser> orderByComparator) {

		return findByGroup_Language(
			groupId, language, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group users where groupId = &#63; and language = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param start the lower bound of the range of group users
	 * @param end the upper bound of the range of group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching group users
	 */
	@Override
	public List<GroupUser> findByGroup_Language(
		long groupId, String language, int start, int end,
		OrderByComparator<GroupUser> orderByComparator,
		boolean useFinderCache) {

		language = Objects.toString(language, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByGroup_Language;
				finderArgs = new Object[] {groupId, language};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByGroup_Language;
			finderArgs = new Object[] {
				groupId, language, start, end, orderByComparator
			};
		}

		List<GroupUser> list = null;

		if (useFinderCache) {
			list = (List<GroupUser>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (GroupUser groupUser : list) {
					if ((groupId != groupUser.getGroupId()) ||
						!language.equals(groupUser.getLanguage())) {

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

			query.append(_SQL_SELECT_GROUPUSER_WHERE);

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_LANGUAGE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(GroupUserModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindLanguage) {
					qPos.add(language);
				}

				list = (List<GroupUser>)QueryUtil.list(
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
	 * Returns the first group user in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user
	 * @throws NoSuchGroupUserException if a matching group user could not be found
	 */
	@Override
	public GroupUser findByGroup_Language_First(
			long groupId, String language,
			OrderByComparator<GroupUser> orderByComparator)
		throws NoSuchGroupUserException {

		GroupUser groupUser = fetchByGroup_Language_First(
			groupId, language, orderByComparator);

		if (groupUser != null) {
			return groupUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchGroupUserException(msg.toString());
	}

	/**
	 * Returns the first group user in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching group user, or <code>null</code> if a matching group user could not be found
	 */
	@Override
	public GroupUser fetchByGroup_Language_First(
		long groupId, String language,
		OrderByComparator<GroupUser> orderByComparator) {

		List<GroupUser> list = findByGroup_Language(
			groupId, language, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last group user in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user
	 * @throws NoSuchGroupUserException if a matching group user could not be found
	 */
	@Override
	public GroupUser findByGroup_Language_Last(
			long groupId, String language,
			OrderByComparator<GroupUser> orderByComparator)
		throws NoSuchGroupUserException {

		GroupUser groupUser = fetchByGroup_Language_Last(
			groupId, language, orderByComparator);

		if (groupUser != null) {
			return groupUser;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(", language=");
		msg.append(language);

		msg.append("}");

		throw new NoSuchGroupUserException(msg.toString());
	}

	/**
	 * Returns the last group user in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching group user, or <code>null</code> if a matching group user could not be found
	 */
	@Override
	public GroupUser fetchByGroup_Language_Last(
		long groupId, String language,
		OrderByComparator<GroupUser> orderByComparator) {

		int count = countByGroup_Language(groupId, language);

		if (count == 0) {
			return null;
		}

		List<GroupUser> list = findByGroup_Language(
			groupId, language, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the group users before and after the current group user in the ordered set where groupId = &#63; and language = &#63;.
	 *
	 * @param groupUserId the primary key of the current group user
	 * @param groupId the group ID
	 * @param language the language
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next group user
	 * @throws NoSuchGroupUserException if a group user with the primary key could not be found
	 */
	@Override
	public GroupUser[] findByGroup_Language_PrevAndNext(
			long groupUserId, long groupId, String language,
			OrderByComparator<GroupUser> orderByComparator)
		throws NoSuchGroupUserException {

		language = Objects.toString(language, "");

		GroupUser groupUser = findByPrimaryKey(groupUserId);

		Session session = null;

		try {
			session = openSession();

			GroupUser[] array = new GroupUserImpl[3];

			array[0] = getByGroup_Language_PrevAndNext(
				session, groupUser, groupId, language, orderByComparator, true);

			array[1] = groupUser;

			array[2] = getByGroup_Language_PrevAndNext(
				session, groupUser, groupId, language, orderByComparator,
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

	protected GroupUser getByGroup_Language_PrevAndNext(
		Session session, GroupUser groupUser, long groupId, String language,
		OrderByComparator<GroupUser> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_GROUPUSER_WHERE);

		query.append(_FINDER_COLUMN_GROUP_LANGUAGE_GROUPID_2);

		boolean bindLanguage = false;

		if (language.isEmpty()) {
			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_LANGUAGE_3);
		}
		else {
			bindLanguage = true;

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_LANGUAGE_2);
		}

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
			query.append(GroupUserModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (bindLanguage) {
			qPos.add(language);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(groupUser)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<GroupUser> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the group users where groupId = &#63; and language = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 */
	@Override
	public void removeByGroup_Language(long groupId, String language) {
		for (GroupUser groupUser :
				findByGroup_Language(
					groupId, language, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(groupUser);
		}
	}

	/**
	 * Returns the number of group users where groupId = &#63; and language = &#63;.
	 *
	 * @param groupId the group ID
	 * @param language the language
	 * @return the number of matching group users
	 */
	@Override
	public int countByGroup_Language(long groupId, String language) {
		language = Objects.toString(language, "");

		FinderPath finderPath = _finderPathCountByGroup_Language;

		Object[] finderArgs = new Object[] {groupId, language};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_GROUPUSER_WHERE);

			query.append(_FINDER_COLUMN_GROUP_LANGUAGE_GROUPID_2);

			boolean bindLanguage = false;

			if (language.isEmpty()) {
				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_LANGUAGE_3);
			}
			else {
				bindLanguage = true;

				query.append(_FINDER_COLUMN_GROUP_LANGUAGE_LANGUAGE_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (bindLanguage) {
					qPos.add(language);
				}

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

	private static final String _FINDER_COLUMN_GROUP_LANGUAGE_GROUPID_2 =
		"groupUser.groupId = ? AND ";

	private static final String _FINDER_COLUMN_GROUP_LANGUAGE_LANGUAGE_2 =
		"groupUser.language = ?";

	private static final String _FINDER_COLUMN_GROUP_LANGUAGE_LANGUAGE_3 =
		"(groupUser.language IS NULL OR groupUser.language = '')";

	public GroupUserPersistenceImpl() {
		setModelClass(GroupUser.class);

		setModelImplClass(GroupUserImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the group user in the entity cache if it is enabled.
	 *
	 * @param groupUser the group user
	 */
	@Override
	public void cacheResult(GroupUser groupUser) {
		entityCache.putResult(
			entityCacheEnabled, GroupUserImpl.class, groupUser.getPrimaryKey(),
			groupUser);

		groupUser.resetOriginalValues();
	}

	/**
	 * Caches the group users in the entity cache if it is enabled.
	 *
	 * @param groupUsers the group users
	 */
	@Override
	public void cacheResult(List<GroupUser> groupUsers) {
		for (GroupUser groupUser : groupUsers) {
			if (entityCache.getResult(
					entityCacheEnabled, GroupUserImpl.class,
					groupUser.getPrimaryKey()) == null) {

				cacheResult(groupUser);
			}
			else {
				groupUser.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all group users.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(GroupUserImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the group user.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(GroupUser groupUser) {
		entityCache.removeResult(
			entityCacheEnabled, GroupUserImpl.class, groupUser.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<GroupUser> groupUsers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (GroupUser groupUser : groupUsers) {
			entityCache.removeResult(
				entityCacheEnabled, GroupUserImpl.class,
				groupUser.getPrimaryKey());
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, GroupUserImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new group user with the primary key. Does not add the group user to the database.
	 *
	 * @param groupUserId the primary key for the new group user
	 * @return the new group user
	 */
	@Override
	public GroupUser create(long groupUserId) {
		GroupUser groupUser = new GroupUserImpl();

		groupUser.setNew(true);
		groupUser.setPrimaryKey(groupUserId);

		return groupUser;
	}

	/**
	 * Removes the group user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param groupUserId the primary key of the group user
	 * @return the group user that was removed
	 * @throws NoSuchGroupUserException if a group user with the primary key could not be found
	 */
	@Override
	public GroupUser remove(long groupUserId) throws NoSuchGroupUserException {
		return remove((Serializable)groupUserId);
	}

	/**
	 * Removes the group user with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the group user
	 * @return the group user that was removed
	 * @throws NoSuchGroupUserException if a group user with the primary key could not be found
	 */
	@Override
	public GroupUser remove(Serializable primaryKey)
		throws NoSuchGroupUserException {

		Session session = null;

		try {
			session = openSession();

			GroupUser groupUser = (GroupUser)session.get(
				GroupUserImpl.class, primaryKey);

			if (groupUser == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchGroupUserException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(groupUser);
		}
		catch (NoSuchGroupUserException noSuchEntityException) {
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
	protected GroupUser removeImpl(GroupUser groupUser) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(groupUser)) {
				groupUser = (GroupUser)session.get(
					GroupUserImpl.class, groupUser.getPrimaryKeyObj());
			}

			if (groupUser != null) {
				session.delete(groupUser);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (groupUser != null) {
			clearCache(groupUser);
		}

		return groupUser;
	}

	@Override
	public GroupUser updateImpl(GroupUser groupUser) {
		boolean isNew = groupUser.isNew();

		if (!(groupUser instanceof GroupUserModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(groupUser.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(groupUser);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in groupUser proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom GroupUser implementation " +
					groupUser.getClass());
		}

		GroupUserModelImpl groupUserModelImpl = (GroupUserModelImpl)groupUser;

		Session session = null;

		try {
			session = openSession();

			if (groupUser.isNew()) {
				session.save(groupUser);

				groupUser.setNew(false);
			}
			else {
				groupUser = (GroupUser)session.merge(groupUser);
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
				groupUserModelImpl.getGroupId(),
				groupUserModelImpl.getLanguage()
			};

			finderCache.removeResult(_finderPathCountByGroup_Language, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByGroup_Language, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((groupUserModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByGroup_Language.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					groupUserModelImpl.getOriginalGroupId(),
					groupUserModelImpl.getOriginalLanguage()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Language, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Language, args);

				args = new Object[] {
					groupUserModelImpl.getGroupId(),
					groupUserModelImpl.getLanguage()
				};

				finderCache.removeResult(
					_finderPathCountByGroup_Language, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByGroup_Language, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, GroupUserImpl.class, groupUser.getPrimaryKey(),
			groupUser, false);

		groupUser.resetOriginalValues();

		return groupUser;
	}

	/**
	 * Returns the group user with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the group user
	 * @return the group user
	 * @throws NoSuchGroupUserException if a group user with the primary key could not be found
	 */
	@Override
	public GroupUser findByPrimaryKey(Serializable primaryKey)
		throws NoSuchGroupUserException {

		GroupUser groupUser = fetchByPrimaryKey(primaryKey);

		if (groupUser == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchGroupUserException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return groupUser;
	}

	/**
	 * Returns the group user with the primary key or throws a <code>NoSuchGroupUserException</code> if it could not be found.
	 *
	 * @param groupUserId the primary key of the group user
	 * @return the group user
	 * @throws NoSuchGroupUserException if a group user with the primary key could not be found
	 */
	@Override
	public GroupUser findByPrimaryKey(long groupUserId)
		throws NoSuchGroupUserException {

		return findByPrimaryKey((Serializable)groupUserId);
	}

	/**
	 * Returns the group user with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param groupUserId the primary key of the group user
	 * @return the group user, or <code>null</code> if a group user with the primary key could not be found
	 */
	@Override
	public GroupUser fetchByPrimaryKey(long groupUserId) {
		return fetchByPrimaryKey((Serializable)groupUserId);
	}

	/**
	 * Returns all the group users.
	 *
	 * @return the group users
	 */
	@Override
	public List<GroupUser> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group users
	 * @param end the upper bound of the range of group users (not inclusive)
	 * @return the range of group users
	 */
	@Override
	public List<GroupUser> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group users
	 * @param end the upper bound of the range of group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group users
	 */
	@Override
	public List<GroupUser> findAll(
		int start, int end, OrderByComparator<GroupUser> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the group users.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>GroupUserModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of group users
	 * @param end the upper bound of the range of group users (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group users
	 */
	@Override
	public List<GroupUser> findAll(
		int start, int end, OrderByComparator<GroupUser> orderByComparator,
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

		List<GroupUser> list = null;

		if (useFinderCache) {
			list = (List<GroupUser>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_GROUPUSER);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_GROUPUSER;

				sql = sql.concat(GroupUserModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<GroupUser>)QueryUtil.list(
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
	 * Removes all the group users from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (GroupUser groupUser : findAll()) {
			remove(groupUser);
		}
	}

	/**
	 * Returns the number of group users.
	 *
	 * @return the number of group users
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_GROUPUSER);

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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "groupUserId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_GROUPUSER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return GroupUserModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the group user persistence.
	 */
	@Activate
	public void activate() {
		GroupUserModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		GroupUserModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByGroup_Language = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroup_Language",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByGroup_Language = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, GroupUserImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroup_Language",
			new String[] {Long.class.getName(), String.class.getName()},
			GroupUserModelImpl.GROUPID_COLUMN_BITMASK |
			GroupUserModelImpl.LANGUAGE_COLUMN_BITMASK |
			GroupUserModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByGroup_Language = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroup_Language",
			new String[] {Long.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(GroupUserImpl.class.getName());
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
				"value.object.column.bitmask.enabled.com.software.cms.model.GroupUser"),
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

	private static final String _SQL_SELECT_GROUPUSER =
		"SELECT groupUser FROM GroupUser groupUser";

	private static final String _SQL_SELECT_GROUPUSER_WHERE =
		"SELECT groupUser FROM GroupUser groupUser WHERE ";

	private static final String _SQL_COUNT_GROUPUSER =
		"SELECT COUNT(groupUser) FROM GroupUser groupUser";

	private static final String _SQL_COUNT_GROUPUSER_WHERE =
		"SELECT COUNT(groupUser) FROM GroupUser groupUser WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "groupUser.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No GroupUser exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No GroupUser exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		GroupUserPersistenceImpl.class);

	static {
		try {
			Class.forName(soft_cmsPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}