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

package com.ecoit.lichcongtac.services.service.impl;

import com.ecoit.lichcongtac.services.model.LichChiTiet;
import com.ecoit.lichcongtac.services.model.impl.LichChiTietImpl;
import com.ecoit.lichcongtac.services.service.base.LichChiTietLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the lich chi tiet local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.ecoit.lichcongtac.services.service.LichChiTietLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LichChiTietLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.ecoit.lichcongtac.services.model.LichChiTiet",
	service = AopService.class
)
public class LichChiTietLocalServiceImpl
	extends LichChiTietLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ecoit.lichcongtac.services.service.LichChiTietLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ecoit.lichcongtac.services.service.LichChiTietLocalServiceUtil</code>.
	 */
	public List<LichChiTiet> searchLichChiTiet(long organizationId, long groupId, String language,
			int status, long userId, String fromDate, String toDate) {
		Session session = null;
		List<LichChiTiet> lichChiTietList = new ArrayList<>();
		try {
			session = lichChiTietPersistence.openSession();
			String sql = "SELECT * FROM ecoit_lich_lichchitiet WHERE groupid = :groupId AND language = :language "
					+ "AND trangthaichitiet = :status ";

			if (!fromDate.isEmpty()) {
				sql += "AND selecteddate >= DATE(:fromDate) ";
			}
			
			if (!toDate.isEmpty()) {
				sql += "AND selecteddate <= DATE(:toDate) ";
			}
			
			if (userId > 0) {
				sql += "AND createdbyuser = :userId ";
			}
			
			if (organizationId >= 0) {
				sql += "AND organizationid = :organizationId ";
			}
			
			sql += "ORDER BY selecteddate, CAST(giobatdau AS time) ASC ";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_lich_lichchitiet", LichChiTietImpl.class);
			//query.setString("searchKey", "%" + q + "%");
			query.setLong("groupId", groupId);
			query.setString("language", language);
			query.setInteger("status", status);
			
			
			if (!fromDate.isEmpty()) {
				query.setString("fromDate", fromDate);
			}
			
			if (!toDate.isEmpty()) {
				query.setString("toDate", toDate);
			}
			
			if (userId > 0) {
				query.setLong("userId", userId);
			}
			
			if (organizationId >= 0) {
				query.setLong("organizationId", organizationId);
			}

			QueryPos.getInstance(query);
			lichChiTietList = query.list();
			return lichChiTietList;
		} finally {
			lichChiTietPersistence.closeSession(session);
		}
	}
	
	public void createUpdateLichChiTiet(long lichChiTietId, long groupId, long userId, long companyId, String description, Date startTime, long organizationId,
			Date selectedDate, String nguoiThamDu, String nguoiChuTri, long lichCongTacId, String address, String note, int status, String language, boolean coLyDo,
			String lyDoTraVe) {
		LichChiTiet lichChiTiet = null;
		Date now = new Date();
		
		try {
			lichChiTiet = lichChiTietPersistence.findByPrimaryKey(lichChiTietId);
		} catch (Exception e) {
			lichChiTiet = null;
		}
		
		if (lichChiTiet ==  null) {
			lichChiTietId = counterLocalService.increment();
			lichChiTiet = lichChiTietPersistence.create(lichChiTietId);
			lichChiTiet.setCreateDate(now);
			lichChiTiet.setCreatedByUser(userId);
			lichChiTiet.setOrganizationId(organizationId);
			lichChiTiet.setLichCongTacId(lichCongTacId);
		}
		
		lichChiTiet.setModifiedDate(now);
		lichChiTiet.setModifiedByUser(userId);
		lichChiTiet.setCompanyId(companyId);
		lichChiTiet.setGroupId(groupId);
		lichChiTiet.setGioBatDau(startTime);
		lichChiTiet.setSelectedDate(selectedDate);
		lichChiTiet.setMoTa(description);
		lichChiTiet.setNguoiThamDu(nguoiThamDu);
		lichChiTiet.setNguoiChuTri(nguoiChuTri);
		lichChiTiet.setAddress(address);
		lichChiTiet.setNote(note);
		lichChiTiet.setTrangthaiChiTiet(status);
		lichChiTiet.setLanguage(language);
		if (coLyDo) {
			lichChiTiet.setLydoTraVe(lyDoTraVe);
		}
		lichChiTietPersistence.update(lichChiTiet);
	}
	
	public void updateStatus(long userId, int status, long lichChiTietId, boolean coLyDo, String lyDoTraVe) {
		LichChiTiet lichChiTiet = lichChiTietPersistence.fetchByPrimaryKey(lichChiTietId);
		lichChiTiet.setTrangthaiChiTiet(status);
		lichChiTiet.setModifiedDate(new Date());
		lichChiTiet.setModifiedByUser(userId);
		if (coLyDo) {
			lichChiTiet.setLydoTraVe(lyDoTraVe);
		}
		lichChiTietPersistence.update(lichChiTiet);
		//lichChiTiet.se;
	}
	
	public List<LichChiTiet> getByLichCongTacId(long lichCongTacId) {
		Session session = null;
		List<LichChiTiet> lichChiTietList = new ArrayList<>();
		try {
			session = lichChiTietPersistence.openSession();
			String sql = "SELECT * FROM ecoit_lich_lichchitiet WHERE lichcongtacid = :lichCongTacId ORDER BY selectedDate ASC, CAST(giobatdau AS time) ASC";
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_lich_lichchitiet", LichChiTietImpl.class);
			query.setLong("lichCongTacId", lichCongTacId);
		
			QueryPos.getInstance(query);
			lichChiTietList = query.list();
			return lichChiTietList;
		} finally {
			lichChiTietPersistence.closeSession(session);
		}
	}
	
	public void deleteByLichCongTacId(long lichCongTacId) {
		lichChiTietPersistence.removeByLichCongTacId(lichCongTacId);
	}
	
	public List<LichChiTiet> getPublishLichChiTiet(long groupId, String language, int status, int stableStatus, String fromDate, String toDate) {
		Session session = null;
		List<LichChiTiet> lichChiTietList = new ArrayList<>();
		try {
			session = lichChiTietPersistence.openSession();
			String sql = "SELECT * FROM ecoit_lich_lichchitiet WHERE groupid = :groupId AND language = :language "
					+ "AND (trangthaichitiet = :status OR trangthaichitiet = :stableStatus) ";

			if (!fromDate.isEmpty()) {
				sql += "AND selecteddate >= DATE(:fromDate) ";
			}
			
			if (!toDate.isEmpty()) {
				sql += "AND selecteddate <= DATE(:toDate) ";
			}
			
			sql += "ORDER BY selecteddate, CAST(giobatdau AS time) ASC ";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_lich_lichchitiet", LichChiTietImpl.class);
			//query.setString("searchKey", "%" + q + "%");
			query.setLong("groupId", groupId);
			query.setString("language", language);
			query.setInteger("status", status);
			query.setInteger("stableStatus", stableStatus);
			
			if (!fromDate.isEmpty()) {
				query.setString("fromDate", fromDate);
			}
			
			if (!toDate.isEmpty()) {
				query.setString("toDate", toDate);
			}

			QueryPos.getInstance(query);
			lichChiTietList = query.list();
			return lichChiTietList;
		} finally {
			lichChiTietPersistence.closeSession(session);
		}
	}
	
	//fromDate string must be formatted as yyyy-MM-dd
	//toDate string must be formatted as yyyy-MM-dd
	public List<LichChiTiet> getByDateAndStatus(String fromDate, String toDate, long groupId, String language, int status) {
		Session session = null;
		List<LichChiTiet> lichChiTietList = new ArrayList<>();
		try {
			session = lichChiTietPersistence.openSession();
			String sql = "SELECT ct.lichchitietid AS lichchitietid, ct.groupid AS groupid, ct.companyid AS companyid, ct.userid AS userid, ct.username AS username, "
					+ "ct.createdate AS createdate, ct.modifieddate AS modifieddate, ct.giobatdau AS giobatdau, ct.mota AS mota, ct.nguoithamdu AS nguoithamdu, ct.nguoichutri AS nguoichutri, "
					+ "ct.selecteddate AS selecteddate, ct.trangthaichitiet AS trangthaichitiet, ct.lichcongtacid AS lichcongtacid, ct.address AS address, ct.note AS note, "
					+ "ct.lydotrave AS lydotrave, ct.organizationid AS organizationid, ct.createdbyuser AS createdbyuser, ct.modifiedbyuser AS modifiedbyuser "
					+ "FROM ecoit_lich_lichchitiet ct INNER JOIN ecoit_lich_lichcongtac cn ON ct.lichcongtacid = cn.lichcongtacid "
					+ "WHERE cn.trangthailichcongtac = :status AND cn.groupid = :groupId "
					+ "AND ct.selecteddate <= DATE(:toDate) AND ct.selecteddate >= DATE(:fromDate) AND cn.language = :language ORDER BY CAST(ct.giobatdau AS time) ASC";
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_lich_lichchitiet", LichChiTietImpl.class);
			query.setLong("groupId", groupId);
			query.setInteger("status", status);
			query.setString("toDate", toDate);
			query.setString("fromDate", fromDate);
			query.setString("language", language);
			
			QueryPos.getInstance(query);
			lichChiTietList = query.list();
			return lichChiTietList;
		} finally {
			lichChiTietPersistence.closeSession(session);
		}
	}
}