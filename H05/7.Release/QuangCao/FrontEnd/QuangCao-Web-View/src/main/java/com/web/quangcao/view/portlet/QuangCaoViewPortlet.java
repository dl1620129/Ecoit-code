package com.web.quangcao.view.portlet;

import com.web.quangcao.view.constants.QuangCaoViewPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author dorem
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=Advertisement View",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=QuangCaoView",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/QuangCao/view.jsp",
		"javax.portlet.name=" + QuangCaoViewPortletKeys.QUANGCAOVIEW,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class QuangCaoViewPortlet extends MVCPortlet {
}