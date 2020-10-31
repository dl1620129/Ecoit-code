package com.software.cms.category.portlet;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.category.constants.CategoryControllerPortletKeys;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.web.util.TreeCategory;


@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + CategoryControllerPortletKeys.CATEGORYCONTROLLER,
	       "mvc.command.name=/category/add_category"
	    },
	    service = MVCRenderCommand.class
	)
public class AddCategoryRender implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String title = "";
			String description = "";
			String sqlOrder = "SELECT coalesce(MAX(thutu),0) FROM soft_cms_category WHERE groupid ="+themeDisplay.getScopeGroupId()+" AND language = '"+themeDisplay.getLanguageId()+"' ";
			int thuTu = 1+ Integer.valueOf(String.valueOf(ArticleLocalServiceUtil.getDuLieuTheoSql(sqlOrder, QueryUtil.ALL_POS, QueryUtil.ALL_POS).get(0)));
			long idparent = 0;
			String rootCate = "";
			String backURL ="";
			
			backURL= ParamUtil.getString(renderRequest, "backURL", "/");
			
			rootCate = new TreeCategory().createCategoryTree(idparent,themeDisplay.getLanguageId(),themeDisplay.getScopeGroupId());
			
			renderRequest.setAttribute("title", title);
			renderRequest.setAttribute("description", description);
			renderRequest.setAttribute("thuTu", thuTu);
			renderRequest.setAttribute("rootCate", rootCate);
			renderRequest.setAttribute("backURL", backURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/category/edit.jsp";
	}

}
