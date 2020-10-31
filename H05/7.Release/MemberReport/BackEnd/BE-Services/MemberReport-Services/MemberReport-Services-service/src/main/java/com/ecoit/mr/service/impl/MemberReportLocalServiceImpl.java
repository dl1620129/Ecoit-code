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

package com.ecoit.mr.service.impl;

import com.ecoit.mr.model.MemberReport;
import com.ecoit.mr.model.impl.MemberReportImpl;
import com.ecoit.mr.service.base.MemberReportLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.json.JSONArray;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the member report local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.mr.service.MemberReportLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MemberReportLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.mr.model.MemberReport",
	service = AopService.class
)
public class MemberReportLocalServiceImpl
	extends MemberReportLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.mr.service.MemberReportLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.mr.service.MemberReportLocalServiceUtil</code>.
	 */
	
	
	public MemberReport updateCreateMemberReport(long reportId, long groupId, long companyId, long userId, String language, long tong, long congTac, 
			long hocTap, long nghiPhep, long nghiOm, long nghiBu, long liDoKhac, String note, long unitId,String listCongTac,
			String listHocTap,String listNghiPhep,String listNghiOm,String listNghiBu,String listLiDoKhac) throws Exception {
		MemberReport memberReport = null;
		Date now = new Date();
		if (reportId <= 0) {
			reportId = counterLocalService.increment();
			memberReport = memberReportPersistence.create(reportId);
			memberReport.setCreateDate(now);
			memberReport.setCreatedByUser(userId);
		} else {
			memberReport = memberReportPersistence.fetchByPrimaryKey(reportId);
		}
		
		memberReport.setModifiedByUser(userId);
		memberReport.setModifiedDate(now);
		memberReport.setCompanyId(companyId);
		memberReport.setGroupId(groupId);
		memberReport.setLanguage(language);
		memberReport.setTong(tong);
		memberReport.setCongTac(congTac);
		memberReport.setHocTap(hocTap);
		memberReport.setNghiPhep(nghiPhep);
		memberReport.setNghiOm(nghiOm);
		memberReport.setNghiBu(nghiBu);
		memberReport.setLiDoKhac(liDoKhac);
		memberReport.setNote(note);
		memberReport.setUnitId(unitId);
		memberReport.setUserId(userId);
		memberReport.setListCongTac(listCongTac);
		memberReport.setListHocTap(listHocTap);
		memberReport.setListNghiPhep(listNghiPhep);
		memberReport.setListNghiBu(listNghiBu);
		memberReport.setListNghiOm(listNghiOm);
		memberReport.setListLiDoKhac(listLiDoKhac);
		memberReport = memberReportPersistence.update(memberReport);
		return memberReport;
	}
	
	public List<MemberReport> searchMemberReport(long unitId, Date modifiedDate, long groupId, long companyId, String language, int start, int limit) throws Exception {
		Session session = null;
		List<MemberReport> memberReportsList = new ArrayList<>();
		try {
			session = memberReportPersistence.openSession();
			String sql = "SELECT * FROM ecoit_mr_memberreport WHERE companyid = :companyId AND groupid = :groupId AND language = :language ";
			
			if (unitId >= 0) {
				sql += "AND unitid = :unitId ";
			}
			
			if (modifiedDate != null) {
				sql += "AND CAST(DATE(modifieddate) AS text) = :modifiedDate ";
			}
			
			sql += "ORDER BY modifieddate DESC OFFSET :start ";
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_mr_memberreport", MemberReportImpl.class);
			query.setInteger("start", start);
			query.setString("language", language);
			query.setLong("groupId", groupId);
			query.setLong("companyId", companyId);
			if (limit > 0) {
				query.setMaxResults(limit);
			}
			if (unitId >= 0) {
				query.setLong("unitId", unitId);
			}
			
			if (modifiedDate != null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				query.setString("modifiedDate", dateFormat.format(modifiedDate));
				System.out.println(dateFormat.format(modifiedDate));
			}
			System.out.println(sql);
			QueryPos.getInstance(query);
			memberReportsList = query.list();
			return memberReportsList;
		} finally {
			memberReportPersistence.closeSession(session);
			
		}
	}
	
	public int countMemberReport(long unitId, Date modifiedDate, long groupId, long companyId, String language) throws Exception {
		int count = 0;
		Session session = null;
		try {
			session = memberReportPersistence.openSession();
			String sql = "SELECT COUNT(*) FROM ecoit_mr_memberreport WHERE companyid = :companyId AND groupid = :groupId AND language = :language ";
			
			if (unitId >= 0) {
				sql += "AND unitid = :unitId ";
			}
			
			if (modifiedDate != null) {
				sql += "AND CAST(DATE(modifieddate) AS text) = :modifiedDate ";
			}
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.setString("language", language);
			query.setLong("groupId", groupId);
			query.setLong("companyId", companyId);
			if (unitId >= 0) {
				query.setLong("unitId", unitId);
			}
			
			if (modifiedDate != null) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				query.setString("modifiedDate", dateFormat.format(modifiedDate));
			}
			
			Iterator<BigInteger> itr = query.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().intValue();
			}
		} finally {
			memberReportPersistence.closeSession(session);
		}
		return count;
	}
	public int getCountMemberreportByDate(Date modifiedDate, long groupId,long userId) throws Exception {
		int count = 0;
		Session session = null;
		try {
			session = memberReportPersistence.openSession();
			String sql = "SELECT COUNT(*) FROM ecoit_mr_memberreport WHERE date(modifieddate) =  date(now()) and groupid= "+groupId+" and userid= "+userId;
			
			SQLQuery query = session.createSQLQuery(sql);
			
			System.out.println(sql);
			Iterator<BigInteger> itr = query.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().intValue();
			}
		} finally {
			memberReportPersistence.closeSession(session);
		}
		return count;
	}
	
	public List<MemberReport> getByUnitId(long unitId) {
		return memberReportPersistence.findByUnit(unitId);
	}
}