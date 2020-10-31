package com.web.quangcao.manager.portlet;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.model.DLFolder;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.web.ecoit.portal.quangcao.model.QuangCao;
import com.web.ecoit.portal.quangcao.service.QuangCaoLocalServiceUtil;
import com.web.quangcao.manager.constants.QuangCaoManagerPortletKeys;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.FileNameMap;
import java.net.URLConnection;
import java.util.Date;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author dorem
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=manager_advertisement",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=QuangCaoManager",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/manager/view.jsp",
		"javax.portlet.name=" + QuangCaoManagerPortletKeys.QUANGCAOMANAGER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class QuangCaoManagerPortlet extends MVCPortlet {
	public void editQuangCao(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		UploadPortletRequest upload = PortalUtil.getUploadPortletRequest(actionRequest);
		long quangCaoId = ParamUtil.getLong(actionRequest, "quangCaoId", -1);
		String tenQuangCao = HtmlUtil.escape(ParamUtil.getString(actionRequest, "tenQuangCao", ""));
		String moTa =  HtmlUtil.escape(ParamUtil.getString(actionRequest, "moTa", ""));
		boolean target = ParamUtil.getBoolean(actionRequest, "target", false);
		String url =  HtmlUtil.escapeURL(ParamUtil.getString(actionRequest, "urlQuangCao", ""));
		String backurl =  ParamUtil.getString(actionRequest, "backurl", "");
		String curl =  ParamUtil.getString(actionRequest, "curl", "");
		boolean isShow = ParamUtil.getBoolean(actionRequest, "isShow", true);
		int status = QuangCaoManagerPortletKeys.QUANGCAO_STATUS_SHOW;
		long imageId = 0;
		try {
			imageId = FileUtils.uploadGuest(upload, actionRequest, actionResponse, "imageId", "Image_Quang_Cao").getFileEntryId();
		} catch (Exception e) {
			imageId = 0;
		}
		System.out.println("imageId: "+imageId);
		if(!isShow)status = QuangCaoManagerPortletKeys.QUANGCAO_STATUS_HIDE;
		try {
			if(quangCaoId == -1) {
				long qCId = CounterLocalServiceUtil.increment(QuangCao.class.getName());
				QuangCao quangCao = QuangCaoLocalServiceUtil.createQuangCao(0);
				quangCao.setQuangCaoId(qCId);
				quangCao.setTenQuangCao(tenQuangCao);
				quangCao.setImageId(imageId);
				quangCao.setMoTa(moTa);
				quangCao.setUrl(url);
				quangCao.setTarget(target);
				quangCao.setGroupId(themeDisplay.getScopeGroupId());
				quangCao.setCreateDate(new Date());
				quangCao.setLanguage(themeDisplay.getLanguageId());
				quangCao.setUserId(themeDisplay.getUserId());
				quangCao.setStatus(status);
				QuangCaoLocalServiceUtil.addQuangCao(quangCao);
			}else {
				QuangCao quangCao = QuangCaoLocalServiceUtil.getQuangCao(quangCaoId);
				if(imageId > 0) {
					if(quangCao.getImageId() > 0) {
						FileUtils.XoaFile(quangCao.getImageId());
					}
					quangCao.setImageId(imageId);
				}
				quangCao.setTenQuangCao(tenQuangCao);
				quangCao.setMoTa(moTa);
				quangCao.setUrl(url);
				quangCao.setTarget(target);
				quangCao.setModifiedDate(new Date());
				quangCao.setGroupId(themeDisplay.getScopeGroupId());
				quangCao.setLanguage(themeDisplay.getLanguageId());
				quangCao.setStatus(status);
				QuangCaoLocalServiceUtil.updateQuangCao(quangCao);
			}
			if(!backurl.equals(""))actionResponse.sendRedirect(backurl);
		} catch (Exception e) {
			if(!curl.equals(""))actionResponse.sendRedirect(curl);
		}
	}
	public void DeleteQuangCao(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String backurl =  ParamUtil.getString(actionRequest, "backurl", "");
		long quangCaoId = ParamUtil.getLong(actionRequest, "quangCaoId", -1);
		if(quangCaoId > 0) {
			try {
				QuangCao quangCao = QuangCaoLocalServiceUtil.getQuangCao(quangCaoId);
				if(quangCao.getImageId() > 0) {
					FileUtils.XoaFile(quangCao.getImageId());
				}
				QuangCaoLocalServiceUtil.deleteQuangCao(quangCao);
			} catch (PortalException e) {
				
			}
			if(!backurl.equals(""))actionResponse.sendRedirect(backurl);
		}
	}
	public void deleteImageQuangCao(ActionRequest actionRequest, ActionResponse actionResponse) {
		long quangCaoId = ParamUtil.getLong(actionRequest, "quangCaoId", -1);
		long imageId = ParamUtil.getLong(actionRequest, "imageId", -1);
		if(quangCaoId > 0 && imageId > 0) {
			try {
				QuangCao quangCao = QuangCaoLocalServiceUtil.getQuangCao(quangCaoId);
				if(quangCao.getImageId() == imageId) {
					FileUtils.XoaFile(imageId);
					quangCao.setImageId(0);
					QuangCaoLocalServiceUtil.updateQuangCao(quangCao);
				}
			} catch (Exception e) {
			}
		}
	}
}