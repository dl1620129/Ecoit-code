<%@page import="com.web.ecoit.portal.quangcao.service.QuangCaoLocalServiceUtil"%>
<%@page import="com.web.ecoit.portal.quangcao.model.QuangCao"%>
<%@page import="com.web.quangcao.view.portlet.FileUtils"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page pageEncoding="utf-8" %>
<%@ include file="../init.jsp"%>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery-3.3.1.js"></script>
<script type="text/javascript" src="<%=request.getContextPath() %>/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/css/jquery.dataTables.min.css">
<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="<%= true %>" var="configurationRenderURL" />
<%
PortletPreferences prefs = renderRequest.getPreferences();
String quangCaoSelect = prefs.getValue("quangCaoSelect", "").trim();
boolean isQuangCaoSlider = Boolean.parseBoolean(prefs.getValue("isQuangCaoSlider", "false"));
String sql="select * from soft_adv_quangcao where groupid="+themeDisplay.getScopeGroupId()+" and language='"+themeDisplay.getLanguageId()+"' and status = 0";
List<QuangCao> lstQuangCaos = QuangCaoLocalServiceUtil.getQuangCaoBySql(sql, -1, -1);
%>
<aui:form action="${configurationActionURL}" method="post" name="fm">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
	<aui:input name="redirect" type="hidden" value="${configurationRenderURL}" />
	<input id="<portlet:namespace />categorySelect" name="<portlet:namespace />categorySelect" type="hidden" value="" />
	<aui:fieldset cssClass="sheet sheet-lg">
		<h3 class="sheet-subtitle">Chọn ảnh quảng cáo</h3>
		<aui:row>
			<aui:col md="12">
				<aui:input checked="<%=isQuangCaoSlider %>" type="checkbox" name="isQuangCaoSlider" label="Nếu quảng cáo là dạng slider"></aui:input>
			</aui:col>
		</aui:row>
		<aui:row>
			<aui:col md="12">
				<table id="table-view-data-quangcao" class="display" style="width:100%">
					<thead>
						<tr>
							<th></th>
							<th>Tên quảng cáo</th>
							<th>Ảnh quảng cáo</th>
						</tr>
					</thead>
					<tbody>
						<%for(QuangCao quangCao : lstQuangCaos){ %>
							<tr>
								<th class="w20">
									<input type="checkbox" id="id_<%=quangCao.getQuangCaoId()%>" name="quangcao-select" value="<%=quangCao.getQuangCaoId()%>">
								</th>
								<th class="w30">
									<%=quangCao.getTenQuangCao() %>
								</th>
								<th class="w50">
									<%if(quangCao.getImageId() > 0 ){%>
										<img alt="" src="<%=FileUtils.getUrlFileEntry(quangCao.getImageId(), themeDisplay)%>" style="width: auto;height: auto;">
									<%}else{ %>
										<img alt="" src="<%=renderRequest.getContextPath()%>/images/noimage.png" style="width: 100%;height: auto;">
									<%} %>
								</th>
							</tr>
						<%} %>
					</tbody>
				</table>
			</aui:col>
		</aui:row>
		
	</aui:fieldset>
	 <aui:button-row>
	 	<aui:input name="quangCaoSelect" id="quangCaoSelect" type="hidden"></aui:input>
        <aui:button cssClass="btn-lg btn btn-primary" onclick="submitFm()" type="button" value="Ghi lại"/>
    </aui:button-row>
</aui:form>
<script type="text/javascript">
<%if(!quangCaoSelect.equals("")) {
	for(String st : quangCaoSelect.split(",")){	
%>
	var idInput = '<%="id_"+st%>';
	document.getElementById(idInput).checked=true;
<%} 
}%>
</script>


<script type="text/javascript">
$(document).ready(function() {
    $('#table-view-data-quangcao').DataTable({
    	"paging": false,
    	"scrollY": "400px"
    	
    });
} );
function submitFm(){
	var quangcaos = "";
	var checkboxes = document.getElementsByName('quangcao-select');
	for (var i=0; i<checkboxes.length; i++) {
		if (checkboxes[i].checked) {
			quangcaos += checkboxes[i].value+',';
		}


	}
	if(quangcaos.length > 0){
		quangcaos = quangcaos.substring(0, quangcaos.length -1);
	}
	document.getElementById("<portlet:namespace />quangCaoSelect").value = quangcaos;
	submitForm(document.<portlet:namespace />fm);
}

</script>