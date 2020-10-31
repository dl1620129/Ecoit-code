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

package ChungThuSo.Service.service.impl;

import ChungThuSo.Service.model.Kyso;
import ChungThuSo.Service.service.base.KysoLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the kyso local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>ChungThuSo.Service.service.KysoLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see KysoLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=ChungThuSo.Service.model.Kyso",
	service = AopService.class
)
public class KysoLocalServiceImpl extends KysoLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>ChungThuSo.Service.service.KysoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ChungThuSo.Service.service.KysoLocalServiceUtil</code>.
	 */
	public int getCountSerialNumber(long groupId,String serialNumber) throws Exception{
		int total=-1;
		Session session= null;
		
		try {
			session= this.kysoPersistence.openSession();
			String sql="select COUNT(*) from cts_portal_kyso where groupid= "+groupId;
			if (!serialNumber.isEmpty()) {
				sql += " AND LOWER(serialNumber) LIKE LOWER('%" + serialNumber + "%') ";
			}
			SQLQuery query= session.createSQLQuery(sql);
			query.setCacheable(false);
			if(query.list().size()>0) {
				total= Integer.parseInt(query.list().get(0).toString());
			}
			return total;
		} finally {
			this.kysoPersistence.closeSession(session);
		} 
	}
	public Kyso findBygetByScreenName (String sn) {
		try {
			return kysoPersistence.findBygetByScreenName(sn);
		} catch (Exception e) {
			return null;
		}
	}
	public Kyso findBygetBySerialNumber (String serialNumber) {
		try {
			return kysoPersistence.findBygetBySerialNumber(serialNumber);
		} catch (Exception e) {
			return null;
		}
	}
}