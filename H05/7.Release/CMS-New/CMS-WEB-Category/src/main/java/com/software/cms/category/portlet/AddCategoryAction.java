package com.software.cms.category.portlet;


import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.category.constants.CategoryControllerPortletKeys;
import com.software.cms.model.Category;
import com.software.cms.model.MapCateLayout;
import com.software.cms.service.CategoryLocalService;
import com.software.cms.service.MapCateLayoutLocalServiceUtil;


@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + CategoryControllerPortletKeys.CATEGORYCONTROLLER,
	        "mvc.command.name=/category/add_category"
	    },
	    service = MVCActionCommand.class
	)
public class AddCategoryAction extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		
		int parentId = ParamUtil.getInteger(request, "parent-id", -1);
		long id = ParamUtil.getLong(request, "id", -1);
		String title = HtmlUtil.escape(ParamUtil.getString(request, "title",""));
		String description = HtmlUtil.escape(ParamUtil.getString(request, "description",""));
		int thuTu = ParamUtil.getInteger(request, "thuTu",1);
		long layoutId = ParamUtil.getLong(request, "layoutId", -1);
		String duongDan = ParamUtil.getString(request, "duongDan","#");
		String slink = ParamUtil.getString(request, "slink", "/");
		String flink = ParamUtil.getString(request, "flink", "/");
		String cmd = HtmlUtil.escape(ParamUtil.getString(request, "cmd",""));
		System.out.println("cmd: "+cmd);
		cmd = (cmd.equals("")?"add":cmd);
		Category category =_categoryService.prepCategory(themeDisplay, cmd, parentId, id, title, description, thuTu, duongDan);
		long categoryId = category.getCategoryId();
		MapCateLayout cateLayout = null;
		
		if(MapCateLayoutLocalServiceUtil.checkExits(categoryId, 2) <=0){
			try {
				cateLayout = MapCateLayoutLocalServiceUtil.createMapCateLayout(CounterLocalServiceUtil.increment(MapCateLayout.class.getName()));
				cateLayout = MapCateLayoutLocalServiceUtil.addMapCateLayout(cateLayout);
				cateLayout.setGroupId(themeDisplay.getScopeGroupId());
				cateLayout.setCategoryId(categoryId);
				cateLayout.setLayoutId(layoutId);
				cateLayout.setType(2);
				cateLayout = MapCateLayoutLocalServiceUtil.updateMapCateLayout(cateLayout);
			} catch (Exception ex) {
			}
		}
		boolean error = validateCategory(request,category);
		if(!error){	
			category = _categoryService.updateCategory(category);
			if(parentId > 0){
				Category cateChild = _categoryService.getCategory(parentId);
				if(cateChild.getCateChild().equals("")){
					cateChild.setCateChild(category.getCategoryId()+"");
				}else{
					cateChild.setCateChild(cateChild.getCateChild()+","+category.getCategoryId());
				}
				cateChild = _categoryService.updateCategory(cateChild);
			}
			response.sendRedirect(slink);
		}else{
			response.sendRedirect(flink);
		}
	}
	
	@SuppressWarnings("static-access")
	private boolean validateCategory(ActionRequest request,Category category){
		Validator validator = new Validator();
		boolean error = false;
		if(validator.isNull(category.getCategoryId())){
			SessionErrors.add(request, "id-is-required");
			error = true;			
		}
		if(category.getParentId()<0){
			SessionErrors.add(request, "parent-is-required");
			error = true;						
		}
		if(validator.isNull(category.getTitle())){
			SessionErrors.add(request, "title-is-required");
			error = true;
		}
		if(validator.isNull(category.getThuTu())){
			SessionErrors.add(request, "thuTu-is-required");
			error = true;
		}
		return error;
	}
	
	@Reference(unbind = "-")
	protected void setCategoryService(CategoryLocalService categoryService) {
		_categoryService = categoryService;
	}
	private CategoryLocalService _categoryService;
}
