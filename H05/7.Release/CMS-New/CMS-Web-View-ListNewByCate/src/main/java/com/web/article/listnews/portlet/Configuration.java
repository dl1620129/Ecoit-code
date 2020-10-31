package com.web.article.listnews.portlet;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.web.article.listnews.constants.ListNewByCategoryPortletKeys;

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
	    "com.web.article.listnews.portlet.ListNewsCateConfiguration",
        configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
        property = {
            "javax.portlet.name=" + ListNewByCategoryPortletKeys.LISTNEWBYCATEGORY,
        },
        service = ConfigurationAction.class
    )
public class Configuration extends DefaultConfigurationAction{
	@Override
    public String getJspPath(HttpServletRequest request) {
		return "/ListNewCate/config.jsp";
	}
	@Override
    public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setAttribute(ListNewsCateConfiguration.class.getName(), _configuration);
        
        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }

    @Override
    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {
    	String portletResource = ParamUtil.getString(actionRequest, Constants.CMD);
    	String type = HtmlUtil.escape(ParamUtil.getString(actionRequest, "type",""));
    	String hien_thi_theo_thong_bao = ParamUtil.getString(actionRequest, "hien_thi_theo_thong_bao");
		String cau_hinh_trang_chi_tiet = ParamUtil.getString(actionRequest, "cau_hinh_trang_chi_tiet");
		String hien_thi_theo_thong_bao_theo_slide = ParamUtil.getString(actionRequest, "hien_thi_theo_thong_bao_theo_slide");
		String hien_thi_theo_dang_tabs = ParamUtil.getString(actionRequest, "hien_thi_theo_dang_tabs");
		String day_bai_viet_thong_bao_len_menu = ParamUtil.getString(actionRequest, "day_bai_viet_thong_bao_len_menu","false");
		String categorySelect = ParamUtil.getString(actionRequest, "categorySelect", "");
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		prefs.setValue("type", type);
		prefs.setValue("categorySelect", categorySelect);
		prefs.setValue("cau_hinh_trang_chi_tiet", cau_hinh_trang_chi_tiet);
		prefs.setValue("hien_thi_theo_thong_bao", hien_thi_theo_thong_bao);
		prefs.setValue("hien_thi_theo_thong_bao_theo_slide", hien_thi_theo_thong_bao_theo_slide);
		prefs.setValue("hien_thi_theo_dang_tabs", hien_thi_theo_dang_tabs);
		prefs.setValue("day_bai_viet_thong_bao_len_menu", day_bai_viet_thong_bao_len_menu);
		prefs.store();
		SessionMessages.add(actionRequest,"potletConfigSaved");
		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
    }

    private volatile ListNewsCateConfiguration _configuration;
}
