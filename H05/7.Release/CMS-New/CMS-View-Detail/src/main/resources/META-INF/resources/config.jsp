<%@page import="com.view.article.render.detail.TreeCategory"%>
<%@include file="init.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/jquery.dataTables.min.css">
<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="true" varImpl="configurationRenderURL" />
<liferay-portlet:resourceURL portletName="${param.portletResource}" var="searchArtByCate" id="resourceConfig" />
<%
PortletPreferences prefs = renderRequest.getPreferences();
String categorySelect = prefs.getValue("categorySelect", "").trim();
String artcleSelect = prefs.getValue("artcleSelect", "").trim();

%>
<form action="${configurationActionURL}"  method="post" name="<portlet:namespace />fm1">
    <aui:input name="redirect" type="hidden" value="${configurationRenderURL.toString()}" />
     <input id="<portlet:namespace />categorySelect" name="<portlet:namespace />categorySelect" type="hidden" value="" />
     <input id="<portlet:namespace />artcleSelect" name="<portlet:namespace />artcleSelect" type="hidden" value="" />
     <aui:fieldset cssClass="sheet sheet-lg">
     	<div style="padding-bottom: 20px;">
	    	<div><span style="font-weight: bold; font-size: 16px">Chọn chuyên mục:</span></div>
		    <div id="boxCate" style="overflow: auto; height: 350px;border: 1px solid #cdcdcd;padding-bottom: 10px; padding-left: 10px;width: 100%;">
		    	<%  
		    	try{
					out.print(new TreeCategory().createCategoryTree(new long[]{0}, themeDisplay.getScopeGroupId(), themeDisplay.getLanguageId(), categorySelect,"",  4,renderRequest));
				}catch(Exception e1){}
				%>
		    </div>
	    </div>
	    <div id="box_art">
	    
	    </div>
     </aui:fieldset>
      <aui:button-row>
        <aui:button cssClass="btn-lg btn btn-primary" onclick="submitFm()" type="button" value="Ghi lại"/>
    </aui:button-row>
</form>
<%if(!categorySelect.equals("")){ %>
<script type="text/javascript">
var url = "${searchArtByCate.toString()}";
jQuery.ajax({
	type: "GET",
	url: url,
	data:{
		_com_view_article_detail_DetailControllerPortlet_cmd:'CONFIG_DETAIL',
		_com_view_article_detail_DetailControllerPortlet_categoryId:'<%=categorySelect%>',
	}, 
	success: function(data) {
		document.getElementById("box_art").innerHTML = data;
		$('#table-view-data').DataTable();
		var idInput = '<%="id_"+artcleSelect%>';
		document.getElementById(idInput).checked=true;
	}
	}
);
</script>
<%} %>
<script type="text/javascript">
function chkChange(e){
	console.log(e.checked);
	if(e.checked){
		var url = "${searchArtByCate.toString()}";
		jQuery.ajax({
			type: "GET",
			url: url,
			data:{
				_com_view_article_detail_DetailControllerPortlet_cmd:'CONFIG_DETAIL',
				_com_view_article_detail_DetailControllerPortlet_categoryId:e.value,
			}, 
			success: function(data) {
				console.log(data);
				document.getElementById("box_art").innerHTML = data;
				$('#table-view-data').DataTable();
			}
			}
		);
	}else{
		$('#box_art').empty();
	}
}
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
	var articleId = "";
	var radioBoxs = document.getElementsByName('select-article');
	for(var i = 0;i<radioBoxs.length;i++){
		if(radioBoxs[i].checked){
			articleId = radioBoxs[i].value;
		}
	}
	document.getElementById("<portlet:namespace />artcleSelect").value = articleId;
	document.getElementById("<portlet:namespace />categorySelect").value = cate;
	submitForm(document.<portlet:namespace />fm1);
}

</script>