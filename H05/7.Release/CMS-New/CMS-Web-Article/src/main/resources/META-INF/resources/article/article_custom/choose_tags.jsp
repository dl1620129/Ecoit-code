<%@ include file="../../init.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<portlet:defineObjects />  
<liferay-theme:defineObjects />
<portlet:resourceURL var="autoCompleteName" >
	<portlet:param name="cmd" value="Tags"/>
</portlet:resourceURL>
<%
String listTagId="";
List<Tag> tags=new ArrayList<Tag>();
long tags_articleId = ParamUtil.getLong(request, "articleId", -1);
Article articleTags = null;
if(tags_articleId > 0)articleTags = ArticleLocalServiceUtil.getArticle(tags_articleId);
else articleTags = ArticleLocalServiceUtil.create();
if(renderRequest.getAttribute("article")!=null){
	try{
		listTagId = ((Article) renderRequest.getAttribute("article")).getTagIds();
	}
	catch(Exception ex){listTagId="";}
}else{
	listTagId = articleTags.getTagIds();
}
if(!listTagId.equals("")){
	try{
		tags=TagLocalServiceUtil.getListTag("select * from soft_cms_tag where tagid in("+listTagId+")", QueryUtil.ALL_POS, QueryUtil.ALL_POS);
	}
	catch(Exception ex){;}
}
if (renderRequest.getAttribute("listTagsFalse") != null
	&& renderRequest.getAttribute("rsValidArticle") != null
	&& renderRequest.getAttribute("rsValidArticle").toString().equals("true")) {
	tags = (List<Tag>) renderRequest.getAttribute("listTagsFalse");
}
%>
<div id="choose-tag">
	<ul class="tags-container" name="<portlet:namespace/>list-tags">
		<%
			for (Tag tag : tags) {
		%>
		<li class="tag-item" value="'<%=tag.getTagId()%>'"><input type="hidden"
			name="tags" value="<%=tag.getTagId()%>" class="tags_">
			<p><%=tag.getTagName()%></p> <span
			class="p token-input-delete-token-facebook">x</span></li>
		<%
			}
		%>
			<li class="token-input-input-token-facebook" id="list-tag">
			<input
				type="text" autocomplete="on" class="form-control"
				id="<portlet:namespace/>choose-tag-input" placeholder="tags ..."
				name="<portlet:namespace/>tagname"></li>
	</ul>
	<aui:input name="tags-saved" type="hidden" />
</div>

<aui:script
	use="autocomplete-list,aui-base,aui-io-request-deprecated,autocomplete-filters,autocomplete-highlighters,datasource,datasource-get,datatable-datasource">
 var list_tag = ",";
 <%
	for (Tag tag : tags) {
%>
  list_tag += '<%=tag.getTagId()%>'+",";
 <%
	}
%>  
 var contactSearchTag = new A.DataSource.IO({source: '${autoCompleteName.toString()}'});
  
 var contactSearchQueryTemplate = function(query) {
  var output = '&<portlet:namespace />keywords=' + query+'&<portlet:namespace />listtag='+list_tag;
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
  	allowBrowserAutocomplete: true,
	activateFirstItem: true,
  resultHighlighter: 'phraseMatch',
  inputNode: '#<portlet:namespace />choose-tag-input',
  render: 'false',
  source: contactSearchTag,
  method:'POST',
  on: {
		select: function(event) {
			var result = event.result.raw;
			  var taginput = document.getElementById("<portlet:namespace />choose-tag-input");
 			  $(".tagsnew").each(function() { 
 		    	  if($(this).val().toLowerCase()==taginput.value.toLowerCase()){ 
 					  $(this).parent().remove(); 
 		    	  } 
		      }); 
 			 $(".tags_").each(function() {
 		     	  if($(this).val().toLowerCase()==taginput.value.toLowerCase()){ 
 		     	  	return;
 		     	  } 
 		       }); 
			  if(result.name!=''){
				   var tag = $('<li class="tag-item" value="'+result.key+'"><input type="hidden" name="tags" value="'+result.key+'" class="tags_"><p>'+htmlEntities(result.name)+'</p><span class="p token-input-delete-token-facebook">x</span></li>');
				   $("#list-tag").before(tag);
				   list_tag+=result.key+",";
				   taginput.value = '';
				   event.preventDefault();
			  }
			      
 			A.one('#<portlet:namespace />tags-saved').val(htmlEntities(result.name));
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
   var select_tag = function(name,id){ 
   var taginput = document.getElementById("<portlet:namespace />choose-tag-input"); 
   if(name!=''){ 
    var tag = $('<li class="tag-item" value="'+id+'"><input type="hidden" name="tags" value="'+id+'"><p>'+htmlEntities(name)+'</p><span class="p token-input-delete-token-facebook">x</span></li>');
    $("#list-tag").before(tag); 
    list_tag+=id+",";
    taginput.value = '';
   } 
    
  }
  
 $("#choose-tag").click(function(){
  $("#<portlet:namespace />choose-tag-input").focus();
 });
 
 $("#choose-tag").delegate(".p","click",function(){
  var idremove = $(this).parent().attr('value')+",";
  list_tag = list_tag.replace(idremove,"");
  $(this).parent().remove();
 });  
 
 $("#<portlet:namespace />choose-tag-input").keydown(function(event){
  lastKeyPressCode = event.keyCode;
  if(lastKeyPressCode==13){
   	  var taginput = document.getElementById("<portlet:namespace />choose-tag-input"); 
   	  var flag = 0; 
       /* $(".tags_").each(function() {
     	  if($(this).val()== $(".tags_").val() ){ 
     	  	flag=1; 
     	  } 
       });  */
       $(".tagsnew").each(function() {
      	  if($(this).val().toLowerCase()==taginput.value.toLowerCase()){ 
      	  	flag=1;

      	  } 
        });
       //flag=-1;
         $(".tags_").each(function() { 
     	  if($(this).val().toLowerCase()==taginput.value.toLowerCase()){ 
     		 $(this).parent().remove();
     	  	flag=1; 
     	  }
       });  
      
 	  if(taginput.value!='' && flag ==0 ){ 
 		   var tag = $('<li class="tag-item" value=""><input type="hidden" name="<portlet:namespace/>tagsnew" value="'+htmlEntities(taginput.value)+'" class="tagsnew"><p>'+htmlEntities(taginput.value)+'</p><span class="p token-input-delete-token-facebook">x</span></li>'); 
 		   $("#list-tag").before(tag); 
 		   taginput.value = ''; 
 	  } 
   	event.preventDefault();
  }
 });
function htmlEntities(str) {
	    return String(str).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;');
	}
</aui:script>
<style>
#aui_3_4_0_1_870,#trigger {
	display: none;
}

.tag-item p {
	
}
ul.yui3-aclist-list{
	background: #dedede;
}
.yui3-aclist-item-active{
	background: #9dcbf4;
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

li.tag-item {
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

li.tag-item p {
	display: inline;
	padding: 0;
	margin: 0;
	font-size: 1.0em;
	color: #555;
	float: left;
	margin-right: 3px;
}

li.tag-item span {
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

li.tag-item span:hover {
	background: #a6b3cf;
	color: #fff;
	cursor: pointer;
}


li.token-input-input-token-facebook {
	float: left;
	margin: 0;
	padding: 0;
	list-style-type: none;
	width: 100%;
}
</style>