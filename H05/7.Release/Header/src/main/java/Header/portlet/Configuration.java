package Header.portlet;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;


import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import Header.constants.HeaderPortletKeys;

@Component(
		configurationPid =
	    "Footer.portlet.FooterConfig",
        configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
        property = {
        "javax.portlet.name=" + HeaderPortletKeys.HEADER,
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
        httpServletRequest.setAttribute(HeaderConfig.class.getName(), _configuration);
        
        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }

    @Override
    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {
    	String portletResource = ParamUtil.getString(actionRequest, Constants.CMD);
    	String noiDung = ParamUtil.getString(actionRequest, "noiDung");
		String testLi = ParamUtil.getString(actionRequest, "testLi");
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		prefs.setValue("noiDung", noiDung);
		prefs.setValue("testLi", testLi);
		prefs.store();
		SessionMessages.add(actionRequest,"potletConfigSaved");
		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
    }
    

    private volatile HeaderConfig _configuration;
}
