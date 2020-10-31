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

package adv.service.impl;

import adv.model.QuangCao;
import adv.model.impl.QuangCaoImpl;
import adv.service.base.QuangCaoLocalServiceBaseImpl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the quang cao local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>adv.service.QuangCaoLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuangCaoLocalServiceBaseImpl
 */
@Component(property = "model.class.name=adv.model.QuangCao", service = AopService.class)
public class QuangCaoLocalServiceImpl extends QuangCaoLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use
	 * <code>adv.service.QuangCaoLocalService</code> via injection or a
	 * <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>adv.service.QuangCaoLocalServiceUtil</code>.
	 */

	public List<QuangCao> getAllAdv(long groupId, int start, int limit, String locale, String q) throws Exception {
		Session session = null;
		try {
			session = this.quangCaoPersistence.openSession();

			String sql = "select * from soft_adv_quangcao where groupid=" + groupId + " and language='" + locale + "'";
			if (!q.isEmpty()) {
				sql += " AND LOWER(tenquangcao) LIKE LOWER('%" + q + "%') ";
			}
			if (start >= 0 && limit > 0) {
				sql += " offset " + start + " limit " + limit;
			}

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("soft_adv_quangcao", QuangCaoImpl.class);
			if (query.list().size() > 0) {
				return (List<QuangCao>) query.list();
			} else {
				return new ArrayList<QuangCao>();
			}
		} finally {
			this.quangCaoPersistence.closeSession(session);
		}
	}

	public int countAbv(long groupId, String locale, String q) throws Exception {
		Session session = null;
		try {
			session = this.quangCaoPersistence.openSession();

			String sql = "select count(*) from soft_adv_quangcao where groupid=" + groupId + " and language='" + locale
					+ "'";

			if (!q.isEmpty()) {
				sql += " AND LOWER(tenquangcao) LIKE LOWER('%" + q + "%') ";
			}

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			if (query.list().size() > 0) {
				return Integer.parseInt(query.list().get(0).toString());
			} else {
				return 0;
			}
		} finally {
			this.quangCaoPersistence.closeSession(session);
		}
	}

}