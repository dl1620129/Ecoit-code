<%@ include file="../../init.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<portlet:defineObjects />  
<liferay-theme:defineObjects />
<portlet:resourceURL var="autoCompleteName">
	<portlet:param name="cmd" value="ArticleInvolve"/>
</portlet:resourceURL>

<%
long Invo_articleId = ParamUtil.getLong(request, "articleId", -1);
Article articleInvo = null;
if(Invo_articleId > 0)articleInvo = ArticleLocalServiceUtil.getArticle(Invo_articleId);
else articleInvo = ArticleLocalServiceUtil.create();
if(renderRequest.getAttribute("article") != null){
	articleInvo = (Article) renderRequest.getAttribute("article");
}
String invoArt = "";
	if (renderRequest.getAttribute("listTagsFalse") != null
			&& renderRequest.getAttribute("rsValidArticle") != null
			&& renderRequest.getAttribute("rsValidArticle").toString()
					.equals("true")) {
		invoArt = articleInvo.getInvolveArt();
	}else{
		if(articleInvo != null){
			invoArt = articleInvo.getInvolveArt();
		}
	}
%>

<div id="choose-involve-art">
	<ul class="tags-container" name="<portlet:namespace/>Involve_art-list">
		 <%
		 if(!invoArt.equals("")){
			for (String st : invoArt.split(",")) {
				Article arti = ArticleLocalServiceUtil.getArticle(Long.valueOf(st));
		%> 
		<li class="Involve_art-item field form-control" value="<%=arti.getArticleId()%>"><input type="hidden"
			name="involve" value="<%= arti.getArticleId()%>" class="Involve_art">
			<p><%=arti.getTitle() %></p> <span
			class="p token-input-delete-token-facebook">x</span></li>
		<%
			}
		 }
		%>
			<li class="token-input-input-token-facebook" id="list-involve-art"><input
				type="text" autocomplete="on" class="form-control"
				id="<portlet:namespace/>choose-Involve-input" placeholder="Bài viết liên quan ..."
				name="<portlet:namespace/>involveartname"></li>
	</ul>
	<aui:input name="Involve_art-saved" type="hidden" />
</div>
<style>
#aui_3_4_0_1_870,#trigger {
	display: none;
}

.tags-container {
	padding: 0;
    margin-bottom: 0;
}

ul.tags-container {
	overflow: hidden;
	width: 100%;
	cursor: text;
	font-size: 12px;
	font-family: Verdana;
	min-height: 1px;
	z-index: 999;
	margin: 0;
	padding: 0;
	list-style-type: none;
	clear: left;
}

li.Involve_art-item {
	overflow: hidden;
	margin: 3px;
	background-color: #eff2f7;
	color: #000;
	cursor: default;
	border: 1px solid #ccd5e4;
	font-size: 12px;
	border-radius: 5px;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	float: left;
	/* white-space: nowrap; */
	padding: 1px 3px 1px 4px;
}

li.Involve_art-item p {
	display: inline;
	padding: 0;
	margin: 0;
	font-size: 1.0em;
	color: #555;
	float: left;
	margin-right: 3px;
}

li.Involve_art-item span {
	color: #a6b3cf;
	font-weight: bold;
	padding: 2px 3px 0px 3px;
	height: 15px;
	line-height: 13px;
	float: left;
	border-radius: 3px;
	-moz-border-radius: 3px;
	-webkit-border-radius: 3px;
}

li.Involve_art-item span:hover {
	background: #a6b3cf;
	color: #fff;
	cursor: pointer;
}

ul.tags-container li input {
	width: 100%;
	padding: 3px 8px;
	margin: 2px 0;
	-webkit-appearance: caret;
	outline: none;
}

li.token-input-input-token-facebook {
	float: left;
	margin: 0;
	padding: 0;
	list-style-type: none;
	width: 100%;
}

