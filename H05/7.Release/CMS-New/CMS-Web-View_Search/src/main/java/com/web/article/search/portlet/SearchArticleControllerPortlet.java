package com.web.article.search.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.model.Article;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.util.CMSPortalUtil;
import com.software.util.NewsWorkflowConstants;
import com.web.article.search.constants.SearchArticleControllerPortletKeys;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author dorem
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=CMS VIEW",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=SearchArticleController",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + SearchArticleControllerPortletKeys.SEARCHARTICLECONTROLLER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class SearchArticleControllerPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		HttpServletRequest requests  = PortalUtil.getHttpServletRequest(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String keyword = ParamUtil.getString(request, "keyword", "").trim();
		String tags = ParamUtil.getString(request, "tags", "").trim();
		if(tags == null || tags.equals("")){
			tags = requests.getParameter("tags");
		}
		if(tags == null || tags.equals("")){
			tags = CMSPortalUtil.getStringParam(requests, "tags","").trim();
		}
		if(tags == null || tags.equals("")){
			tags = String.valueOf(themeDisplay.getRequest().getSession().getAttribute("tags"));
		}
		if(keyword.equals("")){
			keyword = requests.getParameter("keyword");
		}
		if(keyword == null || keyword.equals("")){
			keyword = CMSPortalUtil.getStringParam(requests, "keyword","").trim();
		}
		System.out.println(keyword);
		if (keyword!=null && !keyword.equals("")) {
			keyword = HtmlUtil.escape(keyword);
			PortletURL portletURL = PortletURLUtil.getCurrent(request, response);
			SearchContainer searchContainer = new SearchContainer(request,
					null, null, SearchContainer.DEFAULT_CUR_PARAM, 10,
					portletURL, null, LanguageUtil.get(themeDisplay.getLocale(), "Không có dữ liệu"));

			int total = 0;
			List<Article> result = new ArrayList<Article>();
			long groupId = themeDisplay.getScopeGroupId();
			try {
				String sqlCount = "SELECT count(*) FROM soft_cms_article  WHERE groupid ="+groupId+" and status="+NewsWorkflowConstants.STATUS_PUBLISH+" AND (lower(title) LIKE '%"+keyword.toLowerCase()+"%' OR LOWER(summary) like LOWER('%"+keyword+"%'))";
				total = ArticleLocalServiceUtil.getCountArticleBySQL(sqlCount);
				String sql = "SELECT * FROM soft_cms_article  WHERE groupid ="+groupId+" and status="+NewsWorkflowConstants.STATUS_PUBLISH+" AND (lower(title) LIKE '%"+keyword.toLowerCase()+"%' OR LOWER(summary) like LOWER('%"+keyword+"%')) ORDER BY publisheddatefrom DESC";
			
				result = ArticleLocalServiceUtil.getListArticleBySQL(sql,searchContainer.getStart(),
						total>searchContainer.getEnd()?searchContainer.getEnd():total);
			} catch (Exception e) {
				e.printStackTrace();
			}
			searchContainer.setTotal(total);
			searchContainer.setResults(result);
			request.setAttribute("ListSearchArticle", searchContainer);
			request.setAttribute("keyword", keyword);
		}
		if(tags != null && !tags.equals("")){
			tags = HtmlUtil.escape(tags);
			tags = URLDecoder.decode(tags,"UTF-8");
			PortletURL portletURL = PortletURLUtil.getCurrent(request, response);
			SearchContainer searchContainer = new SearchContainer(request,
					null, null, SearchContainer.DEFAULT_CUR_PARAM, 10,
					portletURL, null, LanguageUtil.get(themeDisplay.getLocale(), "Không có dữ liệu"));
			int total = 0;
			List<Article> result = new ArrayList<Article>();
			long groupId = themeDisplay.getScopeGroupId();
			String sqlCount = "SELECT count(*) FROM soft_cms_article  WHERE groupid ="+groupId+" and status="+NewsWorkflowConstants.STATUS_PUBLISH+" AND lower(tags) LIKE '%{"+tags.toLowerCase()+"}%' ";
			total = ArticleLocalServiceUtil.getCountArticleBySQL(sqlCount);
			
			String sql = "SELECT * FROM soft_cms_article  WHERE groupid ="+groupId+" and status="+NewsWorkflowConstants.STATUS_PUBLISH+" AND lower(tags) LIKE '%{"+tags.toLowerCase()+"}%' ORDER BY publisheddatefrom DESC";
			result = ArticleLocalServiceUtil.getListArticleBySQL(sql,searchContainer.getStart(),
					total>searchContainer.getEnd()?searchContainer.getEnd():total);
			
			searchContainer.setTotal(total);
			searchContainer.setResults(result);
			request.setAttribute("searchContainerResult", searchContainer);
			request.setAttribute("tags", tags);
			
		}
		super.render(request, response);
	}
	
}