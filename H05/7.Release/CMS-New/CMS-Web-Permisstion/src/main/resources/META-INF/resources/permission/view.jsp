<%@ include file="../init.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<portlet:defineObjects />  
<liferay-theme:defineObjects />   
<aui:fieldset>
	<aui:fieldset-group>
		<h3 class="sheet-subtitle">Danh sách nhóm quyền</h3>
		<aui:row>
			<aui:col md="12">
				<c:choose>
					<c:when test="<%=PermissionUtil.checkPermissionAccessZone(themeDisplay.getUserId(), RoleConstants.PERMISSION,themeDisplay.getScopeGroupId()) %>">
						<portlet:renderURL var="addNewGroupUser">
							<portlet:param name="mvcRenderCommandName" value="/permission/edit"/>
							<portlet:param name="backURL" value="<%=themeDisplay.getURLCurrent() %>"/>
						</portlet:renderURL>
						<portlet:actionURL name="removeGroupUser" var="removeGroupUser">
							<portlet:param name="backURL" value="${themeDisplay.getURLCurrent()}" />
						</portlet:actionURL>
						<aui:button-row>
							<aui:button cssClass="btn btn-primary" icon="icon-plus" value="Thêm mới" onClick="document.location='${addNewGroupUser}'" ></aui:button>
						</aui:button-row>
						<%
							int delta = 20;
							List<GroupUser> groups = GroupUserLocalServiceUtil.findByGroup_Language(themeDisplay.getScopeGroupId(), themeDisplay.getLocale().toString());
							PortletURL portletIterator = renderResponse.createRenderURL();
							SearchContainer searchContainerGU = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, delta, portletIterator, null, "Không có dữ liệu!");
							int start = searchContainerGU.getStart();
							int end = searchContainerGU.getEnd();
							if (end > groups.size()) end = groups.size();
							groups = groups.subList(start, end);
							searchContainerGU.setResults(groups);
							searchContainerGU.setTotal(groups.size());
						%>
						<liferay-ui:search-container searchContainer="<%=searchContainerGU %>" >
							<liferay-ui:search-container-row className="com.software.cms.model.GroupUser" keyProperty="groupUserId" modelVar="groupUser">
								<liferay-ui:search-container-column-text name="Tên Nhóm"
								property="name"/>
								<liferay-ui:search-container-column-text name="Mô tả"
								property="description"/>
								<liferay-ui:search-container-column-text name="Số thành viên" cssClass="tex-center"
								value='<%=String.valueOf(GroupUserUsersLocalServiceUtil.findByGroup_GroupUser(themeDisplay.getScopeGroupId(), groupUser.getGroupUserId()).size())%>' />
								<liferay-ui:search-container-column-text name="Sửa" cssClass="w5">
									<portlet:renderURL var="addNewGroupUsers">
										<portlet:param name="mvcRenderCommandName" value="/permission/edit"/>
										<portlet:param name="groupUserId" value="${groupUser.getGroupUserId()}" />
										<portlet:param name="backURL" value="${themeDisplay.getURLCurrent()}"/>
									</portlet:renderURL>
									<aui:a href="${addNewGroupUsers}">
										<button class="btn" >
		                                	<i class="fa fa-fw float-left text-primary" aria-hidden="true"></i>
		                           		</button>
									</aui:a>
								</liferay-ui:search-container-column-text>
								<liferay-ui:search-container-column-text name="Xóa" cssClass="w5">
									<portlet:actionURL var="removeGroupUsers" name="/permission/remove_group">
										<portlet:param name="groupUserId" value="${groupUser.getGroupUserId()}" />
										<portlet:param name="backURL" value="${themeDisplay.getURLCurrent()}"/>
									</portlet:actionURL>
									<aui:a href="${removeGroupUsers}">
										<button class="btn" >
		                                	<i class="fa fa-fw float-left text-danger" aria-hidden="true"></i>
		                           		</button>
									</aui:a>
								</liferay-ui:search-container-column-text>
							</liferay-ui:search-container-row>
							<liferay-ui:search-iterator />
						</liferay-ui:search-container>
					</c:when>
					<c:otherwise>
						<liferay-ui:message key="soft.cms.manage.no-access" />
					</c:otherwise>
				</c:choose> 
			</aui:col>
		</aui:row>
	</aui:fieldset-group>		
</aui:fieldset>
