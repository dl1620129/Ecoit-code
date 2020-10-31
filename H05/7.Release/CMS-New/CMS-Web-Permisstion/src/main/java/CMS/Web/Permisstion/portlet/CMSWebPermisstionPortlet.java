package CMS.Web.Permisstion.portlet;

import CMS.Web.Permisstion.constants.CMSWebPermisstionPortletKeys;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.model.GroupUser;
import com.software.cms.model.GroupUserUsers;
import com.software.cms.model.PermissionGroup;
import com.software.cms.service.GroupUserLocalServiceUtil;
import com.software.cms.service.GroupUserUsersLocalServiceUtil;
import com.software.cms.service.PermissionGroupLocalServiceUtil;
import com.software.cms.service.persistence.GroupUserUsersPK;
import com.software.cms.service.persistence.PermissionGroupPK;
import com.software.util.RoleConstants;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Admin
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Manager CMS",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CMSWebPermisstion",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/permission/view.jsp",
		"javax.portlet.name=" + CMSWebPermisstionPortletKeys.CMSWEBPERMISSTION,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CMSWebPermisstionPortlet extends MVCPortlet {
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		try{
			ThemeDisplay themeDisplay = (ThemeDisplay)renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			List<GroupUser> groups = null;
			ServiceContext serviceContext = ServiceContextFactory.getInstance(GroupUser.class.getName(), renderRequest);
			try {
				 groups = GroupUserLocalServiceUtil.findByGroup_Language(themeDisplay.getScopeGroupId(), themeDisplay.getLocale().toString());
			} catch (Exception e) {
				 groups = null;
			}
			if(groups.isEmpty()) {
				long groupUserId = CounterLocalServiceUtil.increment(GroupUser.class.getName());
				GroupUser groupUser = GroupUserLocalServiceUtil.createGroupUser(groupUserId);
				  groupUser.setName("Administrator");
				  groupUser.setGroupId(themeDisplay.getScopeGroupId());
				  groupUser.setLanguage(themeDisplay.getLanguageId());
				  groupUser.setExpandoBridgeAttributes(serviceContext); 
				  groupUser = GroupUserLocalServiceUtil.updateGroupUser(groupUser);
				  // create group user user
				  GroupUserUsersPK pk = new GroupUserUsersPK(groupUser.getGroupUserId(),themeDisplay.getUserId());
				  GroupUserUsers groupUserUsers = GroupUserUsersLocalServiceUtil.createGroupUserUsers(pk);
				  groupUserUsers.setGroupId(themeDisplay.getScopeGroupId());
				  GroupUserUsersLocalServiceUtil.updateGroupUserUsers(groupUserUsers);
				  // create permission 
				  PermissionGroupPK ppk = new PermissionGroupPK(RoleConstants.PERMISSION, groupUser.getGroupUserId());
				  PermissionGroup pgroup = PermissionGroupLocalServiceUtil.createPermissionGroup(ppk);
				  pgroup.setGroupId(themeDisplay.getScopeGroupId());
				  PermissionGroupLocalServiceUtil.updatePermissionGroup(pgroup);
				 
			}
		}catch(Exception ex){ex.printStackTrace();
			System.out.println(ex.toString());
		}
		super.doView(renderRequest, renderResponse);
	}
}