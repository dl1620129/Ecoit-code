<%@ include file="../../init.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<portlet:defineObjects />  
<liferay-theme:defineObjects />
<portlet:resourceURL var="autoCompleteName">
	<portlet:param name="cmd" value="Sources"/>
</portlet:resourceURL>

<%
long Source_articleId = ParamUtil.getLong(request, "articleId", -1);
Article articleSource = null;
if(Source_articleId > 0)articleSource = ArticleLocalServiceUtil.getArticle(Source_articleId);
else articleSource = ArticleLocalServiceUtil.create();
if(renderRequest.getAttribute("article") != null){
	articleSource = (Article) renderRequest.getAttribute("article");
}
%>
<div id="choose-source" class="form-group input-text-wrapper">
	<ul class="search-container" name="<portlet:namespace/>list-signers" style="margin: 0 !important;">
		<li class="token-input-input-token-facebook" id="list-signer" style="width: 100% !important;">
		<label class="control-label">
				Nguồn bài viết
		</label>
		<aui:input id="searchsource" name="source" autocomplete="off" value="<%=articleSource.getSource() %>" label="">
			<aui:validator name="maxLength" errorMessage="Không được nhập quá 300 ký tự">301</aui:validator>
		</aui:input>
		<%-- <input class="field form-control"
			type="text" autocomplete="off"
			id="<portlet:namespace/>searchsource" name="<portlet:namespace/>source" value="<%=articleSource.getSource() %>" > --%>
		</li>
	</ul>
</div>
<style>
#choose-source .search-container {
	padding: 0;
    margin-bottom: 0;
}

</style>
<aui:script
	use="autocomplete-list,aui-base,aui-io-request-deprecated,autocomplete-filters,autocomplete-highlighters,datasource,datasource-get,datatable-datasource">
 
 var contactSearchDS = new A.DataSource.IO({source: '${autoCompleteName}'});
  
 var contactSearchQueryTemplate = function(query) {
  var output = '&<portlet:namespace />keywords=' + query;
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
  inputNode: '#<portlet:namespace />searchsource',
  render: 'true',
  source: contactSearchDS,
  on: {
		select: function(event) {
			var result = event.result.raw;
			  if(result.name!=''){
			  }
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
	/* width: 400 */
 });

 
 $("#choose-source").click(function(){
  $("#<portlet:namespace />searchsource").focus();
 });
 
 $("#choose-source").delegate(".p","click",function(){
  var idremove = $(this).parent().attr('value')+",";
  list_tag = list_tag.replace(idremove,"");
  $(this).parent().remove();
 });  
 
 $("#<portlet:namespace />searchsource").keydown(function(event){
  lastKeyPressCode = event.keyCode;
  if(lastKeyPressCode==13){
  	event.stopImmediatePropagation();
  }
 });
 function htmlEntities(str) {
	    return String(str).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;');
	}
</aui:script>
