package com.web.article.listnews.portlet;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.PortletURLUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.model.Article;
import com.software.cms.model.Category;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.cms.service.CategoryLocalServiceUtil;
import com.software.util.NewsWorkflowConstants;
import com.web.article.listnews.constants.ListNewByCategoryPortletKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author dorem
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=CMS VIEW",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ListNewByCategory",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/ListNewCate/view.jsp",
		"javax.portlet.name=" + ListNewByCategoryPortletKeys.LISTNEWBYCATEGORY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ListNewByCategoryPortlet extends MVCPortlet {

	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws IOException, PortletException {
		try {
			PortletPreferences preferences = request.getPreferences();
			String cateConfig = preferences.getValue("categorySelect", "-1");
			String slide_tin_chuyen_muc = preferences.getValue("slide_tin_chuyen_muc", "false");
			String danh_sach_slide_tin_chuyen_muc = preferences.getValue("danh_sach_slide_tin_chuyen_muc", "false");
			String check_remove_category = preferences.getValue("check_remove_category", "false");
			
			if (!cateConfig.equals("-1")) {
				long categoryId = Long.valueOf(cateConfig);
				Category cat = CategoryLocalServiceUtil.getCategory(categoryId);
				ThemeDisplay themeDisplay = (ThemeDisplay) request
						.getAttribute(WebKeys.THEME_DISPLAY);
				long groupId = themeDisplay.getScopeGroupId();

				PortletURL portletURL = PortletURLUtil.getCurrent(request,
						response);
				SearchContainer searchContainer = new SearchContainer(request,
						null, null, SearchContainer.DEFAULT_CUR_PARAM,10,
						portletURL, null, LanguageUtil.get(themeDisplay.getLocale(), "no-result"));
				if(slide_tin_chuyen_muc != null && slide_tin_chuyen_muc.equals("true")){
					int total = 0;
					List<Article> result = new ArrayList<Article>();
					List<Article> resultHotNew = new ArrayList<Article>();
					String artIds ="";
					try {
						String sqlHotNew = "SELECT DISTINCT soft_cms_article.* FROM soft_cms_article "
								+ " INNER JOIN soft_cms_categoryarticle "
								+ " ON soft_cms_article.articleid = soft_cms_categoryarticle.articleid "
								+ " WHERE soft_cms_categoryarticle.categoryid = "+categoryId
								+ " and soft_cms_article.groupid = "+themeDisplay.getScopeGroupId()
								+ " AND soft_cms_article.status= "+ NewsWorkflowConstants.STATUS_PUBLISH
								+ "ORDER BY soft_cms_article.publisheddatefrom DESC LIMIT 12";
						resultHotNew = ArticleLocalServiceUtil.getArticleTheoSQL(sqlHotNew);
						for(Article article: resultHotNew ){
							if(artIds.equals(""))artIds=article.getArticleId()+"";
							else artIds+=","+article.getArticleId();
						}
						//Result
						String sqlResultNew = "SELECT DISTINCT soft_cms_article.* FROM soft_cms_article "
								+ " INNER JOIN soft_cms_categoryarticle "
								+ " ON soft_cms_article.articleid = soft_cms_categoryarticle.articleid "
								+ " WHERE soft_cms_categoryarticle.categoryid = "+categoryId
								+ " and soft_cms_article.groupid = "+themeDisplay.getScopeGroupId()
								+ " AND soft_cms_article.status= "+ NewsWorkflowConstants.STATUS_PUBLISH;
						sqlResultNew+= (!artIds.equals("")?" AND soft_cms_article.articleid not in ("+artIds+") ":"");
						sqlResultNew+= " ORDER BY soft_cms_article.publisheddatefrom DESC ";
						//Count
						String sqlCountNew = "SELECT count(DISTINCT soft_cms_article.articleid) FROM soft_cms_article "
								+ " INNER JOIN soft_cms_categoryarticle "
								+ " ON soft_cms_article.articleid = soft_cms_categoryarticle.articleid "
								+ " WHERE soft_cms_categoryarticle.categoryid = "+categoryId
								+ " and soft_cms_article.groupid = "+themeDisplay.getScopeGroupId()
								+ " AND soft_cms_article.status= "+ NewsWorkflowConstants.STATUS_PUBLISH;
						sqlCountNew+= (!artIds.equals("")?" AND soft_cms_article.articleid not in ("+artIds+") ":"");
						if(danh_sach_slide_tin_chuyen_muc.equals("true")){
							total = ArticleLocalServiceUtil.getCountArticleBySQL(sqlCountNew);
							result = ArticleLocalServiceUtil.getListArticleBySQL(sqlResultNew, searchContainer.getStart(),
									total>searchContainer.getEnd()?searchContainer.getEnd():total);
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					searchContainer.setTotal(total);
					searchContainer.setResults(result);
					request.setAttribute("searchContainerTinTucTrangChuyenMuc",
							searchContainer);
					request.setAttribute("resultHotNew",resultHotNew);
					request.setAttribute("category",cat);
					request.setAttribute("slide_tin_chuyen_muc",slide_tin_chuyen_muc);
					request.setAttribute("danh_sach_slide_tin_chuyen_muc",danh_sach_slide_tin_chuyen_muc);
					
				}else{
					int total = 0;
					List<Article> result = new ArrayList<Article>();
					try {
						total = ArticleLocalServiceUtil.getCountArticleByCaterory(
								groupId, categoryId, null);
						result = ArticleLocalServiceUtil.getListArticleByCaterory(
								groupId, categoryId, null,
								searchContainer.getStart(),
								total>searchContainer.getEnd()?searchContainer.getEnd():total);
					} catch (Exception e) {
						// TODO: handle exception
					}
					searchContainer.setTotal(total);
					searchContainer.setResults(result);
					request.setAttribute("searchContainerTinTucTrangChuyenMuc",
							searchContainer);
					request.setAttribute("category",cat);
					request.setAttribute("slide_tin_chuyen_muc",slide_tin_chuyen_muc);
				}
				request.setAttribute("check_remove_category",check_remove_category);
			}
		}catch(Exception ex){}
		super.render(request, response);
	}
	
}