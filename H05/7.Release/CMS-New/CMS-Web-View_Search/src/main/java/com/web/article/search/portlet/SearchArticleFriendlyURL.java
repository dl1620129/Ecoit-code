package com.web.article.search.portlet;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;
import com.web.article.search.constants.SearchArticleControllerPortletKeys;

import org.osgi.service.component.annotations.Component;

@Component(
		 property = {
		 "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
		 "javax.portlet.name="+SearchArticleControllerPortletKeys.SEARCHARTICLECONTROLLER
		 },
		 service = FriendlyURLMapper.class
		 )
public class SearchArticleFriendlyURL extends DefaultFriendlyURLMapper{
	@Override
	 public String getMapping() {
	 return "tim-kiem";
	 }

}
