<%@page import="com.software.cms.service.TagLocalServiceUtil"%>
<%@page import="com.software.cms.model.Tag"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="../init.jsp"%>
<%@page pageEncoding="utf-8" %>
<portlet:defineObjects />  
<liferay-theme:defineObjects />   

<liferay-ui:error key="error_name" message="ecoit.message.name" />

<%
	long id = ParamUtil.getLong(request, "tagid",-1);
	String tagName = "";
	String tagDesc = "";
	if(id > 0){
		Tag tag = TagLocalServiceUtil.getTag(id);
		tagName = tag.getTagName();
		tagDesc = tag.getDescription();
	}
	request.setAttribute("backurl", ParamUtil.getString(request, "backurl"));
%>

<portlet:actionURL var="editTagAction" name="doEditTag">
	<portlet:param name="tagid" value="<%=String.valueOf(id)%>" />
	<portlet:param name="curl" value="<%=themeDisplay.getURLCurrent()%>" />	
	<portlet:param name="backurl" value="${param.backurl}" />
</portlet:actionURL>

<aui:form method="post" action="${editTagAction}">
	<aui:fieldset>
		<aui:fieldset-group>
			<h3 class="sheet-subtitle">Thông tin Tag</h3>
			<aui:row>
		          <aui:col width="100">
		              <aui:input type="text" required="<%=true %>" name="tagname"
						label="Tên Tag" id="tagnameId" value="<%=HtmlUtil.extractText(tagName)%>">
						<aui:validator name="required"
							errorMessage="Vui lòng nhập tên tag"></aui:validator>
						<aui:validator name="maxLength" >300</aui:validator>
					  </aui:input>
				  </aui:col>
	          </aui:row>
	          <aui:row>
		          <aui:col width="100">
		              <aui:input type="textarea" name="tagdesc" label="Mô tả" 
		              		id="tagdescId" placeholder="description" value="<%=HtmlUtil.extractText(tagDesc)%>">
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