li.token-input-input-token-facebook input {
}
</style>
<aui:script
	use="autocomplete-list,aui-base,aui-io-request-deprecated,autocomplete-filters,autocomplete-highlighters,datasource,datasource-get,datatable-datasource">
var list_involve = ",";
<%
if(!invoArt.equals("")){
%>
list_involve += '<%=invoArt%>'+",";
<%
}
%>
 var contactSearchDS = new A.DataSource.IO({source: '${autoCompleteName}'});
  
 var contactSearchQueryTemplate = function(query) {
  var output = '&<portlet:namespace />keywords=' + query+'&<portlet:namespace />listinvolve='+list_involve;
  return output;
 }
  
 var contactSearchLocator = function (response) {
  var responseData = A.JSON.parse(response[0].responseText);
     return responseData;
 };
  
 var contactSearchFormatter = function (query, results) {
  return A.Array.map(results, function (result) {
   return '<strong>'+result.name+'</strong>';
  });
 };
  
 var contactSearchTextLocator = function (result) {
  return result.key;
 };
  
 var contactSearchInput = new A.AutoCompleteList({
  	allowBrowserAutocomplete: false,
	activateFirstItem: true,
  resultHighlighter: 'phraseMatch',
  inputNode: '#<portlet:namespace />choose-Involve-input',
  render: 'true',
  source: contactSearchDS,
  on: {
		select: function(event) {
			var result = event.result.raw;
			  var taginput = document.getElementById("<portlet:namespace />choose-Involve-input");
 		
 			 $(".Involve_art").each(function() {
 		     	  if($(this).val().toLowerCase()==taginput.value.toLowerCase()){ 
 		     	  	return;
 		     	  } 
 		       }); 
			  if(result.name!=''){
				   var tag = $('<li class="Involve_art-item" value="'+result.key+'"><input type="hidden" name="involve" value="'+htmlEntities(result.key)+'" class="Involve_art"><p>'+htmlEntities(result.name)+'</p><span class="p token-input-delete-token-facebook">x</span></li>');
				   $("#list-involve-art").before(tag);
				   list_involve+=result.key+",";
				   taginput.value = '';
				   event.preventDefault();
			  }
			      
 			A.one('#<portlet:namespace />Involve_art-saved').val(htmlEntities(result.name));
		}
	},
  	requestTemplate: contactSearchQueryTemplate,
  	resultListLocator: function (response) {
	var responseData = A.JSON.parse(response[0].responseText);
	return responseData.response;
	},
	resultTextLocator: function (result) {
	return result.name;
	},
	width: 400
 });
  /*  var select_tag = function(name,id){ 
   var taginput = document.getElementById("<portlet:namespace />choose-Involve-input"); 
   if(name!=''){ 
    var tag = $('<li class="Involve_art-item" value="'+id+'"><input type="hidden" name="involve" value="'+id+'"><p>'+htmlEntities(name)+'</p><span class="p token-input-delete-token-facebook">x</span></li>');
    $("#list-involve-art").before(tag); 
    list_involve+=id+",";
    taginput.value = '';
   } 
    
  } */
  
 $("#choose-involve-art").click(function(){
  $("#<portlet:namespace />choose-Involve-input").focus();
 });
 
 $("#choose-involve-art").delegate(".p","click",function(){
  var idremove = $(this).parent().attr('value')+",";
  list_involve = list_involve.replace(idremove,"");
  $(this).parent().remove();
 });  
 
 $("#<portlet:namespace />choose-Involve-input").keydown(function(event){
  lastKeyPressCode = event.keyCode;
  if(lastKeyPressCode==13){
   	  /* var taginput = document.getElementById("<portlet:namespace />choose-Involve-input"); 
   	  var flag = 0; 
       $(".Involve_art").each(function() {
     	  if($(this).val()== $(".Involve_art").val() ){ 
     	  	flag=1; 
     	  } 
       });  */
   	event.preventDefault();
  }
 });
 function htmlEntities(str) {
	    return String(str).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;');
	}
</aui:script>