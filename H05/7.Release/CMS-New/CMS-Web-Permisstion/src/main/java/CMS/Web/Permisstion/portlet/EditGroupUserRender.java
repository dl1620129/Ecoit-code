package CMS.Web.Permisstion.portlet;

import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.model.GroupCategory;
import com.software.cms.model.GroupUser;
import com.software.cms.service.GroupCategoryLocalServiceUtil;
import com.software.cms.service.GroupUserLocalServiceUtil;
import com.web.util.TreeCategory;

import CMS.Web.Permisstion.constants.CMSWebPermisstionPortletKeys;

@Component(immediate = true, property = {
		"javax.portlet.name=" + CMSWebPermisstionPortletKeys.CMSWEBPERMISSTION,
		"mvc.command.name=/permission/edit" },
		service = MVCRenderCommand.class)
public class EditGroupUserRender implements MVCRenderCommand{
	@Override
	public String render(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupUserId = ParamUtil.getLong(renderRequest, "groupUserId", -1);
		long userId = themeDisplay.getUserId();
		long groupId=themeDisplay.getScopeGroupId();
		String language = themeDisplay.getLanguageId();
		String selected = "";
		GroupUser groupUser = null;
		String groupName = "";
		String description = "";
		String 	treeCate = "";
		if (groupUserId > 0) {
			try {
				groupUser = GroupUserLocalServiceUtil.getGroupUser(groupUserId);
				groupName = groupUser.getName();
				description = groupUser.getDescription();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		List<GroupCategory> results = GroupCategoryLocalServiceUtil.getByUserIdAndGroupIdAndGroupUserId(userId, groupId, groupUserId);
		
		if (results != null && results.size() > 0) {
			for (int k = 0; k < results.size(); k++) {
				if (selected.equals(""))
					selected = results.get(k).getCategoryId() + "";
				else
					selected += "," + results.get(k).getCategoryId();
			}
		}
		try {
			treeCate =  new TreeCategory().createCategoryTree(new long[] { 0 }, groupId, language, selected, "", 1,renderResponse.getNamespace(), renderRequest);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		renderRequest.setAttribute("groupName", groupName);
		renderRequest.setAttribute("description", description);
		renderRequest.setAttribute("treeCate", treeCate);
		return "/permission/edit.jsp";
	}
}
