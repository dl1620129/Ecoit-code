<%@page import="com.software.cms.service.ArticleHistoryLocalServiceUtil"%>
<%@page import="com.software.cms.model.ArticleHistory"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@include file="../../init.jsp" %>
<portlet:actionURL var="delArticleHistory"  name="/history/doArticleHistory">
	<portlet:param name="cmd" value="delete"/>
	<portlet:param name="backUrl" value="<%= themeDisplay.getURLCurrent() %>"/>
</portlet:actionURL>
<%
	long idart = 0;
	long history_articleId = ParamUtil.getLong(request, "articleId", -1);
	try{
	    Article articleHistory = null;
	    if(history_articleId > 0)articleHistory = ArticleLocalServiceUtil.getArticle(history_articleId);
	    else articleHistory = ArticleLocalServiceUtil.create();
		idart = articleHistory.getArticleId();
	}catch(Exception ex){}
	List<ArticleHistory> listArticleHistory = new ArrayList<ArticleHistory>();
	listArticleHistory = ArticleHistoryLocalServiceUtil.getHistoryFromArticle(idart);
%>
<portlet:renderURL var="showCompare">
	<portlet:param name="mvcRenderCommandName" value="/history/directArticleHistory"/>
	<portlet:param name="cmd" value="showDiffArticleHistory"/>
	<portlet:param name="backUrl" value="<%= themeDisplay.getURLCurrent() %>"/>
</portlet:renderURL>
<div id="gotoarticlehistory"></div>
<c:choose>
	<c:when test="<%=listArticleHistory.size()<=0 %>">
		<h5><liferay-ui:message key="soft.manage.articlehistory.titlenoshow"/></h5>
	</c:when>
	<c:otherwise>		
		<table class="table table-striped">
			<thead>
				<tr>
					<th style="text-align: center;">
						<liferay-ui:message key="soft.manage.article.label.logs-user-edit"/>
					</th>
					<th style="text-align: center;">
						<liferay-ui:message key="soft.manage.article.label.logs-time-edit"/>
					</th>
					<th>
						
					</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="<%=listArticleHistory%>" var="articleHistory">
					
					<tr>
						<td align="center">
							<%try{
								out.print(UserLocalServiceUtil.getUser( ((ArticleHistory)pageContext.getAttribute("articleHistory")).getUserId()).getFullName());
								}catch(Exception ex){out.print("");} %>
						</td>
						<td align="center">
							<%
							try{
							out.print(DateUtil.getDate(((ArticleHistory)pageContext.getAttribute("articleHistory")).getCreatedDate(),
							"E dd / MMMMM / yyyy hh:mm aaa", locale));}
							catch(Exception ex){
								out.print("");
							}
							%>
						</td>
						<td align="center" style="padding: 4px 0px 4px 0px;">
							<liferay-ui:icon image="history" url="${showCompare}&${renderResponse.getNamespace()}idah=${articleHistory.articleHistoryId}"/>
							<liferay-ui:icon-delete image="delete" url="${delArticleHistory}&${renderResponse.getNamespace()}idah=${articleHistory.articleHistoryId}"/>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:otherwise>
</c:choose>
