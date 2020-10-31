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

import LinkManager.Service.model.Links;
import LinkManager.Service.model.impl.LinksImpl;
import LinkManager.Service.service.base.LinksLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the links local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>LinkManager.Service.service.LinksLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LinksLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=LinkManager.Service.model.Links",
	service = AopService.class
)
public class LinksLocalServiceImpl extends LinksLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>LinkManager.Service.service.LinksLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>LinkManager.Service.service.LinksLocalServiceUtil</code>.
	 */
	public List<Links> getLinkByLinkGroupId(long groupId, long linkGroupId) throws Exception{
		List<Links> listLink= new ArrayList<Links>();
		Session session= null;
		try {
			session=this.linksPersistence.openSession();
			String sql="select * from  portal_links where groupid= "+groupId+" and linksgroupid="+linkGroupId;
		
			SQLQuery query= session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("portal_links", LinksImpl.class);
			listLink= query.list();
		} finally {
			this.linksPersistence.closeSession(session);
		}
		return listLink;
	}
	public List<Links> getListLink(String name, long groupId, int start, int limit) throws Exception{
		List<Links> listLink= new ArrayList<Links>();
		Session session = null;
		try {
			session = this.linksPersistence.openSession();
//			StringBuilder sb= new StringBuilder();
//			sb.append("select * from portal_links l where 1=1 and");
//			if(groupId >=0 ) {
//				sb.append("l.groupId =: groupId ");
//			}
//			if()
			String sql = "select * from portal_links where groupid=" + groupId;
			if (!name.isEmpty()) {
				sql += " AND LOWER(name) LIKE LOWER('%" + name + "%') ";
			}
			sql+="ORDER BY linksid DESC  ";
			if (start >-1 && limit > 0) {
				sql += " offset " + start + " limit " + limit + "";
			}
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("portal_links", LinksImpl.class);
			listLink = query.list();
			
		} finally {
			this.linksPersistence.closeSession(session);
		} 
		return listLink;
	}
	public int getCountByTag(String name, long groupId) throws Exception {
		int total = -1;
		Session session = null;
		try {
			session = this.linksPersistence.openSession();
			String sql = "select count(*) from portal_links where groupid=" + groupId ;
			if (!name.isEmpty()) {
				sql += " AND LOWER(name) LIKE LOWER('%" + name + "%') ";
			}
	
		
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			if (query.list().size() > 0) {
				total = Integer.parseInt(query.list().get(0).toString());
			}
			return total;
		} finally {
			this.linksPersistence.closeSession(session);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}