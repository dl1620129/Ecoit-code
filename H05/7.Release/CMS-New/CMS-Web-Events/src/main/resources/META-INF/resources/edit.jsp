<%@page import="com.software.cms.service.EventLocalServiceUtil"%>
<%@page import="com.software.cms.model.Event"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="init.jsp"%>
<%@page pageEncoding="utf-8" %>
<portlet:defineObjects />  
<liferay-theme:defineObjects />   

<liferay-ui:error key="error_name" message="ecoit.message.name" />

<%
	long eventId = ParamUtil.getLong(request, "eventId",-1);
	String eventName = "";
	String eventDesc = "";
	if(eventId > 0){
		Event event = EventLocalServiceUtil.getEvent(eventId);
		eventName = event.getEventName();
		eventDesc = event.getDescription();
	}
	request.setAttribute("backurl", ParamUtil.getString(request, "backURL"));
%>

<portlet:actionURL var="editEventAction" name="doEventAction">
	<portlet:param name="eventId" value="<%=String.valueOf(eventId)%>" />
	<portlet:param name="curl" value="<%=themeDisplay.getURLCurrent()%>" />	
	<portlet:param name="backurl" value="${param.backurl}" />
</portlet:actionURL>

<aui:form method="post" action="${editEventAction}">
	<aui:fieldset>
		<aui:fieldset-group>
			<h3 class="sheet-subtitle">Thông tin Sự kiện</h3>
			<aui:row>
		          <aui:col width="100">
		              <aui:input type="text" required="<%=true %>" name="eventName"
						label="Tên sự kiện" id="eventName" value="<%=HtmlUtil.extractText(eventName)%>">
						<aui:validator name="required"
							errorMessage="Vui lòng nhập tên sự kiện"></aui:validator>
						<aui:validator name="maxLength" >300</aui:validator>
					  </aui:input>
				  </aui:col>
	          </aui:row>
	          <aui:row>
		          <aui:col width="100">
		              <aui:input type="textarea" name="description" label="Mô tả" 
		              		id="description" placeholder="description" value="<%=HtmlUtil.extractText(eventDesc)%>">
		              		<aui:validator name="maxLength" >500</aui:validator>
		              </aui:input>
		         </aui:col>
	         </aui:row>
		</aui:fieldset-group>
	</aui:fieldset>
    <aui:button-row>
		<aui:button type="submit" value="Lưu"  icon="icon-save"></aui:button>
		<aui:button href="${param.backurl}" type="button" value="Quay lại" icon="icon-repeat"></aui:button>
	</aui:button-row>
</aui:form>