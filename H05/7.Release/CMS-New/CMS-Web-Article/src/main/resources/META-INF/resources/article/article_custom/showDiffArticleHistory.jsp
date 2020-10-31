<%@page import="com.software.util.AttachmentUtil"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.software.cms.model.ArticleHistory"%>
<%@include file="../../init.jsp" %>
<%@include file="iscroll.jsp" %>
<%
	String backUrl = ParamUtil.getString(request, "backUrl");
	String showTypeArHi = "sho";
	Article ar = null;
	ArticleHistory ah = null;
	try{
		ar = (Article)request.getAttribute("ar");
		ah = (ArticleHistory)request.getAttribute("ah");
	}catch(Exception ex){
		response.sendRedirect(ParamUtil.getString(request, "backUrl"));
	}
	try{
		showTypeArHi = request.getAttribute("showType").toString();
	}catch(Exception ex){		
	}
%>
<portlet:actionURL var="doRevive" name="/history/doArticleHistory">
	<portlet:param name="cmd" value="revive"/>
 	<portlet:param name="backUrl" value="<%= backUrl %>"/>
	<portlet:param name="idold" value="<%= Long.toString(ah.getArticleHistoryId()) %>"/>	
	<portlet:param name="idcur" value="<%= Long.toString(ar.getArticleId()) %>"/>	
</portlet:actionURL>
<portlet:renderURL var="doShowdiff">
	<portlet:param name="mvcRenderCommandName" value="/history/directArticleHistory"/>
	<portlet:param name="cmd" value="showdiff"/>
	<portlet:param name="backUrl" value="<%= backUrl %>"/>	
	<portlet:param name="idold" value="<%= Long.toString(ah.getArticleHistoryId()) %>"/>	
	<portlet:param name="idcur" value="<%= Long.toString(ar.getArticleId()) %>"/>
	<portlet:param name="showType" value="<%= showTypeArHi %>"/>	
</portlet:renderURL>
<div class="tool-article-history">
	<a href="${doRevive }"><button><liferay-ui:icon image="undo" message="Revive"/> </button></a>
	<a href="${doShowdiff }"><button><liferay-ui:icon image="view_articles" message="Show Diff"/> </button></a>
	<a href="<%=backUrl%>" style="float: right;"><button><liferay-ui:icon image="back"/> </button></a>
</div>
<div class="part-article-history" onload="loaded()">
	<table id="compare-article-history">
		<tr style="border-bottom: 1px solid #ccc">
			<td class="title-part-article-history" style="font-size: 14px;"><liferay-ui:message key="soft.manage.articlehistory.label.info"/></td>
			<td class="left title-part-article-history"><liferay-ui:message key="soft.manage.articlehistory.label.cur"/></td>
			<td class="right title-part-article-history"><liferay-ui:message key="soft.manage.articlehistory.label.old"/></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="soft.manage.articlehistory.label.modifieduser"/></td>
			<td><i>
				<%try{
					out.print(UserLocalServiceUtil.getUser( ar.getModifiedByUser()).getFullName());
				}catch(Exception ex){out.print("");} %>						
			</i></td>
			<td><i>
				<%try{
					out.print(UserLocalServiceUtil.getUser( ah.getUserId()).getFullName());
				}catch(Exception ex){out.print("");} %>			
			</i></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="soft.manage.articlehistory.label.modifieddate"/></td>
			<td><i>
				<%
					try{
						out.print(DateUtil.getDate(ar.getModifiedDate(),"E dd / MMMMM / yyyy hh:mm aaa", locale));}
					catch(Exception ex){
						out.print("");
					}
				%>						
			</i></td>
			<td><i>
				<%
					try{
						out.print(DateUtil.getDate(ah.getCreatedDate(),"E dd / MMMMM / yyyy hh:mm aaa", locale));}
					catch(Exception ex){
						out.print("");
					}
				%>			
			</i></td>
		</tr>

		<tr>
			<td><liferay-ui:message key="soft.manage.articlehistory.label.compare.title"/></td>
			<td><i><%= ar.getTitle() %></i></td>
			<td><i><%= ah.getTitle() %></i></td>
		</tr>

		<tr>
			<td><liferay-ui:message key="soft.manage.articlehistory.label.compare.summnary"/></td>
			<td><i><%= ar.getSummary() %></i></td>
			<td><i><%= ah.getSummnary() %></i></td>
		</tr>

		<tr>
			<td><liferay-ui:message key="soft.manage.articlehistory.label.compare.author"/></td>
			<td><i><%= ar.getAuthor() %></i></td>
			<td><i><%= ah.getAuthor() %></i></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="soft.manage.articlehistory.label.compare.source"/></td>
			<td><i><%= ar.getSource() %></i></td>
			<td><i><%= ah.getSource() %></i></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="soft.manage.articlehistory.label.compare.imgdesc"/></td>
			<td><i><%= ar.getImageTitle() %></i></td>
			<td><i><%= ah.getImageDescription() %></i></td>
		</tr>
		<tr>
			<td><liferay-ui:message key="soft.manage.articlehistory.label.compare.image"/></td>
			<td>
			<c:choose>			
				<c:when test="<%= Long.parseLong(ar.getImage())>0 %>">
					<img src="<%=AttachmentUtil.viewDocument(renderRequest, renderResponse, themeDisplay, ah.getImage(),"80x80") %>" height="80px" border="1" width="80px" />
				</c:when>
				<c:otherwise>
					<liferay-ui:message key="soft.manage.articlehistory.message.null"/>		
				</c:otherwise>
			</c:choose>						
			</td>
			<td>
			<c:choose>
				<c:when test="<%= Long.parseLong(ah.getImage())>0 %>">
					<img src="<%=AttachmentUtil.viewDocument(renderRequest, renderResponse, themeDisplay, ah.getImage(),"80x80") %>" height="80px" border="1" width="80px" />
				</c:when>
				<c:otherwise>
					<liferay-ui:message key="soft.manage.articlehistory.message.null"/>		
				</c:otherwise>
			</c:choose>									
			</td>
		</tr>
	</table>
	<div class="compare-content" id="box-compare-article">
		<div class="tool-content-article-history">
			<span style="margin-left: 10px;
				font-size: 13px;
				line-height: 30px;"><liferay-ui:message key="soft.manage.articlehistory.label.compare.content"/></span>
			<a href="#box-compare-article"><button id="set-fixed-compare-content" class="maximize-button">
				<liferay-ui:icon image="open_window"/>
			</button></a>
		</div>
		<div class="containe-content-compare left-xxx">
			<div id="content-old">
				<div class="abcxyz123456">
					<%= ar.getContent() %>
				</div>
			</div>
		</div>
		<div class="containe-content-compare right-xxx">
			<div id="content-cur">
				<div class="abcxyz123456">
				<%= ah.getContent() %>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="bg-compare-article"></div>
