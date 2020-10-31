<%@page import="java.util.regex.Matcher"%>
<%@page import="java.util.regex.Pattern"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@include file="init.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%
	long articleId = ParamUtil.getLong(request, "articleId");
	if(articleId > 0){
		Article art = ArticleLocalServiceUtil.getArticle(articleId);
		if(art != null){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
%>
<script>
	document.title = "<%=art.getTitle()!=null&&!art.getTitle().equals("") ?art.getTitle():""%>";
</script>
<section class="article-detail ">
      <a href="Javascript:window.print();" style="font-size: 25px;" title="In bài viết" ><img alt="" src="<%=renderRequest.getContextPath() %>/res/icon-print.png" style="float: right;width: 30px !important;"></a>
	<article>
			<h1 style="font-size: 36px;"><%=art.getTitle()!=null&&!art.getTitle().equals("") ?art.getTitle():""%></h1>
			<p class="more-info"><%=art.getPublishedDateFrom()!=null?sdf.format(art.getPublishedDateFrom()):"" %></p>
			<!-- <div class="tool_box_ecoit"></div> -->
			<p class="description" style="min-height: 90px !important;">
				<%= art.getSummary()!=null?HtmlUtil.extractText(art.getSummary()):"" %>
			</p>
			<p>
				
				<%
					String content = art.getContent()!=null?art.getContent():"";
					if(request.getHeader("User-Agent").indexOf("Mobile") != -1) {
					    //you're in mobile land
					    Pattern findStyle = Pattern.compile("<img[^>]*(width[\\s]*:[\\s]*[0-9]*[\\s]*px[\\s]*;[^>]*height[\\s]*:[\\s]*[0-9]*[\\s]*px[\\s]*;)[^>]*>");
						Matcher m = findStyle.matcher(content);
						while(m.find()){
						    content = content.replace(m.group(1), "");
						}
					} else{%>
						<!-- <style type="text/css">
							.aui img{
								max-width: none !important;
							}
						</style> -->
					<%}
				%>
				<%=content%>
				
			</p>
			<%
			String tac_gia = "";
			String nguon = "";
			if(!art.getAuthor().equals("")) tac_gia = art.getAuthor();
			if(!art.getSource().equals("")) nguon = art.getSource();
			%>
			<div align="right" style="font-size: 13px;font-style: italic;">
				<div class="author_ecoit"><%=tac_gia%></div>
				<div class="author_ecoit"><%=nguon%></div>
			</div>
			
			</article>
		</section>
		<br>
<%}
}%>

<style>
body{background: #e9ebee;}
.article-detail{
	margin-left: 15px;
    margin-right: 15px;
    border: 1px solid #ccc;
    padding: 20px;
}
.right_print{
	text-align: right;
}
.article-detail .more-info {
    color: #000;
    border-bottom: 1px solid #eee;
    padding-bottom: 10px;
    margin-bottom: 30px;
}
.article-detail .description {
    font-weight: bold;
    font-style: italic;
    color: #000;
    margin-bottom: 20px;
}

.site-footer{
	background: #e9ebee no-repeat top right;
    background-size: contain !important;
    margin: 0 !important;
    padding: 30px 0 !important;
    color: #000 !important;
    line-height: 1.1em !important;
}
.container{
	padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
}
.article-detail img{
	width: 100% !important;
}
.row {
	margin-right: -15px !important;
	margin-left: -15px !important;
}
.row:after, .row:before{
	display: table;
	content: " ";
}
.row:after {
	clear: both;
}
.col-md-6{
	position: relative;
	min-height: 1px;
	padding-right: 15px;
	padding-left: 15px;
}

@media ( min-width :992px) {
 .col-md-6 {
		float: left;
	}

	.col-md-6 {
		width: 45%;
	}
	
}
@media ( min-width :670px) {
 .col-md-6 {
		float: left;
	}

	.col-md-6 {
		width: 43%;
	}
	
}
@media(max-width:660px){
	.print{
		text-align: -webkit-center;
	}
}
@media(max-width:670px){
	.right_print{
		text-align: -webkit-center;
	}
	.col-md-6 {
		text-align: center;
	}
}
</style>