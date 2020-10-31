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
import com.ecoit.lichcongtac.services.model.LichCongTac;
import com.ecoit.lichcongtac.services.model.impl.LichCongTacImpl;
import com.ecoit.lichcongtac.services.service.LichChiTietLocalServiceUtil;
import com.ecoit.lichcongtac.services.service.base.LichCongTacLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the lich cong tac local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.ecoit.lichcongtac.services.service.LichCongTacLocalService</code>
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LichCongTacLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.ecoit.lichcongtac.services.model.LichCongTac", service = AopService.class)
public class LichCongTacLocalServiceImpl extends LichCongTacLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>com.ecoit.lichcongtac.services.service.LichCongTacLocalService</code>
	 * via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ecoit.lichcongtac.services.service.LichCongTacLocalServiceUtil</
	 * code>.
	 */

	public LichCongTac createUpdateLichCongTac(long lichCongTacId, String language, long groupId, long userId, boolean coLyDo, String lyDoTraVe,
			long companyId, long organizationId, String name, Date startDate, Date endDate, String organizations, String users, int status)
			throws Exception {
		LichCongTac lichCongTac = null;
		Date now = new Date();
		if (lichCongTacId < 1) {
			lichCongTacId = counterLocalService.increment();
			lichCongTac = lichCongTacPersistence.create(lichCongTacId);
			lichCongTac.setCreateDate(now);
			lichCongTac.setCreatedByUser(userId);
		} else {
			lichCongTac = lichCongTacPersistence.fetchByPrimaryKey(lichCongTacId);
			lichChiTietPersistence.removeByLichCongTacId(lichCongTacId);
		}

		lichCongTac.setModifiedByUser(userId);
		lichCongTac.setModifiedDate(now);
		lichCongTac.setCompanyId(companyId);
		lichCongTac.setGroupId(groupId);
		lichCongTac.setLanguage(language);
		lichCongTac.setTenLich(name);
		lichCongTac.setNgayBatDau(startDate);
		lichCongTac.setNgayKetThuc(endDate);
		lichCongTac.setLichChuyenBanNganh(organizations);
		lichCongTac.setLichChuyenNguoiDung(users);
		lichCongTac.setTrangthaiLichCongTac(status);
		lichCongTac.setOrganizationId(organizationId);
		
		if (coLyDo) {
			lichCongTac.setLydoTraVe(lyDoTraVe);
		}
		
		lichCongTacPersistence.update(lichCongTac);
		return lichCongTac;
	}

	public void updateStatus(long userId, int status, long lichCongTacId, boolean coLyDo, String lyDoTraVe) {
		LichCongTac lichCongTac = lichCongTacPersistence.fetchByPrimaryKey(lichCongTacId);
		lichCongTac.setTrangthaiLichCongTac(status);
		lichCongTac.setModifiedByUser(userId);
		lichCongTac.setModifiedDate(new Date());
		if (coLyDo) {
			lichCongTac.setLydoTraVe(lyDoTraVe);
		}
		
		List<LichChiTiet> lichChiTietList = LichChiTietLocalServiceUtil.getByLichCongTacId(lichCongTacId);
		for (LichChiTiet lichChiTiet : lichChiTietList) {
			LichChiTietLocalServiceUtil.updateStatus(userId, status, lichChiTiet.getLichChiTietId(), coLyDo, lyDoTraVe);
		}
		lichCongTacPersistence.update(lichCongTac);
	}

	public List<LichCongTac> searchLichCongTac(long organizationId, long groupId, String language, String q, int start, int limit,
			int status, long userId, String fromDate, String toDate) {
		Session session = null;
		List<LichCongTac> lichCongTacList = new ArrayList<>();
		try {
			session = lichCongTacPersistence.openSession();
			String sql = "SELECT * FROM ecoit_lich_lichcongtac WHERE groupid = :groupId AND language = :language AND lower(tenlich) LIKE lower(:searchKey) "
					+ "AND trangthailichcongtac = :status ";

			if (!fromDate.isEmpty()) {
				sql += "AND CAST(ngaybatdau AS text) >= :fromDate ";
			}
			
			if (!toDate.isEmpty()) {
				sql += "AND CAST(ngaybatdau AS text) <= :toDate ";
			}
			
			if (userId > 0) {
				sql += "AND createdbyuser = :userId ";
			}
			
			if (organizationId >= 0) {
				sql += "AND organizationid = :organizationId ";
			}
			
			sql += "ORDER BY modifieddate DESC OFFSET :start";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("ecoit_lich_lichcongtac", LichCongTacImpl.class);
			query.setString("searchKey", "%" + q + "%");
			query.setLong("groupId", groupId);
			query.setString("language", language);
			query.setInteger("status", status);
			query.setInteger("start", start);
			
			
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
			
			if (limit > 0) {
				query.setMaxResults(limit);
			}

			QueryPos.getInstance(query);
			lichCongTacList = query.list();
			return lichCongTacList;
		} finally {
			lichCongTacPersistence.closeSession(session);
		}
	}

	public int countLichCongTac(long organizationId, long groupId, String language, String q, int status, long userId, String fromDate, String toDate) {
		Session session = null;
		int count = 0;
		try {
			session = lichCongTacPersistence.openSession();
			String sql = "SELECT COUNT(*) FROM ecoit_lich_lichcongtac WHERE groupid = :groupId AND language = :language AND lower(tenlich) LIKE lower(:searchKey) "
					+ "AND trangthailichcongtac = :status ";
			
			if (!fromDate.isEmpty()) {
				sql += "AND ngaybatdau >= DATE(:fromDate) ";
			}
			
			if (!toDate.isEmpty()) {
				sql += "AND ngaybatdau <= DATE(:toDate) ";
			}
			
			if (userId > 0) {
				sql += "AND createdbyuser = :userId ";
			}
			
			if (organizationId >= 0) {
				sql += "AND organizationid = :organizationId ";
			}
			
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.setString("searchKey", "%" + q + "%");
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
			
			Iterator<BigInteger> itr = query.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().intValue();
			}
		} finally {
			lichCongTacPersistence.closeSession(session);
		}
		return count;
	}

	
	public LichCongTac getByStatusAndId(int status, long lichCongTacId) {
	    return lichCongTacPersistence.fetchBystatusAndId(status, lichCongTacId);
    }
}