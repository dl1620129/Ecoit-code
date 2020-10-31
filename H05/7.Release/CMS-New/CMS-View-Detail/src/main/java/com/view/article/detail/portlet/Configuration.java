package com.view.article.detail.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.software.cms.model.Article;
import com.software.cms.service.ArticleLocalServiceUtil;
import com.software.util.NewsWorkflowConstants;
import com.view.article.detail.constants.DetailControllerPortletKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

@Component(
		configurationPid =
	    "com.view.article.detail.portlet.DetailConfiguration",
        configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
        property = {
            "javax.portlet.name=" + DetailControllerPortletKeys.DETAILCONTROLLER,
        },
        service = ConfigurationAction.class
    )
public class Configuration extends DefaultConfigurationAction{
	@Override
    public String getJspPath(HttpServletRequest request) {
		return "/config.jsp";
	}
	@Override
    public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setAttribute(DetailConfiguration.class.getName(), _configuration);
        
        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }

	@Override
    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {
    	String portletResource = ParamUtil.getString(actionRequest, Constants.CMD);
    	String artcleSelect = HtmlUtil.escape(ParamUtil.getString(actionRequest,"artcleSelect", ""));
		String categorySelect = HtmlUtil.escape(ParamUtil.getString(actionRequest, "categorySelect", ""));
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		prefs.setValue("artcleSelect", artcleSelect);
		prefs.setValue("categorySelect", categorySelect);
		prefs.store();
		SessionMessages.add(actionRequest,"potletConfigSaved");
		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
    }
    
    
    private volatile DetailConfiguration _configuration;
}
