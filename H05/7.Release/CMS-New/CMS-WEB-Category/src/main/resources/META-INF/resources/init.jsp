<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %><%@
taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %><%@
taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %><%@
taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@ page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@ page import="javax.portlet.PortletURL"%>
<%@ page import="javax.portlet.PortletPreferences"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Locale"%>
<%@ page import="java.util.Map"%>
<%@ page import="java.util.ResourceBundle"%>
<%@ page import="javax.portlet.WindowState"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ page import="javax.portlet.PortletPreferences"%>
<%@page import="com.liferay.taglib.search.ResultRow" %><%@
page import="com.liferay.taglib.search.SearchEntry" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%><%@
page import="com.liferay.taglib.aui.AUIUtil" %>
<%@page import="com.liferay.taglib.portlet.RenderURLTei"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.software.cms.service.GroupUserUsersLocalServiceUtil"%>
<%@page import="com.software.util.RoleConstants"%>
<%@page import="com.software.cms.service.GroupUserLocalServiceUtil"%>
<%@page import="com.software.cms.model.GroupUser"%>
<%@page import="com.software.util.PermissionUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.UserGroupRole"%>
<%@page import="com.liferay.portal.kernel.service.RoleLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<portlet:defineObjects />
<liferay-theme:defineObjects />
