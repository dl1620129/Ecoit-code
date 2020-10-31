package com.software.cms.category.portlet;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.category.constants.CategoryControllerPortletKeys;
import com.software.cms.model.Category;
import com.software.cms.service.CategoryLocalService;
import com.web.util.TreeCategory;


@Component(
	    immediate = true,
	    property = {
	       "javax.portlet.name=" + CategoryControllerPortletKeys.CATEGORYCONTROLLER,
	       "mvc.command.name=/category/edit_category"
	    },
	    service = MVCRenderCommand.class
	)
public class EditCategoryRender implements MVCRenderCommand {

	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			long idCate = ParamUtil.getLong(renderRequest, "id-edit", -1);
			String title = "";
			String description = "";
			int thuTu = 0;
			long idparent = 0;
			String rootCate = "";
			String backURL ="";
			Category category = null;
			if(idCate <=0) {
				title="";
				description = "";
				thuTu = 0;
				idparent = 0;
			}else {
				category = _categoryService.getCategory(idCate);
				title = category.getTitle();
				description = category.getDescription();
				thuTu = category.getThuTu();
				idparent = category.getParentId();
			}
			backURL= ParamUtil.getString(renderRequest, "backURL", "/");
			rootCate = new TreeCategory().createCategoryTree(idparent,themeDisplay.getLanguageId(),themeDisplay.getScopeGroupId());
			renderRequest.setAttribute("idCate", idCate);
			renderRequest.setAttribute("title", HtmlUtil.extractText(title));
			renderRequest.setAttribute("description", HtmlUtil.extractText(description));
			renderRequest.setAttribute("thuTu", thuTu);
			renderRequest.setAttribute("rootCate", rootCate);
			renderRequest.setAttribute("backURL", backURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "/category/edit.jsp";
	}
	
	
	@Reference(unbind = "-")
	protected void setCategoryService(CategoryLocalService categoryService) {
		_categoryService = categoryService;
	}
	private CategoryLocalService _categoryService;
}
