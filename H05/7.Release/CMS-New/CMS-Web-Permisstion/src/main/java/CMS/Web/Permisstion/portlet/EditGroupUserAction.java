package CMS.Web.Permisstion.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.service.PermissionGroupLocalServiceUtil;

import CMS.Web.Permisstion.constants.CMSWebPermisstionPortletKeys;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + CMSWebPermisstionPortletKeys.CMSWEBPERMISSTION,
	        "mvc.command.name=/permission/edit_group"
	    },
	    service = MVCActionCommand.class
	)
public class EditGroupUserAction extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String redirect = ParamUtil.getString(request, "backurl","/");
		long groupUserId = ParamUtil.getLong(request, "groupUserId", -1);		
		String groupName = HtmlUtil.escape(ParamUtil.getString(request, "groupName",""));
		String description = HtmlUtil.escape(ParamUtil.getString(request, "description",""));
    	String[] users = ParamUtil.getParameterValues(request, "users");
    	String permissions[] = ParamUtil.getParameterValues(request, "permissions");
    	String categories[] = ParamUtil.getParameterValues(request,"checked-category");
    	try {
    		PermissionGroupLocalServiceUtil.doAddGroupUser(themeDisplay, groupUserId, groupName, description, users, permissions, categories);
			response.sendRedirect(redirect);
		} catch (Exception e) {
			e.printStackTrace();
			SessionErrors.add(request, "article-manage-permission-arror");
			response.sendRedirect(ParamUtil.getString(request, "currentURL","/"));
		}
		
	}

}
