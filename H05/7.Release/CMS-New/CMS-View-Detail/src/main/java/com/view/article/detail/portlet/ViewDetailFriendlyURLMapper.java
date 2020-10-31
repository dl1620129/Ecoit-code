package com.view.article.detail.portlet;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.LiferayPortletURL;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

import java.util.HashMap;
import java.util.Map;
public class ViewDetailFriendlyURLMapper extends DefaultFriendlyURLMapper {

	@Override
	public String buildPath(LiferayPortletURL liferayPortletURL) {
	Map<String, String> routeParameters = new HashMap<String, String>();

	buildRouteParameters(liferayPortletURL, routeParameters);

	String friendlyURLPath = router.parametersToUrl(routeParameters);

	if (Validator.isNull(friendlyURLPath)) {
	return null;
	}

	addParametersIncludedInPath(liferayPortletURL, routeParameters);

	friendlyURLPath = StringPool.SLASH.concat(getMapping()).concat(
	friendlyURLPath);

	return friendlyURLPath;
	}

	}