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

package com.web.ecoit.portal.quangcao.service.impl;

import com.liferay.portal.aop.AopService;
import com.web.ecoit.portal.quangcao.model.QuangCao;
import com.web.ecoit.portal.quangcao.service.base.QuangCaoLocalServiceBaseImpl;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the quang cao local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.web.ecoit.portal.quangcao.service.QuangCaoLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuangCaoLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.web.ecoit.portal.quangcao.model.QuangCao",
	service = AopService.class
)
public class QuangCaoLocalServiceImpl extends QuangCaoLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.web.ecoit.portal.quangcao.service.QuangCaoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.web.ecoit.portal.quangcao.service.QuangCaoLocalServiceUtil</code>.
	 */
	public static final int QuangCaoType_Banner = 1;
	public static final int QuangCaoType_Slider = 2;
	    
	public QuangCao findBybyQuangCaoIdAndGroupIdAndType(long quangCaoId, long groupId, int type) {
		try {
			return this.quangCaoPersistence.findBybyQuangCaoIdAndGroupIdAndType(quangCaoId, groupId, type);
		} catch (Exception e) {
			return null;
		}
	}
	public QuangCao findBybyQuangCaoIdAndStatus(long quangCaoId, int status) {
		try {
			return this.quangCaoPersistence.findBybyQuangCaoIdAndStatus(quangCaoId, status);
		} catch (Exception e) {
			return null;
		}
	}
	public List<QuangCao> getQuangCaoBySql(String sql, int start, int end) {
		try {
			return quangCaoFinder.getQuangCaoBySql(sql, start, end);
		} catch (Exception e) {
			return null;
		}
	}
	public List<Object> getDuLieuTheoSql(String sql, int start, int end) {
		try {
			return quangCaoFinder.getDuLieuTheoSql(sql, start, end);
		} catch (Exception e) {
			return null;
		}
	}
	public int getCountByQuangCao(String sql) {
		return quangCaoFinder.getCountByQuangCao(sql);
	}
}