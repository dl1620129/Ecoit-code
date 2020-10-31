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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MemberReportLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see MemberReportLocalService
 * @generated
 */
public class MemberReportLocalServiceWrapper
	implements MemberReportLocalService,
			   ServiceWrapper<MemberReportLocalService> {

	public MemberReportLocalServiceWrapper(
		MemberReportLocalService memberReportLocalService) {

		_memberReportLocalService = memberReportLocalService;
	}

	/**
	 * Adds the member report to the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberReport the member report
	 * @return the member report that was added
	 */
	@Override
	public com.ecoit.mr.model.MemberReport addMemberReport(
		com.ecoit.mr.model.MemberReport memberReport) {

		return _memberReportLocalService.addMemberReport(memberReport);
	}

	@Override
	public int countMemberReport(
			long unitId, java.util.Date modifiedDate, long groupId,
			long companyId, String language)
		throws Exception {

		return _memberReportLocalService.countMemberReport(
			unitId, modifiedDate, groupId, companyId, language);
	}

	/**
	 * Creates a new member report with the primary key. Does not add the member report to the database.
	 *
	 * @param memberReportId the primary key for the new member report
	 * @return the new member report
	 */
	@Override
	public com.ecoit.mr.model.MemberReport createMemberReport(
		long memberReportId) {

		return _memberReportLocalService.createMemberReport(memberReportId);
	}

	/**
	 * Deletes the member report with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberReportId the primary key of the member report
	 * @return the member report that was removed
	 * @throws PortalException if a member report with the primary key could not be found
	 */
	@Override
	public com.ecoit.mr.model.MemberReport deleteMemberReport(
			long memberReportId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _memberReportLocalService.deleteMemberReport(memberReportId);
	}

	/**
	 * Deletes the member report from the database. Also notifies the appropriate model listeners.
	 *
	 * @param memberReport the member report
	 * @return the member report that was removed
	 */
	@Override
	public com.ecoit.mr.model.MemberReport deleteMemberReport(
		com.ecoit.mr.model.MemberReport memberReport) {

		return _memberReportLocalService.deleteMemberReport(memberReport);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _memberReportLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _memberReportLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _memberReportLocalService.dynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _memberReportLocalService.dynamicQuery(dynamicQuery, start, end);
	}

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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _memberReportLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _memberReportLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _memberReportLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ecoit.mr.model.MemberReport fetchMemberReport(
		long memberReportId) {

		return _memberReportLocalService.fetchMemberReport(memberReportId);
	}

	/**
	 * Returns the member report matching the UUID and group.
	 *
	 * @param uuid the member report's UUID
	 * @param groupId the primary key of the group
	 * @return the matching member report, or <code>null</code> if a matching member report could not be found
	 */
	@Override
	public com.ecoit.mr.model.MemberReport fetchMemberReportByUuidAndGroupId(
		String uuid, long groupId) {

		return _memberReportLocalService.fetchMemberReportByUuidAndGroupId(
			uuid, groupId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _memberReportLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.ecoit.mr.model.MemberReport> getByUnitId(
		long unitId) {

		return _memberReportLocalService.getByUnitId(unitId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery
		getExportActionableDynamicQuery(
			com.liferay.exportimport.kernel.lar.PortletDataContext
				portletDataContext) {

		return _memberReportLocalService.getExportActionableDynamicQuery(
			portletDataContext);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _memberReportLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the member report with the primary key.
	 *
	 * @param memberReportId the primary key of the member report
	 * @return the member report
	 * @throws PortalException if a member report with the primary key could not be found
	 */
	@Override
	public com.ecoit.mr.model.MemberReport getMemberReport(long memberReportId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _memberReportLocalService.getMemberReport(memberReportId);
	}

	/**
	 * Returns the member report matching the UUID and group.
	 *
	 * @param uuid the member report's UUID
	 * @param groupId the primary key of the group
	 * @return the matching member report
	 * @throws PortalException if a matching member report could not be found
	 */
	@Override
	public com.ecoit.mr.model.MemberReport getMemberReportByUuidAndGroupId(
			String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _memberReportLocalService.getMemberReportByUuidAndGroupId(
			uuid, groupId);
	}

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
	@Override
	public java.util.List<com.ecoit.mr.model.MemberReport> getMemberReports(
		int start, int end) {

		return _memberReportLocalService.getMemberReports(start, end);
	}

	/**
	 * Returns all the member reports matching the UUID and company.
	 *
	 * @param uuid the UUID of the member reports
	 * @param companyId the primary key of the company
	 * @return the matching member reports, or an empty list if no matches were found
	 */
	@Override
	public java.util.List<com.ecoit.mr.model.MemberReport>
		getMemberReportsByUuidAndCompanyId(String uuid, long companyId) {

		return _memberReportLocalService.getMemberReportsByUuidAndCompanyId(
			uuid, companyId);
	}

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
	@Override
	public java.util.List<com.ecoit.mr.model.MemberReport>
		getMemberReportsByUuidAndCompanyId(
			String uuid, long companyId, int start, int end,
			com.liferay.portal.kernel.util.OrderByComparator
				<com.ecoit.mr.model.MemberReport> orderByComparator) {

		return _memberReportLocalService.getMemberReportsByUuidAndCompanyId(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the number of member reports.
	 *
	 * @return the number of member reports
	 */
	@Override
	public int getMemberReportsCount() {
		return _memberReportLocalService.getMemberReportsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _memberReportLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _memberReportLocalService.getPersistedModel(primaryKeyObj);
	}

	@Override
	public java.util.List<com.ecoit.mr.model.MemberReport> searchMemberReport(
			long unitId, java.util.Date modifiedDate, long groupId,
			long companyId, String language, int start, int limit)
		throws Exception {

		return _memberReportLocalService.searchMemberReport(
			unitId, modifiedDate, groupId, companyId, language, start, limit);
	}

	@Override
	public void updateCreateMemberReport(
			long reportId, long groupId, long companyId, long userId,
			String language, long tong, long congTac, long hocTap,
			long nghiPhep, long nghiOm, long nghiBu, long liDoKhac, String note,
			long unitId)
		throws Exception {

		_memberReportLocalService.updateCreateMemberReport(
			reportId, groupId, companyId, userId, language, tong, congTac,
			hocTap, nghiPhep, nghiOm, nghiBu, liDoKhac, note, unitId);
	}

	/**
	 * Updates the member report in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param memberReport the member report
	 * @return the member report that was updated
	 */
	@Override
	public com.ecoit.mr.model.MemberReport updateMemberReport(
		com.ecoit.mr.model.MemberReport memberReport) {

		return _memberReportLocalService.updateMemberReport(memberReport);
	}

	@Override
	public MemberReportLocalService getWrappedService() {
		return _memberReportLocalService;
	}

	@Override
	public void setWrappedService(
		MemberReportLocalService memberReportLocalService) {

		_memberReportLocalService = memberReportLocalService;
	}

	private MemberReportLocalService _memberReportLocalService;

}