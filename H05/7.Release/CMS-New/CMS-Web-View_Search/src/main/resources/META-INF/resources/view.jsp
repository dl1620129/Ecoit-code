<%@page import="com.software.util.CMSPortalUtil"%>
<%@page import="com.software.util.AttachmentUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@include file="init.jsp"%>
<style>
.searchBoxForm input{
	width: 200px;
    box-sizing: border-box !important;
    border: 2px solid #ccc !important;
    border-radius: 4px !important;
    font-size: 16px !important;
    background-color: #ffffff !important;
    background-image: url('<%=renderRequest.getContextPath()%>/res/search_icon.png');
    background-position: 0px 0px !important;
    background-repeat: no-repeat !important;
    padding: 0px 2px 0px 37px !important;
    -webkit-transition: width 0.4s ease-in-out !important;
    transition: width 0.4s ease-in-out !important;
    height: 38px !important;
    background-size: 37px;
}
.searchBoxForm input:focus{
	width: 100% !important;
}
</style> 
<%
String keyword = (String)renderRequest.getAttribute("keyword");
String tags = (String)renderRequest.getAttribute("tags");
if(keyword==null) keyword = "";
if(tags==null) tags = "";
else themeDisplay.getRequest().getSession().setAttribute("tags",tags);
SearchContainer searchContainer = (SearchContainer)renderRequest.getAttribute("ListSearchArticle");
if(searchContainer!=null){
	List<Article> listArt = searchContainer.getResults();
	if(listArt==null) listArt = new ArrayList<Article>();
	int total = searchContainer.getTotal();
	String srcImgDefault = renderRequest.getContextPath()+"/image/noimage.png";
%>

<div style="text-align: -webkit-center;">
<liferay-portlet:renderURL var="timKiemBaiViet">
</liferay-portlet:renderURL>

<aui:form action="${timKiemBaiViet}" method="POST" cssClass="searchBoxForm">
<%if(keyword!=null && !keyword.equals("") && !keyword.equals("null")) {%>
	<aui:input required="required" type="text" name="keyword" cssClass="inputSearch" value="<%=HtmlUtil.extractText(keyword)%>" label="" placeholder=""></aui:input>
<%}else if(tags != null && !tags.equals("")&& !tags.equals("null")){ %>
	<aui:input required="required" type="text" name="tags" cssClass="inputSearch" value="<%=HtmlUtil.extractText(tags)%>" label="" placeholder=""></aui:input>
<%}else{ %>
	<aui:input required="required" type="text" name="keyword" cssClass="inputSearch" label="" placeholder=""></aui:input>
<%} %>
</aui:form>
</div>

<div class="page-category-content">
   <h5 class="resultSearch"><liferay-ui:message key="soft.cms.total.article"/> : <%=total %> <liferay-ui:message key="soft.cms.result.article"/></h5>
   <div class="news-list">
		<%
	   for(Article art : listArt){ 
		   String urlImg = AttachmentUtil.viewDocument(renderRequest, renderResponse, themeDisplay, art.getImage(), "210x160");
		   String url = CMSPortalUtil.getUrlArticle(art, 0, request, themeDisplay.getScopeGroupId());
	   %>
	   <div class="newsItem">
		   <div class="ItemContent">
			    <%if(!urlImg.equals(srcImgDefault)){ %>
			       	<a href="<%=url%>"><img class="card-category-img" src="<%=urlImg %>" alt=""></a>
		       	<%} %>
		       	<h2>
		       		<a href="<%=url%>"  title="<%=art.getTitle()%>"><%=art.getTitle() %></a>
		       	</h2>
		       	<div class="time">
		       	
		       	</div>
		       	<p class="des"><%=art.getSummary() %></p>
	    	</div>
        </div>
	   <%} %>
	</div>
   <div style="padding: 10px;">
     <liferay-ui:search-paginator searchContainer="<%=searchContainer%>"></liferay-ui:search-paginator>
   </div>
</div>
<%} %>
