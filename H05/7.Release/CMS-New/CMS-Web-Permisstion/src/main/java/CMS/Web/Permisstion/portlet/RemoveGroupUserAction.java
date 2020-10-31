package CMS.Web.Permisstion.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.service.GroupCategoryLocalServiceUtil;
import com.software.cms.service.GroupUserLocalServiceUtil;
import com.software.cms.service.GroupUserUsersLocalServiceUtil;
import com.software.cms.service.PermissionGroupLocalServiceUtil;

import CMS.Web.Permisstion.constants.CMSWebPermisstionPortletKeys;

@Component(
	    immediate = true,
	    property = {
	        "javax.portlet.name=" + CMSWebPermisstionPortletKeys.CMSWEBPERMISSTION,
	        "mvc.command.name=/permission/remove_group"
	    },
	    service = MVCActionCommand.class
	)
public class RemoveGroupUserAction extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest request, ActionResponse response) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long groupUserId = ParamUtil.getLong(request, "groupUserId",0);
		try {
			//GroupUser groupUser = GroupUserLocalServiceUtil.getGroupUser(groupUserId);
			GroupUserLocalServiceUtil.deleteGroupUser(groupUserId);
			GroupUserUsersLocalServiceUtil.removeByGroup_GroupUser(themeDisplay.getScopeGroupId(), groupUserId);
			GroupCategoryLocalServiceUtil.removeByGroupUserId(groupUserId);
			PermissionGroupLocalServiceUtil.removeByGroup_GroupUser(themeDisplay.getScopeGroupId(), groupUserId);
			//addLogger("remove", themeDisplay, groupUser, null, null, null,request);
		} catch (Exception e) {
			e.printStackTrace();
		}
		response.sendRedirect(ParamUtil.getString(request, "backURL","/"));
	}
}
