<%@page import="com.software.cms.service.CommentLocalServiceUtil"%>
<%@page import="com.software.cms.model.Comment"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@include file="../../init.jsp"%>

<portlet:resourceURL var="sendCommentId" id="commentStatus">
</portlet:resourceURL>
<portlet:resourceURL var="setDeleteChecked" id="setDeleteChecked">
</portlet:resourceURL>
<%
	Long articleId_ = ParamUtil.getLong(request, "articleId");
	List<Comment> commentList = CommentLocalServiceUtil.searchComment(articleId_);
if(commentList.size() > 0){
	List<Comment> parentCommentList = new ArrayList<Comment>();
	List<Comment> childCommentList = new ArrayList<Comment>();
	for(int i = 0; i < commentList.size(); i++){
		if(commentList.get(i).getParentId() == 0L)
			parentCommentList.add(commentList.get(i));
		else
			childCommentList.add(commentList.get(i));
	}
%>

<div class="<portlet:namespace/>comment">
<%
	for(int i = 0; i < parentCommentList.size(); i++){
%>
	<div class="<portlet:namespace/>comment_lv1">
		<div class="comment-content">
			<%= parentCommentList.get(i).getContent() %>
		</div>
		<span class="comment-username">
			<%= parentCommentList.get(i).getUsername() %>
			- <%= parentCommentList.get(i).getCreatedDate() %>
		</span>
		<span class="comment-status">
			<span class="comment-approved">
				<%
					if(parentCommentList.get(i).getApproved() == false){
				%>
				<img src='/html/themes/classic/images/common/close.png' id="cmt_<%= parentCommentList.get(i).getCommentId() %>" 
					class="approved-icon" value="<%=parentCommentList.get(i).getCommentId()%>" />
				<%
					}
					else{
				%>
				<img src='/html/themes/classic/images/common/checked.png' id="cmt_<%= parentCommentList.get(i).getCommentId() %>"  
					class="approved-icon" value="<%=parentCommentList.get(i).getCommentId()%>" />
				<%
					}
				%>
			</span>
			<%-- <span class="comment-like">
				<img src='<%=renderResponse.encodeURL(renderRequest.getContextPath()+"/res/like.gif") %>' />
				<%= parentCommentList.get(i).getLikes() %>
			</span> --%>
			<span class="comment-like">
				<a class="delete_comment" id="cmt_<%=parentCommentList.get(i).getCommentId() %>" ><i class="icon-remove-circle" style="color: red;font-size: 20px;"></i></a>
			</span>
		</span>
	</div>
	<%
		for(int j = 0; j < childCommentList.size(); j++){
			if(childCommentList.get(j).getParentId() == parentCommentList.get(i).getCommentId()){		
	%>
	<div class="<portlet:namespace/>comment_lv2">
		<hr/>
		<div class="comment-content">
			<%= childCommentList.get(j).getContent() %>
		</div>
		<span class="comment-username">
			<%= childCommentList.get(j).getUsername() %>
			- <%= childCommentList.get(j).getCreatedDate() %>
		</span>
		<span class="comment-status">
			<span class="comment-approved">
				<%
					if(childCommentList.get(j).getApproved() == false){
				%>
				<img src='/html/themes/classic/images/common/close.png' id="cmt_<%=childCommentList.get(j).getCommentId() %>" 
					class="approved-icon" value="<%= childCommentList.get(j).getCommentId()%>" />
				<%
					}
					else{
				%>
				<img src='/html/themes/classic/images/common/checked.png' id="cmt_<%=childCommentList.get(j).getCommentId() %>" 
					class="approved-icon" value="<%= childCommentList.get(j).getCommentId()%>" />
				<%
					}
				%>
				
			</span>
			<%-- <span class="comment-like">
				<img src='<%=renderResponse.encodeURL(renderRequest.getContextPath()+"/res/like.gif") %>' />
				<%= childCommentList.get(j).getLikes() %>
			</span> --%>
			<span class="comment-like">
				<a class="delete_comment" id="cmt_<%=childCommentList.get(j).getCommentId() %>" onclick="deleteComments(<%=childCommentList.get(j).getCommentId() %>)"><i class="icon-remove-circle" style="color: red;font-size: 20px;"></i></a>
			</span>
		</span>
	</div>
	<%
			}
		}
	%>
	<hr/>
<%
	}
%>
</div>


<script type="text/javascript">
$(document).ready(function(){
	$(".approved-icon").click(function(){
		var commentStatus = 0;
		if($(this).attr("src") == "/html/themes/classic/images/common/close.png"){
			commentStatus = 0;
		}
		else{
			commentStatus = 1;
		}
			
		var commentId = $(this).attr("value");
		
		$.ajax({
			url: '${sendCommentId}',
			dataType: "json",
			data:{
				<portlet:namespace/>commentId: commentId,
				<portlet:namespace/>commentStatus: commentStatus
			},
			success: function(data) {
				var status = data['status'];
				var item = "cmt_"+data['id'];
				if(status==0){
					$("#"+item).attr("src","/html/themes/classic/images/common/close.png");
				}
				else
					$("#"+item).attr("src","/html/themes/classic/images/common/checked.png");
			}				
		});
	});

<%-- 	$(".delete_comment").click(function(){
	var commentId = $(this).attr("value");
		$.ajax({
			url: '<%=setDeleteChecked%>',
			dataType: "json",
			data:{
				<portlet:namespace/>commentId: commentId,
			},
			success: function(data) {
				var status = data['status'];
				var item = "cmt_"+data['id'];
				if(status==0){
					alert("<liferay-ui:message key='ecoit.cms.manage.article.comment.notSuccessful'/>");
				}
				else
					alert("<liferay-ui:message key='ecoit.cms.manage.article.comment.successful'/>");
			}				
		});
	}); --%>
});
function deleteComments(id){
	var commentId = id;
	$.ajax({
		url: '${setDeleteChecked}',
		dataType: "json",
		data:{
			<portlet:namespace/>commentId: commentId,
		},
		success: function(data) {
			var status = data['status'];
			var item = "cmt_"+data['id'];
			if(status==0){
				alert("<liferay-ui:message key='ecoit.cms.manage.article.comment.notSuccessful'/>");
			}
			else
				alert("<liferay-ui:message key='ecoit.cms.manage.article.comment.successful'/>");
		}				
	});
}
</script>
<%}else{ %>
	<div><b><liferay-ui:message key="soft.manage.search.message.no-result"></liferay-ui:message></b></div>
<%} %>

