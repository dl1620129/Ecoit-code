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

import LinkManager.Service.exception.NoSuchLinksException;
import LinkManager.Service.model.Links;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the links service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinksUtil
 * @generated
 */
@ProviderType
public interface LinksPersistence extends BasePersistence<Links> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LinksUtil} to access the links persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the links where linksid = &#63; or throws a <code>NoSuchLinksException</code> if it could not be found.
	 *
	 * @param linksid the linksid
	 * @return the matching links
	 * @throws NoSuchLinksException if a matching links could not be found
	 */
	public Links findBybyId(long linksid) throws NoSuchLinksException;

	/**
	 * Returns the links where linksid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBybyId(long)}
	 * @param linksid the linksid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching links, or <code>null</code> if a matching links could not be found
	 */
	@Deprecated
	public Links fetchBybyId(long linksid, boolean useFinderCache);

	/**
	 * Returns the links where linksid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param linksid the linksid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching links, or <code>null</code> if a matching links could not be found
	 */
	public Links fetchBybyId(long linksid);

	/**
	 * Removes the links where linksid = &#63; from the database.
	 *
	 * @param linksid the linksid
	 * @return the links that was removed
	 */
	public Links removeBybyId(long linksid) throws NoSuchLinksException;

	/**
	 * Returns the number of linkses where linksid = &#63;.
	 *
	 * @param linksid the linksid
	 * @return the number of matching linkses
	 */
	public int countBybyId(long linksid);

	/**
	 * Returns the links where name = &#63; or throws a <code>NoSuchLinksException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching links
	 * @throws NoSuchLinksException if a matching links could not be found
	 */
	public Links findBybyName(String name) throws NoSuchLinksException;

	/**
	 * Returns the links where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBybyName(String)}
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching links, or <code>null</code> if a matching links could not be found
	 */
	@Deprecated
	public Links fetchBybyName(String name, boolean useFinderCache);

	/**
	 * Returns the links where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching links, or <code>null</code> if a matching links could not be found
	 */
	public Links fetchBybyName(String name);

	/**
	 * Removes the links where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the links that was removed
	 */
	public Links removeBybyName(String name) throws NoSuchLinksException;

	/**
	 * Returns the number of linkses where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching linkses
	 */
	public int countBybyName(String name);

	/**
	 * Returns the links where linksgroupid = &#63; or throws a <code>NoSuchLinksException</code> if it could not be found.
	 *
	 * @param linksgroupid the linksgroupid
	 * @return the matching links
	 * @throws NoSuchLinksException if a matching links could not be found
	 */
	public Links findBybyGroupLinkId(long linksgroupid)
		throws NoSuchLinksException;

	/**
	 * Returns the links where linksgroupid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #fetchBybyGroupLinkId(long)}
	 * @param linksgroupid the linksgroupid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching links, or <code>null</code> if a matching links could not be found
	 */
	@Deprecated
	public Links fetchBybyGroupLinkId(
		long linksgroupid, boolean useFinderCache);

	/**
	 * Returns the links where linksgroupid = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param linksgroupid the linksgroupid
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching links, or <code>null</code> if a matching links could not be found
	 */
	public Links fetchBybyGroupLinkId(long linksgroupid);

	/**
	 * Removes the links where linksgroupid = &#63; from the database.
	 *
	 * @param linksgroupid the linksgroupid
	 * @return the links that was removed
	 */
	public Links removeBybyGroupLinkId(long linksgroupid)
		throws NoSuchLinksException;

	/**
	 * Returns the number of linkses where linksgroupid = &#63;.
	 *
	 * @param linksgroupid the linksgroupid
	 * @return the number of matching linkses
	 */
	public int countBybyGroupLinkId(long linksgroupid);

	/**
	 * Returns all the linkses where groupid = &#63;.
	 *
	 * @param groupid the groupid
	 * @return the matching linkses
	 */
	public java.util.List<Links> findByFindByGroups(long groupid);

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
	public java.util.List<Links> findByFindByGroups(
		long groupid, int start, int end);

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
	public java.util.List<Links> findByFindByGroups(
		long groupid, int start, int end,
		OrderByComparator<Links> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Links> findByFindByGroups(
		long groupid, int start, int end,
		OrderByComparator<Links> orderByComparator);

	/**
	 * Returns the first links in the ordered set where groupid = &#63;.
	 *
	 * @param groupid the groupid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching links
	 * @throws NoSuchLinksException if a matching links could not be found
	 */
	public Links findByFindByGroups_First(
			long groupid, OrderByComparator<Links> orderByComparator)
		throws NoSuchLinksException;

	/**
	 * Returns the first links in the ordered set where groupid = &#63;.
	 *
	 * @param groupid the groupid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching links, or <code>null</code> if a matching links could not be found
	 */
	public Links fetchByFindByGroups_First(
		long groupid, OrderByComparator<Links> orderByComparator);

	/**
	 * Returns the last links in the ordered set where groupid = &#63;.
	 *
	 * @param groupid the groupid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching links
	 * @throws NoSuchLinksException if a matching links could not be found
	 */
	public Links findByFindByGroups_Last(
			long groupid, OrderByComparator<Links> orderByComparator)
		throws NoSuchLinksException;

	/**
	 * Returns the last links in the ordered set where groupid = &#63;.
	 *
	 * @param groupid the groupid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching links, or <code>null</code> if a matching links could not be found
	 */
	public Links fetchByFindByGroups_Last(
		long groupid, OrderByComparator<Links> orderByComparator);

	/**
	 * Returns the linkses before and after the current links in the ordered set where groupid = &#63;.
	 *
	 * @param linksid the primary key of the current links
	 * @param groupid the groupid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next links
	 * @throws NoSuchLinksException if a links with the primary key could not be found
	 */
	public Links[] findByFindByGroups_PrevAndNext(
			long linksid, long groupid,
			OrderByComparator<Links> orderByComparator)
		throws NoSuchLinksException;

	/**
	 * Removes all the linkses where groupid = &#63; from the database.
	 *
	 * @param groupid the groupid
	 */
	public void removeByFindByGroups(long groupid);

	/**
	 * Returns the number of linkses where groupid = &#63;.
	 *
	 * @param groupid the groupid
	 * @return the number of matching linkses
	 */
	public int countByFindByGroups(long groupid);

	/**
	 * Returns all the linkses where groupid = &#63; and parentId = &#63;.
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @return the matching linkses
	 */
	public java.util.List<Links> findByFindByGroupPa(
		long groupid, long parentId);

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
	public java.util.List<Links> findByFindByGroupPa(
		long groupid, long parentId, int start, int end);

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
	public java.util.List<Links> findByFindByGroupPa(
		long groupid, long parentId, int start, int end,
		OrderByComparator<Links> orderByComparator, boolean useFinderCache);

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
	public java.util.List<Links> findByFindByGroupPa(
		long groupid, long parentId, int start, int end,
		OrderByComparator<Links> orderByComparator);

	/**
	 * Returns the first links in the ordered set where groupid = &#63; and parentId = &#63;.
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching links
	 * @throws NoSuchLinksException if a matching links could not be found
	 */
	public Links findByFindByGroupPa_First(
			long groupid, long parentId,
			OrderByComparator<Links> orderByComparator)
		throws NoSuchLinksException;

	/**
	 * Returns the first links in the ordered set where groupid = &#63; and parentId = &#63;.
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching links, or <code>null</code> if a matching links could not be found
	 */
	public Links fetchByFindByGroupPa_First(
		long groupid, long parentId,
		OrderByComparator<Links> orderByComparator);

	/**
	 * Returns the last links in the ordered set where groupid = &#63; and parentId = &#63;.
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching links
	 * @throws NoSuchLinksException if a matching links could not be found
	 */
	public Links findByFindByGroupPa_Last(
			long groupid, long parentId,
			OrderByComparator<Links> orderByComparator)
		throws NoSuchLinksException;

	/**
	 * Returns the last links in the ordered set where groupid = &#63; and parentId = &#63;.
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching links, or <code>null</code> if a matching links could not be found
	 */
	public Links fetchByFindByGroupPa_Last(
		long groupid, long parentId,
		OrderByComparator<Links> orderByComparator);

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
	public Links[] findByFindByGroupPa_PrevAndNext(
			long linksid, long groupid, long parentId,
			OrderByComparator<Links> orderByComparator)
		throws NoSuchLinksException;

	/**
	 * Removes all the linkses where groupid = &#63; and parentId = &#63; from the database.
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 */
	public void removeByFindByGroupPa(long groupid, long parentId);

	/**
	 * Returns the number of linkses where groupid = &#63; and parentId = &#63;.
	 *
	 * @param groupid the groupid
	 * @param parentId the parent ID
	 * @return the number of matching linkses
	 */
	public int countByFindByGroupPa(long groupid, long parentId);

	/**
	 * Caches the links in the entity cache if it is enabled.
	 *
	 * @param links the links
	 */
	public void cacheResult(Links links);

	/**
	 * Caches the linkses in the entity cache if it is enabled.
	 *
	 * @param linkses the linkses
	 */
	public void cacheResult(java.util.List<Links> linkses);

	/**
	 * Creates a new links with the primary key. Does not add the links to the database.
	 *
	 * @param linksid the primary key for the new links
	 * @return the new links
	 */
	public Links create(long linksid);

	/**
	 * Removes the links with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linksid the primary key of the links
	 * @return the links that was removed
	 * @throws NoSuchLinksException if a links with the primary key could not be found
	 */
	public Links remove(long linksid) throws NoSuchLinksException;

	public Links updateImpl(Links links);

	/**
	 * Returns the links with the primary key or throws a <code>NoSuchLinksException</code> if it could not be found.
	 *
	 * @param linksid the primary key of the links
	 * @return the links
	 * @throws NoSuchLinksException if a links with the primary key could not be found
	 */
	public Links findByPrimaryKey(long linksid) throws NoSuchLinksException;

	/**
	 * Returns the links with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param linksid the primary key of the links
	 * @return the links, or <code>null</code> if a links with the primary key could not be found
	 */
	public Links fetchByPrimaryKey(long linksid);

	/**
	 * Returns all the linkses.
	 *
	 * @return the linkses
	 */
	public java.util.List<Links> findAll();

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
	public java.util.List<Links> findAll(int start, int end);

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
	public java.util.List<Links> findAll(
		int start, int end, OrderByComparator<Links> orderByComparator,
		boolean useFinderCache);

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
	public java.util.List<Links> findAll(
		int start, int end, OrderByComparator<Links> orderByComparator);

	/**
	 * Removes all the linkses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of linkses.
	 *
	 * @return the number of linkses
	 */
	public int countAll();

}