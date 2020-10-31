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

package com.ecoit.lichcongtac.services.service;

import com.ecoit.lichcongtac.services.model.ColumnGroupRel;
import com.ecoit.lichcongtac.services.service.persistence.ColumnGroupRelPK;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ColumnGroupRel. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ColumnGroupRelLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ColumnGroupRelLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ColumnGroupRelLocalServiceUtil} to access the column group rel local service. Add custom service methods to <code>com.ecoit.lichcongtac.services.service.impl.ColumnGroupRelLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the column group rel to the database. Also notifies the appropriate model listeners.
	 *
	 * @param columnGroupRel the column group rel
	 * @return the column group rel that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ColumnGroupRel addColumnGroupRel(ColumnGroupRel columnGroupRel);

	public boolean checkPermission(long userGroupId, int columnId);

	/**
	 * Creates a new column group rel with the primary key. Does not add the column group rel to the database.
	 *
	 * @param columnGroupRelPK the primary key for the new column group rel
	 * @return the new column group rel
	 */
	@Transactional(enabled = false)
	public ColumnGroupRel createColumnGroupRel(
		ColumnGroupRelPK columnGroupRelPK);

	public void createColumnGroupRel(long userGroupId, int columnId);

	/**
	 * Deletes the column group rel from the database. Also notifies the appropriate model listeners.
	 *
	 * @param columnGroupRel the column group rel
	 * @return the column group rel that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ColumnGroupRel deleteColumnGroupRel(ColumnGroupRel columnGroupRel);

	/**
	 * Deletes the column group rel with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param columnGroupRelPK the primary key of the column group rel
	 * @return the column group rel that was removed
	 * @throws PortalException if a column group rel with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ColumnGroupRel deleteColumnGroupRel(
			ColumnGroupRelPK columnGroupRelPK)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ColumnGroupRel fetchColumnGroupRel(
		ColumnGroupRelPK columnGroupRelPK);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ColumnGroupRel> getByGroupId(long groupId);

	/**
	 * Returns the column group rel with the primary key.
	 *
	 * @param columnGroupRelPK the primary key of the column group rel
	 * @return the column group rel
	 * @throws PortalException if a column group rel with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ColumnGroupRel getColumnGroupRel(ColumnGroupRelPK columnGroupRelPK)
		throws PortalException;

	/**
	 * Returns a range of all the column group rels.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.ColumnGroupRelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of column group rels
	 * @param end the upper bound of the range of column group rels (not inclusive)
	 * @return the range of column group rels
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ColumnGroupRel> getColumnGroupRels(int start, int end);

	/**
	 * Returns the number of column group rels.
	 *
	 * @return the number of column group rels
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getColumnGroupRelsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Updates the column group rel in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param columnGroupRel the column group rel
	 * @return the column group rel that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ColumnGroupRel updateColumnGroupRel(ColumnGroupRel columnGroupRel);

}