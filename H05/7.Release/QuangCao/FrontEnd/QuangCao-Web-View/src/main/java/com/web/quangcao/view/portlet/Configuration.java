package com.web.quangcao.view.portlet;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.web.quangcao.view.constants.QuangCaoViewPortletKeys;


import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

@Component(
		configurationPid =
	    "com.web.article.newsbycategory.portlet.NewCateConfiguration",
        configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
        property = {
        "javax.portlet.name=" + QuangCaoViewPortletKeys.QUANGCAOVIEW,
        },
        service = ConfigurationAction.class
    )
public class Configuration extends DefaultConfigurationAction{
	@Override
    public String getJspPath(HttpServletRequest request) {
		return "/QuangCao/config.jsp";
	}
	@Override
    public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setAttribute(QuangCaoConfig.class.getName(), _configuration);
        
        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }

    @Override
    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {
    	String portletResource = ParamUtil.getString(actionRequest, Constants.CMD);
    	String isQuangCaoSlider = HtmlUtil.escape(ParamUtil.getString(actionRequest, "isQuangCaoSlider","false"));
		String quangCaoSelect = HtmlUtil.escape(ParamUtil.getString(actionRequest, "quangCaoSelect", ""));
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		prefs.setValue("quangCaoSelect", quangCaoSelect);
		prefs.setValue("isQuangCaoSlider", isQuangCaoSlider);
		prefs.store();
		SessionMessages.add(actionRequest,"potletConfigSaved");
		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
    }
    

    private volatile QuangCaoConfig _configuration;
}
