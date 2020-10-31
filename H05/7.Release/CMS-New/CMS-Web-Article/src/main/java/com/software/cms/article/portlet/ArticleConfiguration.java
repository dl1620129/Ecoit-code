package com.software.cms.article.portlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;

import com.liferay.portal.kernel.portlet.ConfigurationAction;
import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.software.cms.article.constants.ArticleActionPortletKeys;

@Component(
		configurationPid =
	    "com.software.cms.article.portlet.ArtConfiguration",
        configurationPolicy = ConfigurationPolicy.OPTIONAL, immediate = true,
        property = {
            "javax.portlet.name=" + ArticleActionPortletKeys.ARTICLEACTION,
        },
        service = ConfigurationAction.class
    )
public class ArticleConfiguration extends DefaultConfigurationAction{
	@Override
    public String getJspPath(HttpServletRequest request) {
		request.setAttribute("THONG_TIN", ConfigUtil.THONG_TIN);
		request.setAttribute("BAI_VIET", ConfigUtil.BAI_VIET);
		request.setAttribute("QUAN_LY_CHUNG", ConfigUtil.QUAN_LY_CHUNG);
		request.setAttribute("THONG_KE", ConfigUtil.THONG_KE);
		request.setAttribute("PHAN_QUYEN", ConfigUtil.PHAN_QUYEN);
		request.setAttribute("NHAT_KY_HE_THONG", ConfigUtil.NHAT_KY_HE_THONG);
		request.setAttribute("BAI_VIET_NHAP", ConfigUtil.BAI_VIET_NHAP);
		request.setAttribute("BAI_VIET_CHO_DUYET", ConfigUtil.BAI_VIET_CHO_DUYET);
		request.setAttribute("BAI_VIET_DA_DUYET", ConfigUtil.BAI_VIET_DA_DUYET);
		request.setAttribute("BAI_VIET_DA_XUAT_BAN", ConfigUtil.BAI_VIET_DA_XUAT_BAN);
		request.setAttribute("BAI_VIET_XEM_THEO_CHUYEN_MUC_CHO_DUYET", ConfigUtil.BAI_VIET_XEM_THEO_CHUYEN_MUC_CHO_DUYET);
		request.setAttribute("BAI_VIET_XEM_THEO_CHUYEN_MUC_DA_DUYET", ConfigUtil.BAI_VIET_XEM_THEO_CHUYEN_MUC_DA_DUYET);
		request.setAttribute("BAI_VIET_XEM_THEO_CHUYEN_MUC", ConfigUtil.BAI_VIET_XEM_THEO_CHUYEN_MUC);
		request.setAttribute("BAI_VIET_HUY_DUYET", ConfigUtil.BAI_VIET_HUY_DUYET);
		request.setAttribute("BAI_VIET_HUY_XUAT_BAN", ConfigUtil.BAI_VIET_HUY_XUAT_BAN);
		request.setAttribute("BAI_VIET_BINH_LUAN", ConfigUtil.BAI_VIET_BINH_LUAN);
		request.setAttribute("QUAN_LY_CHUYEN_MUC", ConfigUtil.QUAN_LY_CHUYEN_MUC);
		request.setAttribute("QUAN_LY_DONG_SU_KIEN", ConfigUtil.QUAN_LY_DONG_SU_KIEN);
		request.setAttribute("QUAN_LY_TAGS", ConfigUtil.QUAN_LY_TAGS);
		request.setAttribute("THONG_KE_BAI_VIET", ConfigUtil.THONG_KE_BAI_VIET);
		request.setAttribute("THONG_KE_THEO_NGUOI_DUNG", ConfigUtil.THONG_KE_THEO_NGUOI_DUNG);
		request.setAttribute("THONG_KE_THEO_CHUYEN_MUC", ConfigUtil.THONG_KE_THEO_CHUYEN_MUC);
		return "/config/config.jsp";
	}
	@Override
    public void include(PortletConfig portletConfig, HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        httpServletRequest.setAttribute(ArtConfiguration.class.getName(), _configuration);
        
        super.include(portletConfig, httpServletRequest, httpServletResponse);
    }

    @Override
    public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
            throws Exception {
    	String portletResource = ParamUtil.getString(actionRequest, Constants.CMD);
    	String type = HtmlUtil.escape(ParamUtil.getString(actionRequest, "type",""));
		PortletPreferences prefs = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
		prefs.setValue("type", type);
		prefs.store();
		SessionMessages.add(actionRequest,"potletConfigSaved");
		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);
		SessionMessages.add(actionRequest, portletConfig.getPortletName()
				+ SessionMessages.KEY_SUFFIX_UPDATED_CONFIGURATION);
    }

    private volatile ArtConfiguration _configuration;
}
