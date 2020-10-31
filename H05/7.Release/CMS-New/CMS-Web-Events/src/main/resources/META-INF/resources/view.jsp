<%@page import="com.software.cms.model.Event"%>
<%@page import="com.software.cms.service.EventLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp"%>
<%@page pageEncoding="utf-8" %>
<portlet:defineObjects />  
<liferay-theme:defineObjects /> 
<c:choose>
	 <c:when test="<%=PermissionUtil.checkPermissionAccessZone(themeDisplay.getUserId(), RoleConstants.EDIT_EVENT,themeDisplay.getScopeGroupId()) %>"> 
	  
<%
PortletURL portletURL = renderResponse.createRenderURL();
String searchKey = HtmlUtil.escape(ParamUtil.getString(request, "searchKey", ""));
int delta = 20, count = 0, cur = 1, totalRecord = 0;
cur = ParamUtil.getInteger(request, "cur", 1);
delta = ParamUtil.getInteger(request, "delta", 20); 

String sql="select * from soft_cms_event where groupid="+themeDisplay.getScopeGroupId()+" and language='"+themeDisplay.getLanguageId()+"'";
String sqlCount = "select count(*) from soft_cms_event where groupid="+themeDisplay.getScopeGroupId()+" and language='"+themeDisplay.getLanguageId()+"'";
if(!searchKey.equals("")){
	sql += "AND LOWER(eventname) LIKE LOWER('%"+searchKey+"%') ";
	sqlCount += "AND LOWER(eventname) LIKE LOWER('%"+searchKey+"%') ";
}
totalRecord = EventLocalServiceUtil.getCountEvent(themeDisplay.getScopeGroupId(), themeDisplay.getLanguageId(), searchKey);
int totalPage = (totalRecord  % delta == 0)?  totalRecord /delta : totalRecord /delta+1;
if (totalRecord  == 0) totalPage = 0;
int start = delta*(cur-1);
int end = delta*cur;
if (end > totalRecord ) end = totalRecord ;
List<Event> listEvent = EventLocalServiceUtil.findEvent(themeDisplay.getScopeGroupId(), themeDisplay.getLanguageId(), searchKey, start, end);
SearchContainer searchContainerGU = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, delta, portletURL, null, "Không có dữ liệu!");
searchContainerGU.setResults(listEvent);
searchContainerGU.setTotal(totalRecord);
%>
<portlet:renderURL var="addEvent">
	<portlet:param name="mvcPath" value="/edit.jsp" />
	<portlet:param name="backurl" value="<%=themeDisplay.getURLCurrent() %>"/>
</portlet:renderURL>
<aui:fieldset-group markupView="lexicon">
	<aui:fieldset>
		<aui:form action="<%=portletURL.toString() %>" method="POST">
			<aui:row>
				<aui:col width="50">
					<aui:input id="search" type="text" name="searchKey" value="<%=HtmlUtil.extractText(searchKey) %>" placeholder="Từ khóa" label="" />	
				</aui:col>
				<aui:col width="50">
	       			<aui:button name="submitButton" type="submit" value="Tìm kiếm" />
	    		</aui:col>
    		</aui:row>
    		<liferay-ui:error key="noSearchKey" message="ecoit.cms.manage.event.message.noSearchKeyError"></liferay-ui:error>
    	</aui:form>
    	<aui:button-row>
			<aui:button cssClass="btn btn-primary" icon="icon-plus" value="Thêm mới" onClick="document.location='${addEvent}'" ></aui:button>
		</aui:button-row>
		<liferay-ui:search-container searchContainer="<%=searchContainerGU %>" >
				<liferay-ui:search-container-row className="com.software.cms.model.Event" 
												keyProperty="eventId" 
												modelVar="event">
				<liferay-security:permissionsURL modelResource="<%= Event.class.getName() %>"
												modelResourceDescription="<%= themeDisplay.getScopeGroupName() %>"
												resourcePrimKey="${event.getEventId()}" var="permission" />
					<liferay-ui:search-container-column-text name="STT" value="<%= Integer.toString(searchContainer.getStart() + (++count))%>" cssClass="w5"/>							
					<liferay-ui:search-container-column-text name="Tên Sự kiện" property="eventName" />
					
					<liferay-ui:search-container-column-text name="Mô tả" property="description" />
					
					<liferay-ui:search-container-column-text name="Hành động" cssClass="w15">
						<portlet:renderURL var="editEvent">
							<portlet:param name="mvcPath" value="/edit.jsp" />
							<portlet:param name="backurl" value="<%=themeDisplay.getURLCurrent() %>"/>
							<portlet:param name="eventId" value="${event.getEventId()}"/>
						</portlet:renderURL>
						<portlet:actionURL var="deleteEvent" name="doDeleteEvent">
							<portlet:param name="backurl" value="<%=themeDisplay.getURLCurrent() %>"/>
							<portlet:param name="eventId" value="${event.getEventId()}"/>
						</portlet:actionURL>
						
						<liferay-ui:icon-menu message="Hành động" >
							<liferay-ui:icon image="edit" message="Sửa" url="${editEvent}" />
							<liferay-ui:icon-delete image="delete" message="Xóa" url="${deleteEvent}"/>
						</liferay-ui:icon-menu>
					</liferay-ui:search-container-column-text>
				</liferay-ui:search-container-row>
			<liferay-ui:search-iterator/>
			</liferay-ui:search-container>
	</aui:fieldset>
</aui:fieldset-group>
</c:when>
<c:otherwise>
	<div class="alert">
		<p>Không có quyền thao tác</p>
	</div>
</c:otherwise>
</c:choose>