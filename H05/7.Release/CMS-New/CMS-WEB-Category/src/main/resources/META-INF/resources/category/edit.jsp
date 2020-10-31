<%@page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../init.jsp" %>
<liferay-ui:error key="id-is-required" message="ecoit.cms.manage.category.error.id" />
<liferay-ui:error key="group-is-required" message="ecoit.cms.manage.category.error.group" />
<liferay-ui:error key="parent-is-required" message="ecoit.cms.manage.category.error.parent" />
<liferay-ui:error key="thuTu-is-required" message="Vui lòng nhập thứ tự" />
<portlet:actionURL var="doActionCategory" name= "/category/add_category">
	<portlet:param name="slink" value="${backURL}" />
	<portlet:param name="flink" value="${themeDisplay.getURLCurrent()}"/>
</portlet:actionURL>
<aui:form method="post" action="${doActionCategory}" class="form-category">
	<aui:input name="id" value="${idCate}" type="hidden" />
	<c:if test="${idCate ne null }">
		<aui:input name="cmd" value="edit" type="hidden" />
	</c:if>
	<aui:fieldset>
		<aui:fieldset-group>
			<h3 class="sheet-subtitle">Thông tin Chuyên mục</h3>
			<aui:row>
		       	<aui:col width="50">
		       		<aui:select label="Chuyên mục cấp trên" name="parent-id">
						<aui:option value="0" label="Chọn chuyên mục" />
						${rootCate}
					</aui:select>
					<aui:input label="Tên chuyên mục" autocomplete="off" type="text" name="title" value="${title }">
						<aui:validator name="required" errorMessage="Vui lòng nhập tên chuyên mục" />
						<aui:validator name="maxLength" errorMessage="Không được nhập quá 300 ký tự">300</aui:validator>
					</aui:input>
					<aui:input label="Thứ tự" autocomplete="off" type="number" name="thuTu" value="${thuTu }">
						<aui:validator name="required" errorMessage="Vui lòng nhập thứ tự"/>
					</aui:input>
		       	</aui:col>
		       	<aui:col width="50">
		       		<aui:input label="Mô tả" type="textarea" style="height: 128px;" name="description" value="${description }" >
		       			<aui:validator name="maxLength" errorMessage="Không được nhập quá 500 ký tự">500</aui:validator>
		       		</aui:input>
		       		<%
		       		Long plIds = -1L;
							List<Layout> listLayout = LayoutLocalServiceUtil.getLayouts(themeDisplay.getScopeGroupId(), false);
						%>
						<aui:select id="layoutId" name="layoutId" label="Chọn trang">
		                    <%
			                	for(int j = 0; j< listLayout.size(); j++){
			                    Layout l = listLayout.get(j);
		                    %>
		                    <option <%=(plIds==l.getPlid()?"selected":"") %> value="<%=l.getPlid() %>" style="font-size: 13px;"><%=l.getName(locale) %></option>
		                    <%
		                        List<Layout> listLayout1 = l.getChildren();
		                        if (listLayout1 != null && !listLayout1.isEmpty()) {
		                            for (int i = 0; i < listLayout1.size(); i++) {
		                                Layout l1 = listLayout1.get(i);
		                    %>
		                    <option <%=(plIds==l1.getPlid()?"selected":"") %> value="<%=l1.getPlid() %>" style="font-size: 12px;font-style: italic;">---<%=l1.getName(locale) %></option>
		                   <%
		       					 	}
		    					}
		                    }
		                    %>
	                   	</aui:select>
		       	</aui:col>
	       </aui:row>
		</aui:fieldset-group>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" value="Lưu"  icon="icon-save"></aui:button>
		<aui:button href="${backURL}" type="button" value="Quay lại" icon="icon-repeat"></aui:button>
	</aui:button-row>
</aui:form>