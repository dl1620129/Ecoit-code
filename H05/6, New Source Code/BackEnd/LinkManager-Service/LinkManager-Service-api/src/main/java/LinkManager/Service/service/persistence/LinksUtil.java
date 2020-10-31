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

package LinkManager.Service.service.persistence;

import LinkManager.Service.model.Links;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the links service. This utility wraps <code>LinkManager.Service.service.persistence.impl.LinksPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinksPersistence
 * @generated
 */
@ProviderType
public class LinksUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Links links) {
		getPersistence().clearCache(links);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Links> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Links> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Links> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Links> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Links> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Links update(Links links) {
		return getPersistence().update(links);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Links update(Links links, ServiceContext serviceContext) {
		return getPersistence().update(links, serviceContext);
	}

	/**
	 * Returns the links where linksid = &#63; or throws a <code>NoSuchLinksException</code> if it could not be found.
	 *
	 * @param linksid the linksid
	 * @return the matching links
	 * @throws NoSuchLinksException if a matching links could not be found
	 */
	public static Links findBybyId(long linksid)
		throws LinkManager.Service.exception.NoSuchLinksException {

		return getPersistence().findBybyId(linksid);
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
	public static Links fetchBybyId(long linksid, boolean useFinderCache) {
		return getPersistence().fetchBybyId(linksid, useFinderCache);
	}

	/**
	 * Returns the links where linksid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param linksid the linksid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching links, or <code>null</code> if a matching links could not be found
	 */
	public static Links fetchBybyId(long linksid) {
		return getPersistence().fetchBybyId(linksid);
	}

	/**
	 * Removes the links where linksid = &#63; from the database.
	 *
	 * @param linksid the linksid
	 * @return the links that was removed
	 */
	public static Links removeBybyId(long linksid)
		throws LinkManager.Service.exception.NoSuchLinksException {

		return getPersistence().removeBybyId(linksid);
	}

	/**
	 * Returns the number of linkses where linksid = &#63;.
	 *
	 * @param linksid the linksid
	 * @return the number of matching linkses
	 */
	public static int countBybyId(long linksid) {
		return getPersistence().countBybyId(linksid);
	}

	/**
	 * Returns the links where name = &#63; or throws a <code>NoSuchLinksException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching links
	 * @throws NoSuchLinksException if a matching links could not be found
	 */
	public static Links findBybyName(String name)
		throws LinkManager.Service.exception.NoSuchLinksException {

		return getPersistence().findBybyName(name);
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
	public static Links fetchBybyName(String name, boolean useFinderCache) {
		return getPersistence().fetchBybyName(name, useFinderCache);
	}

	/**
	 * Returns the links where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching links, or <code>null</code> if a matching links could not be found
	 */
	public static Links fetchBybyName(String name) {
		return getPersistence().fetchBybyName(name);
	}

	/**
	 * Removes the links where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the links that was removed
	 */
	public static Links removeBybyName(String name)
		throws LinkManager.Service.exception.NoSuchLinksException {

		return getPersistence().removeBybyName(name);
	}

	/**
	 * Returns the number of linkses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching linkses
	 */
	public static int countBybyName(String name) {
		return getPersistence().countBybyName(name);
	}

	/**
	 * Returns the links where linksgroupid = &#63; or throws a <code>NoSuchLinksException</code> if it could not be found.
	 *
	 * @param linksgroupid the linksgroupid
	 * @return the matching links
	 * @throws NoSuchLinksException if a matching links could not be found
	 */
	public static Links findBybyGroupLinkId(long linksgroupid)
		throws LinkManager.Service.exception.NoSuchLinksException {

		return getPersistence().findBybyGroupLinkId(linksgroupid);
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
	public static Links fetchBybyGroupLinkId(
		long linksgroupid, boolean useFinderCache) {

		return getPersistence().fetchBybyGroupLinkId(
			linksgroupid, useFinderCache);
	}

	/**
	 * Returns the links where linksgroupid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param linksgroupid the linksgroupid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching links, or <code>null</code> if a matching links could not be found
	 */
	public static Links fetchBybyGroupLinkId(long linksgroupid) {
		return getPersistence().fetchBybyGroupLinkId(linksgroupid);
	}

	/**
	 * Removes the links where linksgroupid = &#63; from the database.
	 *
	 * @param linksgroupid the linksgroupid
	 * @return the links that was removed
	 */
	public static Links removeBybyGroupLinkId(long linksgroupid)
		throws LinkManager.Service.exception.NoSuchLinksException {

		return getPersistence().removeBybyGroupLinkId(linksgroupid);
	}

	/**
	 * Returns the number of linkses where linksgroupid = &#63;.
	 *
	 * @param linksgroupid the linksgroupid
	 * @return the number of matching linkses
	 */
	public static int countBybyGroupLinkId(long linksgroupid) {
		return getPersistence().countBybyGroupLinkId(linksgroupid);
	}

	/**
	 * Returns all the linkses where groupid = &#63;.
	 *
	 * @param groupid the groupid
	 * @return the matching linkses
	 */
	public static List<Links> findByFindByGroups(long groupid) {
		return getPersistence().findByFindByGroups(groupid);
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
	public static List<Links> findByFindByGroups(
		long groupid, int start, int end) {

		return getPersistence().findByFindByGroups(groupid, start, end);
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
	public static List<Links> findByFindByGroups(
		long groupid, int start, int end,
		OrderByComparator<Links> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByFindByGroups(
			groupid, start, end, orderByComparator, useFinderCache);
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
	public static List<Links> findByFindByGroups(
		long groupid, int start, int end,
		OrderByComparator<Links> orderByComparator) {

		return getPersistence().findByFindByGroups(
			groupid, start, end, orderByComparator);
	}

	/**
	 * Returns the first links in the ordered set where groupid = &#63;.
	 *
	 * @param groupid the groupid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching links
	 * @throws NoSuchLinksException if a matching links could not be found
	 */
	public static Links findByFindByGroups_First(
			long groupid, OrderByComparator<Links> orderByComparator)
		throws LinkManager.Service.exception.NoSuchLinksException {

		return getPersistence().findByFindByGroups_First(
			groupid, orderByComparator);
	}

	/**
	 * Returns the first links in the ordered set where groupid = &#63;.
	 *
	 * @param groupid the groupid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching links, or <code>null</code> if a matching links could not be found
	 */
	public static Links fetchByFindByGroups_First(
		long groupid, OrderByComparator<Links> orderByComparator) {

		return getPersistence().fetchByFindByGroups_First(
			groupid, orderByComparator);
	}

	/**
	 * Returns the last links in the ordered set where groupid = &#63;.
	 *
	 * @param groupid the groupid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching links
	 * @throws NoSuchLinksException if a matching links could not be found
	 */
	public static Links findByFindByGroups_Last(
			long groupid, OrderByComparator<Links> orderByComparator)
		throws LinkManager.Service.exception.NoSuchLinksException {

		return getPersistence().findByFindByGroups_Last(
			groupid, orderByComparator);
	}

	/**
	 * Returns the last links in the ordered set where groupid = &#63;.
	 *
	 * @param groupid the groupid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching links, or <code>null</code> if a matching links could not be found
	 */
	public static Links fetchByFindByGroups_Last(
		long groupid, OrderByComparator<Links> orderByComparator) {

		return getPersistence().fetchByFindByGroups_Last(
			groupid, orderByComparator);
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
	public static Links[] findByFindByGroups_PrevAndNext(
			long linksid, long groupid,
			OrderByComparator<Links> orderByComparator)
		throws LinkManager.Service.exception.NoSuchLinksException {

		return getPersistence().findByFindByGroups_PrevAndNext(
			linksid, groupid, orderByComparator);
	}

	/**
	 * Removes all the linkses where groupid = &#63; from the database.
	 *
	 * @param groupid the groupid
	 */
	public static void removeByFindByGroups(long groupid) {
		getPersistence().removeByFindByGroups(groupid);
	}

	/**
	 * Returns the number of linkses where groupid = &#63;.
	 *
	 * @param groupid the groupid
	 * @return the number of matching linkses
	 */
	public static int countByFindByGroups(long groupid) {
		return getPersistence().countByFindByGroups(groupid);
	}

	/**
	 * Returns all the linkses where groupid = &#63; and parentId = &#63;.
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @return the matching linkses
	 */
	public static List<Links> findByFindByGroupPa(long groupid, long parentId) {
		return getPersistence().findByFindByGroupPa(groupid, parentId);
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
	public static List<Links> findByFindByGroupPa(
		long groupid, long parentId, int start, int end) {

		return getPersistence().findByFindByGroupPa(
			groupid, parentId, start, end);
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
	public static List<Links> findByFindByGroupPa(
		long groupid, long parentId, int start, int end,
		OrderByComparator<Links> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByFindByGroupPa(
			groupid, parentId, start, end, orderByComparator, useFinderCache);
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
	public static List<Links> findByFindByGroupPa(
		long groupid, long parentId, int start, int end,
		OrderByComparator<Links> orderByComparator) {

		return getPersistence().findByFindByGroupPa(
			groupid, parentId, start, end, orderByComparator);
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
	public static Links findByFindByGroupPa_First(
			long groupid, long parentId,
			OrderByComparator<Links> orderByComparator)
		throws LinkManager.Service.exception.NoSuchLinksException {

		return getPersistence().findByFindByGroupPa_First(
			groupid, parentId, orderByComparator);
	}

	/**
	 * Returns the first links in the ordered set where groupid = &#63; and parentId = &#63;.
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching links, or <code>null</code> if a matching links could not be found
	 */
	public static Links fetchByFindByGroupPa_First(
		long groupid, long parentId,
		OrderByComparator<Links> orderByComparator) {

		return getPersistence().fetchByFindByGroupPa_First(
			groupid, parentId, orderByComparator);
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
	public static Links findByFindByGroupPa_Last(
			long groupid, long parentId,
			OrderByComparator<Links> orderByComparator)
		throws LinkManager.Service.exception.NoSuchLinksException {

		return getPersistence().findByFindByGroupPa_Last(
			groupid, parentId, orderByComparator);
	}

	/**
	 * Returns the last links in the ordered set where groupid = &#63; and parentId = &#63;.
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching links, or <code>null</code> if a matching links could not be found
	 */
	public static Links fetchByFindByGroupPa_Last(
		long groupid, long parentId,
		OrderByComparator<Links> orderByComparator) {

		return getPersistence().fetchByFindByGroupPa_Last(
			groupid, parentId, orderByComparator);
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
	public static Links[] findByFindByGroupPa_PrevAndNext(
			long linksid, long groupid, long parentId,
			OrderByComparator<Links> orderByComparator)
		throws LinkManager.Service.exception.NoSuchLinksException {

		return getPersistence().findByFindByGroupPa_PrevAndNext(
			linksid, groupid, parentId, orderByComparator);
	}

	/**
	 * Removes all the linkses where groupid = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 */
	public static void removeByFindByGroupPa(long groupid, long parentId) {
		getPersistence().removeByFindByGroupPa(groupid, parentId);
	}

	/**
	 * Returns the number of linkses where groupid = &#63; and parentId = &#63;.
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @return the number of matching linkses
	 */
	public static int countByFindByGroupPa(long groupid, long parentId) {
		return getPersistence().countByFindByGroupPa(groupid, parentId);
	}

	/**
	 * Caches the links in the entity cache if it is enabled.
	 *
	 * @param links the links
	 */
	public static void cacheResult(Links links) {
		getPersistence().cacheResult(links);
	}

	/**
	 * Caches the linkses in the entity cache if it is enabled.
	 *
	 * @param linkses the linkses
	 */
	public static void cacheResult(List<Links> linkses) {
		getPersistence().cacheResult(linkses);
	}

	/**
	 * Creates a new links with the primary key. Does not add the links to the database.
	 *
	 * @param linksid the primary key for the new links
	 * @return the new links
	 */
	public static Links create(long linksid) {
		return getPersistence().create(linksid);
	}

	/**
	 * Removes the links with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linksid the primary key of the links
	 * @return the links that was removed
	 * @throws NoSuchLinksException if a links with the primary key could not be found
	 */
	public static Links remove(long linksid)
		throws LinkManager.Service.exception.NoSuchLinksException {

		return getPersistence().remove(linksid);
	}

	public static Links updateImpl(Links links) {
		return getPersistence().updateImpl(links);
	}

	/**
	 * Returns the links with the primary key or throws a <code>NoSuchLinksException</code> if it could not be found.
	 *
	 * @param linksid the primary key of the links
	 * @return the links
	 * @throws NoSuchLinksException if a links with the primary key could not be found
	 */
	public static Links findByPrimaryKey(long linksid)
		throws LinkManager.Service.exception.NoSuchLinksException {

		return getPersistence().findByPrimaryKey(linksid);
	}

	/**
	 * Returns the links with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param linksid the primary key of the links
	 * @return the links, or <code>null</code> if a links with the primary key could not be found
	 */
	public static Links fetchByPrimaryKey(long linksid) {
		return getPersistence().fetchByPrimaryKey(linksid);
	}

	/**
	 * Returns all the linkses.
	 *
	 * @return the linkses
	 */
	public static List<Links> findAll() {
		return getPersistence().findAll();
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
	public static List<Links> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
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
	public static List<Links> findAll(
		int start, int end, OrderByComparator<Links> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
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
	public static List<Links> findAll(
		int start, int end, OrderByComparator<Links> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Removes all the linkses from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of linkses.
	 *
	 * @return the number of linkses
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LinksPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LinksPersistence, LinksPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LinksPersistence.class);

		ServiceTracker<LinksPersistence, LinksPersistence> serviceTracker =
			new ServiceTracker<LinksPersistence, LinksPersistence>(
				bundle.getBundleContext(), LinksPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}