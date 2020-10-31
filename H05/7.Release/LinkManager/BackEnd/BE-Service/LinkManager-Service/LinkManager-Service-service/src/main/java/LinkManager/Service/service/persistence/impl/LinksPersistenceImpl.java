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

package LinkManager.Service.service.persistence.impl;

import LinkManager.Service.exception.NoSuchLinksException;
import LinkManager.Service.model.Links;
import LinkManager.Service.model.impl.LinksImpl;
import LinkManager.Service.model.impl.LinksModelImpl;
import LinkManager.Service.service.persistence.LinksPersistence;
import LinkManager.Service.service.persistence.impl.constants.portalPersistenceConstants;

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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the links service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LinksPersistence.class)
@ProviderType
public class LinksPersistenceImpl
	extends BasePersistenceImpl<Links> implements LinksPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LinksUtil</code> to access the links persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LinksImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBybyId;
	private FinderPath _finderPathCountBybyId;

	/**
	 * Returns the links where linksid = &#63; or throws a <code>NoSuchLinksException</code> if it could not be found.
	 *
	 * @param linksid the linksid
	 * @return the matching links
	 * @throws NoSuchLinksException if a matching links could not be found
	 */
	@Override
	public Links findBybyId(long linksid) throws NoSuchLinksException {
		Links links = fetchBybyId(linksid);

		if (links == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("linksid=");
			msg.append(linksid);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLinksException(msg.toString());
		}

		return links;
	}

	/**
	 * Returns the links where linksid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBybyId(long)}
	 * @param linksid the linksid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching links, or <code>null</code> if a matching links could not be found
	 */
	@Deprecated
	@Override
	public Links fetchBybyId(long linksid, boolean useFinderCache) {
		return fetchBybyId(linksid);
	}

	/**
	 * Returns the links where linksid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param linksid the linksid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching links, or <code>null</code> if a matching links could not be found
	 */
	@Override
	public Links fetchBybyId(long linksid) {
		Object[] finderArgs = new Object[] {linksid};

		Object result = finderCache.getResult(
			_finderPathFetchBybyId, finderArgs, this);

		if (result instanceof Links) {
			Links links = (Links)result;

			if ((linksid != links.getLinksid())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LINKS_WHERE);

			query.append(_FINDER_COLUMN_BYID_LINKSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(linksid);

				List<Links> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchBybyId, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"LinksPersistenceImpl.fetchBybyId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Links links = list.get(0);

					result = links;

					cacheResult(links);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchBybyId, finderArgs);

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
			return (Links)result;
		}
	}

	/**
	 * Removes the links where linksid = &#63; from the database.
	 *
	 * @param linksid the linksid
	 * @return the links that was removed
	 */
	@Override
	public Links removeBybyId(long linksid) throws NoSuchLinksException {
		Links links = findBybyId(linksid);

		return remove(links);
	}

	/**
	 * Returns the number of linkses where linksid = &#63;.
	 *
	 * @param linksid the linksid
	 * @return the number of matching linkses
	 */
	@Override
	public int countBybyId(long linksid) {
		FinderPath finderPath = _finderPathCountBybyId;

		Object[] finderArgs = new Object[] {linksid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LINKS_WHERE);

			query.append(_FINDER_COLUMN_BYID_LINKSID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(linksid);

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

	private static final String _FINDER_COLUMN_BYID_LINKSID_2 =
		"links.linksid = ?";

	private FinderPath _finderPathFetchBybyName;
	private FinderPath _finderPathCountBybyName;

	/**
	 * Returns the links where name = &#63; or throws a <code>NoSuchLinksException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching links
	 * @throws NoSuchLinksException if a matching links could not be found
	 */
	@Override
	public Links findBybyName(String name) throws NoSuchLinksException {
		Links links = fetchBybyName(name);

		if (links == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLinksException(msg.toString());
		}

		return links;
	}

	/**
	 * Returns the links where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBybyName(String)}
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching links, or <code>null</code> if a matching links could not be found
	 */
	@Deprecated
	@Override
	public Links fetchBybyName(String name, boolean useFinderCache) {
		return fetchBybyName(name);
	}

	/**
	 * Returns the links where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching links, or <code>null</code> if a matching links could not be found
	 */
	@Override
	public Links fetchBybyName(String name) {
		name = Objects.toString(name, "");

		Object[] finderArgs = new Object[] {name};

		Object result = finderCache.getResult(
			_finderPathFetchBybyName, finderArgs, this);

		if (result instanceof Links) {
			Links links = (Links)result;

			if (!Objects.equals(name, links.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LINKS_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_BYNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_BYNAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				List<Links> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchBybyName, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"LinksPersistenceImpl.fetchBybyName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Links links = list.get(0);

					result = links;

					cacheResult(links);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(_finderPathFetchBybyName, finderArgs);

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
			return (Links)result;
		}
	}

	/**
	 * Removes the links where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the links that was removed
	 */
	@Override
	public Links removeBybyName(String name) throws NoSuchLinksException {
		Links links = findBybyName(name);

		return remove(links);
	}

	/**
	 * Returns the number of linkses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching linkses
	 */
	@Override
	public int countBybyName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountBybyName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LINKS_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				query.append(_FINDER_COLUMN_BYNAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_BYNAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_BYNAME_NAME_2 = "links.name = ?";

	private static final String _FINDER_COLUMN_BYNAME_NAME_3 =
		"(links.name IS NULL OR links.name = '')";

	private FinderPath _finderPathFetchBybyGroupLinkId;
	private FinderPath _finderPathCountBybyGroupLinkId;

	/**
	 * Returns the links where linksgroupid = &#63; or throws a <code>NoSuchLinksException</code> if it could not be found.
	 *
	 * @param linksgroupid the linksgroupid
	 * @return the matching links
	 * @throws NoSuchLinksException if a matching links could not be found
	 */
	@Override
	public Links findBybyGroupLinkId(long linksgroupid)
		throws NoSuchLinksException {

		Links links = fetchBybyGroupLinkId(linksgroupid);

		if (links == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("linksgroupid=");
			msg.append(linksgroupid);

			msg.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchLinksException(msg.toString());
		}

		return links;
	}

	/**
	 * Returns the links where linksgroupid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBybyGroupLinkId(long)}
	 * @param linksgroupid the linksgroupid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching links, or <code>null</code> if a matching links could not be found
	 */
	@Deprecated
	@Override
	public Links fetchBybyGroupLinkId(
		long linksgroupid, boolean useFinderCache) {

		return fetchBybyGroupLinkId(linksgroupid);
	}

	/**
	 * Returns the links where linksgroupid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param linksgroupid the linksgroupid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching links, or <code>null</code> if a matching links could not be found
	 */
	@Override
	public Links fetchBybyGroupLinkId(long linksgroupid) {
		Object[] finderArgs = new Object[] {linksgroupid};

		Object result = finderCache.getResult(
			_finderPathFetchBybyGroupLinkId, finderArgs, this);

		if (result instanceof Links) {
			Links links = (Links)result;

			if ((linksgroupid != links.getLinksgroupid())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_LINKS_WHERE);

			query.append(_FINDER_COLUMN_BYGROUPLINKID_LINKSGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(linksgroupid);

				List<Links> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(
						_finderPathFetchBybyGroupLinkId, finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"LinksPersistenceImpl.fetchBybyGroupLinkId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Links links = list.get(0);

					result = links;

					cacheResult(links);
				}
			}
			catch (Exception e) {
				finderCache.removeResult(
					_finderPathFetchBybyGroupLinkId, finderArgs);

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
			return (Links)result;
		}
	}

	/**
	 * Removes the links where linksgroupid = &#63; from the database.
	 *
	 * @param linksgroupid the linksgroupid
	 * @return the links that was removed
	 */
	@Override
	public Links removeBybyGroupLinkId(long linksgroupid)
		throws NoSuchLinksException {

		Links links = findBybyGroupLinkId(linksgroupid);

		return remove(links);
	}

	/**
	 * Returns the number of linkses where linksgroupid = &#63;.
	 *
	 * @param linksgroupid the linksgroupid
	 * @return the number of matching linkses
	 */
	@Override
	public int countBybyGroupLinkId(long linksgroupid) {
		FinderPath finderPath = _finderPathCountBybyGroupLinkId;

		Object[] finderArgs = new Object[] {linksgroupid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LINKS_WHERE);

			query.append(_FINDER_COLUMN_BYGROUPLINKID_LINKSGROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(linksgroupid);

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

	private static final String _FINDER_COLUMN_BYGROUPLINKID_LINKSGROUPID_2 =
		"links.linksgroupid = ?";

	private FinderPath _finderPathWithPaginationFindByFindByGroups;
	private FinderPath _finderPathWithoutPaginationFindByFindByGroups;
	private FinderPath _finderPathCountByFindByGroups;

	/**
	 * Returns all the linkses where groupid = &#63;.
	 *
	 * @param groupid the groupid
	 * @return the matching linkses
	 */
	@Override
	public List<Links> findByFindByGroups(long groupid) {
		return findByFindByGroups(
			groupid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the linkses where groupid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinksModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupid the groupid
	 * @param start the lower bound of the range of linkses
	 * @param end the upper bound of the range of linkses (not inclusive)
	 * @return the range of matching linkses
	 */
	@Override
	public List<Links> findByFindByGroups(long groupid, int start, int end) {
		return findByFindByGroups(groupid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the linkses where groupid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinksModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByFindByGroups(long, int, int, OrderByComparator)}
	 * @param groupid the groupid
	 * @param start the lower bound of the range of linkses
	 * @param end the upper bound of the range of linkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching linkses
	 */
	@Deprecated
	@Override
	public List<Links> findByFindByGroups(
		long groupid, int start, int end,
		OrderByComparator<Links> orderByComparator, boolean useFinderCache) {

		return findByFindByGroups(groupid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the linkses where groupid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinksModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupid the groupid
	 * @param start the lower bound of the range of linkses
	 * @param end the upper bound of the range of linkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching linkses
	 */
	@Override
	public List<Links> findByFindByGroups(
		long groupid, int start, int end,
		OrderByComparator<Links> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByFindByGroups;
			finderArgs = new Object[] {groupid};
		}
		else {
			finderPath = _finderPathWithPaginationFindByFindByGroups;
			finderArgs = new Object[] {groupid, start, end, orderByComparator};
		}

		List<Links> list = (List<Links>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Links links : list) {
				if ((groupid != links.getGroupid())) {
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

			query.append(_SQL_SELECT_LINKS_WHERE);

			query.append(_FINDER_COLUMN_FINDBYGROUPS_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(LinksModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupid);

				if (!pagination) {
					list = (List<Links>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Links>)QueryUtil.list(
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
	 * Returns the first links in the ordered set where groupid = &#63;.
	 *
	 * @param groupid the groupid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching links
	 * @throws NoSuchLinksException if a matching links could not be found
	 */
	@Override
	public Links findByFindByGroups_First(
			long groupid, OrderByComparator<Links> orderByComparator)
		throws NoSuchLinksException {

		Links links = fetchByFindByGroups_First(groupid, orderByComparator);

		if (links != null) {
			return links;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupid=");
		msg.append(groupid);

		msg.append("}");

		throw new NoSuchLinksException(msg.toString());
	}

	/**
	 * Returns the first links in the ordered set where groupid = &#63;.
	 *
	 * @param groupid the groupid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching links, or <code>null</code> if a matching links could not be found
	 */
	@Override
	public Links fetchByFindByGroups_First(
		long groupid, OrderByComparator<Links> orderByComparator) {

		List<Links> list = findByFindByGroups(groupid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last links in the ordered set where groupid = &#63;.
	 *
	 * @param groupid the groupid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching links
	 * @throws NoSuchLinksException if a matching links could not be found
	 */
	@Override
	public Links findByFindByGroups_Last(
			long groupid, OrderByComparator<Links> orderByComparator)
		throws NoSuchLinksException {

		Links links = fetchByFindByGroups_Last(groupid, orderByComparator);

		if (links != null) {
			return links;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupid=");
		msg.append(groupid);

		msg.append("}");

		throw new NoSuchLinksException(msg.toString());
	}

	/**
	 * Returns the last links in the ordered set where groupid = &#63;.
	 *
	 * @param groupid the groupid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching links, or <code>null</code> if a matching links could not be found
	 */
	@Override
	public Links fetchByFindByGroups_Last(
		long groupid, OrderByComparator<Links> orderByComparator) {

		int count = countByFindByGroups(groupid);

		if (count == 0) {
			return null;
		}

		List<Links> list = findByFindByGroups(
			groupid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the linkses before and after the current links in the ordered set where groupid = &#63;.
	 *
	 * @param linksid the primary key of the current links
	 * @param groupid the groupid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next links
	 * @throws NoSuchLinksException if a links with the primary key could not be found
	 */
	@Override
	public Links[] findByFindByGroups_PrevAndNext(
			long linksid, long groupid,
			OrderByComparator<Links> orderByComparator)
		throws NoSuchLinksException {

		Links links = findByPrimaryKey(linksid);

		Session session = null;

		try {
			session = openSession();

			Links[] array = new LinksImpl[3];

			array[0] = getByFindByGroups_PrevAndNext(
				session, links, groupid, orderByComparator, true);

			array[1] = links;

			array[2] = getByFindByGroups_PrevAndNext(
				session, links, groupid, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Links getByFindByGroups_PrevAndNext(
		Session session, Links links, long groupid,
		OrderByComparator<Links> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_LINKS_WHERE);

		query.append(_FINDER_COLUMN_FINDBYGROUPS_GROUPID_2);

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
			query.append(LinksModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupid);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(links)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Links> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the linkses where groupid = &#63; from the database.
	 *
	 * @param groupid the groupid
	 */
	@Override
	public void removeByFindByGroups(long groupid) {
		for (Links links :
				findByFindByGroups(
					groupid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(links);
		}
	}

	/**
	 * Returns the number of linkses where groupid = &#63;.
	 *
	 * @param groupid the groupid
	 * @return the number of matching linkses
	 */
	@Override
	public int countByFindByGroups(long groupid) {
		FinderPath finderPath = _finderPathCountByFindByGroups;

		Object[] finderArgs = new Object[] {groupid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_LINKS_WHERE);

			query.append(_FINDER_COLUMN_FINDBYGROUPS_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupid);

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

	private static final String _FINDER_COLUMN_FINDBYGROUPS_GROUPID_2 =
		"links.groupid = ?";

	private FinderPath _finderPathWithPaginationFindByFindByGroupPa;
	private FinderPath _finderPathWithoutPaginationFindByFindByGroupPa;
	private FinderPath _finderPathCountByFindByGroupPa;

	/**
	 * Returns all the linkses where groupid = &#63; and parentId = &#63;.
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @return the matching linkses
	 */
	@Override
	public List<Links> findByFindByGroupPa(long groupid, long parentId) {
		return findByFindByGroupPa(
			groupid, parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the linkses where groupid = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinksModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of linkses
	 * @param end the upper bound of the range of linkses (not inclusive)
	 * @return the range of matching linkses
	 */
	@Override
	public List<Links> findByFindByGroupPa(
		long groupid, long parentId, int start, int end) {

		return findByFindByGroupPa(groupid, parentId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the linkses where groupid = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinksModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findByFindByGroupPa(long,long, int, int, OrderByComparator)}
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of linkses
	 * @param end the upper bound of the range of linkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching linkses
	 */
	@Deprecated
	@Override
	public List<Links> findByFindByGroupPa(
		long groupid, long parentId, int start, int end,
		OrderByComparator<Links> orderByComparator, boolean useFinderCache) {

		return findByFindByGroupPa(
			groupid, parentId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the linkses where groupid = &#63; and parentId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinksModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @param start the lower bound of the range of linkses
	 * @param end the upper bound of the range of linkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching linkses
	 */
	@Override
	public List<Links> findByFindByGroupPa(
		long groupid, long parentId, int start, int end,
		OrderByComparator<Links> orderByComparator) {

		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			pagination = false;
			finderPath = _finderPathWithoutPaginationFindByFindByGroupPa;
			finderArgs = new Object[] {groupid, parentId};
		}
		else {
			finderPath = _finderPathWithPaginationFindByFindByGroupPa;
			finderArgs = new Object[] {
				groupid, parentId, start, end, orderByComparator
			};
		}

		List<Links> list = (List<Links>)finderCache.getResult(
			finderPath, finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Links links : list) {
				if ((groupid != links.getGroupid()) ||
					(parentId != links.getParentId())) {

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

			query.append(_SQL_SELECT_LINKS_WHERE);

			query.append(_FINDER_COLUMN_FINDBYGROUPPA_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDBYGROUPPA_PARENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else if (pagination) {
				query.append(LinksModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupid);

				qPos.add(parentId);

				if (!pagination) {
					list = (List<Links>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Links>)QueryUtil.list(
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
	 * Returns the first links in the ordered set where groupid = &#63; and parentId = &#63;.
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching links
	 * @throws NoSuchLinksException if a matching links could not be found
	 */
	@Override
	public Links findByFindByGroupPa_First(
			long groupid, long parentId,
			OrderByComparator<Links> orderByComparator)
		throws NoSuchLinksException {

		Links links = fetchByFindByGroupPa_First(
			groupid, parentId, orderByComparator);

		if (links != null) {
			return links;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupid=");
		msg.append(groupid);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append("}");

		throw new NoSuchLinksException(msg.toString());
	}

	/**
	 * Returns the first links in the ordered set where groupid = &#63; and parentId = &#63;.
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching links, or <code>null</code> if a matching links could not be found
	 */
	@Override
	public Links fetchByFindByGroupPa_First(
		long groupid, long parentId,
		OrderByComparator<Links> orderByComparator) {

		List<Links> list = findByFindByGroupPa(
			groupid, parentId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last links in the ordered set where groupid = &#63; and parentId = &#63;.
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching links
	 * @throws NoSuchLinksException if a matching links could not be found
	 */
	@Override
	public Links findByFindByGroupPa_Last(
			long groupid, long parentId,
			OrderByComparator<Links> orderByComparator)
		throws NoSuchLinksException {

		Links links = fetchByFindByGroupPa_Last(
			groupid, parentId, orderByComparator);

		if (links != null) {
			return links;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupid=");
		msg.append(groupid);

		msg.append(", parentId=");
		msg.append(parentId);

		msg.append("}");

		throw new NoSuchLinksException(msg.toString());
	}

	/**
	 * Returns the last links in the ordered set where groupid = &#63; and parentId = &#63;.
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching links, or <code>null</code> if a matching links could not be found
	 */
	@Override
	public Links fetchByFindByGroupPa_Last(
		long groupid, long parentId,
		OrderByComparator<Links> orderByComparator) {

		int count = countByFindByGroupPa(groupid, parentId);

		if (count == 0) {
			return null;
		}

		List<Links> list = findByFindByGroupPa(
			groupid, parentId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the linkses before and after the current links in the ordered set where groupid = &#63; and parentId = &#63;.
	 *
	 * @param linksid the primary key of the current links
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next links
	 * @throws NoSuchLinksException if a links with the primary key could not be found
	 */
	@Override
	public Links[] findByFindByGroupPa_PrevAndNext(
			long linksid, long groupid, long parentId,
			OrderByComparator<Links> orderByComparator)
		throws NoSuchLinksException {

		Links links = findByPrimaryKey(linksid);

		Session session = null;

		try {
			session = openSession();

			Links[] array = new LinksImpl[3];

			array[0] = getByFindByGroupPa_PrevAndNext(
				session, links, groupid, parentId, orderByComparator, true);

			array[1] = links;

			array[2] = getByFindByGroupPa_PrevAndNext(
				session, links, groupid, parentId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Links getByFindByGroupPa_PrevAndNext(
		Session session, Links links, long groupid, long parentId,
		OrderByComparator<Links> orderByComparator, boolean previous) {

		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_LINKS_WHERE);

		query.append(_FINDER_COLUMN_FINDBYGROUPPA_GROUPID_2);

		query.append(_FINDER_COLUMN_FINDBYGROUPPA_PARENTID_2);

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
			query.append(LinksModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupid);

		qPos.add(parentId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(links)) {

				qPos.add(orderByConditionValue);
			}
		}

		List<Links> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the linkses where groupid = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 */
	@Override
	public void removeByFindByGroupPa(long groupid, long parentId) {
		for (Links links :
				findByFindByGroupPa(
					groupid, parentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(links);
		}
	}

	/**
	 * Returns the number of linkses where groupid = &#63; and parentId = &#63;.
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @return the number of matching linkses
	 */
	@Override
	public int countByFindByGroupPa(long groupid, long parentId) {
		FinderPath finderPath = _finderPathCountByFindByGroupPa;

		Object[] finderArgs = new Object[] {groupid, parentId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_LINKS_WHERE);

			query.append(_FINDER_COLUMN_FINDBYGROUPPA_GROUPID_2);

			query.append(_FINDER_COLUMN_FINDBYGROUPPA_PARENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupid);

				qPos.add(parentId);

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

	private static final String _FINDER_COLUMN_FINDBYGROUPPA_GROUPID_2 =
		"links.groupid = ? AND ";

	private static final String _FINDER_COLUMN_FINDBYGROUPPA_PARENTID_2 =
		"links.parentId = ?";

	public LinksPersistenceImpl() {
		setModelClass(Links.class);

		setModelImplClass(LinksImpl.class);
		setModelPKClass(long.class);

		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("show", "show_");

		setDBColumnNames(dbColumnNames);
	}

	/**
	 * Caches the links in the entity cache if it is enabled.
	 *
	 * @param links the links
	 */
	@Override
	public void cacheResult(Links links) {
		entityCache.putResult(
			entityCacheEnabled, LinksImpl.class, links.getPrimaryKey(), links);

		finderCache.putResult(
			_finderPathFetchBybyId, new Object[] {links.getLinksid()}, links);

		finderCache.putResult(
			_finderPathFetchBybyName, new Object[] {links.getName()}, links);

		finderCache.putResult(
			_finderPathFetchBybyGroupLinkId,
			new Object[] {links.getLinksgroupid()}, links);

		links.resetOriginalValues();
	}

	/**
	 * Caches the linkses in the entity cache if it is enabled.
	 *
	 * @param linkses the linkses
	 */
	@Override
	public void cacheResult(List<Links> linkses) {
		for (Links links : linkses) {
			if (entityCache.getResult(
					entityCacheEnabled, LinksImpl.class,
					links.getPrimaryKey()) == null) {

				cacheResult(links);
			}
			else {
				links.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all linkses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LinksImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the links.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Links links) {
		entityCache.removeResult(
			entityCacheEnabled, LinksImpl.class, links.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((LinksModelImpl)links, true);
	}

	@Override
	public void clearCache(List<Links> linkses) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Links links : linkses) {
			entityCache.removeResult(
				entityCacheEnabled, LinksImpl.class, links.getPrimaryKey());

			clearUniqueFindersCache((LinksModelImpl)links, true);
		}
	}

	protected void cacheUniqueFindersCache(LinksModelImpl linksModelImpl) {
		Object[] args = new Object[] {linksModelImpl.getLinksid()};

		finderCache.putResult(
			_finderPathCountBybyId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBybyId, args, linksModelImpl, false);

		args = new Object[] {linksModelImpl.getName()};

		finderCache.putResult(
			_finderPathCountBybyName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBybyName, args, linksModelImpl, false);

		args = new Object[] {linksModelImpl.getLinksgroupid()};

		finderCache.putResult(
			_finderPathCountBybyGroupLinkId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBybyGroupLinkId, args, linksModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		LinksModelImpl linksModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {linksModelImpl.getLinksid()};

			finderCache.removeResult(_finderPathCountBybyId, args);
			finderCache.removeResult(_finderPathFetchBybyId, args);
		}

		if ((linksModelImpl.getColumnBitmask() &
			 _finderPathFetchBybyId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {linksModelImpl.getOriginalLinksid()};

			finderCache.removeResult(_finderPathCountBybyId, args);
			finderCache.removeResult(_finderPathFetchBybyId, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {linksModelImpl.getName()};

			finderCache.removeResult(_finderPathCountBybyName, args);
			finderCache.removeResult(_finderPathFetchBybyName, args);
		}

		if ((linksModelImpl.getColumnBitmask() &
			 _finderPathFetchBybyName.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {linksModelImpl.getOriginalName()};

			finderCache.removeResult(_finderPathCountBybyName, args);
			finderCache.removeResult(_finderPathFetchBybyName, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {linksModelImpl.getLinksgroupid()};

			finderCache.removeResult(_finderPathCountBybyGroupLinkId, args);
			finderCache.removeResult(_finderPathFetchBybyGroupLinkId, args);
		}

		if ((linksModelImpl.getColumnBitmask() &
			 _finderPathFetchBybyGroupLinkId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				linksModelImpl.getOriginalLinksgroupid()
			};

			finderCache.removeResult(_finderPathCountBybyGroupLinkId, args);
			finderCache.removeResult(_finderPathFetchBybyGroupLinkId, args);
		}
	}

	/**
	 * Creates a new links with the primary key. Does not add the links to the database.
	 *
	 * @param linksid the primary key for the new links
	 * @return the new links
	 */
	@Override
	public Links create(long linksid) {
		Links links = new LinksImpl();

		links.setNew(true);
		links.setPrimaryKey(linksid);

		return links;
	}

	/**
	 * Removes the links with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linksid the primary key of the links
	 * @return the links that was removed
	 * @throws NoSuchLinksException if a links with the primary key could not be found
	 */
	@Override
	public Links remove(long linksid) throws NoSuchLinksException {
		return remove((Serializable)linksid);
	}

	/**
	 * Removes the links with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the links
	 * @return the links that was removed
	 * @throws NoSuchLinksException if a links with the primary key could not be found
	 */
	@Override
	public Links remove(Serializable primaryKey) throws NoSuchLinksException {
		Session session = null;

		try {
			session = openSession();

			Links links = (Links)session.get(LinksImpl.class, primaryKey);

			if (links == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLinksException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(links);
		}
		catch (NoSuchLinksException nsee) {
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
	protected Links removeImpl(Links links) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(links)) {
				links = (Links)session.get(
					LinksImpl.class, links.getPrimaryKeyObj());
			}

			if (links != null) {
				session.delete(links);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (links != null) {
			clearCache(links);
		}

		return links;
	}

	@Override
	public Links updateImpl(Links links) {
		boolean isNew = links.isNew();

		if (!(links instanceof LinksModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(links.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(links);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in links proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Links implementation " +
					links.getClass());
		}

		LinksModelImpl linksModelImpl = (LinksModelImpl)links;

		Session session = null;

		try {
			session = openSession();

			if (links.isNew()) {
				session.save(links);

				links.setNew(false);
			}
			else {
				links = (Links)session.merge(links);
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
			Object[] args = new Object[] {linksModelImpl.getGroupid()};

			finderCache.removeResult(_finderPathCountByFindByGroups, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindByGroups, args);

			args = new Object[] {
				linksModelImpl.getGroupid(), linksModelImpl.getParentId()
			};

			finderCache.removeResult(_finderPathCountByFindByGroupPa, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByFindByGroupPa, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((linksModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindByGroups.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					linksModelImpl.getOriginalGroupid()
				};

				finderCache.removeResult(_finderPathCountByFindByGroups, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindByGroups, args);

				args = new Object[] {linksModelImpl.getGroupid()};

				finderCache.removeResult(_finderPathCountByFindByGroups, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindByGroups, args);
			}

			if ((linksModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByFindByGroupPa.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					linksModelImpl.getOriginalGroupid(),
					linksModelImpl.getOriginalParentId()
				};

				finderCache.removeResult(_finderPathCountByFindByGroupPa, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindByGroupPa, args);

				args = new Object[] {
					linksModelImpl.getGroupid(), linksModelImpl.getParentId()
				};

				finderCache.removeResult(_finderPathCountByFindByGroupPa, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByFindByGroupPa, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, LinksImpl.class, links.getPrimaryKey(), links,
			false);

		clearUniqueFindersCache(linksModelImpl, false);
		cacheUniqueFindersCache(linksModelImpl);

		links.resetOriginalValues();

		return links;
	}

	/**
	 * Returns the links with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the links
	 * @return the links
	 * @throws NoSuchLinksException if a links with the primary key could not be found
	 */
	@Override
	public Links findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLinksException {

		Links links = fetchByPrimaryKey(primaryKey);

		if (links == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLinksException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return links;
	}

	/**
	 * Returns the links with the primary key or throws a <code>NoSuchLinksException</code> if it could not be found.
	 *
	 * @param linksid the primary key of the links
	 * @return the links
	 * @throws NoSuchLinksException if a links with the primary key could not be found
	 */
	@Override
	public Links findByPrimaryKey(long linksid) throws NoSuchLinksException {
		return findByPrimaryKey((Serializable)linksid);
	}

	/**
	 * Returns the links with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param linksid the primary key of the links
	 * @return the links, or <code>null</code> if a links with the primary key could not be found
	 */
	@Override
	public Links fetchByPrimaryKey(long linksid) {
		return fetchByPrimaryKey((Serializable)linksid);
	}

	/**
	 * Returns all the linkses.
	 *
	 * @return the linkses
	 */
	@Override
	public List<Links> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the linkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinksModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of linkses
	 * @param end the upper bound of the range of linkses (not inclusive)
	 * @return the range of linkses
	 */
	@Override
	public List<Links> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the linkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinksModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of linkses
	 * @param end the upper bound of the range of linkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of linkses
	 */
	@Deprecated
	@Override
	public List<Links> findAll(
		int start, int end, OrderByComparator<Links> orderByComparator,
		boolean useFinderCache) {

		return findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the linkses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>LinksModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of linkses
	 * @param end the upper bound of the range of linkses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of linkses
	 */
	@Override
	public List<Links> findAll(
		int start, int end, OrderByComparator<Links> orderByComparator) {

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

		List<Links> list = (List<Links>)finderCache.getResult(
			finderPath, finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_LINKS);

				appendOrderByComparator(
					query, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_LINKS;

				if (pagination) {
					sql = sql.concat(LinksModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Links>)QueryUtil.list(
						q, getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Links>)QueryUtil.list(
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
	 * Removes all the linkses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Links links : findAll()) {
			remove(links);
		}
	}

	/**
	 * Returns the number of linkses.
	 *
	 * @return the number of linkses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_LINKS);

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
		return "linksid";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LINKS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LinksModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the links persistence.
	 */
	@Activate
	public void activate() {
		LinksModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		LinksModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathFetchBybyId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinksImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBybyId",
			new String[] {Long.class.getName()},
			LinksModelImpl.LINKSID_COLUMN_BITMASK);

		_finderPathCountBybyId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyId",
			new String[] {Long.class.getName()});

		_finderPathFetchBybyName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinksImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBybyName",
			new String[] {String.class.getName()},
			LinksModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountBybyName = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyName",
			new String[] {String.class.getName()});

		_finderPathFetchBybyGroupLinkId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinksImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchBybyGroupLinkId",
			new String[] {Long.class.getName()},
			LinksModelImpl.LINKSGROUPID_COLUMN_BITMASK);

		_finderPathCountBybyGroupLinkId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBybyGroupLinkId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByFindByGroups = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindByGroups",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindByGroups = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindByGroups",
			new String[] {Long.class.getName()},
			LinksModelImpl.GROUPID_COLUMN_BITMASK |
			LinksModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByFindByGroups = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindByGroups",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByFindByGroupPa = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinksImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByFindByGroupPa",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByFindByGroupPa = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, LinksImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByFindByGroupPa",
			new String[] {Long.class.getName(), Long.class.getName()},
			LinksModelImpl.GROUPID_COLUMN_BITMASK |
			LinksModelImpl.PARENTID_COLUMN_BITMASK |
			LinksModelImpl.NAME_COLUMN_BITMASK);

		_finderPathCountByFindByGroupPa = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByFindByGroupPa",
			new String[] {Long.class.getName(), Long.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LinksImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = portalPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.LinkManager.Service.model.Links"),
			true);
	}

	@Override
	@Reference(
		target = portalPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = portalPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
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

	private static final String _SQL_SELECT_LINKS =
		"SELECT links FROM Links links";

	private static final String _SQL_SELECT_LINKS_WHERE =
		"SELECT links FROM Links links WHERE ";

	private static final String _SQL_COUNT_LINKS =
		"SELECT COUNT(links) FROM Links links";

	private static final String _SQL_COUNT_LINKS_WHERE =
		"SELECT COUNT(links) FROM Links links WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "links.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Links exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Links exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LinksPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"show"});

	static {
		try {
			Class.forName(portalPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException cnfe) {
			throw new ExceptionInInitializerError(cnfe);
		}
	}

}