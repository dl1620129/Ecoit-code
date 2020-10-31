package com.web.ecoit.portal.quangcao.service.persistence.impl;


import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.web.ecoit.portal.quangcao.model.QuangCao;
import com.web.ecoit.portal.quangcao.model.impl.QuangCaoImpl;
import com.web.ecoit.portal.quangcao.service.persistence.QuangCaoFinder;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
		service = QuangCaoFinder.class
	)
public class QuangCaoFinderImpl extends QuangCaoFinderBaseImpl implements QuangCaoFinder{
	public List<QuangCao> getQuangCaoBySql(String sql, int start, int end) throws SystemException{
		List<QuangCao> listQuangCao = new ArrayList<QuangCao>();
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(true);
			query.addEntity("QuangCao",QuangCaoImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			listQuangCao = (List<QuangCao>)QueryUtil.list(query, getDialect(),start, end);
		}catch(Exception e){
			throw new SystemException(e);
		}finally {
			if(session!=null)closeSession(session);
		}
		return listQuangCao;
	}
	public int getCountByQuangCao(String sql){
		Long count = 0L;
		Session session = null;
		try{
			session = openSession();
			SQLQuery q = session.createSQLQuery(sql);
			Iterator<java.math.BigInteger> itr = q.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().longValue();
			}
			
		} catch (Exception e) {
			count = 0L;
		}finally {
			if (count == null) {
				count = Long.valueOf(0);
			}
			if(session!=null)closeSession(session);
		}
		
		return count.intValue();
	}
	public List<Object> getDuLieuTheoSql(String sql,int start,int end)
	 {
		List<Object> listArt = null;
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
						
			listArt = (List<Object>) QueryUtil.list(query, getDialect(),
					start, end);
		} catch (Exception e) {
			listArt = null;
			//throw new SystemException(e);
		} finally {
			closeSession(session);
		}
		
		return listArt;
	}

}
