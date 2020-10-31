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

package com.ecoit.mr.service;

import com.ecoit.mr.model.MemberReport;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
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
 * Provides the local service interface for MemberReport. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see MemberReportLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface MemberReportLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MemberReportLocalServiceUtil} to access the member report local service. Add custom service methods to <code>com.ecoit.mr.service.impl.MemberReportLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the member report to the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberReport the member report
	 * @return the member report that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public MemberReport addMemberReport(MemberReport memberReport);

	public int countMemberReport(
			long unitId, Date modifiedDate, long groupId, long companyId,
			String language)
		throws Exception;

	/**
	 * Creates a new member report with the primary key. Does not add the member report to the database.
	 *
	 * @param memberReportId the primary key for the new member report
	 * @return the new member report
	 */
	@Transactional(enabled = false)
	public MemberReport createMemberReport(long memberReportId);

	/**
	 * Deletes the member report with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberReportId the primary key of the member report
	 * @return the member report that was removed
	 * @throws PortalException if a member report with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public MemberReport deleteMemberReport(long memberReportId)
		throws PortalException;

	/**
	 * Deletes the member report from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberReport the member report
	 * @return the member report that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public MemberReport deleteMemberReport(MemberReport memberReport);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.MemberReportModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.MemberReportModelImpl</code>.
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
	public MemberReport fetchMemberReport(long memberReportId);

	/**
	 * Returns the member report matching the UUID and group.
	 *
	 * @param uuid the member report's UUID
	 * @param groupId the primary key of the group
	 * @return the matching member report, or <code>null</code> if a matching member report could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MemberReport fetchMemberReportByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MemberReport> getByUnitId(long unitId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the member report with the primary key.
	 *
	 * @param memberReportId the primary key of the member report
	 * @return the member report
	 * @throws PortalException if a member report with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MemberReport getMemberReport(long memberReportId)
		throws PortalException;

	/**
	 * Returns the member report matching the UUID and group.
	 *
	 * @param uuid the member report's UUID
	 * @param groupId the primary key of the group
	 * @return the matching member report
	 * @throws PortalException if a matching member report could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MemberReport getMemberReportByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the member reports.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ecoit.mr.model.impl.MemberReportModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of member reports
	 * @param end the upper bound of the range of member reports (not inclusive)
	 * @return the range of member reports
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MemberReport> getMemberReports(int start, int end);

	/**
	 * Returns all the member reports matching the UUID and company.
	 *
	 * @param uuid the UUID of the member reports
	 * @param companyId the primary key of the company
	 * @return the matching member reports, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MemberReport> getMemberReportsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of member reports matching the UUID and company.
	 *
	 * @param uuid the UUID of the member reports
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of member reports
	 * @param end the upper bound of the range of member reports (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching member reports, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MemberReport> getMemberReportsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<MemberReport> orderByComparator);

	/**
	 * Returns the number of member reports.
	 *
	 * @return the number of member reports
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMemberReportsCount();

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
	public List<MemberReport> searchMemberReport(
			long unitId, Date modifiedDate, long groupId, long companyId,
			String language, int start, int limit)
		throws Exception;

	public void updateCreateMemberReport(
			long reportId, long groupId, long companyId, long userId,
			String language, long tong, long congTac, long hocTap,
			long nghiPhep, long nghiOm, long nghiBu, long liDoKhac, String note,
			long unitId)
		throws Exception;

	/**
	 * Updates the member report in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param memberReport the member report
	 * @return the member report that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public MemberReport updateMemberReport(MemberReport memberReport);

}