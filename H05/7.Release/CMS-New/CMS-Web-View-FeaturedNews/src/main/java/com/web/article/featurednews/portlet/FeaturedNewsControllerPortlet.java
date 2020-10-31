package com.web.article.featurednews.portlet;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.model.Article;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.util.NewsWorkflowConstants;
import com.web.article.featurednews.constants.FeaturedNewsControllerPortletKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
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
		"javax.portlet.display-name=FeaturedNewsController",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FeaturedNewsControllerPortletKeys.FEATUREDNEWSCONTROLLER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FeaturedNewsControllerPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			List<Article> listTinMoiNhat=new ArrayList<Article>();
			List<Article>ltmp=ArticleLocalServiceUtil.getArticleTheoSQL("select * from soft_cms_article where groupid="+themeDisplay.getScopeGroupId()+" and language='"+themeDisplay.getLanguageId()+"' and status="+NewsWorkflowConstants.STATUS_PUBLISH+" and ishomepage=true and thutu="+1+" order by publisheddatefrom desc,modifieddate desc limit 1");
			if(ltmp!=null && ltmp.size()>0)listTinMoiNhat.add(0, ltmp.get(0));
			else listTinMoiNhat.add(0, ArticleLocalServiceUtil.createArticle(0));
			//
			ltmp=ArticleLocalServiceUtil.getArticleTheoSQL("select * from soft_cms_article where groupid="+themeDisplay.getScopeGroupId()+" and language='"+themeDisplay.getLanguageId()+"' and status="+NewsWorkflowConstants.STATUS_PUBLISH+" and ishomepage=true and thutu="+2+" order by publisheddatefrom desc,modifieddate desc limit 1");
			if(ltmp!=null && ltmp.size()>0)listTinMoiNhat.add(1, ltmp.get(0));
			else listTinMoiNhat.add(1, ArticleLocalServiceUtil.createArticle(0));
			
			ltmp=ArticleLocalServiceUtil.getArticleTheoSQL("select * from soft_cms_article where groupid="+themeDisplay.getScopeGroupId()+" and language='"+themeDisplay.getLanguageId()+"' and status="+NewsWorkflowConstants.STATUS_PUBLISH+" and ishomepage=true and thutu="+3+" order by publisheddatefrom desc,modifieddate desc limit 1");
			if(ltmp!=null && ltmp.size()>0)listTinMoiNhat.add(2, ltmp.get(0));
			else listTinMoiNhat.add(2, ArticleLocalServiceUtil.createArticle(0));
			
			ltmp=ArticleLocalServiceUtil.getArticleTheoSQL("select * from soft_cms_article where groupid="+themeDisplay.getScopeGroupId()+" and language='"+themeDisplay.getLanguageId()+"' and status="+NewsWorkflowConstants.STATUS_PUBLISH+" and ishomepage=true and thutu="+4+" order by publisheddatefrom desc,modifieddate desc limit 1");
			if(ltmp!=null && ltmp.size()>0)listTinMoiNhat.add(3, ltmp.get(0));
			else listTinMoiNhat.add(3, ArticleLocalServiceUtil.createArticle(0));
			
			/*
			 * ltmp=ArticleLocalServiceUtil.
			 * getArticleTheoSQL("select * from soft_cms_article where groupid="
			 * +themeDisplay.getScopeGroupId()+" and language='"+themeDisplay.getLanguageId(
			 * )+"' and status=10 and ishomepage=true and thutu="
			 * +5+" order by publisheddatefrom desc,modifieddate desc limit 1");
			 * if(ltmp!=null && ltmp.size()>0)listTinMoiNhat.add(4, ltmp.get(0));
			 * 
			 * ltmp=ArticleLocalServiceUtil.
			 * getArticleTheoSQL("select * from soft_cms_article where groupid="
			 * +themeDisplay.getScopeGroupId()+" and language='"+themeDisplay.getLanguageId(
			 * )+"' and status=10 and ishomepage=true and thutu="
			 * +6+" order by publisheddatefrom desc,modifieddate desc limit 1");
			 * if(ltmp!=null && ltmp.size()>0)listTinMoiNhat.add(5, ltmp.get(0));
			 */
			
			/*
			 * ltmp=ArticleLocalServiceUtil.
			 * getArticleTheoSQL("select * from soft_cms_article where groupid="
			 * +themeDisplay.getScopeGroupId()+" and language='"+themeDisplay.getLanguageId(
			 * )+"' and status=10 and ishomepage=true and thutu="
			 * +7+" order by publisheddatefrom desc,modifieddate desc limit 1");
			 * if(ltmp!=null && ltmp.size()>0)listTinMoiNhat.add(6, ltmp.get(0));
			 */
			String lIds="";
			String sql="select * from soft_cms_article where groupid="+themeDisplay.getScopeGroupId()+" and language='"+themeDisplay.getLanguageId()+"' and status=10 and ishomepage=true ";
			if(listTinMoiNhat.size()<4){
				if(listTinMoiNhat.size()>0){
					for(int i=0;i<listTinMoiNhat.size();i++){
						if(lIds.equals(""))lIds=""+listTinMoiNhat.get(i).getArticleId();
						else lIds+=","+listTinMoiNhat.get(i).getArticleId();
					}
				}
				if(!lIds.equals(""))sql+=" and articleid not in("+lIds+")";
				sql+=" order by publisheddatefrom desc,modifieddate desc limit "+(4-listTinMoiNhat.size());
				ltmp=ArticleLocalServiceUtil.getArticleTheoSQL(sql);
				if(ltmp!=null && ltmp.size()>0){
					for(int i=0;i<ltmp.size();i++){
						listTinMoiNhat.add(ltmp.get(i));
					}
				}
			}
			String sqlNB = "select * from soft_cms_article where groupid="+themeDisplay.getScopeGroupId()+" and language='"+themeDisplay.getLanguageId()+"' and status=10 and isnoibat=true order by publisheddatefrom desc,modifieddate desc limit 4";
			List<Article> listTinNoiBat = ArticleLocalServiceUtil.getArticleTheoSQL(sqlNB);;
			renderRequest.setAttribute("listTinMoiNhat", listTinMoiNhat);
			renderRequest.setAttribute("listTinNoiBat", listTinNoiBat);
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}
	
}