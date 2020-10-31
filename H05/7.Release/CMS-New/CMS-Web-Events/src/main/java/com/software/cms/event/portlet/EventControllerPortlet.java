package com.software.cms.event.portlet;

import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.event.constants.EventControllerPortletKeys;
import com.software.cms.model.Event;
import com.software.cms.model.Logger;
import com.software.cms.service.EventLocalServiceUtil;
import com.software.cms.service.LoggerLocalServiceUtil;

/**
 * @author Admin
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Manager CMS",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=EventController",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + EventControllerPortletKeys.EVENTCONTROLLER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class EventControllerPortlet extends MVCPortlet {
	public void doEventAction(ActionRequest request, ActionResponse response) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		long eventId = ParamUtil.getLong(request, "eventId");
		String redirect =  ParamUtil.getString(request, "backurl","");
		String eventName =  HtmlUtil.escape(ParamUtil.getString(request, "eventName"));
		String description =  HtmlUtil.escape(ParamUtil.getString(request, "description"));
		try {
			if(eventId == -1) {
				Event event = EventLocalServiceUtil.createEvent(0);
				event.setEventName(eventName);
				event.setDescription(description);
				event.setLanguage(themeDisplay.getLocale().toString());
				event.setGroupId(themeDisplay.getScopeGroupId());
				event = EventLocalServiceUtil.addEvent(event);
				addLogger(request, response, event, themeDisplay, 0);
				SessionMessages.add(request, "addSuccess");
			}else {
				Event event = EventLocalServiceUtil.getEvent(eventId);
				event.setEventName(eventName);
				event.setDescription(description);
				event.setLanguage(themeDisplay.getLocale().toString());
				event.setGroupId(themeDisplay.getScopeGroupId());
				event = EventLocalServiceUtil.updateEvent(event);
				addLogger(request, response, event, themeDisplay, 1);
				SessionMessages.add(request, "editSuccess");
			}
			if(!redirect.equals(""))response.sendRedirect(redirect);
		} catch (Exception e) {
			SessionErrors.add(request, "noEventError");
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}
		
	}
	public void doDeleteEvent(ActionRequest request, ActionResponse response) throws Exception{
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		String redirect = ParamUtil.getString(request, "backurl");
		Long id = ParamUtil.getLong(request, "eventId");
		Event event = EventLocalServiceUtil.getEvent(id);
		addLogger(request, response, event, themeDisplay, 2);
		EventLocalServiceUtil.deleteEvent(event);
		if(!redirect.equals(""))response.sendRedirect(redirect);
	}
	private void addLogger(ActionRequest request, ActionResponse response, Event event, ThemeDisplay themeDisplay, int userAction)throws Exception{
		Logger logger = LoggerLocalServiceUtil.createLogger(0);
		logger = LoggerLocalServiceUtil.addLogger(logger);
		logger.setLoggerId(CounterLocalServiceUtil.increment(Logger.class.getName()));
		logger.setUserId(themeDisplay.getUserId());
		logger.setLanguage(themeDisplay.getLocale().toString());
		logger.setGroupId(themeDisplay.getScopeGroupId());
		logger.setCreatedDate(new Date());
		//logger.setType(String.valueOf(RoleConstants.EDIT_EVENT));
		logger.setType("");
		switch (userAction) {
		case 0: //add 
			logger.setDescription(LanguageUtil.get( themeDisplay.getLocale(), "soft.cms.manage.event.logger.add")+" "+event.getEventName());
			break;
		case 1: //edit 
			logger.setDescription(LanguageUtil.get( themeDisplay.getLocale(), "soft.cms.manage.event.logger.edit")+" "+event.getEventName());
			break;
		case 2: //delete 
			logger.setDescription(LanguageUtil.get( themeDisplay.getLocale(), "soft.cms.manage.event.logger.delete")+" "+event.getEventName());
			break;
		default:
			break;
		}
		LoggerLocalServiceUtil.addLogger(logger);
	}
}