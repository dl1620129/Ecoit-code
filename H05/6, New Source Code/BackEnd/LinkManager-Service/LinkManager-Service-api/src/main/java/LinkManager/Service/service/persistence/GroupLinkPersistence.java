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

import LinkManager.Service.exception.NoSuchGroupLinkException;
import LinkManager.Service.model.GroupLink;

import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the group link service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupLinkUtil
 * @generated
 */
@ProviderType
public interface GroupLinkPersistence extends BasePersistence<GroupLink> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link GroupLinkUtil} to access the group link persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the group link in the entity cache if it is enabled.
	 *
	 * @param groupLink the group link
	 */
	public void cacheResult(GroupLink groupLink);

	/**
	 * Caches the group links in the entity cache if it is enabled.
	 *
	 * @param groupLinks the group links
	 */
	public void cacheResult(java.util.List<GroupLink> groupLinks);

	/**
	 * Creates a new group link with the primary key. Does not add the group link to the database.
	 *
	 * @param linksgroupid the primary key for the new group link
	 * @return the new group link
	 */
	public GroupLink create(long linksgroupid);

	/**
	 * Removes the group link with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param linksgroupid the primary key of the group link
	 * @return the group link that was removed
	 * @throws NoSuchGroupLinkException if a group link with the primary key could not be found
	 */
	public GroupLink remove(long linksgroupid) throws NoSuchGroupLinkException;

	public GroupLink updateImpl(GroupLink groupLink);

	/**
	 * Returns the group link with the primary key or throws a <code>NoSuchGroupLinkException</code> if it could not be found.
	 *
	 * @param linksgroupid the primary key of the group link
	 * @return the group link
	 * @throws NoSuchGroupLinkException if a group link with the primary key could not be found
	 */
	public GroupLink findByPrimaryKey(long linksgroupid)
		throws NoSuchGroupLinkException;

	/**
	 * Returns the group link with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param linksgroupid the primary key of the group link
	 * @return the group link, or <code>null</code> if a group link with the primary key could not be found
	 */
	public GroupLink fetchByPrimaryKey(long linksgroupid);

	/**
	 * Returns all the group links.
	 *
	 * @return the group links
	 */
	public java.util.List<GroupLink> findAll();

	/**
	 * Returns a range of all the group links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GroupLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of group links
	 * @param end the upper bound of the range of group links (not inclusive)
	 * @return the range of group links
	 */
	public java.util.List<GroupLink> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the group links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GroupLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @deprecated As of Mueller (7.2.x), replaced by {@link #findAll(int, int, OrderByComparator)}
	 * @param start the lower bound of the range of group links
	 * @param end the upper bound of the range of group links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of group links
	 */
	@Deprecated
	public java.util.List<GroupLink> findAll(
		int start, int end, OrderByComparator<GroupLink> orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns an ordered range of all the group links.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not <code>QueryUtil#ALL_POS</code>), then the query will include the default ORDER BY logic from <code>GroupLinkModelImpl</code>. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of group links
	 * @param end the upper bound of the range of group links (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of group links
	 */
	public java.util.List<GroupLink> findAll(
		int start, int end, OrderByComparator<GroupLink> orderByComparator);

	/**
	 * Removes all the group links from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of group links.
	 *
	 * @return the number of group links
	 */
	public int countAll();

}