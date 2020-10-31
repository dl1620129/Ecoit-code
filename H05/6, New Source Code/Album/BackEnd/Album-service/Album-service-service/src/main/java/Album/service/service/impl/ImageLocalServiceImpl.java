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

package Album.service.service.impl;

import Album.service.model.Image;
import Album.service.model.impl.ImageImpl;
import Album.service.service.ImageLocalServiceUtil;
import Album.service.service.base.ImageLocalServiceBaseImpl;


import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the image local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>Album.service.service.ImageLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ImageLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=Album.service.model.Image",
	service = AopService.class
)
public class ImageLocalServiceImpl extends ImageLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>Album.service.service.ImageLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>Album.service.service.ImageLocalServiceUtil</code>.
	 */
public List<Image> getListImage(String name, int start, int limit, long groupId){
		
		List<Image> listImage= new ArrayList<Image>();
		Session session = null;
		session = this.imagePersistence.openSession();
		try {	
			String sql = "select * from portal_album_image where groupid=" + groupId;
			if (!name.isEmpty()) {
				sql += " AND LOWER(title) LIKE LOWER('%" + name + "%') ";
			}
			sql+="ORDER BY imageid DESC  ";
			if (start >-1 && limit >0) {
				sql += " offset " + start + " limit " + limit + "";
			}
			SQLQuery query= session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("portal_album_image", ImageImpl.class);
			
			listImage = query.list();
		}finally {
			this.imagePersistence.closeSession(session);
		}
		return listImage;
	}
	public int getCountAll(String name,long groupId) throws Exception  {
		int total=-1;
		Session session= null;
		
		try {
			session= this.imagePersistence.openSession();
			String sql="select COUNT(*) from portal_album_image where groupid= "+groupId;
			if (!name.isEmpty()) {
				sql += " AND LOWER(title) LIKE LOWER('%" + name + "%') ";
			}
			SQLQuery query= session.createSQLQuery(sql);
			query.setCacheable(false);
			if(query.list().size()>0) {
				total= Integer.parseInt(query.list().get(0).toString());
			}
			return total;
		} finally {
			this.imagePersistence.closeSession(session);
		} 
	}
	public  void setIsDAiDien(Long categoryId,long groupId,Long imageId) throws Exception  {
		List<Image> listImage= new ArrayList<Image>();
		Session session = null;
		String sql="select * from portal_album_image where groupid= "+groupId;
		try {
			session= this.imagePersistence.openSession();
			if(groupId >0 && categoryId >0) {
				sql += " AND  imageid not in ("+imageId+") and isdaidien=true and categoryId = "+categoryId;
			}
			sql += " order by adddate asc,modifieddate asc";
			System.out.println(sql);
			SQLQuery query= session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("portal_album_image", ImageImpl.class);
			listImage=query.list();
			for(Image image : listImage) {
				image.setIsDaiDien(false);
				ImageLocalServiceUtil.updateImage(image);
			}
			Image image= ImageLocalServiceUtil.getImage(imageId);
			image.setIsDaiDien(true);
			
		} finally {
			this.imagePersistence.closeSession(session);
		} 
	}
	public int getCountByCategory(long categoryId,long groupId) throws Exception  {
		int total=-1;
		Session session= null;
		
		try {
			session= this.imagePersistence.openSession();
			String sql="select COUNT(*) from portal_album_image where groupid= "+groupId;
			if(categoryId >0 ) {
				sql+=" and categoryid = "+categoryId;
			}
			
			SQLQuery query= session.createSQLQuery(sql);
			query.setCacheable(false);
			if(query.list().size()>0) {
				total= Integer.parseInt(query.list().get(0).toString());
			}
			return total;
		} finally {
			this.imagePersistence.closeSession(session);
		} 
	}
	public Image findByIsDaiDienAndCateId(long cateId, boolean isDaiDien) {
		try {
			return imagePersistence.findByIsDaiDienAndCateId(cateId, isDaiDien);
		} catch (Exception e) {
			return null;
		}
	}
	public List<Image> getImageByCategory(long categoryId,long groupId,int start, int limit) throws Exception  {
		List<Image> listImage= new ArrayList<Image>();
		int total=-1;
		Session session= null;
		
		try {
			session= this.imagePersistence.openSession();
			String sql="select * from portal_album_image where groupid= "+groupId;
			if(categoryId >0 ) {
				sql+=" and categoryid = "+categoryId;
			}
			sql+=" ORDER BY imageid DESC  ";
			if (start >-1 && limit >0) {
				sql += " offset " + start + " limit " + limit + "";
			}
		
			SQLQuery query= session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("portal_album_image", ImageImpl.class);
			listImage = query.list();
			return listImage;
		} finally {
			this.imagePersistence.closeSession(session);
		} 
	}
}