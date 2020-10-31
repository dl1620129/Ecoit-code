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

package User.Rank.Poisition.Service.service.impl;

import User.Rank.Poisition.Service.model.UserChucDanh;
import User.Rank.Poisition.Service.model.UserPoisition_Dang;
import User.Rank.Poisition.Service.model.impl.UserChucDanhImpl;
import User.Rank.Poisition.Service.model.impl.UserPoisition_DangImpl;
import User.Rank.Poisition.Service.service.base.UserChucDanhLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the user chuc danh local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>User.Rank.Poisition.Service.service.UserChucDanhLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserChucDanhLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=User.Rank.Poisition.Service.model.UserChucDanh",
	service = AopService.class
)
public class UserChucDanhLocalServiceImpl
	extends UserChucDanhLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>User.Rank.Poisition.Service.service.UserChucDanhLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>User.Rank.Poisition.Service.service.UserChucDanhLocalServiceUtil</code>.
	 */
	public List<UserChucDanh> getListUserChucDanh(long groupId,String name,int start, int limit) throws Exception{
		List<UserChucDanh> listRank= new ArrayList<UserChucDanh>();
		Session session=null;
		try {
			session= this.userChucDanhPersistence.openSession();
			String sql = "select * from portal_user_userchucdanh where groupid=" + groupId;
			if (!name.isEmpty()) {
				sql += " AND LOWER(userchucdanhname) LIKE LOWER('%" + name + "%') ";
			}
			sql+="ORDER BY userchucdanhid DESC  ";
			if (start >-1 && limit >0) {
				sql += " offset " + start + " limit " + limit + "";
			}
			
			SQLQuery query= session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("portal_user_userchucdanh", UserChucDanhImpl.class);
			listRank=query.list();
		} catch (Exception e) {
			this.userChucDanhPersistence.closeSession(session);
		}
		return listRank;
	}
	public int getCountAll(String name,long groupId) throws Exception  {
		int total=-1;
		Session session= null;
		
		try {
			session= this.userChucDanhPersistence.openSession();
			String sql="select COUNT(*) from portal_user_userchucdanh where groupid= "+groupId;
			if (!name.isEmpty()) {
				sql += " AND LOWER(userchucdanhname) LIKE LOWER('%" + name + "%') ";
			}
			
			SQLQuery query= session.createSQLQuery(sql);
			query.setCacheable(false);
			if(query.list().size()>0) {
				total= Integer.parseInt(query.list().get(0).toString());
			}
			return total;
		} finally {
			this.userChucDanhPersistence.closeSession(session);
		} 
	}
}