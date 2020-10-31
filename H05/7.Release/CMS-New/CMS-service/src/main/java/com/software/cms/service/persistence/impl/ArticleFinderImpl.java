package com.software.cms.service.persistence.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.software.cms.model.Article;
import com.software.cms.model.impl.ArticleImpl;
import com.software.cms.service.persistence.ArticleFinder;
import com.software.util.NewsWorkflowConstants;
import com.software.util.PermissionUtil;
import com.software.util.RoleConstants;


@Component(
		service = ArticleFinder.class
	)
public class ArticleFinderImpl extends ArticleFinderBaseImpl implements ArticleFinder{
	public List<Article> getArticleBySql(String sql, int start, int end) throws SystemException{
		List<Article> listArticle = new ArrayList<Article>();
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(true);
			query.addEntity("Article",ArticleImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			listArticle = (List<Article>)QueryUtil.list(query, getDialect(),start, end);
		}catch(Exception e){
			throw new SystemException(e);
		}finally {
			if(session!=null)closeSession(session);
		}
		return listArticle;
	}
	public int getCountByArticle(String sql){
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
	public List<Article> findByUserNews(long groupId, String language,
			long userId, long status, long categoryId, String eventName,
			String tagName, String keyword, boolean inTitle, boolean inSummary,
			boolean inContent, boolean inDate, Date fromDate, Date toDate,boolean inAuthor,boolean userKiemDuyet,
			int start, int end) {
		List<Article> result = new ArrayList<Article>();
		Session session = null;
		StringBuffer sql = new StringBuffer();
		String sqlOr = "";
		try {
			// create query statement
			sql.append("SELECT DISTINCT soft_cms_article.* FROM soft_cms_article ");
			if (categoryId > 0) {
				sql.append(" LEFT JOIN soft_cms_categoryarticle ON soft_cms_article.articleid = soft_cms_categoryarticle.articleid ");
			}
			if(userKiemDuyet){
				sql.append(" LEFT JOIN user_ ON soft_cms_article.publishedbyuser=user_.userid ");
			}
			sql.append(" WHERE soft_cms_article.groupid = ? " //+ groupId
					+ " AND soft_cms_article.language = ? " //+ language + "'"
					+ " AND soft_cms_article.status = ? "); //+ status);
			if (categoryId > 0)
				sql.append(" AND soft_cms_categoryarticle.categoryid = ? ");
						//+ categoryId);
			if(userKiemDuyet){
				sql.append(" AND (LOWER( user_.firstname || ' ' ||user_.middlename || ' ' || user_.lastname ) LIKE LOWER(?) OR LOWER( user_.firstname || ' ' || user_.lastname ) LIKE LOWER(?)) ");
			}
			if(!keyword.equals("")) {
				if(checkKeywordIsNumber(keyword)){
					sql.append(" AND soft_cms_article.articleId = "+keyword);
				}else {
					sql.append(" AND (LOWER(soft_cms_article.title) LIKE LOWER('%"+keyword+"%') OR LOWER(soft_cms_article.summary) LIKE LOWER('%"+keyword+"%'))");
				}
			}
			
			if (!eventName.equals("") )
				sql.append(" AND lower(soft_cms_article.events) like lower(?) "); 
			if (!tagName.equals(""))
				sql.append(" AND lower(soft_cms_article.tags) like lower(?) "); 
			if (inTitle)
				sql.append(" AND LOWER(soft_cms_article.title) LIKE LOWER(?)");
			if (inSummary)
				sql.append(" AND LOWER(soft_cms_article.summary) LIKE LOWER(?)");
			if (inContent)
				sql.append(" AND LOWER(soft_cms_article.content) LIKE LOWER(?)");
			if (inAuthor)
				sql.append(" AND LOWER(soft_cms_article.author) LIKE LOWER(?)");
			if (inDate){
				String datefrom = "";
				String dateTo ="";
				if(status == NewsWorkflowConstants.STATUS_APPROVED){
					if(fromDate != null){
					     datefrom=new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					     sql.append(" AND soft_cms_article.approveddate >= '"+ datefrom + "'");
					    }
				    if(toDate != null){
				        dateTo=new SimpleDateFormat("yyyy-MM-dd").format(toDate);
				        sql.append("  AND date(soft_cms_article.approveddate) <= '" + dateTo + "' ");
				    }
				}else if(status == NewsWorkflowConstants.STATUS_PUBLISH){
					if(fromDate != null){
					     datefrom=new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					     sql.append(" AND soft_cms_article.publisheddatefrom >= '"+ datefrom + "'");
					    }
				    if(toDate != null){
				        dateTo=new SimpleDateFormat("yyyy-MM-dd").format(toDate);
				        sql.append("  AND date(soft_cms_article.publisheddatefrom) <= '" + dateTo + "' ");
				    }
				}else{
					if(fromDate != null){
					     datefrom=new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					     sql.append(" AND soft_cms_article.createddate >= '"+ datefrom + "'");
					    }
				    if(toDate != null){
				        dateTo=new SimpleDateFormat("yyyy-MM-dd").format(toDate);
				        sql.append("  AND date(soft_cms_article.createddate) <= '" + dateTo + "' ");
				    }
				}
				
			}
				
			if (status == NewsWorkflowConstants.STATUS_DRAFT) {
				sql.append(" AND soft_cms_article.createdbyuser = ? ");
			} else {
				if (status == NewsWorkflowConstants.STATUS_PENDING) {
					if ((PermissionUtil.checkPermissionAccessZone(userId,
							RoleConstants.ARTICLE_PENDING, groupId)) &&(!PermissionUtil.checkPermissionAccessZone(userId,
						RoleConstants.VIEW_ARTICLE, groupId))) {
						if(sqlOr.equals("")){
							sqlOr = " AND soft_cms_article.pendingByUser = "+userId;
						}else{
							sqlOr += " OR soft_cms_article.pendingByUser = "+userId;
						}
					}
				}
				if (!PermissionUtil.checkPermissionAccessZone(userId,
						RoleConstants.VIEW_ARTICLE, groupId)) {
					if(sqlOr.equals("")){
						sqlOr = " AND soft_cms_article.createdbyuser = ? ";
					}else{
						sqlOr += " OR soft_cms_article.createdbyuser = ? ";
					}
				}
			}
			if(!sqlOr.equals("")) sql.append("("+sqlOr+")");
			if(status == NewsWorkflowConstants.STATUS_DRAFT){
				sql.append(" ORDER BY soft_cms_article.createddate DESC");
			}
			if(status == NewsWorkflowConstants.STATUS_PUBLISH){
				sql.append(" ORDER BY soft_cms_article.publisheddatefrom DESC");
			}
			if(status == NewsWorkflowConstants.STATUS_APPROVED){
				sql.append(" ORDER BY soft_cms_article.approveddate DESC");	
			}
			if(status == NewsWorkflowConstants.STATUS_PENDING || status == NewsWorkflowConstants.STATUS_PUBLISH_DENIED || status == NewsWorkflowConstants.STATUS_APPROVE_DENIED  ){
				sql.append(" ORDER BY soft_cms_article.modifieddate DESC");
			}
			
			session = openSession();
			SQLQuery query = session.createSQLQuery(sql.toString());
			query.setCacheable(false);
			query.addEntity("Article", ArticleImpl.class);
			
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(groupId);
			qPos.add(language);
			qPos.add(status);
			if (categoryId > 0) qPos.add(categoryId);
			if (!eventName.equals("")) qPos.add("%"+eventName+"%");
			if (!tagName.equals("") ) qPos.add("%"+tagName+"%");
			
			String kw = "%"+keyword+"%";
			if(userKiemDuyet){
				qPos.add(kw);qPos.add(kw);
			}
			if (inTitle) qPos.add(kw);
			if (inSummary) qPos.add(kw);
			if (inContent) qPos.add(kw);
			if (inAuthor) qPos.add(kw);
			if (status == NewsWorkflowConstants.STATUS_DRAFT) {
				qPos.add(userId);
			} else {
				if (!PermissionUtil.checkPermissionAccessZone(userId,
						RoleConstants.VIEW_ARTICLE, groupId)) {
					qPos.add(userId);
				}
			}
			result = (List<Article>) QueryUtil.list(query, getDialect(), start,
					end);
			

		} catch (Exception e) {
		    e.printStackTrace();
			
		} finally {		
			closeSession(session);
		}

		return result;
	}
	public int getCountByUserNews(long groupId, String language,
			long userId, long status, long categoryId, String eventName,
			String tagName, String keyword, boolean inTitle, boolean inSummary,
			boolean inContent, boolean inDate, Date fromDate, Date toDate,boolean inAuthor,boolean userKiemDuyet) {
		Long count=0L;
		Session session = null;
		StringBuffer sql = new StringBuffer();
		StringBuffer sqlLikeOr = new StringBuffer();
		String sqlOr = "";
		try {
			// create query statement
			sql.append("SELECT count(DISTINCT soft_cms_article.*) FROM soft_cms_article ");
			if (categoryId > 0) {
				sql.append(" LEFT JOIN soft_cms_categoryarticle ON soft_cms_article.articleid = soft_cms_categoryarticle.articleid ");
			}
			if(userKiemDuyet){
				sql.append(" LEFT JOIN user_ ON soft_cms_article.publishedbyuser=user_.userid ");
			}
			sql.append(" WHERE soft_cms_article.groupid = ? " //+ groupId
					+ " AND soft_cms_article.language = ? " //+ language + "'"
					+ " AND soft_cms_article.status = ? "); //+ status);
			if (categoryId > 0)
				sql.append(" AND soft_cms_categoryarticle.categoryid = ? ");
						//+ categoryId);
			if(userKiemDuyet){
				sql.append(" AND (LOWER( user_.firstname || ' ' ||user_.middlename || ' ' || user_.lastname ) LIKE LOWER(?) OR LOWER( user_.firstname || ' ' || user_.lastname ) LIKE LOWER(?)) ");
			}
			if(!keyword.equals("")) {
				if(checkKeywordIsNumber(keyword)){
					sql.append(" AND soft_cms_article.articleId = "+keyword);
				}else {
					sql.append(" AND (LOWER(soft_cms_article.title) LIKE LOWER('%"+keyword+"%') OR LOWER(soft_cms_article.summary) LIKE LOWER('%"+keyword+"%'))");
				}
			}
			if (!eventName.equals(""))
				sql.append(" AND lower(soft_cms_article.events) like lower(?) "); // + eventId);
			if (!tagName.equals(""))
				sql.append(" AND lower(soft_cms_article.tags) like lower(?) "); // + tagsId);
			
			if (inTitle)
				sql.append(" AND LOWER(soft_cms_article.title) LIKE LOWER(?)");
						//+ "'%"+ keyword + "%') ");
			if (inSummary)
				sql.append(" AND LOWER(soft_cms_article.summary) LIKE LOWER(?)");
						//+ "'%" + keyword + "%') ");
			if (inContent)
				sql.append(" AND LOWER(soft_cms_article.content) LIKE LOWER(?)");
						//+ "'%"+ keyword + "%') ");
			if (inAuthor)
				sql.append(" AND LOWER(soft_cms_article.author) LIKE LOWER(?)");
			if (inDate){
				String datefrom = "";
				String dateTo ="";
				if(status == NewsWorkflowConstants.STATUS_APPROVED){
					if(fromDate != null){
					     datefrom=new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					     sql.append(" AND soft_cms_article.approveddate >= '"+ datefrom + "'");
					    }
				    if(toDate != null){
				        dateTo=new SimpleDateFormat("yyyy-MM-dd").format(toDate);
				        sql.append("  AND date(soft_cms_article.approveddate) <= '" + dateTo + "' ");
				    }
				}else if(status == NewsWorkflowConstants.STATUS_PUBLISH){
					if(fromDate != null){
					     datefrom=new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					     sql.append(" AND soft_cms_article.publisheddatefrom >= '"+ datefrom + "'");
					    }
				    if(toDate != null){
				        dateTo=new SimpleDateFormat("yyyy-MM-dd").format(toDate);
				        sql.append("  AND date(soft_cms_article.publisheddatefrom) <= '" + dateTo + "' ");
				    }
				}else{
					if(fromDate != null){
					     datefrom=new SimpleDateFormat("yyyy-MM-dd").format(fromDate);
					     sql.append(" AND soft_cms_article.createddate >= '"+ datefrom + "'");
					    }
				    if(toDate != null){
				        dateTo=new SimpleDateFormat("yyyy-MM-dd").format(toDate);
				        sql.append("  AND date(soft_cms_article.createddate) <= '" + dateTo + "' ");
				    }
				}
				
			}
				
			if (status == NewsWorkflowConstants.STATUS_DRAFT) {
				sql.append(" AND soft_cms_article.createdbyuser = ? "); 
			}else {
				if (status == NewsWorkflowConstants.STATUS_PENDING) {
					if ((PermissionUtil.checkPermissionAccessZone(userId,
							RoleConstants.ARTICLE_PENDING, groupId)) &&(!PermissionUtil.checkPermissionAccessZone(userId,
						RoleConstants.VIEW_ARTICLE, groupId))) {
						if(sqlOr.equals("")){
							sqlOr = " AND soft_cms_article.pendingByUser = "+userId;
						}else{
							sqlOr += " OR soft_cms_article.pendingByUser = "+userId;
						}
					}
				}
				if (!PermissionUtil.checkPermissionAccessZone(userId,
						RoleConstants.VIEW_ARTICLE, groupId)) {
					if(sqlOr.equals("")){
						sqlOr = " AND soft_cms_article.createdbyuser = ? ";
					}else{
						sqlOr += " OR soft_cms_article.createdbyuser = ? ";
					}
				}
			}
			if(!sqlOr.equals("")) sql.append(sqlOr);
			
			session = openSession();
			SQLQuery query = session.createSQLQuery(sql.toString());
						
			QueryPos qPos = QueryPos.getInstance(query);
			qPos.add(groupId);
			qPos.add(language);
			qPos.add(status);
			if (categoryId > 0) qPos.add(categoryId);
			if (!eventName.equals("")) qPos.add("%"+eventName+"%");
			if (!tagName.equals("") ) qPos.add("%"+tagName+"%");
			
			String kw = "%"+keyword+"%";
			if(userKiemDuyet){
				qPos.add(kw);qPos.add(kw);
			}
			if (inTitle) qPos.add(kw);
			if (inSummary) qPos.add(kw);
			if (inContent) qPos.add(kw);
			if (inAuthor) qPos.add(kw);
			
			if (status == NewsWorkflowConstants.STATUS_DRAFT) {
				qPos.add(userId);
			} else {
				if (!PermissionUtil.checkPermissionAccessZone(userId,
						RoleConstants.VIEW_ARTICLE, groupId)) {
					qPos.add(userId);
				}
			}
			
			Iterator<java.math.BigInteger> itr = query.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().longValue();
			}

		} catch (Exception e) {
		    e.printStackTrace();
			count=0L;
		} finally {		
			closeSession(session);
		}

		return count.intValue();
	}
	public int getCountArticleByCaterory(long groupId, Long categoryId, Date publishDateFrom)
			throws SystemException {

		Long count = 0L;
		Session session = null;
		String sql = "SELECT COUNT(DISTINCT soft_cms_article.articleid) FROM soft_cms_article "
				+ " INNER JOIN soft_cms_categoryarticle "
				+ " ON soft_cms_article.articleid = soft_cms_categoryarticle.articleid "
				+ " WHERE soft_cms_categoryarticle.categoryid = ?"
				+ " and soft_cms_article.groupid = ? " //+ groupId
				+ " AND soft_cms_article.status= "
				+ NewsWorkflowConstants.STATUS_PUBLISH;
		if (publishDateFrom != null) {
			Calendar c = Calendar.getInstance();
			c.setTime(publishDateFrom);
			c.add(Calendar.DATE, 1);
			publishDateFrom = c.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sql += " AND soft_cms_article.publisheddatefrom <= '"
					+ sdf.format(publishDateFrom) + "' ";
		}
		try {
			session = openSession();
			SQLQuery q = session.createSQLQuery(sql);
			QueryPos qPos = QueryPos.getInstance(q);
			qPos.add(categoryId);
			qPos.add(groupId);

			Iterator<java.math.BigInteger> itr = q.list().iterator();
			if (itr.hasNext()) {
				count = itr.next().longValue();
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new SystemException(e);
		} finally {
			if (count == null) {
				count = Long.valueOf(0);
			}


			closeSession(session);
		}

		return count.intValue();
	}

	@SuppressWarnings("unchecked")
	public List<Article> getListArticleByCaterory(long groupId, Long categoryId,
			Date publishDateFrom, Integer start, Integer end)
			throws SystemException {
		List<Article> listArt = new ArrayList<Article>();
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT DISTINCT soft_cms_article.* FROM soft_cms_article INNER JOIN soft_cms_categoryarticle "
					+ "ON soft_cms_article.articleid=soft_cms_categoryarticle.articleid "
					+ "WHERE soft_cms_categoryarticle.categoryid = ? "
					+ " and soft_cms_article.groupid = ? " //+ groupId
					+ " AND soft_cms_article.status= "
					+ NewsWorkflowConstants.STATUS_PUBLISH;
			if (publishDateFrom != null) {
				Calendar c = Calendar.getInstance();
				c.setTime(publishDateFrom);
				c.add(Calendar.DATE, 1);
				publishDateFrom = c.getTime();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				sql += " AND soft_cms_article.publisheddatefrom <= '"
						+ sdf.format(publishDateFrom) + "' ";
			}

			sql += " ORDER BY publisheddatefrom DESC";

			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(true);
			query.addEntity("Article", ArticleImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			// qPos.add(true);
			qPos.add(categoryId);
			qPos.add(groupId);
			// if (publishDateFrom != null) {
			// qPos.add(CalendarUtil.getTimestamp(publishDateFrom));
			// }

			listArt = (List<Article>) QueryUtil.list(query, getDialect(),
					start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

		return listArt;
	}
	public List<Article> getListArticleByEvent(long groupId, long articleId, long categoryId,
			String eventId, Integer start, Integer end) throws SystemException {
		List<Article> listArt = new ArrayList<Article>();
		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT DISTINCT soft_cms_article.* FROM soft_cms_article inner join soft_cms_categoryarticle "
					+ " ON soft_cms_article.articleid= soft_cms_categoryarticle.articleid "
					+ " WHERE soft_cms_categoryarticle.categoryid = ?"
					+ " and soft_cms_article.groupid = ? "; //+ groupId
					if(!eventId.equals("")){
						sql += " and soft_cms_article.eventid like ('%"+eventId+"%')";
					}
					sql += " AND soft_cms_categoryarticle.articleid != "
					+ articleId
					+ " AND soft_cms_article.status= "
					+ NewsWorkflowConstants.STATUS_PUBLISH
					+ " ORDER BY publisheddatefrom DESC";
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(true);
			query.addEntity("Article", ArticleImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
			// qPos.add(true);
			qPos.add(categoryId);
			qPos.add(groupId);
			listArt = (List<Article>) QueryUtil.list(query, getDialect(),
					start, end);
		} catch (Exception e) {
			throw new SystemException(e);
		} finally {
			closeSession(session);
		}

		return listArt;
	}
	private boolean checkKeywordIsNumber(String keyword){
		boolean check = false;
		try{
			Long.valueOf(keyword);
			check = true;
		}catch(NumberFormatException e){
			check = false;
		}
		return check;
	}
}
