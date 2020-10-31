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

package LinkManager.Service.service.impl;

import LinkManager.Service.model.GroupLink;
import LinkManager.Service.model.impl.GroupLinkImpl;
import LinkManager.Service.service.GroupLinkLocalService;
import LinkManager.Service.service.GroupLinkLocalServiceUtil;
import LinkManager.Service.service.base.GroupLinkLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.nio.channels.SeekableByteChannel;
import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the group link local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>LinkManager.Service.service.GroupLinkLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GroupLinkLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=LinkManager.Service.model.GroupLink",
	service = AopService.class
)
public class GroupLinkLocalServiceImpl extends GroupLinkLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>LinkManager.Service.service.GroupLinkLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>LinkManager.Service.service.GroupLinkLocalServiceUtil</code>.
	 */
	public List<GroupLink> getListGroupLink(String name, int start, int limit, long groupId){
		
		List<GroupLink> listGroup= new ArrayList<GroupLink>();
		Session session = null;
		session = this.groupLinkPersistence.openSession();
		try {
//			StringBuilder sb= new StringBuilder();
//			sb.append("select * from portal_grouplink gr where 1=1");
//			if(groupId >-1) {
//				sb.append("and gr.groupId =: groupId");
//			}
//			if( start > -1 && limit >-1) {
//				sb.append("and gr.start = :start and gr.limit = :limit");
//			}
//			if(!name.isEmpty()) {
//				sb.append("and gr.name LIKE :name");
//			}SQLQuery query= session.createSQLQuery(sb.toString());
			String sql = "select * from portal_grouplink where groupid=" + groupId;
			if (!name.isEmpty()) {
				sql += " AND LOWER(groupName) LIKE LOWER('%" + name + "%') ";
			}
			if (start >-1 && limit >0) {
				sql += " offset " + start + " limit " + limit + "";
			}
		
			SQLQuery query= session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("portal_grouplink", GroupLinkImpl.class);
			
			listGroup = query.list();
		}finally {
			this.groupLinkPersistence.closeSession(session);
		}
		return listGroup;
	}
	public int getCount(String name,long groupId)   {
		int total=-1;
		Session session= null;
		
		try {
			session= this.groupLinkPersistence.openSession();
			String sql="select COUNT(*) from portal_grouplink where groupid= "+groupId;
			SQLQuery query= session.createSQLQuery(sql);
			query.setCacheable(false);
			if(query.list().size()>0) {
				total= Integer.parseInt(query.list().get(0).toString());
			}
			return total;
		} finally {
			this.groupLinkPersistence.closeSession(session);
		} 
	}
	public int getCountAll(String name,long groupId) throws Exception  {
		int total=-1;
		Session session= null;
		
		try {
			session= this.groupLinkPersistence.openSession();
			String sql="select COUNT(*) from portal_grouplink where groupid= "+groupId;
			SQLQuery query= session.createSQLQuery(sql);
			query.setCacheable(false);
			if(query.list().size()>0) {
				total= Integer.parseInt(query.list().get(0).toString());
			}
			return total;
		} finally {
			this.groupLinkPersistence.closeSession(session);
		} 
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}