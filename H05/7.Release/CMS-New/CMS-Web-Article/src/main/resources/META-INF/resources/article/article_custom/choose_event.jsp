<%@page import="com.software.cms.service.EventLocalServiceUtil"%>
<%@page import="com.software.cms.model.Event"%>
<%@ include file="../../init.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<portlet:defineObjects />  
<liferay-theme:defineObjects />
<portlet:resourceURL var="autoCompleteName">
	<portlet:param name="cmd" value="Events"/>
</portlet:resourceURL>
<%
    String listeventIdjsp="";
    List<Event> eventsjsp=new ArrayList<Event>();
    long event_articleId = ParamUtil.getLong(request, "articleId", -1);
    Article articleEvent = null;
    if(event_articleId > 0)articleEvent = ArticleLocalServiceUtil.getArticle(event_articleId);
    else articleEvent = ArticleLocalServiceUtil.create();
    if(renderRequest.getAttribute("article") != null){
    	articleEvent = (Article) renderRequest.getAttribute("article");
    }
    if(articleEvent!=null){
    	try{
    		listeventIdjsp = articleEvent.getEventIds();
    	}
    	catch(Exception ex){listeventIdjsp="";}
    }
    if(!listeventIdjsp.equals("")){
    	try{
    		eventsjsp=EventLocalServiceUtil.getEventBySql("select * from soft_cms_event where eventid in("+listeventIdjsp+")", QueryUtil.ALL_POS, QueryUtil.ALL_POS);
    	}
    	catch(Exception ex){;}
    	
    }
	
	//List<event> events = ArticleeventLocalServiceUtil
	//		.geteventFromArticle(events_id);
	if (renderRequest.getAttribute("listEventsFalse") != null
			&& renderRequest.getAttribute("rsValidArticle") != null
			&& renderRequest.getAttribute("rsValidArticle").toString()
					.equals("true")) {
		eventsjsp = (List<Event>) renderRequest.getAttribute("listEventsFalse");
	}
%>


<div id="choose-event">
	<ul class="events-container" name="<portlet:namespace/>list-events">
		<%
			for (Event event : eventsjsp) {
		%>
		<li class="event-item" value="'<%=event.getEventId()%>'"><input type="hidden"
			name="events" value="<%=event.getEventId()%>" class="events_">
			<p><%=event.getEventName()%></p> <span
			class="p token-input-delete-token-facebook">x</span></li>
		<%
			}
		%>
			<li class="token-input-input-token-facebook" id="list-event"><input
				type="text" autocomplete="on" class="form-control"
				id="<portlet:namespace/>choose-event-input" placeholder="events ..."
				name="<portlet:namespace/>eventname"></li>
	</ul>
	<aui:input name="events-saved" type="hidden" />
</div>
<style>

.events-container{
	padding: 0;
    margin-bottom: 0;
}
li.event-item {
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

li.event-item p {
	display: inline;
	padding: 0;
	margin: 0;
	font-size: 1.0em;
	color: #555;
	float: left;
	margin-right: 3px;
}

li.event-item span {
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

li.event-item span:hover {
	background: #a6b3cf;
	color: #fff;
	cursor: pointer;
}
</style>
<aui:script
	use="autocomplete-list,aui-base,aui-io-request-deprecated,autocomplete-filters,autocomplete-highlighters,datasource,datasource-get,datatable-datasource">
 var list_event = ",";
 <%
	for (Event event : eventsjsp) {
%>
  list_event += '<%=event.getEventId()%>'+",";
 <%
	}
%>  
 var contactSearchDS = new A.DataSource.IO({source: '${autoCompleteName}'});
  
 var contactSearchQueryTemplate = function(query) {
  var output = '&<portlet:namespace />keywords=' + query+'&<portlet:namespace />listevent='+list_event;
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
  inputNode: '#<portlet:namespace />choose-event-input',
  render: 'true',
  source: contactSearchDS,
  on: {
		select: function(event) {
			var result = event.result.raw;
			  var eventinput = document.getElementById("<portlet:namespace />choose-event-input");
 			  $(".eventsnew").each(function() { 
 		    	  if($(this).val().toLowerCase()==eventinput.value.toLowerCase()){ 
 					  $(this).parent().remove(); 
 		    	  } 
		      }); 
 			 $(".events_").each(function() {
 		     	  if($(this).val().toLowerCase()==eventinput.value.toLowerCase()){ 
 		     	  	return;
 		     	  } 
 		       }); 
			  if(result.name!=''){
				   var event = $('<li class="event-item" value="'+result.key+'"><input type="hidden" name="events" value="'+result.key+'" class="events_"><p>'+htmlEntities(result.name)+'</p><span class="p token-input-delete-token-facebook">x</span></li>');
				   $("#list-event").before(event);
				   list_event+=result.key+",";
				   eventinput.value = '';
				   event.preventDefault();
			  }
			      
 			A.one('#<portlet:namespace />events-saved').val(htmlEntities(result.name));
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
   var select_event = function(name,id){ 
   var eventinput = document.getElementById("<portlet:namespace />choose-event-input"); 
   if(name!=''){ 
    var event = $('<li class="event-item" value="'+id+'"><input type="hidden" name="events" value="'+id+'"><p>'+htmlEntities(name)+'</p><span class="p token-input-delete-token-facebook">x</span></li>');
    $("#list-event").before(event); 
    list_event+=id+",";
    eventinput.value = '';
   } 
    
  }
  
 $("#choose-event").click(function(){
  $("#<portlet:namespace />choose-event-input").focus();
 });
 
 $("#choose-event").delegate(".p","click",function(){
  var idremove = $(this).parent().attr('value')+",";
  list_event = list_event.replace(idremove,"");
  $(this).parent().remove();
 });  
 
 $("#<portlet:namespace />choose-event-input").keydown(function(event){
  lastKeyPressCode = event.keyCode;
  if(lastKeyPressCode==13){
   	  var eventinput = document.getElementById("<portlet:namespace />choose-event-input"); 
   	  var flag = 0; 
       /* $(".events_").each(function() {
     	  if($(this).val()== $(".events_").val() ){ 
     	  	flag=1; 
     	  } 
       });  */
       $(".eventsnew").each(function() {
      	  if($(this).val().toLowerCase()==eventinput.value.toLowerCase()){ 
      	  	flag=1;

      	  } 
        });
       //flag=-1;
         $(".events_").each(function() { 
     	  if($(this).val().toLowerCase()==eventinput.value.toLowerCase()){ 
     		 $(this).parent().remove();
     	  	flag=1; 
     	  }
       });  
      
 	  if(eventinput.value!='' && flag ==0 ){ 
 		   var event1 = $('<li class="event-item" value=""><input type="hidden" name="<portlet:namespace/>eventsnew" value="'+htmlEntities(eventinput.value)+'" class="eventsnew"><p>'+htmlEntities(eventinput.value)+'</p><span class="p token-input-delete-token-facebook">x</span></li>'); 
 		   $("#list-event").before(event1); 
 		   eventinput.value = ''; 
 	  } 
   event.preventDefault();
  }
 });
 function htmlEntities(str) {
	    return String(str).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;');
	}
</aui:script>