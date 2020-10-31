<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page pageEncoding="utf-8" %>
<%@ include file="init.jsp"%>
<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL" />
<%
PortletPreferences prefs = renderRequest.getPreferences();
String noiDung = prefs.getValue("noiDung", "");
%>
<aui:form action="${configurationActionURL}" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="${configurationRenderURL}" />
	<aui:fieldset cssClass="sheet sheet-lg">
		<h3 class="sheet-subtitle">Nhập nội dung footer</h3>
		<aui:row>
			<aui:col md="12">
				<liferay-ui:input-editor  contents="Nội dung" name="noiDung" initMethod="initEditorContent" />
				<script type="text/javascript">
					function <portlet:namespace />initEditorContent() { return "<%= UnicodeFormatter.toString(noiDung) %>"; }
				</script>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col md="12">
			</aui:col>
		</aui:row>
		
	</aui:fieldset>
	 <aui:button-row>
        <aui:button cssClass="btn-lg btn btn-primary" type="submit" value="Ghi lại"/>
    </aui:button-row>
</aui:form>


