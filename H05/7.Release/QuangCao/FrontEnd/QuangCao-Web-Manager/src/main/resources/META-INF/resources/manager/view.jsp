<%@page import="com.web.ecoit.portal.quangcao.model.QuangCao"%>
<%@page import="com.web.ecoit.portal.quangcao.service.QuangCaoLocalServiceUtil"%>
<%@page import="com.web.quangcao.manager.portlet.FileUtils"%>
<%@page import="java.net.URLDecoder"%>
<%@ include file="../init.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<portlet:defineObjects />  
<liferay-theme:defineObjects /> 
<%
int delta = 20, count = 0, cur = 1, totalRecord = 0;
cur = ParamUtil.getInteger(request, "cur", 1);
delta = ParamUtil.getInteger(request, "delta", 20); 
PortletURL portletURL = renderResponse.createRenderURL();
String searchKey = HtmlUtil.escape(ParamUtil.getString(request, "searchKey", ""));
String sql="select * from soft_adv_quangcao where groupid="+themeDisplay.getScopeGroupId()+" and language='"+themeDisplay.getLanguageId()+"'";
String sqlCount = "select count(*) from soft_adv_quangcao where groupid="+themeDisplay.getScopeGroupId()+" and language='"+themeDisplay.getLanguageId()+"'";
if(!searchKey.equals("")){
	sql += "AND LOWER(tenquangcao) LIKE LOWER('%"+searchKey+"%') ";
	sqlCount += "AND LOWER(tenquangcao) LIKE LOWER('%"+searchKey+"%') ";
}
sql += "order by createDate desc, modifiedDate desc";
totalRecord = QuangCaoLocalServiceUtil.getCountByQuangCao(sqlCount);
int totalPage = (totalRecord  % delta == 0)?  totalRecord /delta : totalRecord /delta+1;
if (totalRecord  == 0) totalPage = 0;
int start = delta*(cur-1);
int end = delta*cur;
if (end > totalRecord ) end = totalRecord ;
List<QuangCao> listQuangCaos = QuangCaoLocalServiceUtil.getQuangCaoBySql(sql, start, end);
SearchContainer searchContainerQC = new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, delta, portletURL, null, "Không có dữ liệu!");
searchContainerQC.setResults(listQuangCaos);
searchContainerQC.setTotal(totalRecord);
%>

<aui:fieldset>
	<aui:fieldset-group>
		<h3 class="sheet-subtitle">Quản lý quảng cáo</h3>
		<portlet:renderURL var="editAdver">
			<portlet:param name="mvcPath" value="/manager/edit.jsp" />
			<portlet:param name="backurl" value="<%=themeDisplay.getURLCurrent() %>"/>
		</portlet:renderURL>
		<aui:form action="<%=portletURL.toString() %>" method="POST">
				<aui:row>
					<aui:col width="50">
						<aui:input id="search" type="text" name="searchKey" value="<%=HtmlUtil.extractText(searchKey) %>" placeholder="Từ khóa" label="" />	
					</aui:col>
					<aui:col width="50">
		       			<aui:button name="submitButton" type="submit" value="Tìm kiếm" />
		    		</aui:col>
	    		</aui:row>
	    </aui:form>
		<aui:button-row>
			<aui:button cssClass="btn btn-primary" icon="icon-plus" value="Thêm mới" onClick="document.location='${editAdver}'" ></aui:button>
		</aui:button-row>
		<aui:row>
			<aui:col md="12">
				<liferay-ui:search-container searchContainer="<%=searchContainerQC %>" >
					<liferay-ui:search-container-row className="com.web.ecoit.portal.quangcao.model.QuangCao" keyProperty="quangCaoId" modelVar="quangCao">
						<liferay-ui:search-container-column-text name="STT" value="<%= Integer.toString(searchContainer.getStart() + (++count))%>" cssClass="w5"/>	
						<liferay-ui:search-container-column-text name="Ảnh quảng cáo" cssClass="center w20">
						<c:choose>
							<c:when test="${ quangCao.getImageId() > 0}">
								<img src="<%=FileUtils.getUrlFileEntry(quangCao.getImageId(), themeDisplay)%>" style="width:auto ;height:auto;">
							</c:when>
							<c:otherwise>
								<img src="<%=renderRequest.getContextPath()%>/images/noimage.png" style="width:100% ;height:auto;">
							</c:otherwise>
						</c:choose>
						</liferay-ui:search-container-column-text>
						<liferay-ui:search-container-column-text name="Tên quảng cáo" property="tenQuangCao" />
						<liferay-ui:search-container-column-text name="Mô tả" property="moTa" cssClass="w20"/>
						<liferay-ui:search-container-column-text name="URL" value="<%=URLDecoder.decode(quangCao.getUrl(),"UTF-8") %>" cssClass="w20"/>
						<liferay-ui:search-container-column-text name="Sửa" cssClass="w5">
							<portlet:renderURL var="editQuangCao">
								<portlet:param name="mvcPath" value="/manager/edit.jsp" />
								<portlet:param name="backurl" value="${themeDisplay.getURLCurrent()}"/>
								<portlet:param name="quangCaoId" value="${quangCao.getQuangCaoId()}"/>
							</portlet:renderURL>
							<liferay-ui:icon image="edit" message="Sửa" url="${editQuangCao}" />
						</liferay-ui:search-container-column-text>
						<liferay-ui:search-container-column-text name="Xóa" cssClass="w5">
							<portlet:actionURL var="deleteQuangCao" name="DeleteQuangCao">
									<portlet:param name="backurl" value="${themeDisplay.getURLCurrent()}"/>
									<portlet:param name="quangCaoId" value="${quangCao.getQuangCaoId()}"/>
								</portlet:actionURL>
							<liferay-ui:icon-delete image="delete" message="Xóa" url="${deleteQuangCao}"/>
						</liferay-ui:search-container-column-text>
					</liferay-ui:search-container-row>
					<liferay-ui:search-iterator/>
				</liferay-ui:search-container>
			</aui:col>
		</aui:row>
	</aui:fieldset-group>
</aui:fieldset>