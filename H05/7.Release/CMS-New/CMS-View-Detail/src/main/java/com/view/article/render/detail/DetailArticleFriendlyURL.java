package com.view.article.render.detail;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.view.article.detail.constants.DetailControllerPortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(
		 property = {
		 "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
		 "javax.portlet.name="+DetailControllerPortletKeys.DETAILCONTROLLER
		 },
		 service = FriendlyURLMapper.class
		 )
public class DetailArticleFriendlyURL extends DefaultFriendlyURLMapper{
	@Override
	 public String getMapping() {
	 return "chi-tiet";
	 }
}
