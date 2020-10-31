<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.software.cms.service.PermissionGroupLocalServiceUtil"%>
<%@page import="com.web.util.TreeCategory"%>
<%@page import="com.software.cms.service.GroupCategoryLocalServiceUtil"%>
<%@page import="com.software.cms.model.GroupCategory"%>
<%@ include file="../init.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<portlet:defineObjects />  
<liferay-theme:defineObjects />   
 <liferay-ui:error key="error_name" message="ecoit.message.name" />
<%
	long groupUserId = ParamUtil.getLong(request, "groupUserId", -1);
	GroupUser groupUser = null;
	String nameGroup = "";
	String description = "";
	if(groupUserId > 0){
		groupUser = GroupUserLocalServiceUtil.getGroupUser(groupUserId);
		nameGroup = groupUser.getName();
		description = groupUser.getDescription();
	}
	request.setAttribute("backurl", ParamUtil.getString(request, "backURL"));
%>
<portlet:actionURL var="EditGroupUser" name="/permission/edit_group">
	<portlet:param name="currentURL" value="<%=themeDisplay.getURLCurrent()%>" />
	<portlet:param name="backurl" value='${backurl}' />
</portlet:actionURL>
<%-- 
<c:if test="<%= groupUserId <=0 %>">
	<liferay-ui:tabs names="Thêm mới nhóm quyền hạn" />
</c:if>
<c:if test="<%= groupUserId > 0%>">
	<liferay-ui:tabs names="Cập nhật nhóm quyền hạn"/>
</c:if> --%>
<liferay-ui:error key="article-manage-permission-arror" message="ecoit.cms.manage.article.error"/>
<aui:form action="${EditGroupUser}" method="post" name ="fm">
	<input type="hidden" name="<portlet:namespace/>groupUserId" value="<%=groupUserId %>" />
	<aui:fieldset>
		<aui:fieldset-group>
			<h3 class="sheet-subtitle">Thông tin nhóm</h3>
			<aui:row>
			<aui:col md="2">
				<label>Tên nhóm (<span class="red">*</span>)</label>
			</aui:col>
			<aui:col md="10">
				<aui:input type="text"  name="groupName" label="" value="<%=HtmlUtil.extractText(nameGroup) %>">
				 	<aui:validator name="required" errorMessage="Vui lòng nhập tên nhóm" />
					<aui:validator name="maxLength" errorMessage="Không được nhập quá 200 ký tự">200</aui:validator>
				 </aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col md="2">
				<label>Mô tả nhóm </label>
			</aui:col>
			<aui:col md="10">
				<aui:input type="textarea" rows="5" label="" name="description" value="<%=HtmlUtil.extractText(description) %>">
					<aui:validator name="maxLength" errorMessage="Không được nhập quá 500 ký tự">500</aui:validator>
				</aui:input>
			</aui:col>
		</aui:row>
		</aui:fieldset-group>
	</aui:fieldset>
	<aui:fieldset>
		<aui:fieldset-group>
			<h3 class="sheet-subtitle">Thông tin quyền hạn</h3>
				<aui:row>
				<aui:col md="4">
					<div class="box-per">
						<div class="text-border">
							Người dùng
						</div>
						<div class="clear"></div>
						<%						
						List<User> listUsers = UserLocalServiceUtil.getUsers(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
						for (User ugr : listUsers) {
						%>
							<div class="disp-inline" style="padding-left: 10px;">
								<input type="checkbox" value="<%=ugr.getUserId() %>" name="<portlet:namespace/>users" <%= GroupUserUsersLocalServiceUtil.hasGroupUserUsers(groupUserId,ugr.getUserId())?"checked":"" %> /> 
								<span for="checkt1"><%= ugr.getFullName() %></span>
							</div>
						<%} %>
					</div>
				</aui:col>
				<aui:col md="4">
					<div class="box-per">
						<div class="text-border">
							Nhóm quyền
						</div>
						<%for(int i=0;i<RoleConstants.PERMISSION_ARRAY.length;i++){%>
							<div class="disp-inline" style="padding-left: 10px;">
								<input type="checkbox" value="<%=i%>" name="<portlet:namespace/>permissions" <%=PermissionGroupLocalServiceUtil.hasPermissionGroup(i, groupUserId)?"checked":"" %> /> 
								<span for="checkt1" ><liferay-ui:message key="<%= RoleConstants.PERMISSION_ARRAY[i] %>" /></span>
							</div>
						<%} %>
					</div>
				</aui:col>
				<aui:col md="4">
					<div class="box-per">
						<div class="text-border">
							Chuyên mục
						</div>
						   <%
						    List<GroupCategory> result=GroupCategoryLocalServiceUtil.getByUserIdAndGroupIdAndGroupUserId(themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),groupUserId);
						    String selected="";
						    if(result!=null && result.size()>0){
						    	for(int k=0;k<result.size();k++){
						    		if(selected.equals(""))selected=result.get(k).getCategoryId()+"";
						    		else selected+=","+result.get(k).getCategoryId();
						    	}
						    }
							try{
								out.print(new TreeCategory().createCategoryTree(new long[]{0}, themeDisplay.getScopeGroupId(), themeDisplay.getLanguageId(), selected,"", 1,renderResponse.getNamespace(),renderRequest));
							}
							catch(Exception e1){}
							%>
						</div>
				</aui:col>
			</aui:row>
		</aui:fieldset-group>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="Lưu"  icon="icon-save"></aui:button>
		<aui:button href="${backurl}" type="button" value="Quay lại" icon="icon-repeat"></aui:button>
	</aui:button-row>
</aui:form>
<style>
.text-border{
    text-align: center;
    border-bottom: 1px solid #ccc;
    font-weight: bold;
}
</style>
