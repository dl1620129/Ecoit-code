package com.software.cms.article.portlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.article.constants.ArticleActionPortletKeys;
import com.software.cms.model.Article;
import com.software.cms.model.ArticleHistory;
import com.software.cms.model.ArticleMessage;
import com.software.cms.model.Comment;
import com.software.cms.model.Event;
import com.software.cms.model.Logger;
import com.software.cms.model.Tag;
import com.software.cms.service.ArticleHistoryLocalServiceUtil;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.cms.service.ArticleMessageLocalServiceUtil;
import com.software.cms.service.CategoryArticleLocalServiceUtil;
import com.software.cms.service.CommentLocalServiceUtil;
import com.software.cms.service.EventLocalServiceUtil;
import com.software.cms.service.LoggerLocalServiceUtil;
import com.software.cms.service.TagLocalServiceUtil;
import com.software.util.AttachmentUtil;
import com.software.util.NewsWorkflowConstants;
import com.software.util.PermissionUtil;
import com.software.util.RoleConstants;

/**
 * @author dorem
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Manager CMS",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ArticleAction",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/article/view.jsp",
		"javax.portlet.name=" + ArticleActionPortletKeys.ARTICLEACTION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ArticleActionPortlet extends MVCPortlet {

	
	public void editArticle(ActionRequest actionRequest, ActionResponse actionResponse) {
		Article articleTml = ArticleLocalServiceUtil.create();
		ArrayList<Long> listCates = new ArrayList<Long>();
		ArrayList<Tag> listTags = new ArrayList<Tag>();
		ArrayList<Event> listEvents = new ArrayList<Event>();
		ArrayList<String> lstSubSite = new ArrayList<String>();
		String validFalse,backUrlTml,imageIds,checkErrorArt;
		boolean error = false;
		validFalse = "false";
		UploadPortletRequest upload = PortalUtil.getUploadPortletRequest(actionRequest);
		ThemeDisplay themeDisplay = (ThemeDisplay) upload.getAttribute(WebKeys.THEME_DISPLAY);
		String currentURL = ParamUtil.getString(actionRequest, "currentURL", "");
		String backURL = ParamUtil.get(upload, "backURL", "/");
		long action = ParamUtil.getLong(upload, "cmdAction", -1);
		long articleId = ParamUtil.getLong(upload, "articleId", -1);
		String title = HtmlUtil.escape(ParamUtil.getString(actionRequest, "title", ""));
		String summary = HtmlUtil.escape(ParamUtil.getString(actionRequest, "summary", ""));
		String content = ParamUtil.getString(actionRequest, "content", "");
		String imagesDescription = HtmlUtil.escape(ParamUtil.getString(actionRequest, "images-description", ""));
		String author = HtmlUtil.escape(ParamUtil.getString(actionRequest, "author", ""));
		String source = HtmlUtil.escape(ParamUtil.getString(actionRequest, "source", ""));
		System.out.println("action: "+action);
		try {
			Article article = ArticleLocalServiceUtil.createArticle(0);
			String cmd = "add";
			if (articleId <= 0) {
				Article artTmp=null;
				long artId=CounterLocalServiceUtil.increment(Article.class.getName());
				try{
					artTmp=ArticleLocalServiceUtil.getArticle(artId);
				}catch(Exception ex){artTmp=null;}
				if(artTmp!=null)article.setArticleId(ArticleLocalServiceUtil.getMaxId("select max(articleid) from soft_cms_article")+1);
				else article.setArticleId(artId);
				article.setStatus(NewsWorkflowConstants.STATUS_NOT_CREATE);
				article = ArticleLocalServiceUtil.addArticle(article);
				SessionMessages.add(actionRequest, "ADD_ARTICLE_OK");
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			} else {
				cmd = "edit";
				article = ArticleLocalServiceUtil.getArticle(ParamUtil.getLong(upload, "articleId", 0));
				actionRequest.setAttribute("articleId", article.getArticleId());
				SessionMessages.add(actionRequest, "EDIT_ARTICLE_OK");
				SessionMessages.add(actionRequest, PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			}
			long chonNguoiKiemDuyet = ParamUtil.getLong(actionRequest, "chonNguoiKiemDuyet", -1);
			if(chonNguoiKiemDuyet == -1){
				article.setPendingByUser(themeDisplay.getUserId());
			}else{
				article.setPendingByUser(chonNguoiKiemDuyet);
			} 
			long marks = ParamUtil.getLong(upload, "marks", 0);
			if (marks > 0) {
				File file = upload.getFile("images");
				String titleimages = upload.getFileName("images");
				long imageId = AttachmentUtil.uploadFile(upload, article, file, titleimages);
				article.setImage(String.valueOf(imageId));
			}
			article.setTitle(title);
			article.setSummary(summary);
			article.setContent(content);
			article.setImageTitle(imagesDescription);
			article.setAuthor(author);
			article.setSource(source);
			article.setAllowComent(ParamUtil.getBoolean(upload, "isComment", false));
			article.setIsNoiBat(ParamUtil.getBoolean(upload, "isNoiBat", false));
			article.setThuTu(ParamUtil.getLong(actionRequest, "thuTuHienThiTrangChu",0));
			article.setIsHomePage(ParamUtil.getBoolean(upload, "article-homePage", false));
			String tagnew[] = ParamUtil.getParameterValues(upload,"tagsnew");
			Tag tag = null;
			String idTag = "";
			String listTagName="",listTagId="";
			for(int i = 0;i<tagnew.length;i++){
				tag = TagLocalServiceUtil.createTag(CounterLocalServiceUtil
						.increment(Tag.class.getName()));
				tag.setTagName(HtmlUtil.escape(String.valueOf(tagnew[i]).trim()));
				tag.setLanguage(themeDisplay.getLanguageId());
				tag.setGroupId(themeDisplay.getScopeGroupId());
				tag=TagLocalServiceUtil.updateTag(tag);
				idTag += tag.getTagId()+",";
				
			}
			//------------------------------------------------------------------------
			String eventnew[] = ParamUtil.getParameterValues(upload,"eventsnew");
			Event ev=null;
			String idEvent="";
			String listEventName="",listEventId="";
			for(int i = 0;i<eventnew.length;i++){
				ev=EventLocalServiceUtil.createEvent(CounterLocalServiceUtil
						.increment(Event.class.getName()));
				ev.setEventName(HtmlUtil.escape(String.valueOf(eventnew[i]).trim()));
				ev.setLanguage(themeDisplay.getLanguageId());
				ev.setGroupId(themeDisplay.getScopeGroupId());
				ev=EventLocalServiceUtil.updateEvent(ev);
				idEvent+=ev.getEventId()+",";
			}
			String categories[] = ParamUtil.getParameterValues(upload,"checked-category");
			String siteChild[] = ParamUtil.getParameterValues(upload,"checkbox-site");
			String tas[] = ParamUtil.getParameterValues(upload, "tags");
			String evs[] = ParamUtil.getParameterValues(upload, "events");
			String tags = "",events="";
			if(!idTag.equals("") ){
				for (String a: idTag.split(",")){
					tags += a+",";
				}
			}
			if(tas != null && tas.length > 0){
				for(String b : tas){
					tags += b+",";
				}
			}
			if(!idEvent.equals("") ){
				for (String a: idEvent.split(",")){
					events += a+",";
				}
			}
			if(evs != null && evs.length > 0){
				for(String b : evs){
					events += b+",";
				}
			}
			listCates = new ArrayList<Long>();
			listTags = new ArrayList<Tag>();
			listEvents = new ArrayList<Event>();
			lstSubSite = new ArrayList<String>();
			for (int i = 0; i < categories.length; i++) {
				try{
					listCates.add(Long.parseLong(categories[i]));
				}catch(Exception ex){}
			}
			if(!tags.equals("")){
				for (String i : tags.split(",")) {
					try{
						tag=TagLocalServiceUtil.getTag(Long.parseLong(i));
						listTags.add(tag);
						if(listTagName.equals(""))listTagName="{"+tag.getTagName()+"}";
						else listTagName+=",{"+tag.getTagName()+"}";
						if(listTagId.equals(""))listTagId=tag.getTagId()+"";
						else listTagId+=","+tag.getTagId();
					}catch(Exception ex){}
				}	
			}
			if(!events.equals("")){
				for (String i : events.split(",")) {
					try{
						ev=EventLocalServiceUtil.getEvent(Long.parseLong(i));
						listEvents.add(ev);
						if(listEventName.equals(""))listEventName="{"+ev.getEventName()+"}";
						else listEventName+=",{"+ev.getEventName()+"}";
						if(listEventId.equals(""))listEventId=ev.getEventId()+"";
						else listEventId+=","+ev.getEventId();
					}catch(Exception ex){}
				}	
			}
			String InvolveArt[] = ParamUtil.getParameterValues(upload, "involve");
			String invArt ="";
			for(int i=0; i < InvolveArt.length;i++){
				if(invArt.equals("")){
					invArt += InvolveArt[i]+"";
				}else{
					invArt += ","+InvolveArt[i];
				}
			}
			article.setInvolveArt(invArt);
			boolean henGio = ParamUtil.getBoolean(upload, "henGio", false);
			article.setIsTimer(henGio);
			if(henGio){
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
				Date datethoiGianHenGio = df.parse(ParamUtil.getString(upload, "thoiGianHenGio"));
				if(datethoiGianHenGio != null){
					article.setPublishedDateFrom(datethoiGianHenGio);
				}
			}
			error = checkValidator(actionRequest, article,categories.length);
			if (error) {
				articleTml = article;
				validFalse = "true";
				backUrlTml = backURL;
				imageIds= String.valueOf(article.getImage());
				checkErrorArt = "true";
				for(String st : siteChild){
					lstSubSite.add(st);
				}
				System.out.println("imageId:"+ article.getImage());
				if(cmd.equals("add"))
					article.setArticleId(0);
				actionRequest.setAttribute("article", articleTml);
				actionRequest.setAttribute("listCatesFalse", listCates);
				actionRequest.setAttribute("listTagsFalse", listTags);
				actionRequest.setAttribute("listEventsFalse", listEvents);
				actionRequest.setAttribute("rsValidArticle", validFalse);
				actionRequest.setAttribute("backUrlFalse", backUrlTml);
				actionRequest.setAttribute("lstSubSite", lstSubSite);
				actionRequest.setAttribute("imageId", imageIds);
				actionRequest.setAttribute("checkErrorArt", checkErrorArt);
				if(!currentURL.equals(""))actionResponse.sendRedirect(currentURL);
				return;
			} else {
				article.setGroupId(themeDisplay.getScopeGroupId());
				article.setLanguage(themeDisplay.getLocale().toString());
				article.setFriendlyURL(FriendlyURLNormalizerUtil
						.normalize(article.getTitle())
						.replaceAll("<br>", "-").replaceAll("\"", "-")
						+ "-" + article.getArticleId());
				CategoryArticleLocalServiceUtil.removeByArticle(article.getArticleId());
				for (int i = 0; i < categories.length; i++) {
					if (PermissionUtil.checkPermissionCategory(
							themeDisplay.getUserId(),
							Long.parseLong(categories[i]))) {
					}
					CategoryArticleLocalServiceUtil.addCategoryArticle(
							article.getArticleId(), categories[i]);
				}
				Logger logger = LoggerLocalServiceUtil.createLogger(0);
				if (action == RoleConstants.ARTICLE_ADD) {
					if(article.getStatus() <= 0 || article.getStatus()== NewsWorkflowConstants.STATUS_DRAFT){
						article.setStatus(NewsWorkflowConstants.STATUS_DRAFT);
						article.setCreatedByUser(themeDisplay.getUserId());
						article.setCreatedDate(new Date());
						logger.setType(String.valueOf(RoleConstants.ARTICLE_ADD));
					}
				} else if (action == RoleConstants.ARTICLE_PENDING) {
					article.setPendingDate(new Date());
					article.setStatus(NewsWorkflowConstants.STATUS_PENDING);
					if (articleId <= 0) {
						article.setCreatedByUser(themeDisplay.getUserId());
						article.setCreatedDate(new Date());
					}
					logger.setType(String.valueOf(RoleConstants.ARTICLE_PENDING));
				} else if (action == RoleConstants.ARTICLE_APPROVED) {
					if(cmd.equals("add")){
						article.setCreatedByUser(themeDisplay.getUserId());
						article.setCreatedDate(new Date());
					}
					article.setStatus(NewsWorkflowConstants.STATUS_APPROVED);
					article.setApprovedByUser(themeDisplay.getUserId());
					article.setApprovedDate(new Date());
					logger.setType(String.valueOf(RoleConstants.ARTICLE_APPROVED));
				}else if (action == RoleConstants.ARTICLE_PUBLISH) {
					if(article.getStatus() != NewsWorkflowConstants.STATUS_PUBLISH_DENIED){
						if(article.getStatus() == NewsWorkflowConstants.STATUS_NOT_CREATE ||
								article.getStatus() == NewsWorkflowConstants.STATUS_APPROVED ||
								article.getStatus() == NewsWorkflowConstants.STATUS_PENDING){
							//Vào thì xuất bản ko theo quy trình.
							if(cmd.equals("add")){
								article.setCreatedByUser(themeDisplay.getUserId());
								article.setCreatedDate(new Date());
							}
							article.setPendingDate(new Date());
							article.setApprovedByUser(themeDisplay.getUserId());
							article.setApprovedDate(new Date());
							article.setPublishedDateFrom(new Date());
							//kết thúc. 
						}
						article.setNeverExpire(ParamUtil.getBoolean(upload, "never-expire", false));
						if (!article.getNeverExpire()) {
							String strDateFrom = ParamUtil.getString(upload, "date_from", "");
							String strDateTo = ParamUtil.getString(upload, "date_to", "");
							try{
								if(!strDateFrom.equals("") && !strDateTo.equals("")){
									DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm");
									Date fromDate = new Date();
									try{
										fromDate = df.parse(strDateFrom);
										article.setPublishedDateFrom(fromDate);
									}catch(Exception e){article.setPublishedDateFrom(new Date());}
									Date toDate = df.parse(strDateTo);
									article.setPublishedDateTo(toDate);
									int sub_date = toDate.compareTo(fromDate);
									
									if(sub_date <= 0){
										articleTml = article;
										validFalse = "true";
										backUrlTml = backURL;
										if(cmd.equals("add")) article.setArticleId(0);
										SessionErrors.add(actionRequest, "date-error");
										actionRequest.setAttribute("article", articleTml);
										actionRequest.setAttribute("listCatesFalse", listCates);
										actionRequest.setAttribute("listTagsFalse", listTags);
										actionRequest.setAttribute("listEventsFalse", listEvents);
										actionRequest.setAttribute("rsValidArticle", validFalse);
										actionRequest.setAttribute("backUrlFalse", backUrlTml);
										actionRequest.setAttribute("lstSubSite", lstSubSite);
										if(!currentURL.equals(""))actionResponse.sendRedirect(currentURL);
										return;
									}
								}
							}catch(Exception e){
							}
						} else {
							article.setPublishedDateFrom(new Date());
						}
					}
					article.setPublishedByUser(themeDisplay.getUserId());
					article.setStatus(NewsWorkflowConstants.STATUS_PUBLISH);
					logger.setType(String.valueOf(RoleConstants.ARTICLE_PUBLISH));
				}
				if(action == NewsWorkflowConstants.STATUS_SAVE_ART){
					if(article.getStatus() <= 0 || article.getStatus()== NewsWorkflowConstants.STATUS_DRAFT){
						logger.setType(String.valueOf(NewsWorkflowConstants.STATUS_SAVE_ART));
					}
				}
				article.setModifiedByUser(themeDisplay.getUserId());
				article.setModifiedDate(new Date());
				article.setTags(listTagName);
				article.setTagIds(listTagId);
				article.setEvents(listEventName);
				article.setEventIds(listEventId);
				article = ArticleLocalServiceUtil.updateArticle(article);
				logger.setGroupId(themeDisplay.getScopeGroupId());
				logger.setLanguage(themeDisplay.getLocale().toString());
				logger.setUserId(themeDisplay.getUserId());
				logger.setCreatedDate(new Date());
				logger.setDescription("");
				LoggerLocalServiceUtil.addLogger(logger);

				ArticleHistory history = ArticleHistoryLocalServiceUtil.createArticleHistory(0);
				history.setArticleId(article.getArticleId());
				history.setTitle(article.getTitle());
				history.setSummnary(article.getSummary());
				history.setContent(article.getContent());
				history.setAuthor(article.getAuthor());
				history.setSource(article.getSource());
				history.setImage(article.getImage());
				history.setImageDescription(article.getImageTitle());
				history.setUserId(themeDisplay.getUserId());
				history.setCreatedDate(new Date());
				ArticleHistoryLocalServiceUtil.addArticleHistory(history);
				long articleMainId = article.getArticleId();
				for(int s = 0;s<siteChild.length;s++){
					Article articleSite = null;
					try{
						articleSite = ArticleLocalServiceUtil.getArticleTheoSQL("SELECT * FROM soft_cms_article WHERE groupid="+siteChild[s]+" AND articlemainid="+articleMainId+" AND issubsite=TRUE").get(0);
						if(articleSite.getStatus() != NewsWorkflowConstants.STATUS_PUBLISH && articleSite.getStatus() != NewsWorkflowConstants.STATUS_APPROVED){
							ArticleLocalServiceUtil.deleteArticle(articleSite);
						}
						articleSite = null;
					}catch(Exception e){
						articleSite = null;
					}
					if(Validator.isNull(articleSite)){
						Group group = GroupLocalServiceUtil.getGroup(Long.valueOf(siteChild[s]));
						System.out.println(group.getTypeSettingsProperty("languageId"));
						Locale defaultLocale = PortalUtil.getSiteDefaultLocale(group.getGroupId());
						System.out.println(defaultLocale.getDisplayLanguage());
						System.out.println(defaultLocale.getLanguage());
						articleSite = ArticleLocalServiceUtil.createArticle(0);
						long artSiteId=CounterLocalServiceUtil.increment(Article.class.getName());
						String sql = "select max(articleid) from soft_cms_article";
						artSiteId = 1+Long.valueOf(ArticleLocalServiceUtil.getMaxId(sql));
						articleSite = ArticleLocalServiceUtil.getArticle(articleMainId);
						articleSite.setArticleId(artSiteId);
						articleSite.setGroupId(Long.valueOf(siteChild[s]));
						articleSite.setStatus(NewsWorkflowConstants.STATUS_PENDING);
						articleSite.setLanguage(defaultLocale.toLanguageTag().replace("-", "_"));
						articleSite.setCreatedByUser(themeDisplay.getUserId());
						articleSite.setCreatedDate(new Date());
						articleSite.setApprovedDate(null);
						articleSite.setApprovedByUser(0);
						articleSite.setPublishedDateFrom(null);
						articleSite.setPublishedByUser(0);
						articleSite.setArticleMainId(articleMainId);
						articleSite.setIsSubSite(true);
						articleSite = ArticleLocalServiceUtil.addArticle(articleSite);
					}
				}
				if(!backURL.equals("/"))actionResponse.sendRedirect(backURL);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void serveResource(ResourceRequest request, ResourceResponse response)
			throws IOException, PortletException {
		String cmd = HtmlUtil.escape(ParamUtil.getString(request, "cmd", ""));
		ThemeDisplay themeDisplay  = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		JSONObject json = JSONFactoryUtil.createJSONObject();
		JSONArray results = JSONFactoryUtil.createJSONArray();
		String keyword = HtmlUtil.escape(ParamUtil.getString(request, DisplayTerms.KEYWORDS));
		if(cmd.equals("Tags")) {
			String listtag = ParamUtil.getString(request, "listtag");
			List<Tag> filteredEntries = TagLocalServiceUtil.searchByTagName(keyword,themeDisplay.getScopeGroupId(),themeDisplay.getLanguageId());
			for (Tag entries : filteredEntries) {
				String idtag = Long.toString(entries.getTagId());
				String nametag = entries.getTagName();
				if(listtag.matches("(.*),"+idtag+",(.*)")){
				}else{
					JSONObject listEntry = JSONFactoryUtil.createJSONObject();
					listEntry.put("key", idtag);
					listEntry.put("name", HtmlUtil.extractText(nametag));			
					results.put(listEntry);
				}
			}
		}else if(cmd.equals("ArticleInvolve")) {
			String listinvolve = ParamUtil.getString(request, "listinvolve");
			String sql="select * from soft_cms_article where groupid='"+themeDisplay.getScopeGroupId()+"' and lower(language)=lower('"+ themeDisplay.getLocale().toString()+"') and status="+NewsWorkflowConstants.STATUS_PUBLISH+" and LOWER(title) like LOWER('%"+keyword+"%') ";
			if(!listinvolve.equals(",") && listinvolve.length()>2)sql+=" and articleid not in("+listinvolve.substring(1,listinvolve.length()-1)+")";
			sql+=" limit 50";
			List<Article> filteredEntries = ArticleLocalServiceUtil.getArticleTheoSQL(sql);
			for (Article entries : filteredEntries) {
				String idinvolve = Long.toString(entries.getArticleId());
				String nameinvolve = entries.getTitle();
				JSONObject listEntry = JSONFactoryUtil.createJSONObject();
				listEntry.put("key", idinvolve);
				listEntry.put("name", HtmlUtil.extractText(nameinvolve));			
				results.put(listEntry);
			}
		}else if(cmd.equals("Events")) {
			String listevent = ParamUtil.getString(request, "listevent");
			List<Event> filteredEntries = EventLocalServiceUtil.findEvent(themeDisplay.getScopeGroupId(), themeDisplay.getLanguageId(), keyword, 0, 50);
			for (Event entries : filteredEntries) {
				String idtag = Long.toString(entries.getEventId());
				String nameEvent = entries.getEventName();
				if(listevent.matches("(.*),"+idtag+",(.*)")){
				}else{
					JSONObject listEntry = JSONFactoryUtil.createJSONObject();
					listEntry.put("key", idtag);
					listEntry.put("name", HtmlUtil.extractText(nameEvent));			
					results.put(listEntry);
				}
			}
		}else if(cmd.equals("Sources")) {
			List<Object> lst = ArticleLocalServiceUtil.getDuLieuTheoSql("select articleid,source from soft_cms_article where LOWER(source) like LOWER('%"+keyword+"%') limit 100");
			 Iterator<Object> itr= lst.iterator();
			 while (itr.hasNext()) {
				   Object[] obj= (Object[])itr.next();
				   String id = String.valueOf(obj[0]);
					String ten = String.valueOf(obj[1]);
						JSONObject listEntry = JSONFactoryUtil.createJSONObject();
						listEntry.put("key", id);
						listEntry.put("name", HtmlUtil.extractText(ten));			
						results.put(listEntry);
			 }
		}
		json.put("response",results);
		PrintWriter writer = response.getWriter();
		writer.print(json.toString());
	}
	public void removeImage(ActionRequest request, ActionResponse response)
			throws Exception {
		String backURL = ParamUtil.getString(request, "backURL", "/");
		long articleId = ParamUtil.getLong(request, "articleId", -1);
		long imageId = ParamUtil.getLong(request, "imageId", -1);
		
		String urlBack = ParamUtil.getString(request, "urlBack", "/");
		try {
			String sql = "select * from soft_cms_article where image='"+imageId+"' ";
			List<Article> lstArt = ArticleLocalServiceUtil.getListArticleBySQL(sql, QueryUtil.ALL_POS, QueryUtil.ALL_POS);
			if(lstArt != null && lstArt.size() > 1){
				for(Article article: lstArt){
					if(articleId == article.getArticleId()){
						article.setImage("");
						ArticleLocalServiceUtil.updateArticle(article);
					}
				}
			}else{
				if(articleId != -1 && imageId != -1){
					Article article = null;
					try{
						article = ArticleLocalServiceUtil.getArticle(articleId);
					}catch(Exception e){
						article = null;
					}
					 
					if(article != null){
						if(!article.getImage().equals("")){
							DLFileEntryLocalServiceUtil.deleteDLFileEntry(Long
									.parseLong(article.getImage()));
							article.setImage("");
							ArticleLocalServiceUtil.updateArticle(article);
							
						}
					}else{
						if(imageId > 0){
							DLFileEntryLocalServiceUtil.deleteDLFileEntry(imageId);
							response.sendRedirect(urlBack);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(backURL);
	}
	public void approvedArticle(ActionRequest request, ActionResponse response)
			throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		String backURL = ParamUtil.getString(request, "backURL", "/");
		long articleId = ParamUtil.getLong(request, "articleId", 0);
		if (PermissionUtil.checkPermissionArticle(themeDisplay.getUserId(), articleId) 
		&& PermissionUtil.checkPermissionAccessZone(themeDisplay.getUserId(), RoleConstants.ARTICLE_APPROVED, themeDisplay.getScopeGroupId())) {
			try {
				Article article = ArticleLocalServiceUtil.getArticle(articleId);
				article.setStatus(NewsWorkflowConstants.STATUS_APPROVED);
				article.setApprovedByUser(themeDisplay.getUserId());
				article.setApprovedDate(new Date());
				article.setModifiedByUser(themeDisplay.getUserId());
				article.setModifiedDate(new Date());
				ArticleLocalServiceUtil.updateArticle(article);
				Logger logger = LoggerLocalServiceUtil.createLogger(0);
				logger.setGroupId(themeDisplay.getScopeGroupId());
				logger.setLanguage(themeDisplay.getLocale().toString());
				logger.setLoggerId(CounterLocalServiceUtil
						.increment(Logger.class.getName()));
				logger.setType(String.valueOf(RoleConstants.ARTICLE_APPROVED));
				logger.setUserId(themeDisplay.getUserId());
				logger.setCreatedDate(new Date());
				logger.setDescription(LanguageUtil.get(
						themeDisplay.getLocale(),
						"soft.cms.manage.article.button.approved")
						+ " : " + article.getTitle());
				LoggerLocalServiceUtil.addLogger(logger);
				SessionMessages.add(request, "approvedArticle_OK");
				SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			SessionErrors.add(request, "NOT_PERMISSION");
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}
		response.sendRedirect(backURL);
	}
	public void publishArticle(ActionRequest request, ActionResponse response)
			throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		String backURL = ParamUtil.getString(request, "backURL", "/");

		long articleId = ParamUtil.getLong(request, "articleId", 0);
		if (PermissionUtil.checkPermissionArticle(themeDisplay.getUserId(),
				articleId)
				&& PermissionUtil.checkPermissionAccessZone(
						themeDisplay.getUserId(),
						RoleConstants.ARTICLE_PUBLISH,
						themeDisplay.getScopeGroupId())) {
			try {
				Article article = ArticleLocalServiceUtil.getArticle(articleId);
				if(article.getStatus() != NewsWorkflowConstants.STATUS_PUBLISH_DENIED){
					if(article.getStatus() == NewsWorkflowConstants.STATUS_APPROVED || 
							article.getStatus() == NewsWorkflowConstants.STATUS_PENDING){
						article.setApprovedByUser(themeDisplay.getUserId());
						article.setApprovedDate(new Date());
					}
					article.setPublishedByUser(themeDisplay.getUserId());
					article.setPublishedDateFrom(new Date());
					article.setNeverExpire(true);
					article.setModifiedByUser(themeDisplay.getUserId());
					article.setModifiedDate(new Date());
				}
				article.setStatus(NewsWorkflowConstants.STATUS_PUBLISH);
				
				ArticleLocalServiceUtil.updateArticle(article);
				Logger logger =  LoggerLocalServiceUtil.createLogger(0);
				logger.setGroupId(themeDisplay.getScopeGroupId());
				logger.setLanguage(themeDisplay.getLocale().toString());
				logger.setLoggerId(CounterLocalServiceUtil
						.increment(Logger.class.getName()));
				logger.setType(String.valueOf(RoleConstants.ARTICLE_APPROVED));
				logger.setUserId(themeDisplay.getUserId());
				logger.setCreatedDate(new Date());
				logger.setDescription(LanguageUtil.get(themeDisplay.getLocale(),
						"ecoit.cms.manage.article.button.publish")
						+ " : " + article.getTitle());
				LoggerLocalServiceUtil.addLogger(logger);
				SessionMessages.add(request, "publishArticle_OK");
				SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			SessionErrors.add(request, "NOT_PERMISSION");
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}
		
		response.sendRedirect(backURL);
	}
	public void deniedApproveArticle(ActionRequest request,
			ActionResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		String backURL = ParamUtil.getString(request, "backURL", "/");
		long articleId = ParamUtil.getLong(request, "articleId", 0);
		if (PermissionUtil.checkPermissionArticle(themeDisplay.getUserId(),
				articleId)
				&& PermissionUtil.checkPermissionAccessZone(
						themeDisplay.getUserId(),
						RoleConstants.ARTICLE_APPROVED_RETURN,
						themeDisplay.getScopeGroupId())) {
			try {
				Article article = ArticleLocalServiceUtil.getArticle(articleId);
				article.setStatus(NewsWorkflowConstants.STATUS_APPROVE_DENIED);
				article.setModifiedByUser(themeDisplay.getUserId());
				article.setModifiedDate(new Date());
				ArticleLocalServiceUtil.updateArticle(article);
				Logger logger = LoggerLocalServiceUtil.createLogger(0);
				logger.setLoggerId(CounterLocalServiceUtil
						.increment(Logger.class.getName()));
				logger.setGroupId(themeDisplay.getScopeGroupId());
				logger.setLanguage(themeDisplay.getLocale().toString());
				logger.setType(String
						.valueOf(RoleConstants.ARTICLE_APPROVED_RETURN));
				logger.setUserId(themeDisplay.getUserId());
				logger.setCreatedDate(new Date());
				logger.setDescription(LanguageUtil.get(themeDisplay.getLocale(),
						"soft.cms.manage.article.button.approved-return")
						+ " :" + article.getTitle());
				LoggerLocalServiceUtil.addLogger(logger);
				SessionMessages.add(request, "deniedApproveArticle_OK");
				SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			SessionErrors.add(request, "NOT_PERMISSION");
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}
		response.sendRedirect(backURL);
	}
	
	public void deniedPublishArticle(ActionRequest request,
			ActionResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		String backURL = ParamUtil.getString(request, "backURL", "/");
		long articleId = ParamUtil.getLong(request, "articleId", 0);
		if (PermissionUtil.checkPermissionArticle(themeDisplay.getUserId(),
				articleId)
				&& PermissionUtil.checkPermissionAccessZone(
						themeDisplay.getUserId(),
						RoleConstants.ARTICLE_PUBLISH_RETURN,
						themeDisplay.getScopeGroupId())) {
			try {
				Article article = ArticleLocalServiceUtil.getArticle(articleId);
				article.setStatus(NewsWorkflowConstants.STATUS_PUBLISH_DENIED);
				article.setModifiedByUser(themeDisplay.getUserId());
				article.setModifiedDate(new Date());
				ArticleLocalServiceUtil.updateArticle(article);
				// Add message
				String content = HtmlUtil.escape(ParamUtil.getString(request, "message", ""));
				if (!"".equals(content)) {
					ArticleMessage message = ArticleMessageLocalServiceUtil
							.createArticleMessage(CounterLocalServiceUtil
									.increment(ArticleMessage.class.getName()));
					message.setArticleId(articleId);
					message.setCreatedByUser(themeDisplay.getUserId());
					message.setCreatedDate(new Date());
					message.setContent(content);
					ArticleMessageLocalServiceUtil
							.updateArticleMessage(message);
				}
				// Add logger
				Logger logger = LoggerLocalServiceUtil.createLogger(0);
				logger.setLoggerId(CounterLocalServiceUtil
						.increment(Logger.class.getName()));
				logger.setType(String
						.valueOf(RoleConstants.ARTICLE_PUBLISH_RETURN));
				logger.setGroupId(themeDisplay.getScopeGroupId());
				logger.setLanguage(themeDisplay.getLocale().toString());
				logger.setUserId(themeDisplay.getUserId());
				logger.setCreatedDate(new Date());
				logger.setDescription(LanguageUtil.get(themeDisplay.getLocale(),
						"ecoit.cms.manage.article.button.publish-return")
						+ " :" + article.getTitle());
				LoggerLocalServiceUtil.addLogger(logger);
				SessionMessages.add(request, "deniedPublishArticle_OK");
				SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			SessionErrors.add(request, "NOT_PERMISSION");
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}
		response.sendRedirect(backURL);
	}
	public void pendingArticle(ActionRequest request, ActionResponse response)
			throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		String backURL = ParamUtil.getString(request, "backURL", "/");
		long articleId = ParamUtil.getLong(request, "articleId", 0);
		if (PermissionUtil.checkPermissionArticle(themeDisplay.getUserId(),
				articleId)
				&& PermissionUtil.checkPermissionAccessZone(
						themeDisplay.getUserId(),
						RoleConstants.ARTICLE_PENDING,
						themeDisplay.getScopeGroupId())) {
			try {
				Article article = ArticleLocalServiceUtil.getArticle(articleId);
				article.setStatus(NewsWorkflowConstants.STATUS_PENDING);
				article.setPendingDate(new Date());
				article.setModifiedByUser(themeDisplay.getUserId());
				article.setModifiedDate(new Date());
				ArticleLocalServiceUtil.updateArticle(article);
				// Add message
				String content = HtmlUtil.escape(ParamUtil.getString(request, "message", ""));
				if (!"".equals(content)) {
					ArticleMessage message = ArticleMessageLocalServiceUtil
							.createArticleMessage(CounterLocalServiceUtil
									.increment(ArticleMessage.class.getName()));
					message.setArticleId(articleId);
					message.setCreatedByUser(themeDisplay.getUserId());
					message.setCreatedDate(new Date());
					message.setContent(content);
					ArticleMessageLocalServiceUtil
							.updateArticleMessage(message);
				}
				// Add logger
				Logger logger = LoggerLocalServiceUtil.createLogger(0);
				logger.setLoggerId(CounterLocalServiceUtil
						.increment(Logger.class.getName()));
				logger.setGroupId(themeDisplay.getScopeGroupId());
				logger.setLanguage(themeDisplay.getLocale().toString());
				logger.setType(String.valueOf(RoleConstants.ARTICLE_PENDING));
				logger.setUserId(themeDisplay.getUserId());
				logger.setCreatedDate(new Date());
				logger.setDescription(LanguageUtil.get(themeDisplay.getLocale(),
						"ecoit.cms.manage.article.button.approved-pending")
						+ " : " + article.getTitle());
				LoggerLocalServiceUtil.addLogger(logger);
				SessionMessages.add(request, "pendingArticle_OK");
				SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			SessionErrors.add(request, "NOT_PERMISSION");
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}
		response.sendRedirect(backURL);
	}
	public void removeArticle(ActionRequest request, ActionResponse response)
			throws SystemException, PortalException, IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		String backURL = ParamUtil.getString(request, "backURL", "/");
		long articleId = ParamUtil.getLong(request, "articleId", 0);
		if (PermissionUtil.checkPermissionArticle(themeDisplay.getUserId(),
				articleId)
				&& PermissionUtil.checkPermissionAccessZone(
						themeDisplay.getUserId(), RoleConstants.ARTICLE_REMOVE,
						themeDisplay.getScopeGroupId())) {
			try {
				Article article = ArticleLocalServiceUtil.getArticle(articleId);
				String imageId=article.getImage().trim();
				if(!imageId.equals("") && !imageId.equals("0")){
					try{
						DLFileEntryLocalServiceUtil.deleteDLFileEntry(Long
								.parseLong(imageId));
					}
					catch(Exception e1){}
				}
				
				ArticleLocalServiceUtil.deleteArticle(articleId);
				CategoryArticleLocalServiceUtil.removeByArticle(articleId);
				/* Cuong added: Delete comments of a removed article */
				List<Comment> comm = CommentLocalServiceUtil.searchComment(articleId);
				for(int i=0; i<comm.size(); i++){
					CommentLocalServiceUtil.deleteComment(comm.get(i));
				}
				/* end of addition */
				
				Logger logger = LoggerLocalServiceUtil.createLogger(0);
				logger.setLoggerId(CounterLocalServiceUtil
						.increment(Logger.class.getName()));
				logger.setType(String.valueOf(RoleConstants.ARTICLE_REMOVE));
				logger.setUserId(themeDisplay.getUserId());
				logger.setCreatedDate(new Date());
				logger.setDescription(LanguageUtil.get(themeDisplay.getLocale(),
						"ecoit.cms.manage.article.label.search-action-remove")
						+ " : " + article.getTitle());
				LoggerLocalServiceUtil.addLogger(logger);
				SessionMessages.add(request, "removeArticle_OK");
				SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else{
			SessionErrors.add(request, "NOT_PERMISSION");
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}
		response.sendRedirect(backURL);
	}
	private boolean checkValidator(ActionRequest request, Article article, int number) {
		boolean error = false;
		if (Validator.isNull(article.getSummary())) {
			SessionErrors.add(request, "summary-is-required");
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			error = true;
		}
		if (Validator.isNull(article.getContent())) {
			SessionErrors.add(request, "content-is-required");
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			error = true;
		}
		if (Validator.isNull(article.getTitle())) {
			SessionErrors.add(request, "title-is-required");
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			error = true;
		}
		if(number==0) {
			SessionErrors.add(request, "category-is-required");
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			error = true;
		}
		return error;
	}
}