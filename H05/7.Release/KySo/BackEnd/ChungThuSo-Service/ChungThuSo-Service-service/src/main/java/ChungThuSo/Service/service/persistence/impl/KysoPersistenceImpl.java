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

package ChungThuSo.Service.service.persistence.impl;

import ChungThuSo.Service.exception.NoSuchKysoException;
import ChungThuSo.Service.model.Kyso;
import ChungThuSo.Service.model.impl.KysoImpl;
import ChungThuSo.Service.model.impl.KysoModelImpl;
import ChungThuSo.Service.service.persistence.KysoPersistence;
import ChungThuSo.Service.service.persistence.impl.constants.cts_portalPersistenceConstants;

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
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
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

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the kyso service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = KysoPersistence.class)
@ProviderType
public class KysoPersistenceImpl
	extends BasePersistenceImpl<Kyso> implements KysoPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>KysoUtil</code> to access the kyso persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		KysoImpl.class.getName();

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
	 * Returns all the kysos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching kysos
	 */
	@Override
	public List<Kyso> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kysos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @return the range of matching kysos
	 */
	@Override
	public List<Kyso> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the kysos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid(String, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching kysos
	 */
	@Deprecated
	@Override
	public List<Kyso> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Kyso> orderByComparator, boolean useFinderCache) {

		return findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the kysos where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kysos
	 */
	@Override
	public List<Kyso> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Kyso> orderByComparator) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid;
			finderArgs = new Object[] {uuid};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Kyso> list = (List<Kyso>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Kyso kyso : list) {
				if (!uuid.equals(kyso.getUuid())) {
					list = null;

					break;
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

			query.append(_SQL_SELECT_KYSO_WHERE);

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
			else if (pagination) {
				query.append(KysoModelImpl.ORDER_BY_JPQL);
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

				if (!pagination) {
					list = (List<Kyso>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Kyso>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first kyso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	@Override
	public Kyso findByUuid_First(
			String uuid, OrderByComparator<Kyso> orderByComparator)
		throws NoSuchKysoException {

		Kyso kyso = fetchByUuid_First(uuid, orderByComparator);

		if (kyso != null) {
			return kyso;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchKysoException(msg.toString());
	}

	/**
	 * Returns the first kyso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	@Override
	public Kyso fetchByUuid_First(
		String uuid, OrderByComparator<Kyso> orderByComparator) {

		List<Kyso> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last kyso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	@Override
	public Kyso findByUuid_Last(
			String uuid, OrderByComparator<Kyso> orderByComparator)
		throws NoSuchKysoException {

		Kyso kyso = fetchByUuid_Last(uuid, orderByComparator);

		if (kyso != null) {
			return kyso;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append("}");

		throw new NoSuchKysoException(msg.toString());
	}

	/**
	 * Returns the last kyso in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	@Override
	public Kyso fetchByUuid_Last(
		String uuid, OrderByComparator<Kyso> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Kyso> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the kysos before and after the current kyso in the ordered set where uuid = &#63;.
	 *
	 * @param kysoId the primary key of the current kyso
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kyso
	 * @throws NoSuchKysoException if a kyso with the primary key could not be found
	 */
	@Override
	public Kyso[] findByUuid_PrevAndNext(
			long kysoId, String uuid, OrderByComparator<Kyso> orderByComparator)
		throws NoSuchKysoException {

		uuid = Objects.toString(uuid, "");

		Kyso kyso = findByPrimaryKey(kysoId);

		Session session = null;

		try {
			session = openSession();

			Kyso[] array = new KysoImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, kyso, uuid, orderByComparator, true);

			array[1] = kyso;

			array[2] = getByUuid_PrevAndNext(
				session, kyso, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Kyso getByUuid_PrevAndNext(
		Session session, Kyso kyso, String uuid,
		OrderByComparator<Kyso> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_KYSO_WHERE);

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
			query.append(KysoModelImpl.ORDER_BY_JPQL);
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
					orderByComparator.getOrderByConditionValues(kyso)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Kyso> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the kysos where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Kyso kyso :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(kyso);
		}
	}

	/**
	 * Returns the number of kysos where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching kysos
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KYSO_WHERE);

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
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "kyso.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(kyso.uuid IS NULL OR kyso.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the kyso where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchKysoException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	@Override
	public Kyso findByUUID_G(String uuid, long groupId)
		throws NoSuchKysoException {

		Kyso kyso = fetchByUUID_G(uuid, groupId);

		if (kyso == null) {
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

			throw new NoSuchKysoException(msg.toString());
		}

		return kyso;
	}

	/**
	 * Returns the kyso where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchByUUID_G(String,long)}
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	@Deprecated
	@Override
	public Kyso fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		return fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the kyso where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	@Override
	public Kyso fetchByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = new Object[] {uuid, groupId};

		Object result = finderCache.getResult(
			_finderPathFetchByUUID_G, finderArgs, this);

		if (result instanceof Kyso) {
			Kyso kyso = (Kyso)result;

			if (!Objects.equals(uuid, kyso.getUuid()) ||
				(groupId != kyso.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_KYSO_WHERE);

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

				List<Kyso> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchByUUID_G, finderArgs, list);
				}
				else {
					Kyso kyso = list.get(0);

					result = kyso;

					cacheResult(kyso);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchByUUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Kyso)result;
		}
	}

	/**
	 * Removes the kyso where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the kyso that was removed
	 */
	@Override
	public Kyso removeByUUID_G(String uuid, long groupId)
		throws NoSuchKysoException {

		Kyso kyso = findByUUID_G(uuid, groupId);

		return remove(kyso);
	}

	/**
	 * Returns the number of kysos where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching kysos
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_KYSO_WHERE);

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
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"kyso.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(kyso.uuid IS NULL OR kyso.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"kyso.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the kysos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching kysos
	 */
	@Override
	public List<Kyso> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kysos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @return the range of matching kysos
	 */
	@Override
	public List<Kyso> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the kysos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByUuid_C(String,long, int, int, OrderByComparator)}
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching kysos
	 */
	@Deprecated
	@Override
	public List<Kyso> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Kyso> orderByComparator, boolean useFinderCache) {

		return findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the kysos where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching kysos
	 */
	@Override
	public List<Kyso> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Kyso> orderByComparator) {

		uuid = Objects.toString(uuid, "");

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByUuid_C;
			finderArgs = new Object[] {uuid, companyId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Kyso> list = (List<Kyso>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Kyso kyso : list) {
				if (!uuid.equals(kyso.getUuid()) ||
					(companyId != kyso.getCompanyId())) {

					list = null;

					break;
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

			query.append(_SQL_SELECT_KYSO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(KysoModelImpl.ORDER_BY_JPQL);
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

				qPos.add(companyId);

				if (!pagination) {
					list = (List<Kyso>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Kyso>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first kyso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	@Override
	public Kyso findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Kyso> orderByComparator)
		throws NoSuchKysoException {

		Kyso kyso = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (kyso != null) {
			return kyso;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchKysoException(msg.toString());
	}

	/**
	 * Returns the first kyso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	@Override
	public Kyso fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Kyso> orderByComparator) {

		List<Kyso> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last kyso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	@Override
	public Kyso findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Kyso> orderByComparator)
		throws NoSuchKysoException {

		Kyso kyso = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (kyso != null) {
			return kyso;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append("}");

		throw new NoSuchKysoException(msg.toString());
	}

	/**
	 * Returns the last kyso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	@Override
	public Kyso fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Kyso> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Kyso> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the kysos before and after the current kyso in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param kysoId the primary key of the current kyso
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next kyso
	 * @throws NoSuchKysoException if a kyso with the primary key could not be found
	 */
	@Override
	public Kyso[] findByUuid_C_PrevAndNext(
			long kysoId, String uuid, long companyId,
			OrderByComparator<Kyso> orderByComparator)
		throws NoSuchKysoException {

		uuid = Objects.toString(uuid, "");

		Kyso kyso = findByPrimaryKey(kysoId);

		Session session = null;

		try {
			session = openSession();

			Kyso[] array = new KysoImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, kyso, uuid, companyId, orderByComparator, true);

			array[1] = kyso;

			array[2] = getByUuid_C_PrevAndNext(
				session, kyso, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Kyso getByUuid_C_PrevAndNext(
		Session session, Kyso kyso, String uuid, long companyId,
		OrderByComparator<Kyso> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_KYSO_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

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
			query.append(KysoModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(kyso)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Kyso> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the kysos where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Kyso kyso :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(kyso);
		}
	}

	/**
	 * Returns the number of kysos where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching kysos
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_KYSO_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"kyso.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(kyso.uuid IS NULL OR kyso.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"kyso.companyId = ?";

	private FinderPath _finderPathFetchBygetByScreenName;
	private FinderPath _finderPathCountBygetByScreenName;

	/**
	 * Returns the kyso where screenName = &#63; or throws a <code>NoSuchKysoException</code> if it could not be found.
	 *
	 * @param screenName the screen name
	 * @return the matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	@Override
	public Kyso findBygetByScreenName(String screenName)
		throws NoSuchKysoException {

		Kyso kyso = fetchBygetByScreenName(screenName);

		if (kyso == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("screenName=");
			msg.append(screenName);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchKysoException(msg.toString());
		}

		return kyso;
	}

	/**
	 * Returns the kyso where screenName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBygetByScreenName(String)}
	 * @param screenName the screen name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	@Deprecated
	@Override
	public Kyso fetchBygetByScreenName(
		String screenName, boolean useFinderCache) {

		return fetchBygetByScreenName(screenName);
	}

	/**
	 * Returns the kyso where screenName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param screenName the screen name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	@Override
	public Kyso fetchBygetByScreenName(String screenName) {
		screenName = Objects.toString(screenName, "");

		Object[] finderArgs = new Object[] {screenName};

		Object result = finderCache.getResult(
			_finderPathFetchBygetByScreenName, finderArgs, this);

		if (result instanceof Kyso) {
			Kyso kyso = (Kyso)result;

			if (!Objects.equals(screenName, kyso.getScreenName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_KYSO_WHERE);

			boolean bindScreenName = false;

			if (screenName.isEmpty()) {
				query.append(_FINDER_COLUMN_GETBYSCREENNAME_SCREENNAME_3);
			}
			else {
				bindScreenName = true;

				query.append(_FINDER_COLUMN_GETBYSCREENNAME_SCREENNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScreenName) {
					qPos.add(screenName);
				}

				List<Kyso> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchBygetByScreenName, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"KysoPersistenceImpl.fetchBygetByScreenName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Kyso kyso = list.get(0);

					result = kyso;

					cacheResult(kyso);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchBygetByScreenName, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Kyso)result;
		}
	}

	/**
	 * Removes the kyso where screenName = &#63; from the database.
	 *
	 * @param screenName the screen name
	 * @return the kyso that was removed
	 */
	@Override
	public Kyso removeBygetByScreenName(String screenName)
		throws NoSuchKysoException {

		Kyso kyso = findBygetByScreenName(screenName);

		return remove(kyso);
	}

	/**
	 * Returns the number of kysos where screenName = &#63;.
	 *
	 * @param screenName the screen name
	 * @return the number of matching kysos
	 */
	@Override
	public int countBygetByScreenName(String screenName) {
		screenName = Objects.toString(screenName, "");

		FinderPath finderPath = _finderPathCountBygetByScreenName;

		Object[] finderArgs = new Object[] {screenName};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KYSO_WHERE);

			boolean bindScreenName = false;

			if (screenName.isEmpty()) {
				query.append(_FINDER_COLUMN_GETBYSCREENNAME_SCREENNAME_3);
			}
			else {
				bindScreenName = true;

				query.append(_FINDER_COLUMN_GETBYSCREENNAME_SCREENNAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindScreenName) {
					qPos.add(screenName);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_GETBYSCREENNAME_SCREENNAME_2 =
		"kyso.screenName = ?";

	private static final String _FINDER_COLUMN_GETBYSCREENNAME_SCREENNAME_3 =
		"(kyso.screenName IS NULL OR kyso.screenName = '')";

	private FinderPath _finderPathFetchBygetBySerialNumber;
	private FinderPath _finderPathCountBygetBySerialNumber;

	/**
	 * Returns the kyso where serialNumber = &#63; or throws a <code>NoSuchKysoException</code> if it could not be found.
	 *
	 * @param serialNumber the serial number
	 * @return the matching kyso
	 * @throws NoSuchKysoException if a matching kyso could not be found
	 */
	@Override
	public Kyso findBygetBySerialNumber(String serialNumber)
		throws NoSuchKysoException {

		Kyso kyso = fetchBygetBySerialNumber(serialNumber);

		if (kyso == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("serialNumber=");
			msg.append(serialNumber);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchKysoException(msg.toString());
		}

		return kyso;
	}

	/**
	 * Returns the kyso where serialNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBygetBySerialNumber(String)}
	 * @param serialNumber the serial number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	@Deprecated
	@Override
	public Kyso fetchBygetBySerialNumber(
		String serialNumber, boolean useFinderCache) {

		return fetchBygetBySerialNumber(serialNumber);
	}

	/**
	 * Returns the kyso where serialNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param serialNumber the serial number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching kyso, or <code>null</code> if a matching kyso could not be found
	 */
	@Override
	public Kyso fetchBygetBySerialNumber(String serialNumber) {
		serialNumber = Objects.toString(serialNumber, "");

		Object[] finderArgs = new Object[] {serialNumber};

		Object result = finderCache.getResult(
			_finderPathFetchBygetBySerialNumber, finderArgs, this);

		if (result instanceof Kyso) {
			Kyso kyso = (Kyso)result;

			if (!Objects.equals(serialNumber, kyso.getSerialNumber())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_KYSO_WHERE);

			boolean bindSerialNumber = false;

			if (serialNumber.isEmpty()) {
				query.append(_FINDER_COLUMN_GETBYSERIALNUMBER_SERIALNUMBER_3);
			}
			else {
				bindSerialNumber = true;

				query.append(_FINDER_COLUMN_GETBYSERIALNUMBER_SERIALNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSerialNumber) {
					qPos.add(serialNumber);
				}

				List<Kyso> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchBygetBySerialNumber, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"KysoPersistenceImpl.fetchBygetBySerialNumber(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Kyso kyso = list.get(0);

					result = kyso;

					cacheResult(kyso);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchBygetBySerialNumber, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Kyso)result;
		}
	}

	/**
	 * Removes the kyso where serialNumber = &#63; from the database.
	 *
	 * @param serialNumber the serial number
	 * @return the kyso that was removed
	 */
	@Override
	public Kyso removeBygetBySerialNumber(String serialNumber)
		throws NoSuchKysoException {

		Kyso kyso = findBygetBySerialNumber(serialNumber);

		return remove(kyso);
	}

	/**
	 * Returns the number of kysos where serialNumber = &#63;.
	 *
	 * @param serialNumber the serial number
	 * @return the number of matching kysos
	 */
	@Override
	public int countBygetBySerialNumber(String serialNumber) {
		serialNumber = Objects.toString(serialNumber, "");

		FinderPath finderPath = _finderPathCountBygetBySerialNumber;

		Object[] finderArgs = new Object[] {serialNumber};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_KYSO_WHERE);

			boolean bindSerialNumber = false;

			if (serialNumber.isEmpty()) {
				query.append(_FINDER_COLUMN_GETBYSERIALNUMBER_SERIALNUMBER_3);
			}
			else {
				bindSerialNumber = true;

				query.append(_FINDER_COLUMN_GETBYSERIALNUMBER_SERIALNUMBER_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindSerialNumber) {
					qPos.add(serialNumber);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_GETBYSERIALNUMBER_SERIALNUMBER_2 =
			"kyso.serialNumber = ?";

	private static final String
		_FINDER_COLUMN_GETBYSERIALNUMBER_SERIALNUMBER_3 =
			"(kyso.serialNumber IS NULL OR kyso.serialNumber = '')";

	public KysoPersistenceImpl() {
		setModelClass(Kyso.class);

		setModelImplClass(KysoImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the kyso in the entity cache if it is enabled.
	 *
	 * @param kyso the kyso
	 */
	@Override
	public void cacheResult(Kyso kyso) {
		entityCache.putResult(
			entityCacheEnabled, KysoImpl.class, kyso.getPrimaryKey(), kyso);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {kyso.getUuid(), kyso.getGroupId()}, kyso);

		finderCache.putResult(
			_finderPathFetchBygetByScreenName,
			new Object[] {kyso.getScreenName()}, kyso);

		finderCache.putResult(
			_finderPathFetchBygetBySerialNumber,
			new Object[] {kyso.getSerialNumber()}, kyso);

		kyso.resetOriginalValues();
	}

	/**
	 * Caches the kysos in the entity cache if it is enabled.
	 *
	 * @param kysos the kysos
	 */
	@Override
	public void cacheResult(List<Kyso> kysos) {
		for (Kyso kyso : kysos) {
			if (entityCache.getResult(
					entityCacheEnabled, KysoImpl.class, kyso.getPrimaryKey()) ==
						null) {

				cacheResult(kyso);
			}
			else {
				kyso.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all kysos.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(KysoImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the kyso.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Kyso kyso) {
		entityCache.removeResult(
			entityCacheEnabled, KysoImpl.class, kyso.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((KysoModelImpl)kyso, true);
	}

	@Override
	public void clearCache(List<Kyso> kysos) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Kyso kyso : kysos) {
			entityCache.removeResult(
				entityCacheEnabled, KysoImpl.class, kyso.getPrimaryKey());

			clearUniqueFindersCache((KysoModelImpl)kyso, true);
		}
	}

	protected void cacheUniqueFindersCache(KysoModelImpl kysoModelImpl) {
		Object[] args = new Object[] {
			kysoModelImpl.getUuid(), kysoModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, kysoModelImpl, false);

		args = new Object[] {kysoModelImpl.getScreenName()};

		finderCache.putResult(
			_finderPathCountBygetByScreenName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBygetByScreenName, args, kysoModelImpl, false);

		args = new Object[] {kysoModelImpl.getSerialNumber()};

		finderCache.putResult(
			_finderPathCountBygetBySerialNumber, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBygetBySerialNumber, args, kysoModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		KysoModelImpl kysoModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				kysoModelImpl.getUuid(), kysoModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((kysoModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				kysoModelImpl.getOriginalUuid(),
				kysoModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {kysoModelImpl.getScreenName()};

			finderCache.removeResult(_finderPathCountBygetByScreenName, args);
			finderCache.removeResult(_finderPathFetchBygetByScreenName, args);
		}

		if ((kysoModelImpl.getColumnBitmask() &
			 _finderPathFetchBygetByScreenName.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				kysoModelImpl.getOriginalScreenName()
			};

			finderCache.removeResult(_finderPathCountBygetByScreenName, args);
			finderCache.removeResult(_finderPathFetchBygetByScreenName, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {kysoModelImpl.getSerialNumber()};

			finderCache.removeResult(_finderPathCountBygetBySerialNumber, args);
			finderCache.removeResult(_finderPathFetchBygetBySerialNumber, args);
		}

		if ((kysoModelImpl.getColumnBitmask() &
			 _finderPathFetchBygetBySerialNumber.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				kysoModelImpl.getOriginalSerialNumber()
			};

			finderCache.removeResult(_finderPathCountBygetBySerialNumber, args);
			finderCache.removeResult(_finderPathFetchBygetBySerialNumber, args);
		}
	}

	/**
	 * Creates a new kyso with the primary key. Does not add the kyso to the database.
	 *
	 * @param kysoId the primary key for the new kyso
	 * @return the new kyso
	 */
	@Override
	public Kyso create(long kysoId) {
		Kyso kyso = new KysoImpl();

		kyso.setNew(true);
		kyso.setPrimaryKey(kysoId);

		String uuid = PortalUUIDUtil.generate();

		kyso.setUuid(uuid);

		kyso.setCompanyId(CompanyThreadLocal.getCompanyId());

		return kyso;
	}

	/**
	 * Removes the kyso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param kysoId the primary key of the kyso
	 * @return the kyso that was removed
	 * @throws NoSuchKysoException if a kyso with the primary key could not be found
	 */
	@Override
	public Kyso remove(long kysoId) throws NoSuchKysoException {
		return remove((Serializable)kysoId);
	}

	/**
	 * Removes the kyso with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the kyso
	 * @return the kyso that was removed
	 * @throws NoSuchKysoException if a kyso with the primary key could not be found
	 */
	@Override
	public Kyso remove(Serializable primaryKey) throws NoSuchKysoException {
		Session session = null;

		try {
			session = openSession();

			Kyso kyso = (Kyso)session.get(KysoImpl.class, primaryKey);

			if (kyso == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchKysoException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(kyso);
		}
		catch (NoSuchKysoException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Kyso removeImpl(Kyso kyso) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(kyso)) {
				kyso = (Kyso)session.get(
					KysoImpl.class, kyso.getPrimaryKeyObj());
			}

			if (kyso != null) {
				session.delete(kyso);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (kyso != null) {
			clearCache(kyso);
		}

		return kyso;
	}

	@Override
	public Kyso updateImpl(Kyso kyso) {
		boolean isNew = kyso.isNew();

		if (!(kyso instanceof KysoModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(kyso.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(kyso);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in kyso proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Kyso implementation " +
					kyso.getClass());
		}

		KysoModelImpl kysoModelImpl = (KysoModelImpl)kyso;

		if (Validator.isNull(kyso.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			kyso.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (kyso.getCreateDate() == null)) {
			if (serviceContext == null) {
				kyso.setCreateDate(now);
			}
			else {
				kyso.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!kysoModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				kyso.setModifiedDate(now);
			}
			else {
				kyso.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (kyso.isNew()) {
				session.save(kyso);

				kyso.setNew(false);
			}
			else {
				kyso = (Kyso)session.merge(kyso);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {kysoModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				kysoModelImpl.getUuid(), kysoModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((kysoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {kysoModelImpl.getOriginalUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {kysoModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((kysoModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					kysoModelImpl.getOriginalUuid(),
					kysoModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					kysoModelImpl.getUuid(), kysoModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, KysoImpl.class, kyso.getPrimaryKey(), kyso,
			false);

		clearUniqueFindersCache(kysoModelImpl, false);
		cacheUniqueFindersCache(kysoModelImpl);

		kyso.resetOriginalValues();

		return kyso;
	}

	/**
	 * Returns the kyso with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the kyso
	 * @return the kyso
	 * @throws NoSuchKysoException if a kyso with the primary key could not be found
	 */
	@Override
	public Kyso findByPrimaryKey(Serializable primaryKey)
		throws NoSuchKysoException {

		Kyso kyso = fetchByPrimaryKey(primaryKey);

		if (kyso == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchKysoException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return kyso;
	}

	/**
	 * Returns the kyso with the primary key or throws a <code>NoSuchKysoException</code> if it could not be found.
	 *
	 * @param kysoId the primary key of the kyso
	 * @return the kyso
	 * @throws NoSuchKysoException if a kyso with the primary key could not be found
	 */
	@Override
	public Kyso findByPrimaryKey(long kysoId) throws NoSuchKysoException {
		return findByPrimaryKey((Serializable)kysoId);
	}

	/**
	 * Returns the kyso with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param kysoId the primary key of the kyso
	 * @return the kyso, or <code>null</code> if a kyso with the primary key could not be found
	 */
	@Override
	public Kyso fetchByPrimaryKey(long kysoId) {
		return fetchByPrimaryKey((Serializable)kysoId);
	}

	/**
	 * Returns all the kysos.
	 *
	 * @return the kysos
	 */
	@Override
	public List<Kyso> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the kysos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @return the range of kysos
	 */
	@Override
	public List<Kyso> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the kysos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of kysos
	 */
	@Deprecated
	@Override
	public List<Kyso> findAll(
		int start, int end, OrderByComparator<Kyso> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the kysos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>KysoModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of kysos
	 * @param end the upper bound of the range of kysos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of kysos
	 */
	@Override
	public List<Kyso> findAll(
		int start, int end, OrderByComparator<Kyso> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindAll;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Kyso> list = (List<Kyso>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_KYSO);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_KYSO;

				if (pagination) {
					sql = sql.concat(KysoModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Kyso>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Kyso>)QueryUtil.list(
						q, getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the kysos from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Kyso kyso : findAll()) {
			remove(kyso);
		}
	}

	/**
	 * Returns the number of kysos.
	 *
	 * @return the number of kysos
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_KYSO);

				count = (Long)q.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(e);
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
		return "kysoId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_KYSO;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return KysoModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the kyso persistence.
	 */
	@Activate
	public void activate() {
		KysoModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		KysoModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, KysoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, KysoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, KysoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, KysoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			KysoModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, KysoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			KysoModelImpl.UUID_COLUMN_BITMASK |
			KysoModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, KysoImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, KysoImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			KysoModelImpl.UUID_COLUMN_BITMASK |
			KysoModelImpl.COMPANYID_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathFetchBygetByScreenName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, KysoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBygetByScreenName",
			new String[] {String.class.getName()},
			KysoModelImpl.SCREENNAME_COLUMN_BITMASK);

		_finderPathCountBygetByScreenName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBygetByScreenName",
			new String[] {String.class.getName()});

		_finderPathFetchBygetBySerialNumber = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, KysoImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBygetBySerialNumber",
			new String[] {String.class.getName()},
			KysoModelImpl.SERIALNUMBER_COLUMN_BITMASK);

		_finderPathCountBygetBySerialNumber = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBygetBySerialNumber", new String[] {String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(KysoImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = cts_portalPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.ChungThuSo.Service.model.Kyso"),
			true);
	}

	@Override
	@Reference(
		target = cts_portalPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = cts_portalPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_KYSO = "SELECT kyso FROM Kyso kyso";

	private static final String _SQL_SELECT_KYSO_WHERE =
		"SELECT kyso FROM Kyso kyso WHERE ";

	private static final String _SQL_COUNT_KYSO =
		"SELECT COUNT(kyso) FROM Kyso kyso";

	private static final String _SQL_COUNT_KYSO_WHERE =
		"SELECT COUNT(kyso) FROM Kyso kyso WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "kyso.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Kyso exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Kyso exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		KysoPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(cts_portalPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}