<%@page import="java.net.URLDecoder"%>
<%@page import="com.web.quangcao.manager.portlet.FileUtils"%>
<%@page import="com.web.quangcao.manager.constants.QuangCaoManagerPortletKeys"%>
<%@page import="com.web.ecoit.portal.quangcao.model.QuangCao"%>
<%@page import="com.web.ecoit.portal.quangcao.service.QuangCaoLocalServiceUtil"%>
<%@ include file="../init.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<portlet:defineObjects />  
<liferay-theme:defineObjects />

<%
	long quangCaoId = ParamUtil.getLong(request, "quangCaoId", -1);
System.out.println("quangCaoId: "+quangCaoId);
	String tenQuangCao = "";
	String moTa = "";
	boolean target = false;
	boolean isShow = true;
	String url = "";
	long imageId = 0;
	String urlImage = ""; 
	if(quangCaoId > 0){
		try{
			QuangCao quangCao = QuangCaoLocalServiceUtil.getQuangCao(quangCaoId);
			tenQuangCao = quangCao.getTenQuangCao();
			moTa = quangCao.getMoTa();
			target = quangCao.getTarget();
			url = quangCao.getUrl();
			if(quangCao.getStatus() == QuangCaoManagerPortletKeys.QUANGCAO_STATUS_SHOW){
				isShow = true;
			}else{
				isShow = false;
			}
			imageId = quangCao.getImageId();
			if(imageId > 0){
				urlImage = FileUtils.getUrlFileEntry(imageId, themeDisplay);
			}
		}catch(Exception e){e.printStackTrace();
			tenQuangCao = "";
			moTa = "";
			target = false;
			url = "";
			isShow = true;
			imageId = 0;
		}
	}
	request.setAttribute("backurl", ParamUtil.getString(request, "backurl"));
%>
<portlet:actionURL var="editQuangCao" name="editQuangCao">
	<portlet:param name="quangCaoId" value="<%=String.valueOf(quangCaoId)%>" />
	<portlet:param name="curl" value="<%=themeDisplay.getURLCurrent()%>" />	
	<portlet:param name="backurl" value="${param.backurl}" />
</portlet:actionURL>

<aui:form method="post" action="${editQuangCao}" enctype="multipart/form-data">
	<aui:fieldset>
		<aui:fieldset-group>
			<h3 class="sheet-subtitle">Thông tin quảng cáo</h3>
			<aui:row>
		          <aui:col width="100">
		              <aui:input type="text" required="<%=true %>" name="tenQuangCao" label="Tên Quảng cáo" value="<%=HtmlUtil.extractText(tenQuangCao)%>">
						<aui:validator name="required" errorMessage="Vui lòng nhập tên quảng cáo"></aui:validator>
						<aui:validator name="maxLength" >300</aui:validator>
					  </aui:input>
				  </aui:col>
	          </aui:row>
	          <aui:row>
		          <aui:col width="100">
		              <aui:input type="text" name="urlQuangCao" label="Liên kết" value="<%=URLDecoder.decode(url,"UTF-8")  %>">
		              		<aui:validator name="url" errorMessage="Vui lòng nhập đúng liên kết" />
		              		<aui:validator name="maxLength" >300</aui:validator>
		              </aui:input>
		         </aui:col>
	         </aui:row>
	         <aui:row>
		          <aui:col width="100">
		              <aui:input type="textarea" name="moTa" label="Mô tả" value="<%=HtmlUtil.extractText(moTa)%>">
		              		<aui:validator name="maxLength" >500</aui:validator>
		              </aui:input>
		         </aui:col>
	         </aui:row>
	         <aui:row>
	         	<%if(imageId <= 0){ %>
		          <aui:col width="100">
		              <aui:input type="file" name="imageId" label="Ảnh quảng cáo">
		              		<aui:validator name="acceptFiles">'jpg,png,tif,gif'</aui:validator>
		              </aui:input>
		         </aui:col>
		        <%}else{ %>
		        	<aui:col md="6">
		        		<div class="image-ma">
		        			<img alt="" src="<%=urlImage%>">
		        			<a href="javascript:XoaFileImage()" title="Xóa Ảnh"><i class="icon-trash" style="color: red;"></i></a>
		        		</div>
		        		<portlet:actionURL name="deleteImageQuangCao" var="deleteImageQuangCao">
		        			<portlet:param name="quangCaoId" value="<%=String.valueOf(quangCaoId) %>"/>
		        			<portlet:param name="imageId" value="<%=String.valueOf(imageId) %>"/>
		        		</portlet:actionURL>
		        		<script type="text/javascript">
							function XoaFileImage() {
								if (confirm("Bạn có muốn xoá file này không?")) {
									url = "${deleteImageQuangCao}";
									jQuery.ajax({
							    		type: "POST",
							    		url: url,
							    		success: function() {
							    			window.location.reload();
										}
									})
								}
							}
						</script>
		        	</aui:col>
		        <%} %>
	         </aui:row>
	         <aui:row>
		          <aui:col width="100">
		              <aui:input type="checkbox" name="target" label="Mở tab mới" checked="<%=target %>">
		              </aui:input>
		         </aui:col>
	         </aui:row>
	           <aui:row>
		          <aui:col width="100">
		              <aui:input type="checkbox" name="isShow" label="Hiển thị" checked="<%=isShow %>">
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