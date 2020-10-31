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

import com.ecoit.lichcongtac.services.model.LichChiTiet;

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

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for LichChiTiet. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see LichChiTietLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface LichChiTietLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LichChiTietLocalServiceUtil} to access the lich chi tiet local service. Add custom service methods to <code>com.ecoit.lichcongtac.services.service.impl.LichChiTietLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the lich chi tiet to the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichChiTiet the lich chi tiet
	 * @return the lich chi tiet that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public LichChiTiet addLichChiTiet(LichChiTiet lichChiTiet);

	/**
	 * Creates a new lich chi tiet with the primary key. Does not add the lich chi tiet to the database.
	 *
	 * @param lichChiTietId the primary key for the new lich chi tiet
	 * @return the new lich chi tiet
	 */
	@Transactional(enabled = false)
	public LichChiTiet createLichChiTiet(long lichChiTietId);

	public void createUpdateLichChiTiet(
		long lichChiTietId, long groupId, long userId, long companyId,
		String description, Date startTime, long organizationId,
		Date selectedDate, String nguoiThamDu, String nguoiChuTri,
		long lichCongTacId, String address, String note, int status,
		String language, boolean coLyDo, String lyDoTraVe);

	public void deleteByLichCongTacId(long lichCongTacId);

	/**
	 * Deletes the lich chi tiet from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichChiTiet the lich chi tiet
	 * @return the lich chi tiet that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public LichChiTiet deleteLichChiTiet(LichChiTiet lichChiTiet);

	/**
	 * Deletes the lich chi tiet with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param lichChiTietId the primary key of the lich chi tiet
	 * @return the lich chi tiet that was removed
	 * @throws PortalException if a lich chi tiet with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public LichChiTiet deleteLichChiTiet(long lichChiTietId)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.LichChiTietModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.LichChiTietModelImpl</code>.
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
	public LichChiTiet fetchLichChiTiet(long lichChiTietId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LichChiTiet> getByDateAndStatus(
		String fromDate, String toDate, long groupId, String language,
		int status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LichChiTiet> getByLichCongTacId(long lichCongTacId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the lich chi tiet with the primary key.
	 *
	 * @param lichChiTietId the primary key of the lich chi tiet
	 * @return the lich chi tiet
	 * @throws PortalException if a lich chi tiet with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public LichChiTiet getLichChiTiet(long lichChiTietId)
		throws PortalException;

	/**
	 * Returns a range of all the lich chi tiets.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.lichcongtac.services.model.impl.LichChiTietModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lich chi tiets
	 * @param end the upper bound of the range of lich chi tiets (not inclusive)
	 * @return the range of lich chi tiets
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LichChiTiet> getLichChiTiets(int start, int end);

	/**
	 * Returns the number of lich chi tiets.
	 *
	 * @return the number of lich chi tiets
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLichChiTietsCount();

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

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LichChiTiet> getPublishLichChiTiet(
		long groupId, String language, int status, int stableStatus,
		String fromDate, String toDate);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<LichChiTiet> searchLichChiTiet(
		long organizationId, long groupId, String language, int status,
		long userId, String fromDate, String toDate);

	/**
	 * Updates the lich chi tiet in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param lichChiTiet the lich chi tiet
	 * @return the lich chi tiet that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public LichChiTiet updateLichChiTiet(LichChiTiet lichChiTiet);

	public void updateStatus(
		long userId, int status, long lichChiTietId, boolean coLyDo,
		String lyDoTraVe);

}