<style>
	.tool-article-history{
		width: 100%;
		border-bottom: 1px solid #ccc;
		float: left;
		padding: 0px 0px 5px 0px;
		margin-bottom: 10px;
	}
	.left-xxx{
		float: left;
		margin-left: 10px;
	}
	.right-xxx{
		float: right;
		margin-right: 10px;
	}
	.part-article-history{
		margin-top: 10px;
	}
	#compare-article-history{
		width: 100%;
	}
	#compare-article-history tr{
		border-bottom: 1px dotted #ccc;
		padding: 5px 0px 5px 0px;
	}
	#compare-article-history .left,	#compare-article-history .right
	{
		width: 40%;
	}
	#compare-article-history tr td:first-child{
		font-size: 12px; 
	}	
	#compare-article-history td{
		padding: 5px 5px 5px 0px;
		vertical-align: top;
		text-align: justify;
	}
	.title-part-article-history{		
		font-size: 14px;
		font-weight: bold;
	}	
	.compare-content{
		width: 100%;
		padding: 0px 0px 20px 0px;
		float: left;
	}
	
	.tool-content-article-history{
		width: 100%;
		float: left;
		padding: 5px 0px 5px 0px;
		border-bottom: 1px solid #ccc;
	}
	
	.containe-content-compare{
		width: 46%;
		max-height: 520px;
		margin-top:10px;
		background: silver;
		padding: 5px;
		border: 1px solid rgba(0, 0, 0, 0.8);
	}
	#content-old,#content-cur{
		overflow: hidden;
		width: 100%;
		height: 500px;
	}
	.abcxyz123456{
		background: #eeeeee;
	}
	#set-fixed-compare-content:hover{
		text-decoration: underline;
		cursor: pointer;
	}
	.fixed-content{
		position: fixed;
		width:1200px;
		margin:-300px 0px  0px -600px;
		left:50%;
		top:50%;	
		z-index: 100001;
		background: #eeeeee;
		border: 1px solid rgba(0, 0, 0, 0.8);
	}
	.maximize-button{
		float: right;
		margin-right: 10px;
	}
	#portlet_ECOITcms_WAR_ECOITcmsportlet{
		float: left;
		width: 100%;
		padding-bottom: 10px;
	}
	.del-text{
		background: #ffaaaa;
		text-decoration: line-through;		
	}	
	.ins-text{
		background-color: #feff99;
		text-decoration: underline;
	}
	#bg-compare-article{
		position: fixed;
		left: 0px;
		top:0px;
		z-index: 100000;
		background: black;
		opacity:0.8;
		width: 100%;
		height: 100%;
		display: none;
	}
</style>
<aui:script>
	var myScroll;
	var myScroll2;
	function loaded () {
		myScroll = new IScroll('#content-old',{ mouseWheel: true });
		myScroll2 = new IScroll('#content-cur',{ mouseWheel: true });
	}
	document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);
	document.addEventListener('DOMContentLoaded', loaded, false);
	
	$("#set-fixed-compare-content").attr("value","0");
	$("#set-fixed-compare-content").click(function(){		
		var f = $(this).attr("value");
		var khung = $(".compare-content");

 		if(f==0){
			$(this).attr("value","1");
			khung.addClass("fixed-content");
			$("#bg-compare-article").css("display","block");
		}else{
			$(this).attr("value","0");			
			khung.removeClass("fixed-content");
			$("#bg-compare-article").css("display","none");
		}
	});
</aui:script>