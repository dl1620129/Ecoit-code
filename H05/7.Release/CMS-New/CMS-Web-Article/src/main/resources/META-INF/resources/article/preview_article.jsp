<%@page import="java.util.Date"%>
<%@ include file="../init.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<portlet:defineObjects />  
<liferay-theme:defineObjects />
<div id="preview_article">
<%
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
	Article article = (Article) request.getAttribute("articles");
	String title = HtmlUtil.escape(ParamUtil.getString(request, "title", ""));
	String summary = HtmlUtil.escape(ParamUtil.getString(request, "summary", ""));
	String content = ParamUtil.getString(request, "content", "");
	String imagesDescription = HtmlUtil.escape(ParamUtil.getString(request, "images-description", ""));
	String author = HtmlUtil.escape(ParamUtil.getString(request, "author", ""));
	String source = HtmlUtil.escape(ParamUtil.getString(request, "source", ""));
	String publishDate = (String) request.getAttribute("publishDate");
	long articleId = ParamUtil.getLong(request, "articleId",-1);
	if(articleId > 0){
		Article art = ArticleLocalServiceUtil.getArticle(articleId);
		title = art.getTitle();
		if(art.getPublishedDateFrom()!=null){
			publishDate = sdf.format(art.getPublishedDateFrom());
		}else{
			publishDate = sdf.format(new Date());
		}
		summary = art.getSummary();
		content = art.getContent();
		author = art.getAuthor();
		source = art.getSource();
	}
%>

<%if(articleId > 0){ %>
<div style="border: 1px solid #e1e1e1;padding: 10px; margin-bottom: 30px">
	<div class="mc21-noidung-baiviet">
		<div class="chitiet-baiviet">
			<h1 style="font-size: 18px;  line-height: 20px;" id="titlePreview"><%=title %></h1>
			<span style="color: #898989; font-size: 11px;"><%= publishDate%></span>
			<h2 id="summaryPreview" style="color: #666; font-size: 12.01px;  font-weight: bold; text-align: justify; line-height: 20px"><%=summary %></h2>
			<div id="contentPreview" ><%=content %></div>
			<div style="float: right; margin-right: 10px">
				<span style="font-weight: bold" id="authorPreview"><%=author %></span>
			</div>
			<div style="float: right; margin-right: 10px">
				<span style="font-weight: bold" id="sourcePreview"><%=source %></span>
			</div>
			<div style="clear: right;"> <span></span></div>
		</div>
	</div>

</div>
<%}else{ %>
<div style="border: 1px solid #e1e1e1;padding: 10px; margin-bottom: 30px">
	<div class="mc21-noidung-baiviet">
		<div class="chitiet-baiviet">
			<h1 style="font-size: 18px;  line-height: 20px;" id="titlePreview"></h1>
			<span style="color: #898989; font-size: 11px;"><%= sdf.format(new Date())%></span>
			<h2 id="summaryPreview" style="color: #666; font-size: 12.01px;  font-weight: bold; text-align: justify; line-height: 20px"></h2>
			<div id="contentPreview" ></div>
			<div style="float: right; margin-right: 10px">
				<span style="font-weight: bold" id="authorPreview"></span>
			</div>
			<div style="float: right; margin-right: 10px">
				<span style="font-weight: bold" id="sourcePreview"></span>
			</div>
			<div style="clear: right;"> <span></span></div>
		</div>
	</div>

</div>
<script type="text/javascript">
	document.getElementById('contentPreview').innerHTML = window.parent.<portlet:namespace/>content.getHTML();
	document.getElementById('titlePreview').innerHTML = htmlEntities(window.parent.document.getElementById('<portlet:namespace/>title').value);
	document.getElementById('summaryPreview').innerHTML = htmlEntities(window.parent.document.getElementById('<portlet:namespace/>summary').value);
	document.getElementById('authorPreview').innerHTML = htmlEntities(window.parent.document.getElementById('<portlet:namespace/>author').value);
	document.getElementById('sourcePreview').innerHTML = htmlEntities(window.parent.document.getElementById('<portlet:namespace/>searchsource').value);
function htmlEntities(str) {
    return String(str).replace(/&/g, '&amp;').replace(/</g, '&lt;').replace(/>/g, '&gt;').replace(/"/g, '&quot;');
}
</script>
<%}%>
</div>
<style>
	#preview_article img{
		width: 100%;
	}
</style>