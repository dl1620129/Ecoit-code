package CMS.Web.Tag.portlet;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletConfig;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.model.Logger;
import com.software.cms.model.Tag;
import com.software.cms.service.LoggerLocalServiceUtil;
import com.software.cms.service.TagLocalServiceUtil;
import com.software.util.RoleConstants;

import CMS.Web.Tag.constants.CMSWebTagPortletKeys;

/**
 * @author Admin
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Manager CMS",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CMSWebTag",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/tag/view.jsp",
		"javax.portlet.name=" + CMSWebTagPortletKeys.CMSWEBTAG,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CMSWebTagPortlet extends MVCPortlet {
	public void doEditTag(ActionRequest request, ActionResponse response) {
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			long tagid = ParamUtil.getLong(request, "tagid", -1);
			String name = HtmlUtil.escape(ParamUtil.getString(request, "tagname"));
			String tagdesc = HtmlUtil.escape(ParamUtil.getString(request, "tagdesc"));
			Tag tag = null;
			if(tagid == -1) {
				 tag = TagLocalServiceUtil.createTag(0);
				 tag.setTagName(name);
				 tag = TagLocalServiceUtil.addTag(tag);
				 Logger logger = LoggerLocalServiceUtil.createLogger(0);
				 logger = LoggerLocalServiceUtil.addLogger(logger);
				 addLogger(request, response, tag, themeDisplay, logger, "add");
			}else {
				 tag = TagLocalServiceUtil.getTag(tagid);
				 tag.setTagName(name);
				 TagLocalServiceUtil.updateTag(tag);
				 Logger logger = LoggerLocalServiceUtil.createLogger(0);
				 logger = LoggerLocalServiceUtil.addLogger(logger);
				 addLogger(request, response, tag, themeDisplay, logger, "edit");
			}
			boolean hople = false;
			if (Validator.isNotNull(name)) {
				tag.setTagName(name);
				tag.setDescription(tagdesc);
				tag.setLanguage(themeDisplay.getLanguageId());
				tag.setGroupId(themeDisplay.getScopeGroupId());
				tag = TagLocalServiceUtil.updateTag(tag);
				hople = true;
			} else {
				SessionErrors.add(request, "error_name");
			}
			if (!hople) {// Name = null
				String curl = ParamUtil.getString(request, "curl");
				response.sendRedirect(curl);
			} else {
				String backurl = ParamUtil.getString(request, "backurl");
				response.sendRedirect(backurl);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void doDeleteTag(ActionRequest request, ActionResponse response)
			throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long id = ParamUtil.getLong(request, "tagid");
		Tag tag = TagLocalServiceUtil.getTag(id);
		TagLocalServiceUtil.deleteTag(id);
		Logger logger = LoggerLocalServiceUtil.createLogger(0);
		logger = LoggerLocalServiceUtil.addLogger(logger);
		addLogger(request, response, tag, themeDisplay, logger, "delete");
		response.sendRedirect(ParamUtil.getString(request, "backurl"));
		SessionMessages.add(request, "DELETE_TAG_OK");
	}
	
	public void addLogger(ActionRequest request,ActionResponse response,Tag tag, ThemeDisplay themeDisplay,Logger logger,String action)throws Exception{
		PortletConfig portletConfig = (PortletConfig) request.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);
		logger.setLoggerId(CounterLocalServiceUtil.increment(Logger.class.getName()));
		logger.setUserId(themeDisplay.getUserId());
		logger.setLanguage(themeDisplay.getLocale().toString());
		logger.setGroupId(themeDisplay.getScopeGroupId());
		logger.setCreatedDate(new Date());
		logger.setType(String.valueOf(RoleConstants.EDIT_TAGS));
		
		if(action.equals("add")) 
			logger.setDescription(
					LanguageUtil.get(themeDisplay.getLocale(), "soft.cms.manage.tag.logger.added")+" : "+tag.getTagName());
		else if(action.equals("edit")) 
			logger.setDescription(
					LanguageUtil.get(themeDisplay.getLocale(), "soft.cms.manage.tag.logger.edited")+" : "+tag.getTagName());
		else if(action.equals("delete")) 
			logger.setDescription(LanguageUtil.get(themeDisplay.getLocale(), "soft.cms.manage.tag.logger.deleted")+" : "+tag.getTagName());
			
		LoggerLocalServiceUtil.addLogger(logger);
	}
}