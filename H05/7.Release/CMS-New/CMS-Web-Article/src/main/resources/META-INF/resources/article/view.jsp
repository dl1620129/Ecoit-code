
<%@page import="com.software.cms.article.portlet.ConfigUtil"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ include file="../init.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<portlet:defineObjects />  
<liferay-theme:defineObjects />

<%
PortletPreferences prefs = renderRequest.getPreferences();
String portletResource = ParamUtil.getString(request, "portletResource");
if (Validator.isNotNull(portletResource)) {
	try {
		prefs = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	} catch (PortalException e) {
		
	}
}
String type = GetterUtil.getString(prefs.getValue("type", ""));
if (type.equals(ConfigUtil.THONG_TIN)) {
	%>
	<jsp:include page="/article/information/view.jsp"></jsp:include>
	<%
}
if (type.equals(ConfigUtil.BAI_VIET) || type.equals(ConfigUtil.BAI_VIET_NHAP) || type.equals(ConfigUtil.BAI_VIET_CHO_DUYET) 
		|| type.equals(ConfigUtil.BAI_VIET_DA_DUYET) || type.equals(ConfigUtil.BAI_VIET_DA_XUAT_BAN) || type.equals(ConfigUtil.BAI_VIET_HUY_DUYET) 
		|| type.equals(ConfigUtil.BAI_VIET_HUY_XUAT_BAN)) {
	%>
	<jsp:include page="/article/article_result.jsp"></jsp:include>
	<%
}
%>