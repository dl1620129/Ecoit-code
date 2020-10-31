<%@page import="com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ include file="init.jsp" %>
<%@page pageEncoding="utf-8" %>
<%
PortletPreferences preferences = renderRequest.getPreferences();
String portletResource = ParamUtil.getString(request, "portletResource");
if (Validator.isNotNull(portletResource)) {
	preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
}
String noiDung = GetterUtil.getString(preferences.getValue("noiDung",""));
if(!noiDung.equals("")){
%>
<%=noiDung%>
<%}else{ %>
<div class="header-middle">
	<div class="container position-relative">
		<div class="row">
			<a href="${site_default_url}" class="logo col-sm-2"><img src="<%=themeDisplay.getLayoutSetLogo() %>" alt=""></a>
				<div class="slogan col-sm-8">
						<h3>Cục công nghệ thông tin</h3>
						<h1>Bộ công an</h1>
						<h4 class="superme">Information technology department - ministry of public security vietnam</h4>
				</div>
			<div class="header-search position-absolute col-sm-2">
				<p><a href="/hoi-dap">Hỏi đáp</a> | <a href="">English</a></p>
				<form action="/search" class="form-search-header">
					<input class="search-ip" type="search" placeholder="Tìm kiếm" name="keyword" aria-label="Search">
					<button type="submit"><i class="icon-search"></i></button>
				</form>
			</div>
		</div>
	</div>
</div>
<%}%>