package com.software.cms.article.portlet;

import java.util.Iterator;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;
import com.liferay.portal.kernel.servlet.ServletResponseUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.article.constants.ArticleActionPortletKeys;
import com.software.cms.model.Article;
import com.software.cms.model.Event;
import com.software.cms.model.Tag;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.cms.service.EventLocalServiceUtil;
import com.software.cms.service.TagLocalServiceUtil;
import com.software.util.NewsWorkflowConstants;

@Component(
	    property = {
	        "javax.portlet.name="+ ArticleActionPortletKeys.ARTICLEACTION,
	        "mvc.command.name="+ ArticleActionPortletKeys.Article_Resoucre
	    },
	    service = MVCResourceCommand.class
	)
public class ArticleServerResource extends BaseMVCResourceCommand{

	@Override
	protected void doServeResource(ResourceRequest request, ResourceResponse response)
			throws Exception {
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
				String nametag = entries.getEventName();
				if(listevent.matches("(.*),"+idtag+",(.*)")){
				}else{
					JSONObject listEntry = JSONFactoryUtil.createJSONObject();
					listEntry.put("key", idtag);
					listEntry.put("name", nametag);			
					results.put(listEntry);
				}
			}
		}else if(cmd.equals("Sources")) {
			List<Object> lst = ArticleLocalServiceUtil.getDuLieuTheoSql("select articleid,source from soft_cms_article where LOWER(source) like LOWER('%"+keyword+"%') limit 100");
			 Iterator<Object> itr= lst.iterator();
			 while (itr.hasNext()) {
				   Object[] obj= (Object[])itr.next();
				   System.out.println("obj1:"+String.valueOf(obj[0]));
				   String id = String.valueOf(obj[0]);
					String ten = String.valueOf(obj[1]);
						JSONObject listEntry = JSONFactoryUtil.createJSONObject();
						listEntry.put("key", id);
						listEntry.put("name", HtmlUtil.extractText(ten));			
						results.put(listEntry);
			 }
		}
		json.put("response","'"+results+"'");
		HttpServletResponse httpServletResponse = PortalUtil.getHttpServletResponse(response);
		/* PrintWriter writer = response.getWriter(); */
		ServletResponseUtil.write(httpServletResponse, json.toString());
		/*
		 * writer.print(json.toString()); writer.flush(); writer.close();
		 */
	}

}
