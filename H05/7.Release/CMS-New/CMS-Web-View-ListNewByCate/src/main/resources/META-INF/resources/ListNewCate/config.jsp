<%@page import="com.web.article.listnews.portlet.TreeCategory"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page pageEncoding="utf-8" %>
<%@ include file="../init.jsp"%>
<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL" />
<%
PortletPreferences prefs = renderRequest.getPreferences();
String categorySelect = prefs.getValue("categorySelect", "").trim();
boolean cau_hinh_trang_chi_tiet = Boolean.parseBoolean(prefs.getValue("cau_hinh_trang_chi_tiet", "false"));
boolean hien_thi_theo_thong_bao =  Boolean.parseBoolean(prefs.getValue("hien_thi_theo_thong_bao", "false"));
boolean hien_thi_theo_thong_bao_theo_slide = Boolean.parseBoolean(prefs.getValue("hien_thi_theo_thong_bao_theo_slide", "false"));
boolean hien_thi_theo_dang_tabs = Boolean.parseBoolean(prefs.getValue("hien_thi_theo_dang_tabs", "false"));
boolean day_bai_viet_thong_bao_len_menu = Boolean.parseBoolean(prefs.getValue("day_bai_viet_thong_bao_len_menu", "false"));
%>
<aui:form action="${configurationActionURL}" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="${configurationRenderURL}" />
	<input id="<portlet:namespace />categorySelect" name="<portlet:namespace />categorySelect" type="hidden" value="" />
	<aui:fieldset cssClass="sheet sheet-lg">
		<h3 class="sheet-subtitle">Cấu hình chuyên mục hiển thị</h3>
		<div style="overflow: auto; height: 350px;border: 1px solid #cdcdcd;padding-bottom: 10px; padding-left: 10px;width: 100%;">
			<%
			try{
				out.print(new TreeCategory().createCategoryTree(new long[]{0}, themeDisplay.getScopeGroupId(), themeDisplay.getLanguageId(), categorySelect,"",  4,renderRequest));
			}catch(Exception e1){}
			%>
		</div>
		<%-- <div class="md-3">
			<h3 class="sheet-subtitle">Tùy chọn khác</h3>
			<aui:input name="cau_hinh_trang_chi_tiet" type="checkbox" checked="<%=cau_hinh_trang_chi_tiet %>" label="Hiển thị bài viết theo trang chi tiết :"></aui:input>
			<aui:input name="hien_thi_theo_thong_bao" type="checkbox" checked="<%=hien_thi_theo_thong_bao %>" label="Hiển thị bài viết theo dạng thông báo :"></aui:input>	    
			<aui:input name="hien_thi_theo_thong_bao_theo_slide" type="checkbox" checked="<%=hien_thi_theo_thong_bao_theo_slide %>" label="Hiển thị bài viết theo dạng thông báo slide :"></aui:input>
			<aui:input name="hien_thi_theo_dang_tabs" type="checkbox" checked="<%=hien_thi_theo_dang_tabs %>" label="Hiển thị bài viết theo dạng tabs :"></aui:input>
			<aui:input name="day_bai_viet_thong_bao_len_menu" type="checkbox" checked="<%=day_bai_viet_thong_bao_len_menu %>" label="Đẩy bài viết thông báo lên Menu:"></aui:input>
		</div> --%>
	</aui:fieldset>
	 <aui:button-row>
        <aui:button cssClass="btn-lg btn btn-primary" onclick="submitFm()" type="button" value="Ghi lại"/>
    </aui:button-row>
</aui:form>
<script type="text/javascript">
function submitFm(){
	var cate = "";
	var checkboxes = document.getElementsByName('checked-category');
	for (var i=0; i<checkboxes.length; i++) {
		if (checkboxes[i].checked) {
		 cate += checkboxes[i].value+',';
		}


	}
	if(cate.length > 0){
		 cate = cate.substring(0, cate.length -1);
	}
	document.getElementById("<portlet:namespace />categorySelect").value = cate;
	submitForm(document.<portlet:namespace />fm);
}

</script>