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

package adv.service.persistence.impl;

import adv.exception.NoSuchQuangCaoException;

import adv.model.QuangCao;
import adv.model.impl.QuangCaoImpl;
import adv.model.impl.QuangCaoModelImpl;

import adv.service.persistence.QuangCaoPersistence;
import adv.service.persistence.impl.constants.soft_advPersistenceConstants;

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
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
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
 * The persistence implementation for the quang cao service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = QuangCaoPersistence.class)
public class QuangCaoPersistenceImpl
	extends BasePersistenceImpl<QuangCao> implements QuangCaoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>QuangCaoUtil</code> to access the quang cao persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		QuangCaoImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the quang caos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching quang caos
	 */
	@Override
	public List<QuangCao> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quang caos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuangCaoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @return the range of matching quang caos
	 */
	@Override
	public List<QuangCao> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the quang caos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuangCaoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quang caos
	 */
	@Override
	public List<QuangCao> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<QuangCao> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quang caos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuangCaoModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quang caos
	 */
	@Override
	public List<QuangCao> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<QuangCao> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<QuangCao> list = null;

		if (useFinderCache) {
			list = (List<QuangCao>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (QuangCao quangCao : list) {
					if (!uuid.equals(quangCao.getUuid())) {
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

			query.append(_SQL_SELECT_QUANGCAO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				query.append(QuangCaoModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				list = (List<QuangCao>)QueryUtil.list(
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
	 * Returns the first quang cao in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quang cao
	 * @throws NoSuchQuangCaoException if a matching quang cao could not be found
	 */
	@Override
	public QuangCao findByUuid_First(
			String uuid, OrderByComparator<QuangCao> orderByComparator)
		throws NoSuchQuangCaoException {

		QuangCao quangCao = fetchByUuid_First(uuid, orderByComparator);

		if (quangCao != null) {
			return quangCao;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchQuangCaoException(msg.toString());
	}

	/**
	 * Returns the first quang cao in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	@Override
	public QuangCao fetchByUuid_First(
		String uuid, OrderByComparator<QuangCao> orderByComparator) {

		List<QuangCao> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last quang cao in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quang cao
	 * @throws NoSuchQuangCaoException if a matching quang cao could not be found
	 */
	@Override
	public QuangCao findByUuid_Last(
			String uuid, OrderByComparator<QuangCao> orderByComparator)
		throws NoSuchQuangCaoException {

		QuangCao quangCao = fetchByUuid_Last(uuid, orderByComparator);

		if (quangCao != null) {
			return quangCao;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchQuangCaoException(msg.toString());
	}

	/**
	 * Returns the last quang cao in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	@Override
	public QuangCao fetchByUuid_Last(
		String uuid, OrderByComparator<QuangCao> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<QuangCao> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the quang caos before and after the current quang cao in the ordered set where uuid = &#63;.
	 *
	 * @param quangCaoId the primary key of the current quang cao
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quang cao
	 * @throws NoSuchQuangCaoException if a quang cao with the primary key could not be found
	 */
	@Override
	public QuangCao[] findByUuid_PrevAndNext(
			long quangCaoId, String uuid,
			OrderByComparator<QuangCao> orderByComparator)
		throws NoSuchQuangCaoException {

		uuid = Objects.toString(uuid, "");

		QuangCao quangCao = findByPrimaryKey(quangCaoId);

		Session session = null;

		try {
			session = openSession();

			QuangCao[] array = new QuangCaoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, quangCao, uuid, orderByComparator, true);

			array[1] = quangCao;

			array[2] = getByUuid_PrevAndNext(
				session, quangCao, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected QuangCao getByUuid_PrevAndNext(
		Session session, QuangCao quangCao, String uuid,
		OrderByComparator<QuangCao> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_QUANGCAO_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
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
			query.append(QuangCaoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(quangCao)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<QuangCao> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the quang caos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (QuangCao quangCao :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(quangCao);
		}
	}

	/**
	 * Returns the number of quang caos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching quang caos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_QUANGCAO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
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

	private static final String _FINDER_COLUMN_UUID_UUID_2 =
		"quangCao.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(quangCao.uuid IS NULL OR quangCao.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the quang cao where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchQuangCaoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching quang cao
	 * @throws NoSuchQuangCaoException if a matching quang cao could not be found
	 */
	@Override
	public QuangCao findByUUID_G(String uuid, long groupId)
		throws NoSuchQuangCaoException {

		QuangCao quangCao = fetchByUUID_G(uuid, groupId);

		if (quangCao == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchQuangCaoException(msg.toString());
		}

		return quangCao;
	}

	/**
	 * Returns the quang cao where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	@Override
	public QuangCao fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the quang cao where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	@Override
	public QuangCao fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof QuangCao) {
			QuangCao quangCao = (QuangCao)result;

			if (!Objects.equals(uuid, quangCao.getUuid()) ||
				(groupId != quangCao.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_QUANGCAO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<QuangCao> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					QuangCao quangCao = list.get(0);

					result = quangCao;

					cacheResult(quangCao);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUUID_G, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (QuangCao)result;
		}
	}

	/**
	 * Removes the quang cao where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the quang cao that was removed
	 */
	@Override
	public QuangCao removeByUUID_G(String uuid, long groupId)
		throws NoSuchQuangCaoException {

		QuangCao quangCao = findByUUID_G(uuid, groupId);

		return remove(quangCao);
	}

	/**
	 * Returns the number of quang caos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching quang caos
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_QUANGCAO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"quangCao.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(quangCao.uuid IS NULL OR quangCao.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"quangCao.groupId = ?";

	private FinderPath _finderPathFetchBybyQuangCaoIdAndGroupIdAndType;
	private FinderPath _finderPathCountBybyQuangCaoIdAndGroupIdAndType;

	/**
	 * Returns the quang cao where quangCaoId = &#63; and groupId = &#63; and type = &#63; or throws a <code>NoSuchQuangCaoException</code> if it could not be found.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param type the type
	 * @return the matching quang cao
	 * @throws NoSuchQuangCaoException if a matching quang cao could not be found
	 */
	@Override
	public QuangCao findBybyQuangCaoIdAndGroupIdAndType(
			long quangCaoId, long groupId, int type)
		throws NoSuchQuangCaoException {

		QuangCao quangCao = fetchBybyQuangCaoIdAndGroupIdAndType(
			quangCaoId, groupId, type);

		if (quangCao == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("quangCaoId=");
			msg.append(quangCaoId);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(", type=");
			msg.append(type);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchQuangCaoException(msg.toString());
		}

		return quangCao;
	}

	/**
	 * Returns the quang cao where quangCaoId = &#63; and groupId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param type the type
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	@Override
	public QuangCao fetchBybyQuangCaoIdAndGroupIdAndType(
		long quangCaoId, long groupId, int type) {

		return fetchBybyQuangCaoIdAndGroupIdAndType(
			quangCaoId, groupId, type, true);
	}

	/**
	 * Returns the quang cao where quangCaoId = &#63; and groupId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	@Override
	public QuangCao fetchBybyQuangCaoIdAndGroupIdAndType(
		long quangCaoId, long groupId, int type, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {quangCaoId, groupId, type};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBybyQuangCaoIdAndGroupIdAndType, finderArgs,
				this);
		}

		if (result instanceof QuangCao) {
			QuangCao quangCao = (QuangCao)result;

			if ((quangCaoId != quangCao.getQuangCaoId()) ||
				(groupId != quangCao.getGroupId()) ||
				(type != quangCao.getType())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_QUANGCAO_WHERE);

			query.append(
				_FINDER_COLUMN_BYQUANGCAOIDANDGROUPIDANDTYPE_QUANGCAOID_2);

			query.append(
				_FINDER_COLUMN_BYQUANGCAOIDANDGROUPIDANDTYPE_GROUPID_2);

			query.append(_FINDER_COLUMN_BYQUANGCAOIDANDGROUPIDANDTYPE_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(quangCaoId);

				qPos.add(groupId);

				qPos.add(type);

				List<QuangCao> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBybyQuangCaoIdAndGroupIdAndType,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									quangCaoId, groupId, type
								};
							}

							_log.warn(
								"QuangCaoPersistenceImpl.fetchBybyQuangCaoIdAndGroupIdAndType(long, long, int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					QuangCao quangCao = list.get(0);

					result = quangCao;

					cacheResult(quangCao);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchBybyQuangCaoIdAndGroupIdAndType,
						finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (QuangCao)result;
		}
	}

	/**
	 * Removes the quang cao where quangCaoId = &#63; and groupId = &#63; and type = &#63; from the database.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param type the type
	 * @return the quang cao that was removed
	 */
	@Override
	public QuangCao removeBybyQuangCaoIdAndGroupIdAndType(
			long quangCaoId, long groupId, int type)
		throws NoSuchQuangCaoException {

		QuangCao quangCao = findBybyQuangCaoIdAndGroupIdAndType(
			quangCaoId, groupId, type);

		return remove(quangCao);
	}

	/**
	 * Returns the number of quang caos where quangCaoId = &#63; and groupId = &#63; and type = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param groupId the group ID
	 * @param type the type
	 * @return the number of matching quang caos
	 */
	@Override
	public int countBybyQuangCaoIdAndGroupIdAndType(
		long quangCaoId, long groupId, int type) {

		FinderPath finderPath = _finderPathCountBybyQuangCaoIdAndGroupIdAndType;

		Object[] finderArgs = new Object[] {quangCaoId, groupId, type};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_QUANGCAO_WHERE);

			query.append(
				_FINDER_COLUMN_BYQUANGCAOIDANDGROUPIDANDTYPE_QUANGCAOID_2);

			query.append(
				_FINDER_COLUMN_BYQUANGCAOIDANDGROUPIDANDTYPE_GROUPID_2);

			query.append(_FINDER_COLUMN_BYQUANGCAOIDANDGROUPIDANDTYPE_TYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(quangCaoId);

				qPos.add(groupId);

				qPos.add(type);

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

	private static final String
		_FINDER_COLUMN_BYQUANGCAOIDANDGROUPIDANDTYPE_QUANGCAOID_2 =
			"quangCao.quangCaoId = ? AND ";

	private static final String
		_FINDER_COLUMN_BYQUANGCAOIDANDGROUPIDANDTYPE_GROUPID_2 =
			"quangCao.groupId = ? AND ";

	private static final String
		_FINDER_COLUMN_BYQUANGCAOIDANDGROUPIDANDTYPE_TYPE_2 =
			"quangCao.type = ?";

	private FinderPath _finderPathFetchBybyQuangCaoIdAndStatus;
	private FinderPath _finderPathCountBybyQuangCaoIdAndStatus;

	/**
	 * Returns the quang cao where quangCaoId = &#63; and status = &#63; or throws a <code>NoSuchQuangCaoException</code> if it could not be found.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param status the status
	 * @return the matching quang cao
	 * @throws NoSuchQuangCaoException if a matching quang cao could not be found
	 */
	@Override
	public QuangCao findBybyQuangCaoIdAndStatus(long quangCaoId, int status)
		throws NoSuchQuangCaoException {

		QuangCao quangCao = fetchBybyQuangCaoIdAndStatus(quangCaoId, status);

		if (quangCao == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("quangCaoId=");
			msg.append(quangCaoId);

			msg.append(", status=");
			msg.append(status);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchQuangCaoException(msg.toString());
		}

		return quangCao;
	}

	/**
	 * Returns the quang cao where quangCaoId = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param status the status
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	@Override
	public QuangCao fetchBybyQuangCaoIdAndStatus(long quangCaoId, int status) {
		return fetchBybyQuangCaoIdAndStatus(quangCaoId, status, true);
	}

	/**
	 * Returns the quang cao where quangCaoId = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quang cao, or <code>null</code> if a matching quang cao could not be found
	 */
	@Override
	public QuangCao fetchBybyQuangCaoIdAndStatus(
		long quangCaoId, int status, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {quangCaoId, status};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBybyQuangCaoIdAndStatus, finderArgs, this);
		}

		if (result instanceof QuangCao) {
			QuangCao quangCao = (QuangCao)result;

			if ((quangCaoId != quangCao.getQuangCaoId()) ||
				(status != quangCao.getStatus())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_QUANGCAO_WHERE);

			query.append(_FINDER_COLUMN_BYQUANGCAOIDANDSTATUS_QUANGCAOID_2);

			query.append(_FINDER_COLUMN_BYQUANGCAOIDANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(quangCaoId);

				qPos.add(status);

				List<QuangCao> list = q.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBybyQuangCaoIdAndStatus, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {quangCaoId, status};
							}

							_log.warn(
								"QuangCaoPersistenceImpl.fetchBybyQuangCaoIdAndStatus(long, int, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					QuangCao quangCao = list.get(0);

					result = quangCao;

					cacheResult(quangCao);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchBybyQuangCaoIdAndStatus, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (QuangCao)result;
		}
	}

	/**
	 * Removes the quang cao where quangCaoId = &#63; and status = &#63; from the database.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param status the status
	 * @return the quang cao that was removed
	 */
	@Override
	public QuangCao removeBybyQuangCaoIdAndStatus(long quangCaoId, int status)
		throws NoSuchQuangCaoException {

		QuangCao quangCao = findBybyQuangCaoIdAndStatus(quangCaoId, status);

		return remove(quangCao);
	}

	/**
	 * Returns the number of quang caos where quangCaoId = &#63; and status = &#63;.
	 *
	 * @param quangCaoId the quang cao ID
	 * @param status the status
	 * @return the number of matching quang caos
	 */
	@Override
	public int countBybyQuangCaoIdAndStatus(long quangCaoId, int status) {
		FinderPath finderPath = _finderPathCountBybyQuangCaoIdAndStatus;

		Object[] finderArgs = new Object[] {quangCaoId, status};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_QUANGCAO_WHERE);

			query.append(_FINDER_COLUMN_BYQUANGCAOIDANDSTATUS_QUANGCAOID_2);

			query.append(_FINDER_COLUMN_BYQUANGCAOIDANDSTATUS_STATUS_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(quangCaoId);

				qPos.add(status);

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

	private static final String
		_FINDER_COLUMN_BYQUANGCAOIDANDSTATUS_QUANGCAOID_2 =
			"quangCao.quangCaoId = ? AND ";

	private static final String _FINDER_COLUMN_BYQUANGCAOIDANDSTATUS_STATUS_2 =
		"quangCao.status = ?";

	public QuangCaoPersistenceImpl() {
		setModelClass(QuangCao.class);

		setModelImplClass(QuangCaoImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the quang cao in the entity cache if it is enabled.
	 *
	 * @param quangCao the quang cao
	 */
	@Override
	public void cacheResult(QuangCao quangCao) {
		entityCache.putResult(
			entityCacheEnabled, QuangCaoImpl.class, quangCao.getPrimaryKey(),
			quangCao);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {quangCao.getUuid(), quangCao.getGroupId()}, quangCao);

		finderCache.putResult(
			_finderPathFetchBybyQuangCaoIdAndGroupIdAndType,
			new Object[] {
				quangCao.getQuangCaoId(), quangCao.getGroupId(),
				quangCao.getType()
			},
			quangCao);

		finderCache.putResult(
			_finderPathFetchBybyQuangCaoIdAndStatus,
			new Object[] {quangCao.getQuangCaoId(), quangCao.getStatus()},
			quangCao);

		quangCao.resetOriginalValues();
	}

	/**
	 * Caches the quang caos in the entity cache if it is enabled.
	 *
	 * @param quangCaos the quang caos
	 */
	@Override
	public void cacheResult(List<QuangCao> quangCaos) {
		for (QuangCao quangCao : quangCaos) {
			if (entityCache.getResult(
					entityCacheEnabled, QuangCaoImpl.class,
					quangCao.getPrimaryKey()) == null) {

				cacheResult(quangCao);
			}
			else {
				quangCao.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all quang caos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(QuangCaoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the quang cao.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuangCao quangCao) {
		entityCache.removeResult(
			entityCacheEnabled, QuangCaoImpl.class, quangCao.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((QuangCaoModelImpl)quangCao, true);
	}

	@Override
	public void clearCache(List<QuangCao> quangCaos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (QuangCao quangCao : quangCaos) {
			entityCache.removeResult(
				entityCacheEnabled, QuangCaoImpl.class,
				quangCao.getPrimaryKey());

			clearUniqueFindersCache((QuangCaoModelImpl)quangCao, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, QuangCaoImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		QuangCaoModelImpl quangCaoModelImpl) {

		Object[] args = new Object[] {
			quangCaoModelImpl.getUuid(), quangCaoModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, quangCaoModelImpl, false);

		args = new Object[] {
			quangCaoModelImpl.getQuangCaoId(), quangCaoModelImpl.getGroupId(),
			quangCaoModelImpl.getType()
		};

		finderCache.putResult(
			_finderPathCountBybyQuangCaoIdAndGroupIdAndType, args,
			Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBybyQuangCaoIdAndGroupIdAndType, args,
			quangCaoModelImpl, false);

		args = new Object[] {
			quangCaoModelImpl.getQuangCaoId(), quangCaoModelImpl.getStatus()
		};

		finderCache.putResult(
			_finderPathCountBybyQuangCaoIdAndStatus, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchBybyQuangCaoIdAndStatus, args, quangCaoModelImpl,
			false);
	}

	protected void clearUniqueFindersCache(
		QuangCaoModelImpl quangCaoModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				quangCaoModelImpl.getUuid(), quangCaoModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((quangCaoModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				quangCaoModelImpl.getOriginalUuid(),
				quangCaoModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				quangCaoModelImpl.getQuangCaoId(),
				quangCaoModelImpl.getGroupId(), quangCaoModelImpl.getType()
			};

			finderCache.removeResult(
				_finderPathCountBybyQuangCaoIdAndGroupIdAndType, args);
			finderCache.removeResult(
				_finderPathFetchBybyQuangCaoIdAndGroupIdAndType, args);
		}

		if ((quangCaoModelImpl.getColumnBitmask() &
			 _finderPathFetchBybyQuangCaoIdAndGroupIdAndType.
				 getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				quangCaoModelImpl.getOriginalQuangCaoId(),
				quangCaoModelImpl.getOriginalGroupId(),
				quangCaoModelImpl.getOriginalType()
			};

			finderCache.removeResult(
				_finderPathCountBybyQuangCaoIdAndGroupIdAndType, args);
			finderCache.removeResult(
				_finderPathFetchBybyQuangCaoIdAndGroupIdAndType, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {
				quangCaoModelImpl.getQuangCaoId(), quangCaoModelImpl.getStatus()
			};

			finderCache.removeResult(
				_finderPathCountBybyQuangCaoIdAndStatus, args);
			finderCache.removeResult(
				_finderPathFetchBybyQuangCaoIdAndStatus, args);
		}

		if ((quangCaoModelImpl.getColumnBitmask() &
			 _finderPathFetchBybyQuangCaoIdAndStatus.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				quangCaoModelImpl.getOriginalQuangCaoId(),
				quangCaoModelImpl.getOriginalStatus()
			};

			finderCache.removeResult(
				_finderPathCountBybyQuangCaoIdAndStatus, args);
			finderCache.removeResult(
				_finderPathFetchBybyQuangCaoIdAndStatus, args);
		}
	}

	/**
	 * Creates a new quang cao with the primary key. Does not add the quang cao to the database.
	 *
	 * @param quangCaoId the primary key for the new quang cao
	 * @return the new quang cao
	 */
	@Override
	public QuangCao create(long quangCaoId) {
		QuangCao quangCao = new QuangCaoImpl();

		quangCao.setNew(true);
		quangCao.setPrimaryKey(quangCaoId);

		String uuid = PortalUUIDUtil.generate();

		quangCao.setUuid(uuid);

		return quangCao;
	}

	/**
	 * Removes the quang cao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quangCaoId the primary key of the quang cao
	 * @return the quang cao that was removed
	 * @throws NoSuchQuangCaoException if a quang cao with the primary key could not be found
	 */
	@Override
	public QuangCao remove(long quangCaoId) throws NoSuchQuangCaoException {
		return remove((Serializable)quangCaoId);
	}

	/**
	 * Removes the quang cao with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the quang cao
	 * @return the quang cao that was removed
	 * @throws NoSuchQuangCaoException if a quang cao with the primary key could not be found
	 */
	@Override
	public QuangCao remove(Serializable primaryKey)
		throws NoSuchQuangCaoException {

		Session session = null;

		try {
			session = openSession();

			QuangCao quangCao = (QuangCao)session.get(
				QuangCaoImpl.class, primaryKey);

			if (quangCao == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuangCaoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(quangCao);
		}
		catch (NoSuchQuangCaoException noSuchEntityException) {
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
	protected QuangCao removeImpl(QuangCao quangCao) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(quangCao)) {
				quangCao = (QuangCao)session.get(
					QuangCaoImpl.class, quangCao.getPrimaryKeyObj());
			}

			if (quangCao != null) {
				session.delete(quangCao);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (quangCao != null) {
			clearCache(quangCao);
		}

		return quangCao;
	}

	@Override
	public QuangCao updateImpl(QuangCao quangCao) {
		boolean isNew = quangCao.isNew();

		if (!(quangCao instanceof QuangCaoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(quangCao.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(quangCao);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in quangCao proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom QuangCao implementation " +
					quangCao.getClass());
		}

		QuangCaoModelImpl quangCaoModelImpl = (QuangCaoModelImpl)quangCao;

		if (Validator.isNull(quangCao.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			quangCao.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (quangCao.getCreateDate() == null)) {
			if (serviceContext == null) {
				quangCao.setCreateDate(now);
			}
			else {
				quangCao.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!quangCaoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				quangCao.setModifiedDate(now);
			}
			else {
				quangCao.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (quangCao.isNew()) {
				session.save(quangCao);

				quangCao.setNew(false);
			}
			else {
				quangCao = (QuangCao)session.merge(quangCao);
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
			Object[] args = new Object[] {quangCaoModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((quangCaoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					quangCaoModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {quangCaoModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, QuangCaoImpl.class, quangCao.getPrimaryKey(),
			quangCao, false);

		clearUniqueFindersCache(quangCaoModelImpl, false);
		cacheUniqueFindersCache(quangCaoModelImpl);

		quangCao.resetOriginalValues();

		return quangCao;
	}

	/**
	 * Returns the quang cao with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the quang cao
	 * @return the quang cao
	 * @throws NoSuchQuangCaoException if a quang cao with the primary key could not be found
	 */
	@Override
	public QuangCao findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuangCaoException {

		QuangCao quangCao = fetchByPrimaryKey(primaryKey);

		if (quangCao == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuangCaoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return quangCao;
	}

	/**
	 * Returns the quang cao with the primary key or throws a <code>NoSuchQuangCaoException</code> if it could not be found.
	 *
	 * @param quangCaoId the primary key of the quang cao
	 * @return the quang cao
	 * @throws NoSuchQuangCaoException if a quang cao with the primary key could not be found
	 */
	@Override
	public QuangCao findByPrimaryKey(long quangCaoId)
		throws NoSuchQuangCaoException {

		return findByPrimaryKey((Serializable)quangCaoId);
	}

	/**
	 * Returns the quang cao with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quangCaoId the primary key of the quang cao
	 * @return the quang cao, or <code>null</code> if a quang cao with the primary key could not be found
	 */
	@Override
	public QuangCao fetchByPrimaryKey(long quangCaoId) {
		return fetchByPrimaryKey((Serializable)quangCaoId);
	}

	/**
	 * Returns all the quang caos.
	 *
	 * @return the quang caos
	 */
	@Override
	public List<QuangCao> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quang caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuangCaoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @return the range of quang caos
	 */
	@Override
	public List<QuangCao> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the quang caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuangCaoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quang caos
	 */
	@Override
	public List<QuangCao> findAll(
		int start, int end, OrderByComparator<QuangCao> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quang caos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuangCaoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quang caos
	 * @param end the upper bound of the range of quang caos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quang caos
	 */
	@Override
	public List<QuangCao> findAll(
		int start, int end, OrderByComparator<QuangCao> orderByComparator,
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

		List<QuangCao> list = null;

		if (useFinderCache) {
			list = (List<QuangCao>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_QUANGCAO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_QUANGCAO;

				sql = sql.concat(QuangCaoModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				list = (List<QuangCao>)QueryUtil.list(
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
	 * Removes all the quang caos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QuangCao quangCao : findAll()) {
			remove(quangCao);
		}
	}

	/**
	 * Returns the number of quang caos.
	 *
	 * @return the number of quang caos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_QUANGCAO);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "quangCaoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_QUANGCAO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QuangCaoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the quang cao persistence.
	 */
	@Activate
	public void activate() {
		QuangCaoModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		QuangCaoModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, QuangCaoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, QuangCaoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, QuangCaoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, QuangCaoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			QuangCaoModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, QuangCaoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			QuangCaoModelImpl.UUID_COLUMN_BITMASK |
			QuangCaoModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathFetchBybyQuangCaoIdAndGroupIdAndType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, QuangCaoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBybyQuangCaoIdAndGroupIdAndType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			QuangCaoModelImpl.QUANGCAOID_COLUMN_BITMASK |
			QuangCaoModelImpl.GROUPID_COLUMN_BITMASK |
			QuangCaoModelImpl.TYPE_COLUMN_BITMASK);

		_finderPathCountBybyQuangCaoIdAndGroupIdAndType = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybyQuangCaoIdAndGroupIdAndType",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

		_finderPathFetchBybyQuangCaoIdAndStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, QuangCaoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBybyQuangCaoIdAndStatus",
			new String[] {Long.class.getName(), Integer.class.getName()},
			QuangCaoModelImpl.QUANGCAOID_COLUMN_BITMASK |
			QuangCaoModelImpl.STATUS_COLUMN_BITMASK);

		_finderPathCountBybyQuangCaoIdAndStatus = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBybyQuangCaoIdAndStatus",
			new String[] {Long.class.getName(), Integer.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(QuangCaoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = soft_advPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.adv.model.QuangCao"),
			true);
	}

	@Override
	@Reference(
		target = soft_advPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = soft_advPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_QUANGCAO =
		"SELECT quangCao FROM QuangCao quangCao";

	private static final String _SQL_SELECT_QUANGCAO_WHERE =
		"SELECT quangCao FROM QuangCao quangCao WHERE ";

	private static final String _SQL_COUNT_QUANGCAO =
		"SELECT COUNT(quangCao) FROM QuangCao quangCao";

	private static final String _SQL_COUNT_QUANGCAO_WHERE =
		"SELECT COUNT(quangCao) FROM QuangCao quangCao WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "quangCao.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No QuangCao exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No QuangCao exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		QuangCaoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type"});

	static {
		try {
			Class.forName(soft_advPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}